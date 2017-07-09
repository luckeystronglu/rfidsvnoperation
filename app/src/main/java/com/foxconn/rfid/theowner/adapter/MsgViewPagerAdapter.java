package com.foxconn.rfid.theowner.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appadmin on 2017/1/13.
 */

public class MsgViewPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> mfragment;//一个fragment的集合
    private List<String> tabs;//一个头部标题的集合
    public MsgViewPagerAdapter(FragmentManager fm ) {
        super(fm);
        mfragment=new ArrayList<>();
        tabs=new ArrayList<>();
    }

    public void addFragment(Fragment fragment,String tab){
        mfragment.add(fragment);
        tabs.add(tab);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mfragment.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }
}
