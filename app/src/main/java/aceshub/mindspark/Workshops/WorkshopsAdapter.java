package aceshub.mindspark.Workshops;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import aceshub.mindspark.Events.Event_WorkshopDetailsActivity;
import aceshub.mindspark.R;

/**
 * Created by Ashish Pawar(ashishpawar2015.ap@gmail.com) on 1/6/17.
 */

public class WorkshopsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<WorkshopSingleItem> workshopSingleItems;

    public WorkshopsAdapter(Context context, List<WorkshopSingleItem> workshopSingleItems) {
        this.context = context;
        this.workshopSingleItems = workshopSingleItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.workshop_single_item,parent,false);
        return new WorkshopHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final WorkshopHolder workshopHolder=(WorkshopHolder)holder;
        workshopHolder.ivWorkshop.setImageResource(workshopSingleItems.get(position).getWorkshopImage());
        workshopHolder.tvWorkshop.setText(workshopSingleItems.get(position).getWorkshopName());


        /*int colorId = workshopSingleItems.get(position).getBackgroundColor();
        int color = ContextCompat.getColor(workshopHolder.tvWorkshop.getContext(), colorId);
        workshopHolder.cvWorkshop.setCardBackgroundColor(color);*/

        workshopHolder.cvWorkshop.setCardBackgroundColor(ContextCompat.getColor(context, R.color.eventsCardBackground));

        workshopHolder.cvWorkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(workshopHolder.cvWorkshop.getContext(), Event_WorkshopDetailsActivity.class);
                i.putExtra("origin","WorkshopFragment");
                i.putExtra("Workshop",workshopSingleItems.get(position));
                workshopHolder.cvWorkshop.getContext().startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return workshopSingleItems.size();
    }

    private class WorkshopHolder extends RecyclerView.ViewHolder {
        TextView tvWorkshop;
        ImageView ivWorkshop;
        CardView cvWorkshop;
        public WorkshopHolder(View itemView) {
            super(itemView);
            tvWorkshop=(TextView)itemView.findViewById(R.id.tvWorkshop);
            ivWorkshop=(ImageView)itemView.findViewById(R.id.ivWorkshop);
            cvWorkshop=(CardView)itemView.findViewById(R.id.cvWorkshops);
        }

    }
}
