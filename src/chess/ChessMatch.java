package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

//Partida de Xadrez
public class ChessMatch {

	private Board board;
	
	//Construtor da partida
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	//Desenha o tabuleiro
	public ChessPiece[][] getPieces(){
		ChessPiece[][] matriz = new ChessPiece[board.getLinhas()][board.getColunas()];
		for(int i = 0; i < board.getLinhas(); i++) {
			for(int j = 0; j < board.getColunas(); j++) {
				matriz[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return matriz;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validadeSourcePosition(source);
		Piece capturePiece = makeMove(source, target);
		return (ChessPiece) capturePiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return (ChessPiece) capturedPiece;
	}
	
	private void validadeSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("Nao existe peca na posicao de origem.");
		}
	}
	
	private void placeNewPiece(char coluna, int linha, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(coluna, linha).toPosition());
	}
	
	//Responsavel por iniciar a partidade de xadrez, colocando as peças no tabuleiro
	private void initialSetup() {
		 placeNewPiece('c', 2, new Rook(board, Color.WHITE));
	        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
	        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
	        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
	        placeNewPiece('d', 1, new King(board, Color.WHITE));

	        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
	        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
	        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
	        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
	        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
	        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
	
}

