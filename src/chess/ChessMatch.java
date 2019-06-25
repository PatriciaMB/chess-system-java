package chess;

import boardgame.Board;
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
	
	//Responsavel por iniciar a partidade de xadrez, colocando as peças no tabuleiro
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Color.WHITE), new Position(0, 4));
		board.placePiece(new King(board, Color.BLACK), new Position(7, 4));
	}
}

