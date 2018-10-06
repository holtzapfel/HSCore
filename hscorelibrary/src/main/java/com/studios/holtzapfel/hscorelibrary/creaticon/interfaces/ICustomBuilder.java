package com.studios.holtzapfel.hscorelibrary.creaticon.interfaces;

import android.graphics.Typeface;

public interface ICustomBuilder {

    ICustomBuilder width(int width);

    ICustomBuilder height(int height);

    ICustomBuilder textColor(int color);

    ICustomBuilder withBorder(int thickness);

    ICustomBuilder useFont(Typeface font);

    ICustomBuilder fontSize(int size);

    ICustomBuilder bold();

    ICustomBuilder toUpperCase();

    IShapeBuilder prepare();

}
