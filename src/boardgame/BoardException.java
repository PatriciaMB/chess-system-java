package boardgame;

public class BoardException extends RuntimeException{
	//Exce��o opcional de ser tratada
	
	private static final long serialVersionUID = 1L;
	
	public BoardException(String mgs) {
		super(mgs);
	}
}
