package com.example.phuong.appmp3.fragments;

import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.phuong.appmp3.R;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by phuong on 08/01/2017.
 */
@EFragment(R.layout.fragment_home)
public class HomeFragment extends BaseFragment {
    @ViewById(R.id.tabs)
    TabLayout mTab;
    private String mTabTitles[] = new String[]{"ONLINE", "OFFLINE"};

    @Override
    void inits() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frContainer, OnlineFragment_.builder().build()).commit();
        initTextTab();
        mTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frContainer, OnlineFragment_.builder().build()).commit();

                        break;
                    case 1:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frContainer, OfflineFragment_.builder().build()).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void initTextTab() {

        TabLayout.Tab tab0 = mTab.newTab();
        mTab.addTab(tab0);
        TabLayout.Tab tab1 = mTab.newTab();
        mTab.addTab(tab1);

        TextView mTvTab1 = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.tab_home_text_custom, null);
        mTvTab1.setText(mTabTitles[0]);
        tab0.setCustomView(mTvTab1);

        TextView mTvTab2 = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.tab_home_text_custom, null);
        mTvTab2.setText(mTabTitles[1]);
        tab1.setCustomView(mTvTab2);
    }

}
