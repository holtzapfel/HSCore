package com.studios.holtzapfel.hscorelibrary.menumaker.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.studios.holtzapfel.hscorelibrary.HSMaster;
import com.studios.holtzapfel.hscorelibrary.R;
import com.studios.holtzapfel.hscorelibrary.menumaker.MMMenu;
import com.studios.holtzapfel.hscorelibrary.menumaker.model.interfaces.IBodyItem;
import com.studios.holtzapfel.hscorelibrary.menumaker.model.interfaces.IMenuItem;

import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by holtzapfel on 6/27/17.
 */

public class BodyMenuItem extends AbstractMenuItem<BodyMenuItem, BodyMenuItem.BodyMenuItemViewHolder> implements IBodyItem<BodyMenuItem, BodyMenuItem.BodyMenuItemViewHolder> {


    public BodyMenuItem(int id){
        withID(id);
    }

    private String mTitle;
    private AlertDialog mInputDialog;

    @Override
    public BodyMenuItem withTitle(@Nullable String title) {
        this.mTitle = title;
        return this;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    private int mTitleTextColorRes = -1;

    @Override
    public BodyMenuItem withTitleTextColor(@ColorRes int colorRes) {
        this.mTitleTextColorRes = colorRes;
        return this;
    }

    @Override
    public int getTitleTextColorRes() {
        return mTitleTextColorRes;
    }

    private float mTitleTextSize = -1;
    private int mTitleTextSizeUnit = -1;

    @Override
    public BodyMenuItem withTitleTextSize(float size) {
        this.mTitleTextSize = size;
        return this;
    }

    @Override
    public BodyMenuItem withTitleTextSize(int unit, float size) {
        this.mTitleTextSizeUnit = unit;
        this.mTitleTextSize = size;
        return this;
    }

    @Override
    public float getTitleTextSize() {
        return mTitleTextSize;
    }

    @Override
    public int getTitleTextSizeUnit() {
        return mTitleTextSizeUnit;
    }

    private String mDescription;

    @Override
    public BodyMenuItem withDescription(@Nullable String description) {
        this.mDescription = description;
        return this;
    }

    @Override
    public String getDescription() {
        return mDescription;
    }

    private int mDescriptionTextColorRes = -1;

    @Override
    public BodyMenuItem withDescriptionTextColor(@ColorRes int colorRes) {
        this.mDescriptionTextColorRes = colorRes;
        return this;
    }

    @Override
    public int getDescriptionTextColorRes() {
        return mDescriptionTextColorRes;
    }

    private float mDescriptionTextSize = -1;
    private int mDescriptionTextSizeUnit = -1;
    @Override
    public BodyMenuItem withDescriptionTextSize(float size) {
        this.mDescriptionTextSize = size;
        return this;
    }

    @Override
    public BodyMenuItem withDescriptionTextSize(int unit, float size) {
        this.mDescriptionTextSizeUnit = unit;
        this.mDescriptionTextSize = size;
        return this;
    }

    @Override
    public float getDescriptionTextSize() {
        return mDescriptionTextSize;
    }

    @Override
    public int getDescriptionTextSizeUnit() {
        return mDescriptionTextSizeUnit;
    }

    private String mValue;

    @Override
    public BodyMenuItem withValue(@Nullable String value) {
        this.mValue = value;
        return this;
    }

    @Override
    public String getValue() {
        return mValue;
    }

    private int mValueTextColorRes = -1;

    @Override
    public BodyMenuItem withValueTextColor(@ColorRes int colorRes) {
        this.mValueTextColorRes = colorRes;
        return this;
    }

    @Override
    public int getValueTextColorRes() {
        return mValueTextColorRes;
    }

    private float mValueTextSize = -1;
    private int mValueTextSizeUnit = -1;
    @Override
    public BodyMenuItem withValueTextSize(float size) {
        this.mValueTextSize = size;
        return this;
    }

    @Override
    public BodyMenuItem withValueTextSize(int unit, float size) {
        this.mValueTextSizeUnit = unit;
        this.mValueTextSize = size;
        return this;
    }

    @Override
    public float getValueTextSize() {
        return mValueTextSize;
    }

    @Override
    public int getValueTextSizeUnit() {
        return mValueTextSizeUnit;
    }

    private boolean isValueEditable = false;
    private CharSequence mEditableHint;
    private boolean prefillWithValue = false;
    private boolean allowEmptyInput = true;
    private CharSequence mEditableTitle;
    private int mEditableInputType = -1;
    private boolean verifyIfValueIsEmail = false;
    private boolean verifyIfValueIsPhone = false;
    private OnVerifyInputListener mVerifyInputListener;
    private boolean isInputTypePassword = false;

    @Override
    public BodyMenuItem withValueEditable(@Nullable String value, @Nullable CharSequence inputHint, boolean prefillInputWithItemValue, boolean allowEmptyInput, @Nullable CharSequence dialogTitle) {
        this.withValue(value);
        this.isValueEditable = true;
        this.mEditableHint = inputHint;
        this.prefillWithValue = prefillInputWithItemValue;
        this.allowEmptyInput = allowEmptyInput;
        this.mEditableTitle = dialogTitle;
        return this;
    }

    @Override
    public BodyMenuItem withValueEditable(@Nullable String value, @Nullable CharSequence inputHint, boolean prefillInputWithItemValue, boolean allowEmptyInput, @Nullable CharSequence dialogTitle, @Nullable OnVerifyInputListener verifyInputListener) {
        withValueEditable(value, inputHint, prefillInputWithItemValue, allowEmptyInput, dialogTitle);
        this.mVerifyInputListener = verifyInputListener;
        return this;
    }

    @Override
    public BodyMenuItem withValueEditable(@Nullable String value, @Nullable CharSequence inputHint, boolean prefillInputWithItemValue, boolean allowEmptyInput, @Nullable CharSequence dialogTitle, int inputType) {
        withValueEditable(value, inputHint, prefillInputWithItemValue, allowEmptyInput, dialogTitle);
        this.mEditableInputType = inputType;
        isInputTypePassword = inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD;
        return this;
    }

    @Override
    public BodyMenuItem withValueEditable(@Nullable String value, @Nullable CharSequence inputHint, boolean prefillInputWithItemValue, boolean allowEmptyInput, @Nullable CharSequence dialogTitle, int inputType, @Nullable OnVerifyInputListener verifyInputListener) {
        withValueEditable(value, inputHint, prefillInputWithItemValue, allowEmptyInput, dialogTitle, inputType);
        this.mVerifyInputListener = verifyInputListener;
        return this;
    }

    @Override
    public BodyMenuItem withValueEditable(@Nullable String value, @Nullable CharSequence inputHint, boolean prefillInputWithItemValue, boolean allowEmptyInput, @Nullable CharSequence dialogTitle, int inputType, boolean verifyInputTypeEmailOrPhone) {
        withValueEditable(value, inputHint, prefillInputWithItemValue, allowEmptyInput, dialogTitle, inputType);

        if (verifyInputTypeEmailOrPhone){
            switch (inputType){
                case InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS:
                    this.verifyIfValueIsEmail = true;
                    this.verifyIfValueIsPhone = false;
                    break;
                case InputType.TYPE_CLASS_PHONE:
                    this.verifyIfValueIsPhone = true;
                    this.verifyIfValueIsEmail = false;
                    break;
            }
        } else {
            this.verifyIfValueIsEmail = false;
            this.verifyIfValueIsPhone = false;
        }
        return this;
    }

    private CharSequence getPrefillValue(){
        if (prefillWithValue){
            return mValue;
        } else return null;
    }

    private boolean mBooleanValue = false;
    private boolean isSwitchUsed = false;

    @Override
    public BodyMenuItem withBooleanValue(boolean value) {
        this.mBooleanValue = value;
        this.isSwitchUsed = true;
        return this;
    }

    @Override
    public boolean getBooleanValue() {
        return mBooleanValue;
    }

    private String mContent;

    @Override
    public BodyMenuItem withContent(@Nullable String content) {
        this.mContent = content;
        return this;
    }

    @Override
    public String getContent() {
        return mContent;
    }

    private int mContentTextColorRes = -1;

    @Override
    public BodyMenuItem withContentTextColor(@ColorRes int colorRes) {
        this.mContentTextColorRes = colorRes;
        return this;
    }

    @Override
    public int getContentTextColorRes() {
        return mContentTextColorRes;
    }

    private float mContentTextSize = -1;
    private int mContentTextSizeUnit = -1;

    @Override
    public BodyMenuItem withContentTextSize(float size) {
        this.mContentTextSize = size;
        return this;
    }

    @Override
    public BodyMenuItem withContentTextSize(int unit, float size) {
        this.mContentTextSizeUnit = unit;
        this.mContentTextSize = size;
        return this;
    }

    @Override
    public float getContentTextSize() {
        return mContentTextSize;
    }

    @Override
    public int getContentTextSizeUnit() {
        return mContentTextSizeUnit;
    }

    private int mIconLeftRes = -1;
    private Drawable mIconLeft;

    @Override
    public BodyMenuItem withIconLeft(int iconRes) {
        this.mIconLeftRes = getMMIconRes(iconRes);
        if (this.mIconLeftRes != -1){
            withIconLeftSize(75, 75);
        } else this.mIconLeftRes = iconRes;
        return this;
    }

    @Override
    public BodyMenuItem withIconLeft(@Nullable Drawable icon) {
        this.mIconLeft = icon;
        return this;
    }

    @Override
    public int getIconLeftRes() {
        return mIconLeftRes;
    }

    @Override
    public Drawable getIconLeft() {
        return mIconLeft;
    }

    private int mIconLeftHeight = -1;
    private int mIconLeftWidth = -1;

    @Override
    public BodyMenuItem withIconLeftSize(int width, int height){
        this.mIconLeftWidth = width;
        this.mIconLeftHeight = height;
        return this;
    }

    @Override
    public int getIconLeftWidth(){
        return mIconLeftWidth;
    }

    @Override
    public int getIconLeftHeight(){
        return mIconLeftHeight;
    }

    private boolean isIconLeftVisible = true;

    @Override
    public BodyMenuItem withIconLeftVisible(boolean isVisible) {
        this.isIconLeftVisible = isVisible;
        return this;
    }

    @Override
    public boolean isIconLeftVisible() {
        return isIconLeftVisible;
    }

    private int mIconLeftColorRes = -1;

    @Override
    public BodyMenuItem withIconLeftColor(@ColorRes int colorRes) {
        this.mIconLeftColorRes = colorRes;
        return this;
    }

    @Override
    public int getIconLeftColorRes() {
        return mIconLeftColorRes;
    }

    private int mIconRightRes = -1;
    private Drawable mIconRight;

    @Override
    public BodyMenuItem withIconRight(int iconRes) {
        this.mIconRightRes = getMMIconRes(iconRes);
        if (this.mIconRightRes != -1){
            withIconRightSize(75, 75);
        } else this.mIconRightRes = iconRes;
        return this;
    }

    @Override
    public BodyMenuItem withIconRight(@Nullable Drawable icon) {
        this.mIconRight = icon;
        return this;
    }

    @Override
    public int getIconRightRes() {
        return mIconRightRes;
    }

    @Override
    public Drawable getIconRight() {
        return mIconRight;
    }

    private boolean isIconRightVisible = true;

    @Override
    public BodyMenuItem withIconRightVisible(boolean isVisible) {
        this.isIconRightVisible = isVisible;
        return this;
    }

    @Override
    public boolean isIconRightVisible() {
        return isIconRightVisible;
    }

    private int mIconRightColorRes = -1;

    @Override
    public BodyMenuItem withIconRightColor(@ColorRes int colorRes) {
        this.mIconRightColorRes = colorRes;
        return this;
    }

    @Override
    public int getIconRightColorRes() {
        return mIconRightColorRes;
    }

    private int mIconRightHeight = -1;
    private int mIconRightWidth = -1;

    @Override
    public BodyMenuItem withIconRightSize(int width, int height){
        this.mIconRightWidth = width;
        this.mIconRightHeight = height;
        return this;
    }

    @Override
    public int getIconRightWidth(){
        return mIconRightWidth;
    }

    @Override
    public int getIconRightHeight(){
        return mIconRightHeight;
    }

    private boolean isDividerEnabled = true;

    @Override
    public BodyMenuItem withDividerEnabled(boolean isEnabled) {
        this.isDividerEnabled = isEnabled;
        return this;
    }

    @Override
    public boolean isDividerEnabled() {
        return isDividerEnabled;
    }

    private int mDividerColorRes = -1;

    @Override
    public BodyMenuItem withDividerColor(int colorRes) {
        this.mDividerColorRes = colorRes;
        return this;
    }

    @Override
    public int getDividerColorRes() {
        return mDividerColorRes;
    }

    @Override
    public int getMenuType() {
        return IMenuItem.MENU_ITEM_TYPE_BODY;
    }

    @Override
    public void bindView(final Context context, final BodyMenuItemViewHolder holder, final MMMenu.OnMenuItemClickListener listener) {
        // Configure card
        if(isEnabled()){
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isSwitchUsed){
                        holder.booleanValue.performClick();
                    } else if (isValueEditable){

                        final EditText editTextInput = new EditText(context);
                        editTextInput.setHint(mEditableHint);
                        editTextInput.setText(getPrefillValue());
                        editTextInput.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void afterTextChanged(Editable editable) {
                                String input = editable.toString();
                                if (!allowEmptyInput){
                                    mInputDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(!input.equals(""));
                                }


                            }
                        });
                        if (mEditableInputType != -1){
                            editTextInput.setInputType(mEditableInputType);
                        }

                        AlertDialog.Builder dialogEditable = new AlertDialog.Builder(context)
                                .setView(editTextInput)
                                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String input = editTextInput.getText().toString();
                                if (mVerifyInputListener != null){
                                    boolean isVerified = mVerifyInputListener.onVerifyInput(input);
                                    mVerifyInputListener.afterVerification(isVerified);

                                    if (isVerified){
                                        withValue(input);
                                        dialogInterface.dismiss();
                                        listener.onBodyItemClick(BodyMenuItem.this);
                                    }
                                } else if (verifyIfValueIsEmail){
                                    if (HSMaster.verifyStringIsEmail(input)){
                                        withValue(input);
                                        dialogInterface.dismiss();
                                        listener.onBodyItemClick(BodyMenuItem.this);
                                    } else Toast.makeText(context, "Invalid Email Address", Toast.LENGTH_SHORT).show();
                                } else if (verifyIfValueIsPhone){
                                    if (HSMaster.verifyStringIsPhoneNumber(input)){
                                        withValue(input);
                                        dialogInterface.dismiss();
                                        listener.onBodyItemClick(BodyMenuItem.this);
                                    } else Toast.makeText(context, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                                } else {
                                    withValue(String.valueOf(input));
                                    dialogInterface.dismiss();
                                    listener.onBodyItemClick(BodyMenuItem.this);
                                }

                                if (getValue() != null){
                                    holder.value.setVisibility(View.VISIBLE);
                                    holder.value.setText(HSMaster.fromHtml(getValue()));
                                } else holder.value.setVisibility(View.GONE);
                            }
                        })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                })
                                .setCancelable(false);

                        if (mEditableTitle != null){
                            dialogEditable.setTitle(mEditableTitle);
                        }

                        mInputDialog = dialogEditable.create();
                        mInputDialog.show();
                    } else listener.onBodyItemClick(BodyMenuItem.this);
                }
            });
        }

        // Configure title
        if (getTitle() != null){
            holder.title.setVisibility(View.VISIBLE);
            holder.title.setText(HSMaster.fromHtml(getTitle()));

            // Set text color
            if (getTitleTextColorRes() != -1 && getTitleTextColorRes() != 0){
                holder.title.setTextColor(ResourcesCompat.getColor(context.getResources(), getTitleTextColorRes(), context.getTheme()));
            }

            // Set text size
            if (mTitleTextSize != -1){
                if (mTitleTextSizeUnit != -1){
                    holder.title.setTextSize(mTitleTextSizeUnit, mTitleTextSize);
                } else holder.title.setTextSize(mTitleTextSize);
            }
        } else holder.title.setVisibility(View.GONE);

        // Configure description
        if (getDescription() != null){
            holder.description.setVisibility(View.VISIBLE);
            holder.description.setText(HSMaster.fromHtml(getDescription()));

            // Set text color
            if (getDescriptionTextColorRes() > 0){
                holder.description.setTextColor(ResourcesCompat.getColor(context.getResources(), getDescriptionTextColorRes(), context.getTheme()));
            }

            // Set text color
            if (mDescriptionTextSize != -1){
                if (mDescriptionTextSizeUnit != -1){
                    holder.description.setTextSize(mDescriptionTextSizeUnit, mDescriptionTextSize);
                } else holder.description.setTextSize(mDescriptionTextSize);
            }
        } else holder.description.setVisibility(View.GONE);

        // Configure switch
        if (isSwitchUsed){
            holder.booleanValue.setVisibility(View.VISIBLE);
            holder.booleanValue.setChecked(getBooleanValue());
            holder.booleanValue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    BodyMenuItem.this.withBooleanValue(b);
                    listener.onBodyItemClick(BodyMenuItem.this);
                }
            });
        } else holder.booleanValue.setVisibility(View.GONE);

        // Configure value
        if (getValue() != null){
            holder.value.setVisibility(View.VISIBLE);
            holder.value.setText(HSMaster.fromHtml(getValue()));

            // Convert text to hidden password if input type is password
            if (isInputTypePassword) {
                holder.value.setTransformationMethod(new PasswordTransformationMethod());
            }

            // Set text color
            if (getValueTextColorRes() > 0){
                holder.value.setTextColor(ResourcesCompat.getColor(context.getResources(), getValueTextColorRes(), context.getTheme()));
            }

            // Set text size
            if (mValueTextSize != -1){
                if (mValueTextSizeUnit != -1){
                    holder.value.setTextSize(mValueTextSizeUnit, mValueTextSize);
                } else holder.value.setTextSize(mValueTextSize);
            }
        } else holder.value.setVisibility(View.GONE);

        // Configure content
        if (getContent() != null){
            holder.content.setVisibility(View.VISIBLE);
            holder.content.setText(HSMaster.fromHtml(getContent()));

            // Set text color
            if (getContentTextColorRes() > 0){
                holder.content.setTextColor(ResourcesCompat.getColor(context.getResources(), getContentTextColorRes(), context.getTheme()));
            }

            // Set text size
            if (mContentTextSize != -1){
                if (mContentTextSizeUnit != -1){
                    holder.content.setTextSize(mContentTextSizeUnit, mContentTextSize);
                } else holder.content.setTextSize(mContentTextSize);
            }
        } else holder.content.setVisibility(View.GONE);

        // Configure left icon
        if (getIconLeftRes() != -1 || getIconLeft() != null){
            if (isIconLeftVisible()) {
                holder.iconLeft.setVisibility(View.VISIBLE);
            } else holder.iconLeft.setVisibility(View.GONE);

            if (getIconLeftRes() != -1) {
                holder.iconLeft.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), getIconLeftRes(), context.getTheme()));
            } else if (getIconLeft() != null){
                holder.iconLeft.setImageDrawable(getIconLeft());
            }

            if (getIconLeftColorRes() != -1){
                holder.iconLeft.setColorFilter(ResourcesCompat.getColor(context.getResources(), getIconLeftColorRes(), context.getTheme()));
            }

            if (getIconLeftWidth() != -1 && getIconLeftHeight() != -1){
                holder.iconLeft.getLayoutParams().width = getIconLeftWidth();
                holder.iconLeft.getLayoutParams().height = getIconLeftHeight();
            }
        } else holder.iconLeft.setVisibility(View.GONE);

        // Configure right icon
        if (getIconRightRes() != -1 || getIconRight() != null){
            if (isIconRightVisible()) {
                holder.iconRight.setVisibility(View.VISIBLE);
            } else holder.iconRight.setVisibility(View.GONE);

            if (getIconRightRes() != -1) {
                holder.iconRight.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), getIconRightRes(), context.getTheme()));
            } else if (getIconRight() != null){
                holder.iconRight.setImageDrawable(getIconRight());
            }

            if (getIconRightColorRes() != -1){
                holder.iconRight.setColorFilter(ResourcesCompat.getColor(context.getResources(), getIconRightColorRes(), context.getTheme()));
            }

            if (getIconRightWidth() != -1 && getIconRightHeight() != -1){
                holder.iconRight.getLayoutParams().width = getIconRightWidth();
                holder.iconRight.getLayoutParams().height = getIconLeftHeight();
            }
        } else holder.iconRight.setVisibility(View.GONE);

        // Configure divider
        if (isLastItem()){
            holder.divider.setVisibility(View.GONE);
        } else if (isDividerEnabled()){
            holder.divider.setVisibility(View.VISIBLE);
            if (getDividerColorRes() > 0){
                holder.divider.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), getDividerColorRes(), context.getTheme()));
            }
        } else holder.divider.setVisibility(View.GONE);

        // Configure enabled
        holder.cardView.setEnabled(isEnabled());
        holder.title.setEnabled(isEnabled());
        holder.description.setEnabled(isEnabled());
        holder.booleanValue.setEnabled(isEnabled());
        holder.value.setEnabled(isEnabled());
        holder.content.setEnabled(isEnabled());
        holder.iconLeft.setEnabled(isEnabled());
        holder.iconRight.setEnabled(isEnabled());

        // Configure clickable
        holder.cardView.setClickable(isClickable());
        holder.booleanValue.setClickable(isClickable());
    }

    @Override
    public void unbindView(BodyMenuItemViewHolder holder) {

    }

    public static class BodyMenuItemViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView iconLeft;
        TextView title;
        TextView description;
        TextView value;
        Switch booleanValue;
        ImageView iconRight;
        TextView content;
        TextView divider;

        public BodyMenuItemViewHolder(View v) {
            super(v);

            // Associate views
            cardView = v.findViewById(R.id.mm_item_body_cardview);
            iconLeft = v.findViewById(R.id.mm_item_body_icon_left);
            title = v.findViewById(R.id.mm_item_body_title);
            description = v.findViewById(R.id.mm_item_body_description);
            value = v.findViewById(R.id.mm_item_body_value);
            booleanValue = v.findViewById(R.id.mm_item_body_switch);
            iconRight = v.findViewById(R.id.mm_item_body_icon_right);
            content = v.findViewById(R.id.mm_item_body_content);
            divider = v.findViewById(R.id.mm_item_body_divider);
        }
    }
}
