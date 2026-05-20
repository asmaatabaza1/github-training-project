package com.example.assignment02;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import com.example.assignment02.Fragments.BottomNFragment;
import com.example.assignment02.Fragments.DrawerFragment;
import com.example.assignment02.Fragments.MainFragment;
import com.example.assignment02.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.tool);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                binding.tool,
                R.string.open_drawer,
                R.string.close_drawer
        );

        binding.drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        binding.tool.setTitleTextColor(getResources().getColor(R.color.white));
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));

        getSupportActionBar().setTitle("أذكاري");

        loadFragment(new MainFragment());

        binding.navigationView.setNavigationItemSelectedListener(this);

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

                        } else if (item.getItemId() == R.id.other) {

                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.frame_container,

                                            BottomNFragment.newInstance(
                                                    "اللهم صلِّ وسلم على رسول الله",

                                                    "واعلموا أنه ما من عبدٍ مسلمٍ أكثر الصلاة على النبي محمد ﷺ إلا نوّر الله قلبه، وغفر ذنبه، وشرح صدره، ويسَّرَ أمره.\n\n• ابن الجوزيّ."))

                                    .commit();
                        }

                        return true;
                    }
                });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.sun) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container,
                            DrawerFragment.newInstance(
                                    "أذكار الصباح",
                                    "• قراءة آية الكرسي"))
                    .commit();

        } else if (item.getItemId() == R.id.ligt) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container,
                            DrawerFragment.newInstance(
                                    "أذكار المساء",
                                    "• قراءة آية الكرسي"))
                    .commit();

        } else if (item.getItemId() == R.id.LogOut) {

            new AlertDialog.Builder(this)
                    .setTitle("تأكيد الخروج")
                    .setMessage("هل تريد الخروج من التطبيق؟")
                    .setPositiveButton("نعم", (dialog, which) -> finishAffinity())
                    .setNegativeButton("لا", null)
                    .show();
        }

        binding.navigationView.setCheckedItem(item.getItemId());
        binding.drawerLayout.closeDrawer(GravityCompat.START);

        return false;
    }

    @Override
    public void onBackPressed() {

        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {

            binding.drawerLayout.closeDrawer(GravityCompat.START);

        } else if (binding.bottom.getSelectedItemId() == R.id.form
                || binding.bottom.getSelectedItemId() == R.id.other) {

            binding.bottom.setSelectedItemId(R.id.home);

        } else {

            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit();
    }
}