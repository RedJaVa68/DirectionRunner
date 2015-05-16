package edu.utep.cs.cs4330.DirectionRunner;
/**
 * This is a countdown timer
 * @author Jacob Valdiviez
 *
 */
public class Clock implements Runnable{
	/**
	 * This contains the amount of minutes in the timer
	 */
	private int minutes;
	/**
	 * This contains the amount of seconds in the timer
	 */
	private int seconds;
	/**
	 * This determines whether the clock ran out of time
	 */
	private boolean timeRunOut;
	/**
	 * This instantiates the clock with a given minutes and seconds
	 * @param minutes
	 * @param seconds
	 */
	public Clock(int minutes, int seconds){
		this.minutes = minutes;
		this.seconds = seconds;
		this.timeRunOut = false;
	}
	/**
	 * This decrements the time
	 */
	public void run() {
		while(minutes > 0 || seconds > 0){
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
			if(seconds == 0){
				minutes --;
				seconds = 59;
			}
			else
				seconds --;
		}
		this.timeRunOut = true;
	}
	/**
	 * This checks whether the time ran out or not
	 * @return boolean
	 */
	public boolean timeRunOut(){
		return this.timeRunOut;
	}

}
