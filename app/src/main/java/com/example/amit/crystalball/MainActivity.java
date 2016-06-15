package com.example.amit.crystalball;

import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CrystalBall ball = new CrystalBall();
    TextView mGetAnswer;
    ImageView mCrystalball;
    private SensorManager mSensorManager;
    private Sensor mAccelarometer ;
    private ShakeDetector mShakeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        mGetAnswer =(TextView)findViewById(R.id.textView);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelarometer =mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {
                handleNewAnswer();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.registerListener(mShakeDetector,mAccelarometer,SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.unregisterListener(mShakeDetector);
    }

    private void handleNewAnswer() {
        mGetAnswer.setText(ball.getAnswer());

        animationCrystalBall();
        answerAnimation();
        playSound();
    }


    private void animationCrystalBall(){

        mCrystalball = (ImageView)findViewById(R.id.imageView);
        mCrystalball.setImageResource(R.drawable.ball_animation);
        AnimationDrawable animation = (AnimationDrawable) mCrystalball.getDrawable();
        animation.start();
    }
    private void answerAnimation() {
        AlphaAnimation fadeanim = new AlphaAnimation(0,1);
        fadeanim.setDuration(1500);
        mGetAnswer.setAnimation(fadeanim);

    }

    private void playSound(){
        MediaPlayer player = MediaPlayer.create(this,R.raw.crystal_ball);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
