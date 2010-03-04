package occamrummy;

public class GameController {
	
	int turn, player;
	
	/**
	 * constructor
	 */
	public GameController() {
		
	}
	
	public boolean isTurn() {
		return false;
		
	}
	
	/**
	 * handle turn initiation
	 * @return
	 */
	public boolean beginTurn() {
		
		return true;
	}
	/**
	 * pass turn
	 * @return
	 */
	public void endTurn() {
		
	}
	
	/**
	 * handles a move update from current player
	 * @param tile
	 * @return
	 */
	public void getCurrentPlayerMove(Tile tile) {
		
	}
	
	/**
	 * broadcast move to other players
	 * @param g
	 */
	public void broadcastMove(GameBoard g) {
		
	}
	

}
