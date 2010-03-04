package occamrummy;
/**
 * 
 * @author 
 * defines the API and responsibilities of the user interface / graphics module
 */
public interface GameUI {
	/*
	 * displays gamestate
	 * prints to display for human
	 * other format for AI
	 */
	public void printBoard(GameBoard b);
	
	public Tile getMove();
	/*
	 * handles mouse pressed, released.  triggers
	 */
}
