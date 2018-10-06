package com.studios.holtzapfel.hscorelibrary.creaticon;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;

import com.studios.holtzapfel.hscorelibrary.creaticon.interfaces.IBuilder;
import com.studios.holtzapfel.hscorelibrary.creaticon.interfaces.ICustomBuilder;
import com.studios.holtzapfel.hscorelibrary.creaticon.interfaces.IShapeBuilder;

public class CreaticonBuilder implements IBuilder, IShapeBuilder, ICustomBuilder {

    // TEXT
    String text;
    Typeface font;
    int textColor;
    int fontSize;
    boolean isBold;
    boolean isUpperCase;

    // SHAPE
    RectShape shape;
    int width;
    int height;
    float cornerRadius;
    int backgroundColor;
    int borderThickness;

    CreaticonBuilder(){
        text = "";
        font = Typeface.DEFAULT;
        textColor = Color.WHITE;
        fontSize = -1;
        isBold = false;
        isUpperCase = false;

        shape = new RectShape();
        width = -1;
        height = -1;
        backgroundColor = Color.GRAY;
        borderThickness = 0;
    }

    @Override
    public Creaticon with(String text, int color) {
        this.text = text;
        this.backgroundColor = color;
        return new Creaticon(this);
    }

    @Override
    public ICustomBuilder width(int width) {
        this.width = width;
        return this;
    }

    @Override
    public ICustomBuilder height(int height) {
        this.height = height;
        return this;
    }

    @Override
    public ICustomBuilder textColor(int color) {
        this.textColor = color;
        return this;
    }

    @Override
    public ICustomBuilder withBorder(int thickness) {
        this.borderThickness = thickness;
        return this;
    }

    @Override
    public ICustomBuilder useFont(Typeface font) {
        this.font = font;
        return this;
    }

    @Override
    public ICustomBuilder fontSize(int size) {
        this.fontSize = size;
        return this;
    }

    @Override
    public ICustomBuilder bold() {
        this.isBold = true;
        return this;
    }

    @Override
    public ICustomBuilder toUpperCase() {
        this.isUpperCase = true;
        return this;
    }

    @Override
    public IShapeBuilder prepare() {
        return this;
    }

    @Override
    public ICustomBuilder customize() {
        return this;
    }

    @Override
    public IBuilder rectangle() {
        this.shape = new RectShape();
        return this;
    }

    @Override
    public IBuilder circle() {
        this.shape = new OvalShape();
        return this;
    }

    @Override
    public IBuilder roundedRectangle(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        float[] radii = {cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius};
        this.shape = new RoundRectShape(radii, null, null);
        return this;
    }
}
