package occamrummy;

public class Rummikub {

	GameBoard gameBoard;
	Player player;
	int turn;
	/**
	 * 
	 */
	public Rummikub() {
		gameBoard = new GameBoard();
		player = new Player();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public void resetGame() {
		gameBoard = new GameBoard();
		player = new Player();
	}
}

