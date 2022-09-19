package com.charlesgodoy.earhebcg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.charlesgodoy.earhebcg.ui.AccountFragment;
import com.charlesgodoy.earhebcg.ui.CouponsFragment;
import com.charlesgodoy.earhebcg.ui.HomeFragment;
import com.charlesgodoy.earhebcg.ui.OrdersFragment;
import com.charlesgodoy.earhebcg.ui.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

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

        // Selects the Account icon to be highlighted on activity start
        bottomNavigationView.setSelectedItemId(R.id.account);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, accountFragment).commit();

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