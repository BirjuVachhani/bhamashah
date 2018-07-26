package in.gov.rajasthan.bhamashah.bhamashah;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import in.gov.rajasthan.bhamashah.bhamashah.home.HomeActivity;
import in.gov.rajasthan.bhamashah.bhamashah.utils.PreferenceManager;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        PreferenceManager manager = PreferenceManager.getInstance(this);
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
