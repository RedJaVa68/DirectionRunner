package edu.utep.cs.cs4330.DirectionRunner;
/**
 * This class stores the direction
 * @author Jacob Valdiviez
 *
 */
public class Direction {
	/**
	 * States whether the direction is up
	 */
	private boolean up;
	/**
	 * States whether the direction is down
	 */
	private boolean down;
	/**
	 * States whether the direction is right
	 */
	private boolean right;
	/**
	 * States whether the direction is left
	 */
	private boolean left;
	/**
	 * Instantiates the direction with a given string ("up","down",
	 * "right","left") makes all booleans false if mispelled
	 * @param direction
	 */
	public Direction(String direction){
		this.up = false;
		this.down = false;
		this.right = false;
		this.left = false;
		if(direction.equalsIgnoreCase("up"))
			this.up = true;
		else if(direction.equalsIgnoreCase("down"))
			this.down = true;
		else if(direction.equalsIgnoreCase("right"))
			this.right = true;
		else if(direction.equalsIgnoreCase("left"))
			this.left = true;
	}
	/**
	 * Instantiates the Direction accordingly to booleans
	 * @param up
	 * @param down
	 * @param right
	 * @param left
	 */
	public Direction(boolean up, boolean down, boolean right, boolean left){
		this.up = up;
		this.down = down;
		this.right = right;
		this.left = left;
	}
	/**
	 * Returns a string telling which way the direction is going
	 * @return String
	 */
	public String direction(){
		if(isUp())
			return "up";
		else if(isDown())
			return "down";
		else if(isRight())
			return "right";
		else
			return "left";
	}
	/**
	 * Checks if the direction is up
	 * @return boolean
	 */
	public boolean isUp(){
		return this.up;
	}
	/**
	 * Checks if the direction is down
	 * @return boolean
	 */
	public boolean isDown(){
		return this.down;
	}
	/**
	 * Checks if the direction is right
	 * @return boolean
	 */
	public boolean isRight(){
		return this.right;
	}
	/**
	 * Checks if the direction is left
	 * @return boolean
	 */
	public boolean isLeft(){
		return this.left;
	}

}