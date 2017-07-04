package com.yyy.djk.dropdownmenu;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by Somnus on 2017/3/13.
 *
 * @Description:
 */

public class RecyclerViewAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public RecyclerViewAdapter() {
        super(R.layout.item_constellation_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.text,item);
    }
}
