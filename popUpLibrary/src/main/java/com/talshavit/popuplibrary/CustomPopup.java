package com.talshavit.popuplibrary;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.core.content.ContextCompat;

public class CustomPopup extends PopupWindow {
    private Context context;
    private View contentView, customView;
    private LinearLayout layout;
    private GradientDrawable backgroundDrawable;


    public CustomPopup(Context context) {
        super(context);
        init(context);
    }

    public CustomPopup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomPopup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;

        contentView = LayoutInflater.from(context).inflate(R.layout.custom_popup, null);
        setContentView(contentView);

        initDefaultSettings();
    }

    private void initDefaultSettings() {
        layout = contentView.findViewById(R.id.popupLayout);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        backgroundDrawable = new GradientDrawable();
        setFocusable(true);
        setTouchable(true);
        setInputMethodMode(INPUT_METHOD_NEEDED);
        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        if (customView != null) {
            customView.setBackground(backgroundDrawable);
        }
    }

    public void setCustomView(View view) {
        this.customView = view;
        layout.addView(view);
    }

    public void changeWidth(int width) {
        if (customView != null) {
            ViewGroup.LayoutParams params = customView.getLayoutParams();
            params.width = width;
            customView.setLayoutParams(params);
        }
    }

    public void changeHeight(int height) {
        if (customView != null) {
            ViewGroup.LayoutParams params = customView.getLayoutParams();
            params.height = height;
            customView.setLayoutParams(params);
        }
    }

    public void setPopUpSize(int width, int height) {
        changeWidth(width);
        changeHeight(height);
    }

    public void setBackgroundOneColor(int colorID) {
        int color = ContextCompat.getColor(context, colorID);
        backgroundDrawable.setColor(color);
        if (customView != null) {
            customView.setBackgroundColor(color);
        }
    }

    public void setGradientBackgroundColor(int startColorID, int endColorID, GradientDrawable.Orientation orientation) {
        int startColor = ContextCompat.getColor(context, startColorID);
        int endColor = ContextCompat.getColor(context, endColorID);
        backgroundDrawable.setOrientation(orientation);
        backgroundDrawable.setColors(new int[]{startColor, endColor});
        if (customView != null) {
            customView.setBackground(backgroundDrawable);
        }
    }

    public void setCornerRadius(float cornerRadius) {
        backgroundDrawable.setCornerRadius(cornerRadius);
        if (customView != null) {
            customView.setBackground(backgroundDrawable);
        }
    }

    public void setBorder(int borderColorResId, float borderWidth) {
        int borderColor = ContextCompat.getColor(context, borderColorResId);
        backgroundDrawable.setStroke((int) borderWidth, borderColor);
        if (customView != null) {
            customView.setBackground(backgroundDrawable);
        }
    }

    public void showKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    private void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public void show(View view) {
        showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    public void show(View view, String position, String animationType) {
        int gravity;
        switch (position.toUpperCase()) {
            case "TOP":
                gravity = Gravity.TOP;
                break;
            case "BOTTOM":
                gravity = Gravity.BOTTOM;
                break;
            case "CENTER":
            default:
                gravity = Gravity.CENTER;
                break;
        }

        int animationStyle = getAnimationResource(animationType);
        setAnimationStyle(animationStyle);
        showAtLocation(view, gravity, 0, 0);

        showKeyboard(customView);
    }

    private int getAnimationResource(String animationType) {
        switch (animationType.toUpperCase()) {
            case "BOTTOM":
                return R.style.PopupAnimation_Bottom;
            case "TOP":
                return R.style.PopupAnimation_Top;
            case "LEFT":
                return R.style.PopupAnimation_Left;
            case "RIGHT":
                return R.style.PopupAnimation_Right;
            case "ROTATE":
                return R.style.PopupAnimation_Rotate;
            case "ROTATE_SCALE":
            case "SCALE_ROTATE":
                return R.style.PopupAnimation_Rotate_Scale;
            case "BOUNCE":
                return R.style.PopupAnimation_Bounce;
            case "SCALE":
                return R.style.PopupAnimation_Scale;
            case "NONE":
            default:
                return -1;
        }
    }

    public void dismissPopup() {
        hideKeyboard(contentView);
        dismiss();
    }
}
