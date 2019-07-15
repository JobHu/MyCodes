package ycit.exception;

public class UserException extends Exception{
	
	private static final long serialVersionUID = 1L;
   //抛出用户的异常
	public UserException(String msg){
		super(msg);
	}

}
