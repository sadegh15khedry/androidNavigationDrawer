package com.example.sadeghshop;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
//import android.support.v7.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting our custom toolbar
        MaterialToolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                new HomeFragment());

        //setting drawer and drawer toggle btn
        drawerLayout = (DrawerLayout) findViewById(R.id.myDrawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_actionbar, R.string.close_actionbar);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener((NavigationBarView.OnItemSelectedListener) navigationItemSelectedListener);

//        Button button = (Button) findViewById(R.id.button_1);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Snackbar.make(view,"thank god",Snackbar.LENGTH_LONG).show();
//                Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
//                startActivity(intent);
//            }
//        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //drawer btn stuff
        if (item != null && item.getItemId() == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(Gravity.RIGHT))
                drawerLayout.closeDrawer(Gravity.RIGHT);
            else
                drawerLayout.openDrawer(Gravity.RIGHT);
        }
        return super.onOptionsItemSelected(item);
    }


    private BottomNavigationView.OnItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_profile:
                    selectedFragment = new ProfileFragment();
                    break;
                case R.id.nav_cart:
                    selectedFragment = new CartFragment();
                    break;
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_categories:
                    selectedFragment = new CategoriesFragment();
                    break;

            }
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                    selectedFragment);
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                    selectedFragment);

            return true;
        }
    };


}