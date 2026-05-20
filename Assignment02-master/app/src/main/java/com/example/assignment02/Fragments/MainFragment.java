package com.example.assignment02.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assignment02.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import androidx.viewpager2.widget.ViewPager2;

public class MainFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

        ArrayList<String> tabs = new ArrayList<>();
        tabs.add("دعاء");
        tabs.add("أذكار");
        tabs.add("حديث");

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(MyFragment.newInstance("دُعاء", "اللهُمَّ إِنِّا نسْأَلُكَ الثَّبَاتَ فِي الأمر ، وَالْعَزِيمَةَ عَلَى الرُّشْدِ، وَأَسْأَلُكَ مُوجِبَاتِ رَحْمَتِكَ، وَعَزَائِمَ مَغْفِرَتِكَ، وَأَسْأَلُكَ شُكْرَ نِعْمَتِكَ وَحُسْنَ عِبَادَتِكَ، وَأَسْأَلُكَ قَلْبًا سَلِيمًا ، وَلِسَانًا صَادِقًا، وَأَسْأَلُكَ مِنْ خَيْرِ مَا تَعْلَمُ، وَأَعُوذُ بِكَ مِنْ شَرِّ مَا تَعْلَمُ، وَأَسْتَغْفِرُكَ لِمَا تَعْلَمُ إِنَّكَ أَنْتَ عَلَّامُ الغيوب.."));
        fragments.add(MyFragment.newInstance("الباقيات الصالحات", "- سبحان الله\n" +
                "\u200F- الحمد لله\n" +
                "\u200F- لا إله إلّا الله\n" +
                "\u200F- الله اكبر\n" +
                "\u200F- سبحان الله وبحمده\n" +
                "\u200F- سبحان الله العظيم\n" +
                "\u200F- أستغفر الله وأتوب إليه\n" +
                "\u200F- لا حول ولا قوة إلّا بِـالله\n" +
                "\u200F- اللهُمَّ صلِّ وسلم على نبينا محمدﷺ.\n" +
                "\u200F- لا إله إلّا أنت سُبحانك إنّي كنتُ من الظالمين.\n" +
                "\n"));
        fragments.add(MyFragment.newInstance("الصبر جنة المؤمن في الدنيا", "قَالَ رَسُولُ الله ﷺ: عَجَباً لأمْرِ الْمُؤْمِنِ إِنَّ أَمْرَهُ كُلَّهُ لَهُ خَيْرٌ، وَلَيْسَ ذَلِكَ لأِحَدٍ إِلاَّ للْمُؤْمِن: إِنْ أَصَابَتْهُ سَرَّاءُ شَكَرَ فَكَانَ خَيْراً لَهُ، وَإِنْ أَصَابَتْهُ ضَرَّاءُ صَبَرَ فَكَانَ خيْراً لَهُ. \n  \nرواه مسلم."));

        Adapter adapter = new Adapter(this, fragments);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(tabs.get(position))).attach();
    }
}
