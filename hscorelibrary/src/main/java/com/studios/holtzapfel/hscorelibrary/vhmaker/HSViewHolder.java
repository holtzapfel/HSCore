package com.studios.holtzapfel.hscorelibrary.vhmaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studios.holtzapfel.hscorelibrary.vhmaker.viewholders.HSVHSimpleText;
import com.studios.holtzapfel.hscorelibrary.R;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;

public class HSViewHolder {

    public static ITypeBuilder build(){
        return new ViewHolderBuilder();
    }

    private static class ViewHolderBuilder implements ITypeBuilder, IConfigBuilder{

        private static final int TYPE_SIMPLE_TEXT = 1;

        boolean attachToRoot;
        int type;
        @LayoutRes int layout;

        ViewHolderBuilder(){
            attachToRoot = false;
            type = -1;
        }

        @Override
        public IConfigBuilder typeSimpleText() {
            layout = R.layout.hs_mod_simple_text;
            type = TYPE_SIMPLE_TEXT;
            return this;
        }

        @Override
        public IConfigBuilder withAttachToRoot(boolean isAttach) {
            this.attachToRoot = isAttach;
            return this;
        }

        @Override
        public RecyclerView.ViewHolder build(Context context, ViewGroup viewGroup) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View v = inflater.inflate(layout, viewGroup, attachToRoot);

            switch (type){
                case TYPE_SIMPLE_TEXT:
                    return new HSVHSimpleText(v);
            }

            return null;
        }
    }

    public interface ITypeBuilder{
        IConfigBuilder typeSimpleText();
    }

    public interface IConfigBuilder{
        IConfigBuilder withAttachToRoot(boolean isAttach);
        RecyclerView.ViewHolder build(Context context, ViewGroup viewGroup);
    }
}
