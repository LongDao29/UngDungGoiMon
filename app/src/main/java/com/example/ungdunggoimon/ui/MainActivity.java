package com.example.ungdunggoimon.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.ungdunggoimon.R;
import com.example.ungdunggoimon.databinding.ActivityMainBinding;
import com.example.ungdunggoimon.ui.fragment.BillFragment;
import com.example.ungdunggoimon.ui.fragment.ChangePasswordFragment;
import com.example.ungdunggoimon.ui.fragment.HomeFragment;
import com.example.ungdunggoimon.ui.fragment.InfoFragment;
import com.example.ungdunggoimon.ui.fragment.NotifyFragment;
import com.example.ungdunggoimon.ui.fragment.SettingFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private ActivityMainBinding binding;
    private HomeFragment fmHome = new HomeFragment();
    private SettingFragment fmSetting = new SettingFragment();
    private NotifyFragment fmNotify = new NotifyFragment();
    private BillFragment fmBill = new BillFragment();
    public InfoFragment fmInfo = new InfoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.nav.setOnItemSelectedListener(this);
        showFm(fmHome);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                showFm(fmHome);
                break;
            case R.id.nav_order:
                showFm(fmNotify);
                break;
            case R.id.nav_recipes:
                showFm(fmBill);
                break;
            case R.id.nav_setting:
                showFm(fmSetting);
                break;
        }
        return true;
    }

    public void showFm(Fragment fmShow) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fmShow);
        transaction.addToBackStack(fmShow.getClass().getName());
        transaction.commit();
    }
}