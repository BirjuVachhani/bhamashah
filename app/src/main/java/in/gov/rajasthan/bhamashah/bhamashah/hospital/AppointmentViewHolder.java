package in.gov.rajasthan.bhamashah.bhamashah.hospital;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.gov.rajasthan.bhamashah.bhamashah.R;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class AppointmentViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ivDelete)
    ImageView ivDelete;

    public AppointmentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Appointment appointment) {

    }

    public void setClickListener(View.OnClickListener onClickListener) {
        ivDelete.setOnClickListener(onClickListener);
    }
}
