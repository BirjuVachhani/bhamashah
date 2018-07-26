package in.gov.rajasthan.bhamashah.bhamashah.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.gov.rajasthan.bhamashah.bhamashah.R;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class HomeViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.ivService)
    ImageView ivService;
    @BindView(R.id.tvServiceTitle)
    TextView tvServiceTitle;
    private View rootView;

    public HomeViewHolder(View itemView) {
        super(itemView);
        this.rootView = itemView;
        ButterKnife.bind(this, itemView);
    }

    public void bind(ServiceHolder serviceHolder) {
//        Picasso.get().load(serviceHolder.getImageId()).fit().into(ivService);
        ivService.setImageResource(serviceHolder.getImageId());
        tvServiceTitle.setText(serviceHolder.getServiceTitle());
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        rootView.setOnClickListener(onClickListener);
    }
}
