package com.silicon.hub.firepay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.silicon.hub.firepay.Utils.Session;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    TextView toolbarTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTitleTextView = findViewById(R.id.textview_toolbar_title);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()){
                case R.id.bottom_nav_home:
                    selectedFragment = new HomeFragment();
                    toolbarTitleTextView.setText("FirePay");
                    break;
                case R.id.bottom_nav_wallet:
                    selectedFragment = new WalletFragment();
                    toolbarTitleTextView.setText("Wallet");
                    break;
                case R.id.bottom_nav_transaction:
                    selectedFragment = new TransactionHistoryFragment();
                    toolbarTitleTextView.setText("Transaction History");
                    break;
                case R.id.bottom_nav_profile:
                    selectedFragment = new ProfileFragment();
                    toolbarTitleTextView.setText("Profile");
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.settings:
                // open page for changing settings
                return true;
            case R.id.log_out:
                // clear all shared preferences data
                Session session = new Session(this);
                session.clearUser();
                // return to login screen
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                // and remove this activity from the back stack
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    // the selected currency will be passed to this activity from the fragment
    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = new Intent(HomeActivity.this, CurrencyBuyActivity.class);
        switch (id){
            case R.id.layout_buy_bitcoin:
                // open activity to buy bitcoin
                intent.setAction(CurrencyBuyActivity.BUY_BITCOIN);
                startActivity(intent);
                break;
            case R.id.button_buy_perfectmoney:
                // open activity to buy perfect money
                intent.setAction(CurrencyBuyActivity.BUY_PERFECT_MONEY);
                startActivity(intent);
                break;
            case R.id.button_buy_mastertrader:
                // open activity to buy master trader
                intent.setAction(CurrencyBuyActivity.BUY_MASTER_TRADER);
                startActivity(intent);
                break;
            case R.id.button_buy_ethereum:
                // open activity to buy ethereum
                intent.setAction(CurrencyBuyActivity.BUY_ETHEREUM);
                startActivity(intent);
                break;
        }
    }
}
