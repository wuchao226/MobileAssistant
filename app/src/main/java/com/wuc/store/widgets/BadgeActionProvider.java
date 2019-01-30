package com.wuc.store.widgets;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wuc.store.R;
import com.wuc.store.util.UiUtils;

/**
 * @author: wuchao
 * @date: 2018/11/29 14:10
 * @desciption:
 */
public class BadgeActionProvider extends ActionProvider {

    private ImageView mIvIcon;
    private TextView mTvBadge;

    private View.OnClickListener mOnClickListener;

    public BadgeActionProvider(Context context) {
        super(context);
    }

    @Override
    public View onCreateActionView() {
        int size = UiUtils.getDimens(android.support.design.R.dimen.abc_action_bar_default_height_material);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(size, size);
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.menu_badge_provider, null, false);
        view.setLayoutParams(params);
        mIvIcon = view.findViewById(R.id.iv_icon);
        mTvBadge = view.findViewById(R.id.tv_badge);
        view.setOnClickListener(new BadgeMenuClickListener());
        return view;
    }

    /**
     * 设置图标。
     *
     * @param icon drawable 或者mipmap中的id。
     */
    public void setIcon(@DrawableRes int icon) {
        mIvIcon.setImageResource(icon);
    }

    /**
     * 设置显示的数字。
     *
     * @param i 数字。
     */
    public void setBadge(int i) {
        mTvBadge.setText(Integer.toString(i));
    }

    /**
     * 设置文字。
     *
     * @param i string.xml中的id。
     */
    public void setTextInt(@StringRes int i) {
        mTvBadge.setText(i);
    }

    /**
     * 设置显示的文字。
     *
     * @param i 文字。
     */
    public void setText(CharSequence i) {
        mTvBadge.setText(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    private class BadgeMenuClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (mOnClickListener != null) {
                mOnClickListener.onClick(v);
            }
        }
    }
}
