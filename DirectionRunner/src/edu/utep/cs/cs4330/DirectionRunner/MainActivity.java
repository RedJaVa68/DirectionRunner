package edu.utep.cs.cs4330.DirectionRunner;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * This Activity is the Main activity where the home screen appears
 * for the application
 * @author Jacob Valdiviez
 *
 */
public class MainActivity extends ActionBarActivity {
	/**
	 * This field contains the text editor found in the Main Activity
	 */
	EditText username;
	/**
	 * This creates the activity
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.username);
    }
    /**
     * This creates the options menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    /**
     * This handles when items is selected
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
     * This method is called when the play button is clicked
     * @param view
     */
    public void play(View view){
    	// Show dialog about installing the theme
    	final String name = username.getText().toString();
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Are you sure?");
        alert.setMessage("Your playername will be '" + name + "'");
        alert.setPositiveButton("OK",
        		new DialogInterface.OnClickListener() {
              	public void onClick(DialogInterface dialog, int id) {
                  	// Here actually start the GoLauncher
                  	final Intent intent = new Intent(MainActivity.this,GameActivity.class);
                  	intent.putExtra("name", name);
              		intent.putExtra("level", 1);
              		intent.putExtra("score", 0);
              		intent.putExtra("save", false);
                  	startActivity(intent);
              	}
        });
        alert.setNegativeButton("Cancel",
        		new DialogInterface.OnClickListener() {
            	public void onClick(DialogInterface dialog, int id) {
            	}
        });
        alert.show();
    }
    /**
     * This method is called when the highscore button is clicke
     * @param view
     */
    public void stats(View view){
    	Intent intent = new Intent(this,StatsActivity.class);
    	startActivity(intent);
    }
}
