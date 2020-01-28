package exception;

public class IncorrectNameStudentException extends Exception{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IncorrectNameStudentException() { super(); }
	  public IncorrectNameStudentException(String message) { super(message); }
	  public IncorrectNameStudentException(String message, Throwable cause) { super(message, cause); }
	  public IncorrectNameStudentException(Throwable cause) { super(cause); }
	
}
