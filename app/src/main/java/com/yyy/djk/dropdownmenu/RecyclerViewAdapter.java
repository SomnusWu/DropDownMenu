package com.yyy.djk.dropdownmenu;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by Somnus on 2017/3/13.
 *
 * @Description:
 */

public class RecyclerViewAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private int checkItemPosition=-1;

    public void setCheckItem(int position) {
        checkItemPosition = position;
        notifyDataSetChanged();
    }

    public RecyclerViewAdapter() {
        super(R.layout.item_constellation_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.text, item);
        TextView mTvText = (TextView) helper.itemView.findViewById(R.id.text);
        int position = helper.getLayoutPosition();
        if (checkItemPosition != -1) {
            if (checkItemPosition == position) {
                mTvText.setTextColor(mContext.getResources().getColor(R.color.drop_down_selected));
                mTvText.setCompoundDrawablesWithIntrinsicBounds(null, null, mContext.getResources().getDrawable(R.drawable.drop_down_checked), null);
            } else {
                mTvText.setTextColor(mContext.getResources().getColor(R.color.drop_down_unselected));
                mTvText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }
        }
    }
}
