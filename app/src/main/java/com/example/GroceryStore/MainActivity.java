package com.example.GroceryStore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Initialize Variable
    RecyclerView categoryRecyclerView;
    RecyclerView recyclerView;
    RecyclerView recentlyViewedRecycler;

    ArrayList<MainModel> mainModels;

    MainAdapter mainAdapter;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    ImageView allCategory, cart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign Variable
        recyclerView = findViewById(R.id.recycler_view);
        categoryRecyclerView = findViewById(R.id.categoryRecyclerview);
        allCategory = findViewById(R.id.allCategoryImages);
        cart = findViewById(R.id.cart);
        recentlyViewedRecycler = findViewById(R.id.recently_item);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShoppingCart.class);
                startActivity(intent);
            }
        });



        //Create Integer

        Integer [] langLogo = {R.drawable.brocoli, R.drawable.meat, R.drawable.berry, R.drawable.brocoli, R.drawable.meat, R.drawable.berry};


        // adding data to model
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, R.drawable.fish));
        categoryList.add(new Category(2, R.drawable.colddrink));
        categoryList.add(new Category(3, R.drawable.meats));
        categoryList.add(new Category(4, R.drawable.watermellon));
        categoryList.add(new Category(5, R.drawable.fruits));
        categoryList.add(new Category(6, R.drawable.veggies));


        // adding data to model...
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Strawberry", "The strawberry is a highly nutritious fruit, loaded with vitamin C.", "₨ 55", "1", "KG", R.drawable.strawberry, R.drawable.b1));
        recentlyViewedList.add(new RecentlyViewed("Watermelon", "Watermelon has high water content and also provides some fiber.", "₨ 40", "1", "KG", R.drawable.wtermelon, R.drawable.b4));
        recentlyViewedList.add(new RecentlyViewed("Papaya", "Papayas are spherical or pear-shaped fruits that can be as long as 20 inches.", "₨ 85", "1", "KG", R.drawable.papaya, R.drawable.b3));
        recentlyViewedList.add(new RecentlyViewed("Kiwi", "Full of nutrients like vitamin C, vitamin K, vitamin E, folate, and potassium.", "₨ 70", "1", "KG", R.drawable.kiwi, R.drawable.b2 ));
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

        //Initialize ArrayList...

        mainModels = new ArrayList<>();
        for (int i = 0; i<langLogo.length; i++){
            MainModel model = new MainModel(langLogo[i]);
            mainModels.add(model);


            //Design Horizontal Layout..

            LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());

            //Initialize MainAdapter
            mainAdapter = new MainAdapter(MainActivity.this, mainModels);

            //Set MainAdapter To RecyclerView
            recyclerView.setAdapter(mainAdapter);
        }


    }
    private void setCategoryRecycler(List< Category > categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }


    //Now again we need to create a adapter and model class for recently viewed items...



}