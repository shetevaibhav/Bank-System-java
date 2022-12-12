package bank.Exception;

public class CustomeException extends RuntimeException{
	
	String message;

	 

    public String getMessage() {
        return message;
    }

 

    public void setMessage(String message) {
        this.message = message;
    }



	public CustomeException(String message) {
		super();
		this.message = message;
	}



	 

   

}
