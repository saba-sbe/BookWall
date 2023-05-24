package com.example.bookwall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class BookActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    gharzfragment gharzfragment = new gharzfragment();
    kharidfragment kharidfragment = new kharidfragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        setUpToolbar();
        setUpNavigationView();
        tabLayout = findViewById(R.id.book_tabs);
        viewPager = findViewById(R.id.book_view);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpNavigationView() {
        NavigationView navigationView = findViewById(R.id.book_navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_menu_sign_in:
                        startActivity(new Intent(BookActivity.this, SignInActivity.class));
                        break;
                    case R.id.navigation_menu_main:
                        startActivity(new Intent(BookActivity.this, MainPageActivity.class));
                        break;
                }
                return true;
            }
        });

    }

    private void setUpToolbar() {
        DrawerLayout drawerLayout = findViewById(R.id.book_drawer_layout);

        Toolbar toolbar = findViewById(R.id.book_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);


        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, 0, 0);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_book_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_book_basket_product:
                startActivity(new Intent(BookActivity.this, BasketActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpViewPager(ViewPager viewPager){
        Util.ViewPagerAdapter adapter = new Util.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(kharidfragment,"خرید");
        adapter.addFragment(gharzfragment,"قرض");
        viewPager.setAdapter(adapter);
    }
}
