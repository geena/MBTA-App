package requests;

public interface Closure<S, T, U>
{
    public S invoke(T caller, U data);
    
    Class<U> getResponseType();
}