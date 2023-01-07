package lab4Package;

public class GameRuleEngine {
	boolean win;
	GameView view;
	GameController controller;
	GameBoard board;

	public GameRuleEngine(GameBoard board) {
		this.board = board;
	}

	public boolean checkColumn(int player) {	
		int columns = board.getColumns();
		int rows = board.getRows();
		for(int column = 0; column < columns; column++) {
			win = true;
			for(int row = 0; row < rows; row++) {
				if(board.getCordinate(row, column) != player) {
					win = false;
				}
			}
			if(win == true) return win;
		}
		return false;
	}
	
	public boolean checkRow(int player) {
		int rows = board.getRows();
		int columns = board.getColumns();
		for(int row = 0; row < rows; row++) {
			win=true;
			for(int column = 0; column < columns; column++) {
				if(board.getCordinate(row, column) != player) {
					win = false;
				}
			}
			if(win == true) return win;
		}
		return false;
	}
	
	public boolean checkLeftDiagonals(int player) {
		win=true;	
		int rows = board.getRows();
		for(int row = 0; row < rows; row++) {
			if(board.getCordinate(row, rows-row-1) != player) {
				win = false;
			}
		}
		if(win == true) return win;
		return false;
	}
	
	public boolean checkRightDiagonals(int player) {
		win=true;
		int rows = board.getRows();
		for(int row = 0; row < rows; row++) {
			if(board.getCordinate(row, row) != player) {
				win = false;
			}
		}
		if(win == true) return win;
		return false;
	}
	
	public boolean checkMove(int columns, int rows) {
		if(board.getCordinate(rows, columns) == 0) {
			return true;
		}
		else return false;		
	}
	
	public boolean checkTheWinner(int player) {
		if(checkColumn(player)|| checkRow(player) || checkLeftDiagonals(player) || checkRightDiagonals(player)) {
			win = true;
		}
		if(win == true) {return win;}
		return false;
	}
}
