package com.example.assignment02;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.assignment02.Fragments.BottomNFragment;
import com.example.assignment02.Fragments.MainFragment;
import com.example.assignment02.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.tool);

        binding.tool.setTitleTextColor(getResources().getColor(R.color.white));
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));

        getSupportActionBar().setTitle("أذكاري");

        loadFragment(new MainFragment());

        binding.bottom.setOnItemSelectedListener(
                new NavigationBarView.OnItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        if (item.getItemId() == R.id.home) {

                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.frame_container,
                                            MainFragment.newInstance())
                                    .commit();

                        } else if (item.getItemId() == R.id.form) {

                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.frame_container,

                                            BottomNFragment.newInstance(
                                                    "الأمر بالمعروف والنهي عن المنكر ",

                                                    "لا تترُكُوا الأمرَ بالمعروفِ وإن قصّرتُم في بعضه\n" +
                                                            "ولا تترُكُوا النهيَ عن منكرٍ وإن كنتم تواقعون بعضه\n" +
                                                            "ودُلُّوا الناسَ على الخيرِ وإن كنتم لا تأتونه كله !\n\n" +
                                                            "• ابن حزم"))

                                    .commit();
                        }

                        return true;
                    }
                });
    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit();
    }
}