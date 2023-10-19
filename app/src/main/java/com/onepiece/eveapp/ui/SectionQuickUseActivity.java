package com.onepiece.eveapp.ui;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.onepiece.eveapp.GridSectionAverageGapItemDecoration;
import com.onepiece.eveapp.R;
import com.onepiece.eveapp.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */


public class SectionQuickUseActivity extends BaseActivity {
    private RecyclerView    mRecyclerView;
    private List<MySection1> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_uer);

//        setBackBtn();
        setTitle("Quick Section Use");

        mRecyclerView = findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.addItemDecoration(new GridSectionAverageGapItemDecoration(10, 10, 20, 15));

        mData = getSectionData();
        SectionQuickAdapter adapter = new SectionQuickAdapter(R.layout.item_single_battery, R.layout.item_header_top, mData);


        mRecyclerView.setAdapter(adapter);
    }

    public static List<MySection1> getSectionData() {
        List<MySection1> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(new MySection1(true, "Section " + i));
            list.add(new MySection1(false, new Video("HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK", "CYM_CHAD")));
            list.add(new MySection1(false, new Video("HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK", "CYM_CHAD")));
            list.add(new MySection1(false, new Video("HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK", "CYM_CHAD")));
            list.add(new MySection1(false, new Video("HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK", "CYM_CHAD")));
            list.add(new MySection1(false, new Video("HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK", "CYM_CHAD")));
            list.add(new MySection1(false, new Video("HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK", "CYM_CHAD")));
        }
        return list;
    }


    @Override
    public void observeViewModel() {

    }

    @Override
    protected void initViewBinding() {

    }
}
