package in.gov.rajasthan.bhamashah.bhamashah;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class EmptyListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvMessage)
    TextView tvMessage;

    public EmptyListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(String message) {
        tvMessage.setText(message);
    }
}
