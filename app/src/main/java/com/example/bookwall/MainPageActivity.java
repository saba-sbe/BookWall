package com.example.bookwall;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

public class MainPageActivity extends AppCompatActivity {

    ImageView bargh, mekanik, omran, sanae, computer, memari, shimi, mavad, riazi;
    Button morebutton;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        findviews();
        clicks();
        setUpToolbar();
        setUpNavigationView();
//        setUpRecycler();
    }

    private void setUpRecycler() {
        recyclerView.setAdapter(new CustomAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(MainPageActivity.this,LinearLayoutManager.HORIZONTAL,false));

    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

        LayoutInflater inflater;

        private CustomAdapter() {
            inflater = (LayoutInflater) MainPageActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(inflater.inflate(R.layout.item_list, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.image.setImageResource(R.drawable.notebookplaceholder);
            holder.name.setText("مدار منطقی");
            holder.price.setText("100000");
        }

        @Override
        public int getItemCount() {
            return 8;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name;
            TextView price;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.itemImage);
                name = itemView.findViewById(R.id.tvtitle);
                price = itemView.findViewById(R.id.tvprice);
            }
        }
    }


    private void setUpNavigationView() {
        NavigationView navigationView = findViewById(R.id.main_navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_menu_sign_in:
                        startActivity(new Intent(MainPageActivity.this, SignInActivity.class));
                        break;
                    case R.id.navigation_menu_main:
                        startActivity(new Intent(MainPageActivity.this, MainPageActivity.class));
                        break;
                }
                return true;
            }
        });

    }

    private void setUpToolbar() {
        DrawerLayout drawerLayout = findViewById(R.id.main_drawerlayout);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);


        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, 0, 0);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


    }

    private void clicks() {
        bargh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, BookActivity.class));
            }
        });

        mekanik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, BookActivity.class));
            }
        });

        omran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, BookActivity.class));
            }
        });

        sanae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, BookActivity.class));
            }
        });

        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, BookActivity.class));
            }
        });

        memari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, BookActivity.class));
            }
        });

        shimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, BookActivity.class));
            }
        });

        mavad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, BookActivity.class));
            }
        });

        riazi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, BookActivity.class));
            }
        });

//        morebutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainPageActivity.this, BookActivity.class));
//            }
//        });
    }

    private void findviews() {
        bargh = findViewById(R.id.main_bargh);
        mekanik = findViewById(R.id.main_mekaink);
        omran = findViewById(R.id.main_omran);
        sanae = findViewById(R.id.main_sanae);
        computer = findViewById(R.id.main_computer);
        memari = findViewById(R.id.main_memari);
        shimi = findViewById(R.id.main_shimi);
        mavad = findViewById(R.id.main_mavad);
        riazi = findViewById(R.id.main_riazi);
//        morebutton = findViewById(R.id.main_button_more);
//        recyclerView = findViewById(R.id.main_recycler_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_main_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_basket_product:
                startActivity(new Intent(MainPageActivity.this, BasketActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
