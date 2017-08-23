package com.example.android1.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FadinActivity extends AppCompatActivity implements Animation.AnimationListener{

    Animation animation;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fadin);

        textView=(TextView)findViewById(R.id.text);
        button=(Button)findViewById(R.id.button);
        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fad_in);
        animation.setAnimationListener(this);



        textView.setVisibility(View.INVISIBLE);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                textView.setAnimation(animation);

            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation ==this.animation) {
            Toast.makeText(getApplicationContext(), "Animation Stopped",
                    Toast.LENGTH_SHORT).show();
            textView.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
