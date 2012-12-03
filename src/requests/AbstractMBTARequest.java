package requests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;

import models.MBTAResponse;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import commons.UserOptions;

public abstract class AbstractMBTARequest
{
	private static final String SERVER_URL 	= "http://developer.mbta.com/lib/rthr/";
	private static final int 	TIME_OUT	= 10000;

	public Closure<Void, AbstractMBTARequest, MBTAResponse> _successClosure;
	public Closure<Void, AbstractMBTARequest, MBTAResponse> _errorClosure;
	public Closure<Void, AbstractMBTARequest, MBTAResponse> _cancelClosure;

	private MBTAResponse _mbtaResponse;
	
	private String _testJson;

	public AbstractMBTARequest(Closure<Void, AbstractMBTARequest, MBTAResponse> successClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> errorClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> cancelClosure)
	{
		_successClosure = successClosure;
		_errorClosure 	= errorClosure;
		_cancelClosure 	= cancelClosure;
		_mbtaResponse 	= new MBTAResponse();
	}

	protected abstract String getAPIName();

	protected void setMBTAResponse(MBTAResponse mbtaResponse)
	{
		_mbtaResponse = mbtaResponse;
	}

	public MBTAResponse getMBTAResponse()
	{
		return _mbtaResponse;
	}
	
	public void doTestRequest() throws IOException
	{
		_testJson = readFile(UserOptions.TestDataDirectory);
		parse(_testJson);
	}
	
	private String readFile( String file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }

	    return stringBuilder.toString();
	}

	public void parse(String json)
	{
		ObjectMapper objectMapper 	= new ObjectMapper();
		JsonFactory jsonFactory 	= new JsonFactory();

		try
		{
			JsonParser jsonParser = jsonFactory.createJsonParser(json);
			_mbtaResponse = objectMapper.readValue(jsonParser, MBTAResponse.class);

			_successClosure.invoke(this, _mbtaResponse);
		}
		catch (JsonParseException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}

	public void doRequest()
	{
		RequestThread requestThread = new RequestThread();
		requestThread.run();
	}

	protected void execute(int timeout) throws IOException
	{
		HttpURLConnection connection = null;
		URL serverAddress = null;
		BufferedReader resultReader  = null;

		try
		{
			serverAddress  = new URL(SERVER_URL + getAPIName());
			connection = (HttpURLConnection)serverAddress.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setReadTimeout(timeout);
			connection.connect();

			resultReader  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder resultStr = new StringBuilder();
			String line = null;
			while ((line = resultReader.readLine()) != null)
			{
				resultStr.append(line);
			}

			parse(resultStr.toString());
		} catch (SocketTimeoutException e)
		{
			_mbtaResponse = new MBTAResponse();
			_mbtaResponse.setException(new Exception("Connection Timed Out"));
			_errorClosure.invoke(this, _mbtaResponse);
		} catch (MalformedURLException e) 
		{
			_mbtaResponse = new MBTAResponse();
			_mbtaResponse.setException(e);
			_errorClosure.invoke(this, _mbtaResponse);
		} catch (ProtocolException e) 
		{
			_mbtaResponse = new MBTAResponse();
			_mbtaResponse.setException(e);
			_errorClosure.invoke(this, _mbtaResponse);
		} catch (IOException e) 
		{
			_mbtaResponse = new MBTAResponse();
			_mbtaResponse.setException(new Exception("No Connection"));
			_errorClosure.invoke(this, _mbtaResponse);
		}
		finally
		{
			//close the connection, set all objects to null
			connection.disconnect();
			resultReader = null;
			connection = null;
		}
	}

	private class RequestThread extends Thread
	{
		public void run()
		{
			try {
				execute(TIME_OUT);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}