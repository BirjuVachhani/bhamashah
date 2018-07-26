package in.gov.rajasthan.bhamashah.bhamashah.job;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.gov.rajasthan.bhamashah.bhamashah.Constants;
import in.gov.rajasthan.bhamashah.bhamashah.R;

public class JobDetailsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @BindView(R.id.tvPosition)
    TextView tvPosition;

    @BindView(R.id.tvCompany)
    TextView tvCompany;

    @BindView(R.id.tvCity)
    TextView tvCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);
        ButterKnife.bind(this);

        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent() != null) {
            Job job = getIntent().getParcelableExtra(Constants.JOB);
            getSupportActionBar().setTitle(job.getPosition());

            setJobData(job);
        }
    }

    private void setJobData(Job job) {
        tvPosition.setText(job.getPosition());
        tvCompany.setText(job.getCompany());
        tvCity.setText(job.getCity());
    }

    public void applyNow(View view) {
        //TODO open application form
    }
}
