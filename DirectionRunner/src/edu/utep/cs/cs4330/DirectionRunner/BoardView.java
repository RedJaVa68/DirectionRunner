package edu.utep.cs.cs4330.DirectionRunner;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/**
 * This class contains the Board UI
 * @author Jacob Valdiviez
 *
 */
public class BoardView extends View{
	/**
	 * This field contains the color of the background
	 */
	private int backgroundColor = Color.rgb(255, 255, 255);
	/**
	 * This field contains the paint used for the cells
	 */
	private Paint paint = new Paint();
	/**
	 * This field contains the cell width of the board
	 */
	int cellWidth;
	/**
	 * This field contains the cell Height of the board
	 */
	int cellHeight;
	/**
	 * This contains the game
	 */
	private GameManager game;
	/**
	 * This method draws a cell within the board
	 * @param value
	 * @param x
	 * @param y
	 * @param canvas
	 */
	public void drawCell(int value, int x, int y, android.graphics.Canvas canvas){
		this.paint.setColor(Color.BLACK);
		int x1 = x * cellWidth, y1 = (y * cellHeight), x2 = (x + 1) * cellWidth, y2 = (y + 1) * cellHeight;
		int tx = (x1 + x2)/2, ty = (y1 + y2)/2;
		canvas.drawRect(x1,y1,x2,y2, this.paint);
		if(value >= 0){
			this.paint.setColor(Color.rgb(230, 0, 0));
			for(int i = y1; i < y2; i ++){
				canvas.drawLine(x1+1, i+1, x2-1, i+1, this.paint);
			}
		}
		else{
			this.paint.setColor(this.backgroundColor);
			canvas.drawRect(x1+1,y1+1,x2-1,y2-1, this.paint);
		}
	}
	/**
	 * This method updates the board display
	 */
	public void update(android.graphics.Canvas canvas){
		Board temp = this.game.getBoard();
		int x = temp.getCells().length - 1;
		for(int i = 0; i < temp.getCells().length; i ++){
			for(int j = 0; j < temp.getCells()[i].length; j ++){
				if((temp.getCells()[i][j].getX() == this.game.getPlayerX())&&(temp.getCells()[i][j].getY() == this.game.getPlayerY())){
					drawCell(0,j,x,canvas);
				}
				else{
					drawCell(-1,j,x,canvas);
				}
			}
			x --;
		}
	}
	/**
	 * Instantiates the class
	 * @param context
	 */
	public BoardView(Context context){
		super(context);
	}
	/**
	 * Instantiates the class
	 * @param context
	 */
	public BoardView(Context context, AttributeSet attrs){
		super(context,attrs);
	}
	/**
	 * Instantiates the class
	 * @param context
	 */
	public BoardView(Context context, AttributeSet attrs, int defStyle){
		super(context,attrs,defStyle);
	}
	/**
	 * This overrides the onDraw method with drawing the
	 * current state of the board.
	 */
	@Override
	protected void onDraw(android.graphics.Canvas canvas){
		super.onDraw(canvas);
		//this.cellWidth = 100;
		this.cellWidth = (getMeasuredWidth() - 100) / 5;
		//this.cellHeight = 100;
		this.cellHeight = (getMeasuredHeight() - 100) / 7;
		update(canvas);
	}
	/**
	 * This method sets the GameManager with a new game
	 * @see GameManager
	 * @param game
	 */
	public void setGame(GameManager game){
		this.game = game;
	}
	/**
	 * This method makes sure the board is visible and not overlapping other
	 * components inside the same layout
	 */
	@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {     
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);      
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);     
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        int newH = (int)(parentHeight / 1.5f);
        this.setMeasuredDimension(parentWidth, newH);
    }
}
