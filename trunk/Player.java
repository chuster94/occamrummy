

public class Player {

	/* class variables */
	private Tile hand[];
	private int id;
	private static int MAXHANDSIZE = 93;
	
	Player() {
		setHand(new Tile[MAXHANDSIZE]);
	}

	/**
	 * @param hand the hand to set
	 */
	public void setHand(Tile hand[]) {
		this.hand = hand;
	}

	/**
	 * @return the hand
	 */
	public Tile[] getHand() {
		return hand;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param newTile
	 * @return
	 */
	public boolean insertTile(Tile newTile, int index) {
		if (hand[index] == null) {
			hand[index] = newTile;
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Tile removeTile(int index) {
		return hand[index];
	}
}
