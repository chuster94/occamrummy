package occamrummy;

public class Tile {
	
	/* class variables */
	private int number;
	private Color color;
	private int xCoord, yCoord;
	private boolean wild;
	/*
	 * Note:	When tile is a wild the number field is defined as scratch space.
	 */
	
	/**
	 * 
	 * @param number
	 * @param color
	 * @param wild
	 */
	public Tile (int number, Color color, boolean wild) {
		this.setColor(color);
		if (number > 0  && number < 14) {
			this.setNumber(number);
		}
		this.setWild(wild);
		this.setxCoord(0);
		this.setyCoord(0);
	}
	/**
	 * 
	 * @param number
	 * @param color
	 * @param xCoord
	 * @param yCoord
	 */
	public Tile (int number, Color color, boolean wild, int xCoord, int yCoord) {
		this.setColor(color);
		if (number > 0  && number < 14) {
			this.setNumber(number);
		}
		this.setWild(wild);
		this.setxCoord(xCoord);
		this.setyCoord(yCoord);
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * @param xCoord the xCoord to set
	 */
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	/**
	 * @return the xCoord
	 */
	public int getxCoord() {
		return xCoord;
	}
	/**
	 * @param yCoord the yCoord to set
	 */
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	/**
	 * @return the yCoord
	 */
	public int getyCoord() {
		return yCoord;
	}
	public void setWild(boolean wild) {
		this.wild = wild;
	}
	public boolean isWild() {
		return wild;
	}
	
}

