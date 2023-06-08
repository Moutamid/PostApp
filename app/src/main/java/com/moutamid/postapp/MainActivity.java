package com.moutamid.postapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.moutamid.postapp.fragments.HomeFragment;
import com.moutamid.postapp.fragments.PostFragment;
import com.moutamid.postapp.fragments.ProfileFragment;
import com.moutamid.postapp.fragments.ThemeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Constants.checkApp(this);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
        bottomNav.setSelectedItemId(R.id.home);
        bottomNav.setItemActiveIndicatorColor(ColorStateList.valueOf(getResources().getColor(R.color.top)));
        bottomNav.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
            } else if (itemId == R.id.post) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new PostFragment()).commit();
            } else if (itemId == R.id.theme) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ThemeFragment()).commit();
            } else if (itemId == R.id.profile) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ProfileFragment()).commit();
            }
            return true;
        });

    }
}