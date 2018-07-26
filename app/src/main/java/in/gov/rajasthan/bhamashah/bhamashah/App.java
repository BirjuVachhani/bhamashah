package in.gov.rajasthan.bhamashah.bhamashah;

import android.app.Application;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppData.init(this);
    }
}
