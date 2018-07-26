package in.gov.rajasthan.bhamashah.bhamashah.job;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.gov.rajasthan.bhamashah.bhamashah.R;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class JobViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvjobTitle)
    TextView tvJobTitle;

    private View rootView;

    public JobViewHolder(View itemView) {
        super(itemView);
        this.rootView = itemView;
        ButterKnife.bind(this, itemView);
    }

    public void bind(Job job) {
        tvJobTitle.setText(String.format("%s at %s", job.getPosition(), job.getCompany()));
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        rootView.setOnClickListener(onClickListener);
    }
}
