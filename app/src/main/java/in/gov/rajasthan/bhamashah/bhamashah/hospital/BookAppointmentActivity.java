package in.gov.rajasthan.bhamashah.bhamashah.hospital;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import in.gov.rajasthan.bhamashah.bhamashah.R;

public class BookAppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        ButterKnife.bind(this);
    }
}
