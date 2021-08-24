package eci.edu.laboratorio1.Service;

public class usersNotFoundException extends Exception{
	
	public usersNotFoundException(String message) {
        super(message);
    }

    public usersNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
