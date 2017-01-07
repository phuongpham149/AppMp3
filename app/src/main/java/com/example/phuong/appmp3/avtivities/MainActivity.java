package com.example.phuong.appmp3.avtivities;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.example.phuong.appmp3.R;
import com.example.phuong.appmp3.adapters.MenuMainAdapter;
import com.example.phuong.appmp3.fragments.HomeFragment_;
import com.example.phuong.appmp3.listeners.ItemMenuClickListener;
import com.example.phuong.appmp3.models.MenuItem;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phuong on 07/01/2017.
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity implements ItemMenuClickListener {
    @ViewById(R.id.toolbar)
    Toolbar mToolbar;
    @ViewById(R.id.recyclerviewMenu)
    RecyclerView mRecyclerViewMenu;
    @ViewById(R.id.drawer_main)
    DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mDrawerToggle;

    private MenuMainAdapter mMenuMainAdapter;
    private List mMenuItem;
    private String[] mTitleMenu;
    private int[] mIconMenu = {R.drawable.ic_home, R.drawable.ic_feedback, R.drawable.ic_about};

    @Override
    void inits() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_menu);
        getSupportActionBar().setTitle(getResources().getString(R.string.toolbar_title));
        mToolbar.setTitleTextColor(Color.WHITE);
        initMenu();
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.app_name, R.string.app_name) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

    public void initMenu() {
        initDataMenu();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerViewMenu.setLayoutManager(layoutManager);
        mMenuMainAdapter = new MenuMainAdapter(mMenuItem, this, this);
        mRecyclerViewMenu.setAdapter(mMenuMainAdapter);
    }

    public void initDataMenu() {
        mMenuItem = new ArrayList();
        mMenuItem.add("aaaa");
        mTitleMenu = getResources().getStringArray(R.array.title_menu);
        mMenuItem.add(new MenuItem(mIconMenu[0], mTitleMenu[0]));
        mMenuItem.add(new MenuItem(mIconMenu[1], mTitleMenu[1]));
        mMenuItem.add(new MenuItem(mIconMenu[2], mTitleMenu[2]));
    }

    @Override
    public void itemClick(int position) {
        Log.d("tag1", "12  " + position);
        displayView(position);
    }

    public void displayView(int position) {
        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.frContainer, HomeFragment_.builder().build()).commit();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

}
