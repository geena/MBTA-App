package requests;

import java.io.BufferedReader;
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

public abstract class AbstractMBTARequest
{
	private static final String SERVER_URL 	= "http://developer.mbta.com/lib/rthr/";
	private static final int 	TIME_OUT	= 10000;

	public Closure<Void, AbstractMBTARequest, MBTAResponse> _successClosure;
	public Closure<Void, AbstractMBTARequest, MBTAResponse> _errorClosure;
	public Closure<Void, AbstractMBTARequest, MBTAResponse> _cancelClosure;

	private MBTAResponse _mbtaResponse;

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

	protected void parse(String json)
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

	protected void execute(int timeout)
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
			//TODO: Handle Timeouts
		} catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} catch (ProtocolException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
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
			execute(TIME_OUT);
		}
	}
}