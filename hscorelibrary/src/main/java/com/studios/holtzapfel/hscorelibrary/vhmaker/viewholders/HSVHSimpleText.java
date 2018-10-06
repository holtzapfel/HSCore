package com.studios.holtzapfel.hscorelibrary.vhmaker.viewholders;

import android.view.View;
import android.widget.TextView;

import com.studios.holtzapfel.hscorelibrary.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HSVHSimpleText extends RecyclerView.ViewHolder {

    private TextView mTextSimple;

    public HSVHSimpleText(@NonNull View itemView) {
        super(itemView);

        mTextSimple = itemView.findViewById(R.id.text_simple);
    }

    public void bind(String message){
        mTextSimple.setText(message);
    }
}
