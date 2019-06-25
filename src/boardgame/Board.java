package boardgame;

public class Board {
	
	private int linhas;
	private int colunas;
	private Piece[][] pieces;
	
	public Board(int linhas, int colunas) {
		//Não faz sentido criar uma tabuleiro com 0 ou menos colunas e linhas
		if(linhas < 1 || colunas < 1) {
			throw new BoardException("Erro ao criar tabuleiro: É necessario que haja pelo menos uma linha e coluna.");
			
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pieces = new Piece[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Piece piece(int linha, int coluna) {
		if(!positionExists(linha, coluna)) {
			throw new BoardException("Posição não existe no tabuleiro.");
		}
		return pieces[linha][coluna];
	}
	
	//Retorna a peça que estiver na matriz na posição expecificada
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não existe no tabuleiro.");
		}
		return pieces[position.getLinha()][position.getColuna()];		
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça nessa posição " + position);
		}
		pieces[position.getLinha()][position.getColuna()] = piece;
		piece.position = position;
	}
	private boolean positionExists(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getLinha(), position.getColuna());	
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não existe no tabuleiro.");
		}
		//Tem uma peça nessa posição?
		return piece(position) != null;
	}
}
