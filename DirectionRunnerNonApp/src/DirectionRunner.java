/**
 * This class puts the entire game together.
 * @author Jacob Valdiviez
 *
 */
public class DirectionRunner {
	/**
	 * This field contains the user of the user who is playing
	 */
	private User user;
	/**
	 * This field contains the game handler
	 */
	private GameManager game;
	/**
	 * This field checks whether the user has made it to a new level
	 */
	private boolean newLevel;
	/**
	 * This field checks whether the user lost or won
	 */
	private boolean lost;
	/**
	 * This field contains the minutes
	 */
	private int min;
	/**
	 * This field contains the seconds
	 */
	private int sec;
	/**
	 * Instantiates the class with a given username
	 * @param name
	 */
	public DirectionRunner(String name){
		this.user = new User(name);
		this.lost = false;
		this.min = 5;
		this.sec = 0;
		this.game = new GameManager(name,this.min,this.sec);
		this.newLevel = false;
		this.game.initialize();
	}
	/**
	 * Plays the game
	 * Fix me
	 */
	public void playGame(){
		while(!this.game.getClock().timeRunOut()){
			if((this.game.getBoard().getPlayer().getX() == this.game.getBoard().getRows()) && (this.game.getBoard().getPlayer().getY() == this.game.getBoard().getColumns())){
				this.user.setScore(this.user.getScore() + 1000 + (this.user.getLevel() * 35));
				this.user.levelUp();
				this.newLevel = true;
				try{
					Thread.sleep(5000);
				}catch(Exception e){}
				this.newLevel = false;
				if(sec == 0){
					min --;
					sec = 30;
				}else{
					sec = 0;
				}
				this.game = new GameManager(this.user.getUsername(),min, sec);
				this.game.initialize();
			}
		}
		this.lost = true;
	}
	/**
	 * Returns whether the player lost or not
	 * @return boolean
	 */
	public boolean lost(){
		return this.lost;
	}
	/**
	 * Returns whether the user is in a new level or not
	 * @return boolean
	 */
	public boolean newLevel(){
		return this.newLevel;
	}
	/**
	 * Returns the gamemanager
	 * @return GameManager
	 * @see GameManager
	 */
	public GameManager getGame(){
		return this.game;
	}
 

}
