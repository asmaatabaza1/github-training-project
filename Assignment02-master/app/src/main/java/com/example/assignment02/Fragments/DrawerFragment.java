package com.example.assignment02.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.assignment02.databinding.FragmentDrawerBinding;

public class DrawerFragment extends Fragment {
    private static final String ARG_TITLE = "title";
    private static final String ARG_CONTENT = "content";
    private String title;
    private String content;

    public DrawerFragment() {
    }

    public static DrawerFragment newInstance(String title, String content) {
        DrawerFragment fragment = new DrawerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            content = getArguments().getString(ARG_CONTENT);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDrawerBinding binding = FragmentDrawerBinding.inflate(inflater, container, false);

        binding.title.setText(title);
        binding.content.setText(content);

        return binding.getRoot();

    }
}
