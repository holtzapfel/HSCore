package com.studios.holtzapfel.hscore;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import com.studios.holtzapfel.hscorelibrary.HSMaster;
import com.studios.holtzapfel.hscorelibrary.creaticon.Creaticon;
import com.studios.holtzapfel.hscorelibrary.creaticon.CreaticonBuilder;
import com.studios.holtzapfel.hscorelibrary.menumaker.MMActivity;
import com.studios.holtzapfel.hscorelibrary.menumaker.MMMenu;
import com.studios.holtzapfel.hscorelibrary.menumaker.MMMenuBuilder;
import com.studios.holtzapfel.hscorelibrary.menumaker.MMPage;
import com.studios.holtzapfel.hscorelibrary.menumaker.MMPageBuilder;
import com.studios.holtzapfel.hscorelibrary.menumaker.model.BodyMenuItem;
import com.studios.holtzapfel.hscorelibrary.menumaker.model.FooterMenuItem;
import com.studios.holtzapfel.hscorelibrary.menumaker.model.HeaderMenuItem;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MMActivity implements MMMenu.OnMenuItemClickListener {

    private static final int PAGE_MAIN = 100;
    private static final int ID_FEATURE_MENU_MAKER = 101;

    private MMMenu mMenu;

    @BindView(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ButterKnife it
        ButterKnife.bind(this);

        // Setup toolbar
        setSupportActionBar(mToolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startMenu();
    }

    @Override
    public MMMenu onRequestMenu() {
        if (mMenu == null){
            mMenu = buildMenu();
        }
        return mMenu;
    }

    private MMMenu buildMenu(){

        Drawable drawable = Creaticon.build().circle().with("MM", Color.BLUE);

        MMPage pageMain = new MMPageBuilder(PAGE_MAIN)
                .withPageTitle("HS Core Library")
                .withMenuItems(
                        new HeaderMenuItem().withTitle("Features"),
                        new BodyMenuItem(ID_FEATURE_MENU_MAKER).withTitle("Menu Maker").withDescription("The easiest way to make a menu.").withIconLeft(drawable).withLastItem(true),
                        new FooterMenuItem()
                )
                .withHeaderTitleTextColor(R.color.colorAccent)
                .build();

        return new MMMenuBuilder(this)
                .withFrameLayout(R.id.frame)
                .withInitialPageID(PAGE_MAIN)
                .withPages(pageMain)
                .withOnMenuItemClickListener(this)
                .withUseSlidingAnimationFragmentTransitions(true)
                .withUseUpArrowOnInitialPage(false)
                .build();
    }

    @Override
    public void onBodyItemClick(BodyMenuItem bodyMenuItem) {
        switch (bodyMenuItem.getID()){
            case ID_FEATURE_MENU_MAKER:
                Toast.makeText(this, "Menu Maker", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onHeaderItemClick(HeaderMenuItem headerMenuItem) {

    }
}
