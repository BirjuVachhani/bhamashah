package in.gov.rajasthan.bhamashah.bhamashah.job;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.gov.rajasthan.bhamashah.bhamashah.AppData;
import in.gov.rajasthan.bhamashah.bhamashah.Constants;
import in.gov.rajasthan.bhamashah.bhamashah.R;
import in.gov.rajasthan.bhamashah.bhamashah.job.Job;
import in.gov.rajasthan.bhamashah.bhamashah.job.JobDetailsActivity;
import in.gov.rajasthan.bhamashah.bhamashah.job.JobsAdapter;

public class JobsActivity extends AppCompatActivity implements JobsAdapter.JobSelectionListener {

    @BindView(R.id.rvJobList)
    RecyclerView rvJobsList;

    @BindView(R.id.ivBack)
    ImageView ivBack;

    @BindView(R.id.etJobSearch)
    EditText etJobSearch;

    @BindView(R.id.ivSearch)
    ImageView ivSearch;

    private TextWatcher searchWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            filterList(s.toString());
        }
    };

    private void filterList(String search) {
        ArrayList<Job> allJobs = AppData.getJobs();
        ArrayList<Job> filteredList = new ArrayList<>();
        for (Job job : allJobs) {
            if (job.getCompany().toLowerCase().contains(search.toLowerCase())
                    || job.getCity().toLowerCase().contains(search.toLowerCase())
                    || job.getCompany().toLowerCase().contains(search.toLowerCase())) {
                filteredList.add(job);
            }
        }
        adapter.setList(filteredList);
    }

    private JobsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);
        ButterKnife.bind(this);

        adapter = new JobsAdapter(this, AppData.getJobs());
        rvJobsList.setAdapter(adapter);
        rvJobsList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvJobsList.setLayoutManager(new LinearLayoutManager(this));
        etJobSearch.addTextChangedListener(searchWatcher);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void searchHospitals(View view) {
        //TODO search hospital here
        filterList(etJobSearch.getText().toString());
    }

    public void navigateBack(View view) {
        finish();
    }

    @Override
    public void onJobSelected(Job job) {
        //TODO show hospital details
        Intent intent = new Intent(this, JobDetailsActivity.class);
        intent.putExtra(Constants.JOB, job);
        startActivity(intent);
    }
}
