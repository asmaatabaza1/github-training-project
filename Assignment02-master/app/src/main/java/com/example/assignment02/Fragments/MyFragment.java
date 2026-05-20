package com.example.assignment02.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.assignment02.databinding.FragmentMyBinding;

public class MyFragment extends Fragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_CONTENT = "content";

    private String title;
    private String content;

    public MyFragment() {
        // Required empty public constructor
    }

    public static MyFragment newInstance(String title, String content) {
        MyFragment fragment = new MyFragment();
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentMyBinding binding = FragmentMyBinding.inflate(inflater, container, false);

        binding.title.setText(title);
        binding.content.setText(content);

        return binding.getRoot();
    }
}
