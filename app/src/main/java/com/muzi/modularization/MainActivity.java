package com.muzi.modularization;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.muzi.base.constants.RouterConstant;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends SupportActivity {

    private RadioGroup radioGroup;

    private SupportFragment[] fragments = new SupportFragment[4];

    private int currentFragment = 3;
    private int nextFragment = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);

        initFragment();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_study:
                        nextFragment = 0;
                        break;
                    case R.id.rb_college:
                        nextFragment = 1;
                        break;
                    case R.id.rb_train:
                        nextFragment = 2;
                        break;
                    case R.id.rb_user:
                        nextFragment = 3;
                        break;
                }
                if (nextFragment != currentFragment) {
                    SupportFragment nextSupportFragment = fragments[nextFragment];
                    showHideFragment(nextSupportFragment);
                    currentFragment = nextFragment;
                }
            }
        });
    }

    private void initFragment() {
        SupportFragment studyFragment = (SupportFragment) ARouter.getInstance().build(RouterConstant.STUDY_FRAGMENT).navigation();
        if (studyFragment == null) {
            studyFragment = EmptyFragment.getInstance("study");
        }
        fragments[0] = studyFragment;

        SupportFragment collegeFragment = (SupportFragment) ARouter.getInstance().build(RouterConstant.COLLEGE_FRAGMENT).navigation();
        if (collegeFragment == null) {
            collegeFragment = EmptyFragment.getInstance("college");
        }
        fragments[1] = collegeFragment;

        SupportFragment trainFragment = (SupportFragment) ARouter.getInstance().build(RouterConstant.TRAIN_FRAGMENT).navigation();
        if (trainFragment == null) {
            trainFragment = EmptyFragment.getInstance("train");
        }
        fragments[2] = trainFragment;

        SupportFragment userFragment = (SupportFragment) ARouter.getInstance().build(RouterConstant.USER_FRAGMENT).navigation();
        if (userFragment == null) {
            userFragment = EmptyFragment.getInstance("user");
        }
        fragments[3] = userFragment;

        loadMultipleRootFragment(R.id.container, currentFragment, studyFragment, collegeFragment, trainFragment, userFragment);
    }
}
