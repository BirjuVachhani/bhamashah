package in.gov.rajasthan.bhamashah.bhamashah.hospital;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.gov.rajasthan.bhamashah.bhamashah.R;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class HospitalViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvHospitalName)
    TextView tvHospitalName;

    @BindView(R.id.tvCityName)
    TextView tvCityName;

    private View rootView;

    public HospitalViewHolder(View itemView) {
        super(itemView);
        this.rootView = itemView;
        ButterKnife.bind(this, itemView);
    }

    public void bind(Hospital hospital) {
        tvHospitalName.setText(hospital.getName());
        tvCityName.setText(hospital.getCity());
    }


    public void setClickListener(View.OnClickListener onClickListener) {
        rootView.setOnClickListener(onClickListener);
    }
}
