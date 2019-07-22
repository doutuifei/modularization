package com.muzi.modularization.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muzi.base.constants.RouterConstant;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Author: lipeng
 * Date: 2019/7/19
 * Email: lipeng@moyi365.com
 * Content:
 */
@Route(path = RouterConstant.USER_FRAGMENT)
public class UserFragment extends SupportFragment {

    public static SupportFragment getInstance() {
        SupportFragment fragment = new UserFragment();
        fragment.setArguments(null);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
