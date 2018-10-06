package com.studios.holtzapfel.hscorelibrary.creaticon.interfaces;

public interface IShapeBuilder {

    ICustomBuilder customize();

    IBuilder rectangle();

    IBuilder circle();

    IBuilder roundedRectangle(int cornerRadius);

}
