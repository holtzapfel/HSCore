package com.studios.holtzapfel.hscorelibrary.menumaker.model.interfaces;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by holtzapfel on 6/20/17.
 */

public interface IFooterItem<T, VH extends RecyclerView.ViewHolder> extends IMenuItem<T, VH> {

    T withButtonLeft(CharSequence text, View.OnClickListener onClickListener);

    T withButtonCenter(CharSequence text, View.OnClickListener onClickListener);

    T withButtonRight(CharSequence text, View.OnClickListener onClickListener);
}
