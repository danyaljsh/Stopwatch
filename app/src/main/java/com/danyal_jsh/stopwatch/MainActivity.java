package com.danyal_jsh.stopwatch;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private ImageView ivSplash;
  private Button btnGet;
  private TextView tvSplash,tvSubSplash;
  private Animation ivSplashAnim;
  private Animation tvSplashAnim;
  private Animation btnGetAnim;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnGet =findViewById(R.id.btnget);
    tvSplash =findViewById(R.id.tvsplash);
    tvSubSplash =findViewById(R.id.tvsubsplash);
    ivSplash =findViewById(R.id.ivsplash);

    Typeface mLight =Typeface.createFromAsset(getAssets(),"font/MLight.ttf");
    Typeface mMedium =Typeface.createFromAsset(getAssets(),"font/MMedium.ttf");
    Typeface mRegular =Typeface.createFromAsset(getAssets(),"font/MRegular.ttf");

    ivSplashAnim = AnimationUtils.loadAnimation(this,R.anim.ivsplashanimation);
    tvSplashAnim = AnimationUtils.loadAnimation(this,R.anim.tvsplashanim);
    btnGetAnim   = AnimationUtils.loadAnimation(this,R.anim.btngetanim);

    ivSplash.startAnimation(ivSplashAnim);
    tvSplash.startAnimation(tvSplashAnim);
    tvSubSplash.startAnimation(tvSplashAnim);
    btnGet.startAnimation(btnGetAnim);

    tvSplash.setTypeface(mRegular);
    tvSubSplash.setTypeface(mLight);
    btnGet.setTypeface(mMedium);


    btnGet.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent =new Intent(MainActivity.this,StopWatchActivity.class);
        startActivity(intent);
      }
    });


  }
}
