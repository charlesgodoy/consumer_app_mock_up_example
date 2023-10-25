package com.charlesgodoy.consumer_app_mock_up_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.charlesgodoy.consumer_app_mock_up_example.ui.AccountFragment;
import com.charlesgodoy.consumer_app_mock_up_example.ui.CouponsFragment;
import com.charlesgodoy.consumer_app_mock_up_example.ui.HomeFragment;
import com.charlesgodoy.consumer_app_mock_up_example.ui.OrdersFragment;
import com.charlesgodoy.consumer_app_mock_up_example.ui.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    ShopFragment shopFragment = new ShopFragment();
    CouponsFragment couponsFragment = new CouponsFragment();
    OrdersFragment ordersFragment = new OrdersFragment();
    AccountFragment accountFragment = new AccountFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        fab = findViewById(R.id.btn_fab);

        // Selects the Account icon to be highlighted on activity start
        bottomNavigationView.setSelectedItemId(R.id.account);

        // Put code here when FAB is clicked
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You clicked FAB", Toast.LENGTH_SHORT).show();
            }
        });

        // Starts app at account fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.container, accountFragment).commit();

        // Bottom Navigation clicks
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch(item.getItemId()) {

                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;

                    case R.id.shop:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, shopFragment).commit();
                        return true;

                    case R.id.coupons:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, couponsFragment).commit();
                        return true;

                    case R.id.orders:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, ordersFragment).commit();
                        return true;

                    case R.id.account:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, accountFragment).commit();
                        return true;
                }

                return false;
            }
        });

    }


}