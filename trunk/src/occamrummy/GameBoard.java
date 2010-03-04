package occamrummy;

import java.util.Random;

/*
 * This class contains the central game board and methods to use it.
 */
public class GameBoard {
	/* class variables */
	private int BOARDSIZEX = 15, BOARDSIZEY = 15, POTSIZE = 106;
	private Tile gameBoard[][];
	private Tile pot[];
	
	/**
	 * Constructor for GameBoard class.
	 */
	public GameBoard() {
		gameBoard = new Tile[BOARDSIZEX][BOARDSIZEY];
		pot = new Tile[POTSIZE];
		//populate pot
		int counter = 0;
		for (int numbers = 1; numbers < 14; numbers++) {
				pot[counter] = new Tile(numbers, Color.Black, false);
				counter++;
				pot[counter] = new Tile(numbers, Color.Red, false);
				counter++;
				pot[counter] = new Tile(numbers, Color.Blue, false);
				counter++;
				pot[counter] = new Tile(numbers, Color.Yellow, false);
				counter++;
				pot[counter] = new Tile(numbers, Color.Black, false);
				counter++;
				pot[counter] = new Tile(numbers, Color.Red, false);
				counter++;
				pot[counter] = new Tile(numbers, Color.Blue, false);
				counter++;
				pot[counter] = new Tile(numbers, Color.Yellow, false);
				counter++;
		}
		pot[counter] = new Tile(0, Color.Black, true);
		counter++;
		pot[counter] = new Tile(0, Color.Black, true);
	}
	/**
	 * 
	 * @param newTile	Tile to be inserted
	 * @return			True if insert successful, false otherwise
	 */
	public boolean insertTile(Tile newTile, int xCoord, int yCoord) {
		if (gameBoard[xCoord][yCoord] == null) {
			gameBoard[yCoord][yCoord] = newTile;
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 
	 * @param xCoord	X coordinate on game board
	 * @param yCoord	Y coordinate on game board
	 * @return			Tile object at coordinates given, null if no tile found.
	 */
	public Tile removeTile(int xCoord, int yCoord) {
		Tile tempTile = gameBoard[xCoord][yCoord];
		gameBoard[xCoord][yCoord] = null;
		return tempTile;
	}
	/**
	 * 
	 * @param xCoord	X coordinate on game board.
	 * @param yCoord	Y coordinate on game board.
	 * @return			Tile object at coordinates given, null if no tile found.
	 */
	public Tile viewTile(int xCoord, int yCoord) {
		return gameBoard[xCoord][yCoord];
	}
	/**This draw method will become inefficient when there are only a few tiles left in pot.
	 * 
	 * @return Randomly drawn tile from pot.
	 */
	public Tile DrawTile() {
		while (true) {
			Random r = new Random();
			int seed = r.nextInt()%106;
			if (pot[seed] != null)
			{
				Tile temp = pot[seed];
				pot[seed] = null;
				return temp;
			}
		}
	}
	/**
	 * 
	 * @param gameBoard
	 */
	public void updateBoard(Tile[][] gameBoard) {
		if (gameBoard != null) {
			this.gameBoard = gameBoard;
		}
	}
	/**
	 * 
	 * @param pot
	 */
	public void updatePot(Tile[] pot) {
		if (pot != null) {
			this.pot = pot;
		}
	}
	/**
	 * 
	 * @return		True if board is in a valid state, false otherwise.
	 */
	public boolean isValid(){
		
		//loop through each row
		for(int row = 0; row < BOARDSIZEY; row++)
		{	
			int column = 0;
			//find all substrings in current row
			while (column < BOARDSIZEX) {
				int subStringStart, subStringEnd;
				//find first tile in substring
				while (gameBoard[row][column] == null) {
					if (column < BOARDSIZEX-1) {
						column++;
					} else {
						break;
					}
				}
				//check for end of column
				if (column >= BOARDSIZEX) {
					break;
				}
				subStringStart = column;
				column++;
				//find end of substring
				while(gameBoard[row][column] != null) {
					if (column < BOARDSIZEX-1) {
						column++;
					} else {
						column++;
						break;
					}
				}
				subStringEnd = column-1;
				//validate substring found
				if (!validateSubString(row, subStringStart, subStringEnd)) {
					return false;
				}
			}	
		}
		return true;
	}
	/**
	 * 
	 * @param row		Y coordinate of row being examined
	 * @param start		X coordinate of substring start
	 * @param end		X coordinate of substring end
	 * @return			True if substring is valid, false otherwise.
	 */
	private boolean validateSubString(int row, int start, int end) {
		/* check length of substring */
		int length = end - start;
		if (length < 3 || length > 13) {
			return false;
		}
		/* determine if substring is a sequence or a set */
		if (gameBoard[row][start].getNumber() == gameBoard[row][start+1].getNumber()) {
		  /* substring is a SET */
			if (length > 4) {
				 return false;
			} else if (gameBoard[row][start].getNumber() != gameBoard[row][start+2].getNumber()) {
				return false;
			} else if (length == 3) {
				return true;
			} else if (gameBoard[row][start].getNumber() == gameBoard[row][start+3].getNumber()) {
				return true;
			} else {
				return false;
			}
		} else {
		  /* substring is a SEQUENCE */
			for (int column = start+1; column <= end; column++) {
				if (gameBoard[row][column-1].getNumber() != gameBoard[row][column].getNumber()+1) {
					return false;
				} else if (gameBoard[row][start].getColor() != gameBoard[row][column].getColor()) {
						return false;
				}
			}
			return true;
		}
	}
}

