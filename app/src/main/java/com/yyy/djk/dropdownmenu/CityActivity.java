package com.yyy.djk.dropdownmenu;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.yyydjk.library.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CityActivity extends AppCompatActivity {
    @InjectView(R.id.dropDownMenu)
    DropDownMenu mDropDownMenu;



    private String headers[] = {"城市"};
    private List<View> popupViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


        initView();
    }

    private void initView() {

        final View city2View = getLayoutInflater().inflate(R.layout.city_two_layout, null);
        RecyclerView mLeftRecyclerView = ButterKnife.findById(city2View, R.id.recyclerView_left);
        RecyclerView mRightRecyclerView = ButterKnife.findById(city2View, R.id.recyclerView_right);


        RecyclerViewAdapter mRecyclerViewAdapter = new RecyclerViewAdapter();
        mLeftRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mLeftRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLeftRecyclerView.setAdapter(mRecyclerViewAdapter);
        mLeftRecyclerView.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));

        List<String> mlist = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mlist.add(i + "");
        }
        mRecyclerViewAdapter.addData(mlist);

        RecyclerViewAdapter mRecyclerViewAdapterRight = new RecyclerViewAdapter();
        mRightRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRightRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRightRecyclerView.setAdapter(mRecyclerViewAdapterRight);

        mRecyclerViewAdapterRight.addData(mlist);

        popupViews.add(city2View);

        View view = LayoutInflater.from(this).inflate(R.layout.layout_recylcer_view, null);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerViewAdapter = new RecyclerViewAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        //init dropdownview
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, view);

    }

    private void initData() {

    }
}
