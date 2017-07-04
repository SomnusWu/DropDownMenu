package com.yyy.djk.dropdownmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yyydjk.library.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    private String headers[] = {"城市", "年龄", "性别", "星座"};
    @InjectView(R.id.dropDownMenu)
    DropDownMenu mDropDownMenu;
    //内容体
    protected View mContentView;
    private List<View> popupViews = new ArrayList<>();



    private String citys[] = {"不限", "武汉", "北京", "上海", "成都", "广州", "深圳", "重庆", "天津", "西安", "南京", "杭州"};
    private String ages[] = {"不限", "18岁以下", "18-22岁", "23-26岁", "27-35岁", "35岁以上"};
    private String sexs[] = {"不限", "男", "女"};
    private String constellations[] = {"不限", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座"};

    private int constellationPosition = 0;

    //主页内容数据
    private RecyclerViewAdapter mRecyclerViewAdapter;
    //城市数据
    private RecyclerViewAdapter mCityRecyclerViewAdapter;
    //年龄数据
    private AgeRecyclerViewAdapter mAgeRecyclerViewAdapter;
    //性别数据
    private RecyclerViewAdapter mSexRecyclerViewAdapter;
    //星座数据
    private ConstellationAdapter constellationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initView();
        initData();
    }

    private void initView() {
        //主页面的内容
        mContentView = LayoutInflater.from(this).inflate(R.layout.view_recycler_view_refresh, null);
        RecyclerView mRecyclerView = (RecyclerView) mContentView.findViewById(R.id.rv_list);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerViewAdapter = new RecyclerViewAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, CityActivity.class);
                startActivity(intent);
            }
        });

        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) mContentView.findViewById(R.id.swipeLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
        getPopUpViews();
        //init dropdownview
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers),popupViews, mContentView);
    }


    private void initData() {
        List<String> mlist = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mlist.add(i + "");
        }
        mRecyclerViewAdapter.addData(mlist);
    }



    public List<View> getPopUpViews() {
        /***
         * 城市列表布局
         */
        final View cityView = getLayoutInflater().inflate(R.layout.layout_recylcer_view, null);
        RecyclerView mCityRecycler = (RecyclerView) cityView.findViewById(R.id.recyclerView);
        mCityRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mCityRecyclerViewAdapter = new RecyclerViewAdapter();
        mCityRecycler.setLayoutManager(new LinearLayoutManager(this));
        mCityRecyclerViewAdapter.addData(Arrays.asList(citys));
        mCityRecycler.setAdapter(mCityRecyclerViewAdapter);
        mCityRecyclerViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mCityRecyclerViewAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[0] : citys[position]);
                mDropDownMenu.closeMenu();
            }
        });
        /**
         * 年龄布局 数据
         */
        final View ageView = getLayoutInflater().inflate(R.layout.layout_recylcer_view, null);
        RecyclerView mAgeRecycler = (RecyclerView) ageView.findViewById(R.id.recyclerView);
        mAgeRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAgeRecyclerViewAdapter = new AgeRecyclerViewAdapter();
        mAgeRecycler.setLayoutManager(new LinearLayoutManager(this));
        mAgeRecyclerViewAdapter.addData(Arrays.asList(ages));
        mAgeRecycler.setAdapter(mAgeRecyclerViewAdapter);
        mAgeRecyclerViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mAgeRecyclerViewAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[1] : ages[position]);
                mDropDownMenu.closeMenu();
            }
        });
        /**
         * 性别布局数据
         */
        final View sexView = getLayoutInflater().inflate(R.layout.layout_recylcer_view, null);
        RecyclerView mSexRecycler = (RecyclerView) sexView.findViewById(R.id.recyclerView);
        mSexRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mSexRecyclerViewAdapter = new RecyclerViewAdapter();
        mSexRecycler.setLayoutManager(new LinearLayoutManager(this));
        mSexRecyclerViewAdapter.addData(Arrays.asList(sexs));
        mSexRecycler.setAdapter(mSexRecyclerViewAdapter);
        mSexRecyclerViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mSexRecyclerViewAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[2] : sexs[position]);
                mDropDownMenu.closeMenu();
            }
        });
        //init constellation
        final View constellationView = getLayoutInflater().inflate(R.layout.custom_layout, null);
        GridView constellation = ButterKnife.findById(constellationView, R.id.constellation);
        constellationAdapter = new ConstellationAdapter(this, Arrays.asList(constellations));
        constellation.setAdapter(constellationAdapter);
        TextView ok = ButterKnife.findById(constellationView, R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDropDownMenu.setTabText(constellationPosition == 0 ? headers[3] : constellations[constellationPosition]);
                mDropDownMenu.closeMenu();
            }
        });
        constellation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                constellationAdapter.setCheckItem(position);
                constellationPosition = position;
            }
        });
        //init popupViews
        popupViews.add(cityView);
        popupViews.add(ageView);
        popupViews.add(sexView);
        popupViews.add(constellationView);
        return popupViews;
    }

    @Override
    public void onBackPressed() {
        //退出activity前关闭菜单
        if (mDropDownMenu.isShowing()) {
            mDropDownMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }
}
