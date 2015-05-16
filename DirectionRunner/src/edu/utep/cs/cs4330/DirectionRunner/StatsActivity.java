package edu.utep.cs.cs4330.DirectionRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/**
 * This activity is the highscore screen
 * @author Jacob Valdiviez
 *
 */
public class StatsActivity extends ActionBarActivity{
	/**
	 * This field contains the display for the top highscore
	 */
	TextView text1;
	/**
	 * This field contains the display for the 2nd highscore
	 */
	TextView text2;
	/**
	 * This field contains the display for the 3rd highscore
	 */
	TextView text3;
	/**
	 * This field contains the display for the 4th highscore
	 */
	TextView text4;
	/**
	 * This field contains the display for the 5th highscore
	 */
	TextView text5;
	/**
	 * This method creates the activity and displays all the highscores
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity);
        List<String> highscores = readHighscores();
        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        text3 = (TextView)findViewById(R.id.text3);
        text4 = (TextView)findViewById(R.id.text4);
        text5 = (TextView)findViewById(R.id.text5);
        TextView[] textViews= {text1,text2,text3,text4,text5};
        for(int i = 0; i < highscores.size();i++){
        	textViews[i].setText(highscores.get(i));
        }
    }
    /**
     * This method creates the options menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    /**
     * This method handles items selected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * This method gets the highscores from the text file and returns
     * it into a list of string
     * @return List<String>
     */
    public List<String> readHighscores(){
    	List<String> highscores = new ArrayList<String>();
    	try{
    		FileInputStream foi = openFileInput("highscores.txt");
    		BufferedReader br = new BufferedReader(new InputStreamReader(foi));
    		String line;
    		while((line = br.readLine()) != null){
    			highscores.add(line);
    		}
    	}catch(Exception e){}
    	return highscores;
    }
    /**
     * This method is called when the Back button is clicked
     * @param view
     */
    public void back(View view){
    	Intent intent = new Intent(this,MainActivity.class);
    	startActivity(intent);
    }
}
