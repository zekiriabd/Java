package com.example.playingaudiofile;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startMp3(View v) {
        //Toast.makeText(this, "اللهم رب هذه الدعوة التامة، والصلاة القائمة، آت محمدًا الوسيلة والفضيلة، وابعثه مقامًا محمودًا الذي وعدته إنك لا تخلف الميعاد",Toast.LENGTH_SHORT).show();
        //mediaPlayer = MediaPlayer.create(this,Uri.parse("http://praytimes.org/audio/adhan/Sunni/Abdul-Hakam.mp3"));
        mediaPlayer = MediaPlayer.create(this,R.raw.adhan);
        mediaPlayer.start();
    }

    public void stopMp3(View v){
        mediaPlayer.stop();
        mediaPlayer.release();
    }


}
