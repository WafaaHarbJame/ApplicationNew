package com.iapplication.applicationnew.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.iapplication.applicationnew.Adapters.CategoryAdapter;
import com.iapplication.applicationnew.Adapters.LocationsAdapter;
import com.iapplication.applicationnew.Adapters.SliderAdapter;
import com.iapplication.applicationnew.Models.CategoryModel;
import com.iapplication.applicationnew.Models.LocationModel;
import com.iapplication.applicationnew.Models.SliderModel;
import com.iapplication.applicationnew.R;
import com.iapplication.applicationnew.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements CategoryAdapter.OnMainCategoryItemClicked,LocationsAdapter.OnMainCategoryItemClicked {

    // TODO: Data Binding
    private FragmentHomeBinding binding;
    // TODO: Activity Context
    private Context context;
    // TODO: Views
    private View view;
    private List<SliderModel> mSliderItems;
    // TODO: Category Data
    private ArrayList<CategoryModel> categoryModels;
    private CategoryAdapter categoryAdapter;
    private GridLayoutManager gridCategoryManger;

    // TODO: popular location  Data
    private ArrayList<LocationModel> locationModels;
    private LocationsAdapter locationsAdapter;
    private LinearLayoutManager linearLayoutManager;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.fragment_home, container, false);
        view = binding.getRoot();
        context = getActivity();

        getSlider();
        //getCategory();
        getPopularLocation();
        binding.swlRefreshList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.swlRefreshList.setRefreshing(false);
            }
        });

        return view;
    }

    private void getPopularLocation() {

        locationModels=new ArrayList<>();
        binding.listLocation.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        binding.listLocation.setLayoutManager(linearLayoutManager);
        locationModels.add(new LocationModel(1,getString(R.string.shopping),"https://slidervilla.com/smooth-slider/files/2014/05/6.jpg"));
        locationModels.add(new LocationModel(2,getString(R.string.CofeeBar),"https://slidervilla.com/smooth-slider/files/2014/05/6.jpg"));
        locationModels.add(new LocationModel(3,getString(R.string.Events),"https://slidervilla.com/smooth-slider/files/2014/05/6.jpg"));
        locationModels.add(new LocationModel(4,getString(R.string.Real_Estate),"https://slidervilla.com/smooth-slider/files/2014/05/6.jpg"));
        locationModels.add(new LocationModel(5,getString(R.string.Jobseeker),"https://slidervilla.com/smooth-slider/files/2014/05/6.jpg"));
        locationModels.add(new LocationModel(6,getString(R.string.Restaurant),"https://slidervilla.com/smooth-slider/files/2014/05/6.jpg"));
        locationsAdapter=new LocationsAdapter(context,locationModels,this,0);
        binding.listLocation.setAdapter(locationsAdapter);

    }

    private void getCategory() {

        categoryModels=new ArrayList<>();
        // TODO: Add Recycle Shop View Layout Manger
        binding.listCategory.setHasFixedSize(true);
        gridCategoryManger = new GridLayoutManager(context, 4, LinearLayoutManager.VERTICAL, false);
        binding.listCategory.setLayoutManager(gridCategoryManger);
        categoryModels.add(new CategoryModel(1,getString(R.string.shopping),R.drawable.ic_shopping_basket,R.color.red));
        categoryModels.add(new CategoryModel(2,getString(R.string.CofeeBar),R.drawable.ic_tea_cup,R.color.green));
        categoryModels.add(new CategoryModel(3,getString(R.string.Events),R.drawable.ic_star,R.color.blue));
        categoryModels.add(new CategoryModel(4,getString(R.string.Real_Estate),R.drawable.ic_shake_hands,R.color.gray1));
        categoryModels.add(new CategoryModel(5,getString(R.string.Jobseeker),R.drawable.ic_jobseeker,R.color.green1));
        categoryModels.add(new CategoryModel(6,getString(R.string.Restaurant),R.drawable.ic_restaurant,R.color.red));
        categoryModels.add(new CategoryModel(7,getString(R.string.Automotive),R.drawable.ic_sedan_car_front,R.color.green));
        categoryModels.add(new CategoryModel(8,getString(R.string.More),R.drawable.ic_more,R.color.blue));
        categoryAdapter=new CategoryAdapter(context,categoryModels,this,0);
        binding.listCategory.setAdapter(categoryAdapter);

    }

    private void getSlider() {
        SliderView sliderView=binding.imageSlider;
        mSliderItems=new ArrayList<>();
        mSliderItems.add(new SliderModel(1,"https://slidervilla.com/smooth-slider/files/2014/05/6.jpg"));
        mSliderItems.add(new SliderModel(2,"http://www.joedaoud.com/webdev/jquery-slider/img/slider1.jpg"));
        mSliderItems.add(new SliderModel(3,"https://slidervilla.com/smooth-slider/files/2014/05/6.jpg"));

        sliderView.setIndicatorAnimation(IndicatorAnimations.THIN_WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setIndicatorSelectedColor(Color.RED);
        sliderView.setIndicatorUnselectedColor(Color.BLACK);
        sliderView.setAutoCycle(true);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);

        SliderAdapter sliderBroshourAdapter=new SliderAdapter(context,mSliderItems);
        sliderView.setSliderAdapter(sliderBroshourAdapter);
        sliderBroshourAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnCategoryItemClicked(CategoryModel categoryModel) {

    }

    @Override
    public void OnCategoryItemClicked(LocationModel locationModel) {

    }
}