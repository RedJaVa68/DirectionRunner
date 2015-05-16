/**
 * This class contains the player
 * @author Jacob Valdiviez
 *
 */
public class Player {
	/**
	 * Contains x coordinate pos of player
	 */
	private int x;
	/**
	 * Contains y coordinate pos of player
	 */
	private int y;
	/**
	 * Contains name of player
	 */
	private String name;
	/**
	 * initiates the player with a given name and starts him in
	 * (0,0)
	 * @param name
	 */
	public Player(String name){
		this(name,0,0);
	}
	/**
	 * initiates the player with a given name and a given pos.
	 * @param name
	 * @param x
	 * @param y
	 */
	public Player(String name, int x, int y){
		this.name = name;
		this.x = x;
		this.y = y;
	}
	/**
	 * returns the x coordinate of the player
	 * @return int
	 */
	public int getX(){
		return this.x;
	}
	/**
	 * returns the y coordinate of the player
	 * @return int
	 */
	public int getY(){
		return this.y;
	}
	/**
	 * returns the name of the player
	 * @return String
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * sets the x coordinate of the player
	 * @param x
	 */
	public void setX(int x){
		this.x = x;
	}
	/**
	 * sets the y coordinate of the player
	 * @param y
	 */
	public void setY(int y){
		this.y = y;
	}
}
