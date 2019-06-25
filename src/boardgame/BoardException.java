package boardgame;

public class BoardException extends RuntimeException{
	//Exceção opcional de ser tratada
	
	private static final long serialVersionUID = 1L;
	
	public BoardException(String mgs) {
		super(mgs);
	}
}
