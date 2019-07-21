package com.muzi.modularization;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Author: lipeng
 * Date: 2019/7/19
 * Email: lipeng@moyi365.com
 * Content:
 */
public class EmptyFragment extends SupportFragment {

    public static SupportFragment getInstance(String text) {
        SupportFragment fragment = new EmptyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_empty, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String text = getArguments().getString("text");
        if (text != null) {
            TextView textView = view.findViewById(R.id.title);
            textView.setText(text);
        }
    }
}
