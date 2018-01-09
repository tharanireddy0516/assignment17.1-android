package com.example.tharani.musicplayer;
/*import is libraries imported for writing the code
* AppCompatActivity is base class for activities
* Bundle handles the orientation of the activity
*/
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Tharani on 01/09/2018.
 */

/**
  * A Service is an application component that can perform long-running operations in the background
       and it does not provide a user interface.
  * Creating class Music_Service and extends it from Service base class .
 */
public class MyService extends Service {
    // MediaPlayer class can be used to control playback of audio/video files and streams.
    MediaPlayer mediaPlayer; //Declaring variable
    @Nullable
    @Override
    /*
    onBind()returns an IBinder object that defines the programming interface that clients
       can use to interact with the service.
     */
    public IBinder onBind(Intent intent) {
        return null;//returns null
    }

    @Override
    public void onCreate() { //onCreate is Called by the system when the service is first created.
        /*
          Raw folder in Android is used to keep mp3 or ogg audio files and also video files.
         The raw folder is created inside resource folder.
         */
       /**  Creating & initializing Media player object by ID.
         getApplicationContext() : Returns the context for the entire application
         raw is included in the res folder of android project. You can add an assets files in raw folder like music files
        added music that is good life*/
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.goodlife);
        mediaPlayer.setLooping(true); //Loop will execute till the condition is true
    }

    @Override
    // onStartCommand is called by the system every time a client explicitly starts the service.
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start(); //Starting media player

        //Providing the arguments it supplied and a unique integer token representing the start request.
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    //onDestroy is called by the system to notify a Service that it is no longer used .
    public void onDestroy() {
        mediaPlayer.stop();// Media player stops
    }
}
