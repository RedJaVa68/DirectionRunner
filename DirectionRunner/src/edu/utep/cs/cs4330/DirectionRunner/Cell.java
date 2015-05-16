package edu.utep.cs.cs4330.DirectionRunner;

/**
 * This class contains the data of a cell
 * @author Jacob Valdiviez
 *
 */
public class Cell {
	/**
	 * X coordinate of the cell
	 */
	private int x;
	/**
	 * Y coordinate of the cell
	 */
	private int y;
	/**
	 * The direction a cell has
	 * @see Direction
	 */
	private Direction direction;
	/**
	 * Instantiates the cell with 0,0 coordinates and a Direction
	 * @param direction
	 * @see Direction
	 */
	public Cell(Direction direction){
		this(direction,0,0);
	}
	/**
	 * Instantiates the cell with a given x and y coordinates and a
	 * direction
	 * @param direction
	 * @param x
	 * @param y
	 * @see Direction
	 */
	public Cell(Direction direction, int x, int y){
		this.direction = direction;
		this.x = x;
		this.y = y;
	}
	/**
	 * Returns the x coordinate of the cell
	 * @return int
	 */
	public int getX(){
		return this.x;
	}
	/**
	 * Returns the y coordinate of the cell
	 * @return int
	 */
	public int getY(){
		return this.y;
	}
	/**
	 * Returns the direction located in the cell
	 * @return Direction
	 * @see Direction
	 */
	public Direction getDirection(){
		return this.direction;
	}
}