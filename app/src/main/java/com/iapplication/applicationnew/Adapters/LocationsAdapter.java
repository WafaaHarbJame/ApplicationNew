package com.iapplication.applicationnew.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iapplication.applicationnew.Models.CategoryModel;
import com.iapplication.applicationnew.Models.LocationModel;
import com.iapplication.applicationnew.R;

import java.util.ArrayList;

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.Holder> {

    private Context context;
    private ArrayList<LocationModel> locationModels;
    private OnMainCategoryItemClicked onMainCategoryItemClicked;
    private int lastIndex = 0;
    private int selectedPosition;


    public LocationsAdapter(Context context, ArrayList<LocationModel> mainCategoryDMS,
                            OnMainCategoryItemClicked onMainCategoryItemClicked, int selectedPosition) {
        this.context = context;
        this.locationModels = mainCategoryDMS;
        this.onMainCategoryItemClicked = onMainCategoryItemClicked;
        this.selectedPosition = selectedPosition;




    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_location_item, parent, false);


        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        LocationModel locationModel = locationModels.get(position);

        holder.buttonCategory.setText(locationModel.getName());

        Glide.with(context).load(locationModel.getIcon()).thumbnail(0.05f).into(holder.catImage);



    }

    @Override
    public int getItemCount() {
        return locationModels.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView buttonCategory;
        ImageView catImage;
        View line;

        Holder(View view) {
            super(view);
            buttonCategory = view.findViewById(R.id.btnCategory);
            catImage = view.findViewById(R.id.ivCatImage);


        }
    }

    public interface OnMainCategoryItemClicked {
        void OnCategoryItemClicked(LocationModel locationModel);
    }


}
