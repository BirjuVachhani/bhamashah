package in.gov.rajasthan.bhamashah.bhamashah.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.gov.rajasthan.bhamashah.bhamashah.R;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private final ServiceSelectionListener listener;
    private List<ServiceHolder> mList;

    public HomeAdapter(List<ServiceHolder> mList, Context context) {
        this.listener = (ServiceSelectionListener) context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeViewHolder holder, int position) {
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onServiceSelected(holder.getAdapterPosition());
            }
        };
        holder.bind(mList.get(position));
        holder.setClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    interface ServiceSelectionListener {
        void onServiceSelected(int position);
    }
}
