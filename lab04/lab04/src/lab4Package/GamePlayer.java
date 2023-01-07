package lab4Package;

public class GamePlayer {	
	GameBoard board;
	/*Change Here If You Want Add More Players*/
	int numOfPlayer = 2;

	public GamePlayer(GameBoard board) {	
		this.board = board;
	}
	public int getNumberOfPlayers() {
		return numOfPlayer;	
	}

}
