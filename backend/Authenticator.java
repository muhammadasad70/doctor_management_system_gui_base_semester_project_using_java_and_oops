package backend;


public interface Authenticator {
    Boolean Authenticate(String username, String password);
}
