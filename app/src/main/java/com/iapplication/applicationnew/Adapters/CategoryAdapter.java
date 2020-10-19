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
import com.iapplication.applicationnew.R;

import java.util.ArrayList;

    public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Holder> {

        private Context context;
        private ArrayList<CategoryModel> mainCategoryDMS;
        private OnMainCategoryItemClicked onMainCategoryItemClicked;
        private int lastIndex = 0;
        private int selectedPosition;


        public CategoryAdapter(Context context, ArrayList<CategoryModel> mainCategoryDMS,
                                        OnMainCategoryItemClicked onMainCategoryItemClicked, int selectedPosition) {
            this.context = context;
            this.mainCategoryDMS = mainCategoryDMS;
            this.onMainCategoryItemClicked = onMainCategoryItemClicked;
            this.selectedPosition = selectedPosition;




        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_catogory, parent, false);


            return new Holder(itemView);
        }

        @Override
        public void onBindViewHolder(final Holder holder, int position) {
            CategoryModel categoryModel = mainCategoryDMS.get(position);

            holder.buttonCategory.setText(categoryModel.getName());
            holder.catImage.setImageResource(categoryModel.getIcon());



        }

        @Override
        public int getItemCount() {
            return mainCategoryDMS.size();
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
            void OnCategoryItemClicked(CategoryModel categoryModel);
        }


    }
