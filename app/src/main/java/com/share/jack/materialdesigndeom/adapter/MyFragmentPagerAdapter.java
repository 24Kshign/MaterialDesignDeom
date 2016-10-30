package com.share.jack.materialdesigndeom.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.share.jack.materialdesigndeom.fragment.FragmentOne;
import com.share.jack.materialdesigndeom.fragment.FragmentThree;
import com.share.jack.materialdesigndeom.fragment.FragmentTwo;

/**
 *
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"TitleOne", "TitleTwo", "TitleThree"};

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private FragmentThree fragmentThree;

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            if (fragmentTwo == null) {
                fragmentTwo = new FragmentTwo();
            }
            return fragmentTwo;
        } else if (position == 2) {
            if (fragmentThree == null) {
                fragmentThree = new FragmentThree();
            }
            return fragmentThree;
        } else {
            if (fragmentOne == null) {
                fragmentOne = new FragmentOne();
            }
            return fragmentOne;
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //用来设置tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
