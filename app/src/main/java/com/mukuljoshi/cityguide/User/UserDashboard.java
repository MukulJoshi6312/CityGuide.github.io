package com.mukuljoshi.cityguide.User;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.mukuljoshi.cityguide.Comman.LoginSignup.RetailerStartUpScreen;
import com.mukuljoshi.cityguide.HelperClasses.HomeAdapter.CategroiesAdapter;
import com.mukuljoshi.cityguide.HelperClasses.HomeAdapter.CategroiesViewedHelperClass;
import com.mukuljoshi.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.mukuljoshi.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.mukuljoshi.cityguide.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.mukuljoshi.cityguide.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.mukuljoshi.cityguide.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    RecyclerView featuredRecycler;
    RecyclerView mostViewedRecycler;
    RecyclerView categoriesRecycler;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4, gradient5;
    RecyclerView.Adapter adapter;
    ImageView menu_icon;

    //animation variable
    static final float END_SCALE = 0.7f;
    LinearLayout contentView;


    // drawer menu variable
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);


        //hooks

        featuredRecycler = findViewById(R.id.featured__recycler);
        mostViewedRecycler = findViewById(R.id.most_view_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        menu_icon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);


        // menu hooks

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        navigationDrawer();


        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
    }

    // navigation drawer function
    private void navigationDrawer() {
        // Navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else
                    drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.card3));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // Scale the view based on current slide offset

                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the view accounting for the scaled width

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);


            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nev_all_categories:
                Intent intent = new Intent(getApplicationContext(), AllCategories.class);
                startActivity(intent);
                break;

        }

        return true;
    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featureddLoaction = new ArrayList<>();
        featureddLoaction.add(new FeaturedHelperClass(R.drawable.mcd, "McDonald's", "MCD is the best for eating the junk food."));
        featureddLoaction.add(new FeaturedHelperClass(R.drawable.city_1, "McDonald's", "MCD is the best for eating the junk food."));
        featureddLoaction.add(new FeaturedHelperClass(R.drawable.city_2, "McDonald's", "MCD is the best for eating the junk food."));

        adapter = new FeaturedAdapter(featureddLoaction);

        featuredRecycler.setAdapter(adapter);

        // GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});


    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLoaction = new ArrayList<>();

        mostViewedLoaction.add(new MostViewedHelperClass(R.drawable.mcd, "McDonald's"));
        mostViewedLoaction.add(new MostViewedHelperClass(R.drawable.city_2, "London"));
        mostViewedLoaction.add(new MostViewedHelperClass(R.drawable.city_1, "Hogwarts"));
        mostViewedLoaction.add(new MostViewedHelperClass(R.drawable.education_icon, "Education"));

        adapter = new MostViewedAdapter(mostViewedLoaction);
        mostViewedRecycler.setAdapter(adapter);
    }


    public void categoriesRecycler() {
        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
        gradient5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfbb8d7e5, 0xffb8d7f5});

        ArrayList<CategroiesViewedHelperClass> mostViewedLoaction = new ArrayList<>();

        mostViewedLoaction.add(new CategroiesViewedHelperClass(R.drawable.hosptel, "Hospital", gradient1));
        mostViewedLoaction.add(new CategroiesViewedHelperClass(R.drawable.school, "School", gradient2));
        mostViewedLoaction.add(new CategroiesViewedHelperClass(R.drawable.shopping, "Shopping", gradient3));
        mostViewedLoaction.add(new CategroiesViewedHelperClass(R.drawable.res_image, "Restaurant", gradient4));
        mostViewedLoaction.add(new CategroiesViewedHelperClass(R.drawable.transport, "Transport", gradient5));

        adapter = new CategroiesAdapter(mostViewedLoaction);
        categoriesRecycler.setAdapter(adapter);

    }

    public void callRetailerScreen(View view){

        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));


    }


}