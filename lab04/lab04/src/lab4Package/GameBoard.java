package lab4Package;
public class GameBoard {

	GameView view;
	GameRuleEngine ruleEngine;
	GamePlayer players;

	/*Change here to edit the size of the board*/
	int rows = 3;
	int columns = 3;
	int[][] board = new int[rows][columns];
	int playerTurn = 0;
	boolean win;


	public GameBoard() {

		ruleEngine = new GameRuleEngine(this);
		players = new GamePlayer(this);

	}
	public int getColumns() {return columns;}
	public int getRows() {return rows;}
	public int getCordinate(int row, int column) {return board[row][column];}

	public void updateBoard(int player,int row, int column) {
		board[row][column] = player;
	}
	public boolean isFull() {
		boolean isFull = true;
		for(int row = 0; row < getRows(); row++)
			for(int column = 0; column < getColumns(); column++) {
				if(board[row][column] == 0) {isFull = false;}
			}
		return isFull;
	}
	public void resetBoard() {
		for(int row = 0; row < getRows(); row++)
			for(int column = 0; column < getColumns(); column++)
				board[row][column] = 0;	
		win = false;
	}
	
	
	public int numOfPlayers() {
		return players.getNumberOfPlayers();
	}
	
	public int playerTurn() {
		return playerTurn = playerTurn % numOfPlayers();
	}
	
	public boolean checkMove(int columns, int rows) {
		if(getCordinate(rows, columns) == 0) {
			return true;
		}
		else return false;		
	}
	
	public void move(int rows, int columns) {
		if(checkMove(columns, rows)) {
			playerTurn = playerTurn % numOfPlayers() + 1;
			updateBoard((playerTurn),rows,columns);			
			if(ruleEngine.checkTheWinner(playerTurn)) {
				win = true;
			}	
		}
	}
	
	

}
