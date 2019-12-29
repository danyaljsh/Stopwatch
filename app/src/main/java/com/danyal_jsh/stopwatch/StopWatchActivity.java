package com.danyal_jsh.stopwatch;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

  private Button btnStart,btnStop;
  private ImageView ivAnchor;
  private Animation ivAnchorAnim;
  private Chronometer timerHere;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_stop_watch);

    btnStart =findViewById(R.id.btnstart);
    btnStop =findViewById(R.id.btnstop);
    ivAnchor =findViewById(R.id.ivanchor);
    timerHere =findViewById(R.id.timerhere);

    btnStop.setAlpha(0);
    //load Animation
    ivAnchorAnim = AnimationUtils.loadAnimation(this,R.anim.anchoranim);

    //load font
    Typeface mMedium =Typeface.createFromAsset(getAssets(),"font/MMedium.ttf");

    //customize font
    btnStart.setTypeface(mMedium);

    btnStart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
       //start Animation
      ivAnchor.startAnimation(ivAnchorAnim);
      btnStop.animate().alpha(1).translationY(-160).setDuration(500).start();
      btnStart.animate().alpha(0).setDuration(500).start();

      //startTime
        timerHere.setBase(SystemClock.elapsedRealtime());
        timerHere.start();
      }
    });
  }
}
