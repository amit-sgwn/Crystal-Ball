package com.example.amit.crystalball;

import android.graphics.drawable.AnimationDrawable;
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
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        mGetAnswer =(TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetAnswer.setText(ball.getAnswer());

                animationCrystalBall();
                answerAnimation();
                playSound();
            }
        });
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
