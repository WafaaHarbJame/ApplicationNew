package com.iapplication.applicationnew.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.iapplication.applicationnew.Models.SliderModel;
import com.iapplication.applicationnew.R;
import com.iapplication.applicationnew.databinding.RowSliderLayoutItemBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;
    private List<SliderModel> mSliderItems = new ArrayList<>();


    public SliderAdapter(Context context, List<SliderModel> mSliderItems) {
        this.mSliderItems = mSliderItems;
        this.context = context;
    }

    public void renewItems(List<SliderModel> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(SliderModel sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        RowSliderLayoutItemBinding itemView = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.row_slider_layout_item, parent, false);

        return new SliderAdapterVH(itemView);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        SliderModel sliderItem = mSliderItems.get(position);

        Glide.with(context).asBitmap().load(sliderItem.getSlider_image()).into(viewHolder.binding.imageIv);


    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        RowSliderLayoutItemBinding binding;

        SliderAdapterVH(RowSliderLayoutItemBinding view) {
            super(view.getRoot());
            binding = view;
        }
    }

}