package com.example.tharani.musicplayer;
/*import is libraries imported for writing the code
* AppCompatActivity is base class for activities
* Bundle handles the orientation of the activity
*/
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /*onCreate is the first method in the life cycle of an activity
        savedInstance passes data to super class,data is pull to store state of application
      * setContentView is used to set layout for the activity
      *R is a resource and it is auto generate file
      * activity_main assign an integer value*/
        //Declaring variables
        Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creating & initializing objects by ID.
        start =  findViewById(R.id.start);
        stop =  findViewById(R.id.stop);
        // Calling onClick Methods
        start.setOnClickListener(this);//starts
        stop.setOnClickListener(this);//stops
    }

    @Override
    public void onClick(View view) {
        // A Switch is a two-state toggle switch widget that can select between two options.
        switch (view.getId()) { // Construct a new Switch
            //A switch statement allows a variable to be tested for equality against a list of values. Each value is called a case,
            // and the variable being switched on is checked for each case
            case R.id.start:// Start Music
                startService(new Intent(this, MyService.class)); // Starts the service
                Toast.makeText(this, "Music  started", Toast.LENGTH_LONG).show(); //Toast message
                //A toast is a view containing a quick little message
                //LENGTH_LONG Show the view or text notification for a long period of time
                break; //Break statement
            case R.id.stop:// Stop music
                stopService(new Intent(this, MyService.class)); // Starts the service
                Toast.makeText(this, "Music stoped", Toast.LENGTH_LONG).show(); //Toast message
                //A toast is a view containing a quick little message
                //LENGTH_LONG Show the view or text notification for a long period of time
                break; //Break statement

        }
    }
    }

