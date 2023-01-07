package lab4Package;

public class GameController {

	GameView view;
	GameBoard board;
	GameRuleEngine ruleEngine;

	public GameController() {

		board = new GameBoard();
		view = new GameView(this, board.getRows(), board.getColumns());
	}

	public void checkIfTheGameEnded(int row, int column) {
		if(board.isFull() || board.win) {
			reset();
			board.resetBoard();
		}
		
		board.move(row, column);
		view.setTextOfButton(row, column, board.getCordinate(row, column));
		view.setTextOfLabel(" The player " + (board.playerTurn()+1)+ " Turn");
		if(board.win == true){
			view.setTextOfLabel("You won!");
		}
	}
	public void reset() {
		for(int row = 0; row < board.getRows(); row++)
			for(int column = 0; column < board.getColumns(); column++) {
				view.setTextOfButton(row, column, 0);
			}
	}

}


