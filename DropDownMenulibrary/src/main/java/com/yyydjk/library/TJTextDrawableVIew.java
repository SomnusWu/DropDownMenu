package com.yyydjk.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Somnus on 2017/5/22.
 *
 * @Description:
 */

public class TJTextDrawableVIew extends LinearLayout {

    private Context mContext;
    private int iconResource;
    private CharSequence content;

    private ImageView imgArrow;
    private TextView tvContent;


    public TJTextDrawableVIew(Context context, AttributeSet attrs) {
        // super(context, attrs);
        // TODO Auto-generated constructor stub
        this(context, attrs, 0);
    }

    public TJTextDrawableVIew(Context context, AttributeSet attrs, int defStyleAttr) {
        // super(context, attrs, defStyleAttr);
        // TODO Auto-generated constructor stub
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.DrawableTextViewAtt, defStyleAttr, 0);
        content = a.getText(R.styleable.DrawableTextViewAtt_drawableContent);
        iconResource = a.getResourceId(R.styleable.DrawableTextViewAtt_drawableImg, 0);
        a.recycle();
        initView(context);
        setGravity(Gravity.CENTER);
    }

    private void initView(Context mcontext) {
        mContext = mcontext;
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.view_drwable_tab, this);
        imgArrow = (ImageView) view.findViewById(R.id.img_icon);
        tvContent = (TextView) view.findViewById(R.id.tv_content);
        if (iconResource != 0) {
            imgArrow.setImageResource(iconResource);
        }
        if (!TextUtils.isEmpty(content)) {
            tvContent.setText(content);
        }
    }

    public void setDrawableTextFocusable(boolean isFocusable){
        tvContent.setSelected(isFocusable);
        imgArrow.setSelected(isFocusable);
    }


    public void setTextColor(int color){
        tvContent.setTextColor(color);
    }
    public void setText(String text){
        tvContent.setText(text);
    }
    public void setArrowRes(int img){
        imgArrow.setImageResource(img);
    }

}
