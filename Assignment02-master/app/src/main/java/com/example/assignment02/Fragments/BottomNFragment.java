package com.example.assignment02.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.assignment02.databinding.FragmentBottomNBinding;
import com.example.assignment02.databinding.ItemContentBinding;

public class BottomNFragment extends Fragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_CONTENT = "content";

    private String mTitle;
    private String mContent;

    public BottomNFragment() {
        // Required empty public constructor
    }

    public static BottomNFragment newInstance(String title, String content) {
        BottomNFragment fragment = new BottomNFragment();
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
            mTitle = getArguments().getString(ARG_TITLE);
            mContent = getArguments().getString(ARG_CONTENT);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentBottomNBinding binding = FragmentBottomNBinding.inflate(inflater, container, false);

        binding.title.setText(mTitle);
            ItemContentBinding itemBinding = ItemContentBinding.inflate(inflater, binding.containerLayout, false);

            itemBinding.content.setText(mContent);

            binding.containerLayout.addView(itemBinding.getRoot());

        return binding.getRoot();
    }
}
