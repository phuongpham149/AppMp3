package com.example.phuong.appmp3.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.phuong.appmp3.R;
import com.example.phuong.appmp3.adapters.MusicOnlineAdapter;
import com.example.phuong.appmp3.models.MusicOnline;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phuong on 08/01/2017.
 */
@EFragment(R.layout.fragment_music_online)
public class OnlineFragment extends BaseFragment implements MusicOnlineAdapter.onItemClickListener{
    @ViewById(R.id.recyclerViewOnline)
    RecyclerView mRecyclerViewOnline;

    private List<MusicOnline> mMusic;
    private MusicOnlineAdapter mAdapter;

    @Override
    void inits() {
        initsData();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerViewOnline.setLayoutManager(layoutManager);
        mAdapter = new MusicOnlineAdapter(mMusic, getContext(),this);
        mRecyclerViewOnline.setAdapter(mAdapter);
    }

    public void initsData() {
        mMusic = new ArrayList<>();
        MusicOnline musicOnline = new MusicOnline();
        musicOnline.setName("Anh vẫn còn yêu em");
        musicOnline.setSinger("Minh Vương");
        musicOnline.setDuration("3:45");

        MusicOnline musicOnline1 = new MusicOnline();
        musicOnline1.setName("Anh vẫn còn yêu em");
        musicOnline1.setSinger("Minh Vương");
        musicOnline1.setDuration("3:45");

        MusicOnline musicOnline2 = new MusicOnline();
        musicOnline2.setName("Anh vẫn còn yêu em");
        musicOnline2.setSinger("Minh Vương");
        musicOnline2.setDuration("3:45");

        MusicOnline musicOnline3 = new MusicOnline();
        musicOnline3.setName("Anh vẫn còn yêu em");
        musicOnline3.setSinger("Minh Vương");
        musicOnline3.setDuration("3:45");

        MusicOnline musicOnline4 = new MusicOnline();
        musicOnline4.setName("Anh vẫn còn yêu em");
        musicOnline4.setSinger("Minh Vương");
        musicOnline4.setDuration("3:45");

        mMusic.add(musicOnline);
        mMusic.add(musicOnline1);
        mMusic.add(musicOnline2);
        mMusic.add(musicOnline3);
        mMusic.add(musicOnline4);
    }

    @Override
    public void itemClickListener(int position) {
        //bat 1 bai hat
    }
}
