package bel.kaistra.beltimetracker.adapters;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import bel.kaistra.beltimetracker.controller.MainFragment;

public class MyPagerAdapter extends android.support.v4.app.FragmentPagerAdapter{
    private final int PAGE_COUNT = 2;
    private String[] pageTitles = {"Tab1", "Tab2"};
    private Context context;

    public MyPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        return MainFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }
}
