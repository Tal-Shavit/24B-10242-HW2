package com.talshavit.a24b_10242_hw_2;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.talshavit.popuplibrary.CustomPopup;

public class MainActivity extends AppCompatActivity {

    private MaterialButton main_BTN_click, confirmButton;
    private CustomPopup customPopup;
    private TextInputEditText width, height, cornerRadius, borderWidth;
    private AutoCompleteTextView colorBorder, oneColor, gradientColor1, gradientColor2, orientation, gravity, animation;
    private String oneColorStr, borderColorStr, gradientColor1Str, gradientColor2Str, orientationStr, gravityStr, animationStr;
    private View customView;
    private String[] colorOptions = {"BLACK", "WHITE", "BLUE", "ORANGE", "PINK", "PURPLE", "GREEN", "RED", "YELLOW", "LIGHTBLUE", "LIGHTORANGE"};
    private String[] orientArr = {"TL_BR", "TL_BL", "BL_TR", "BR_TL", "TOP_BOTTOM", "BOTTOM_TOP", "LEFT_RIGHT", "RIGHT_LEFT"};
    private String[] gravityArr = {"TOP", "BOTTOM", "CENTER"};
    private String[] animArr = {"TOP", "BOTTOM", "LEFT", "RIGHT", "ROTATE", "ROTATE_SCALE", "SCALE_ROTATE", "BOUNCE", "SCALE", "NONE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initViews();
    }

    private void initViews() {
        main_BTN_click.setOnClickListener(view -> {
            customPopup = new CustomPopup(MainActivity.this);
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            customView = inflater.inflate(R.layout.custom_content, null);
            findViewsCustom(customView);

            initAllAdapters();
            setOnItems();
            onConfirmButton();

            customPopup.setCustomView(customView);
            //customPopup.setBackgroundOneColor(R.color.orange);
            //customPopup.setCornerRadius(90);
            //customPopup.setBorder(R.color.black, 4);
            //customPopup.setGradientBackgroundColor(R.color.lightOrange, R.color.lightBlue, GradientDrawable.Orientation.BOTTOM_TOP);
            customPopup.show(view, "center", "scale");

        });
    }

    private void onConfirmButton() {
        confirmButton.setOnClickListener(view -> updatePopupConditions());
    }

    private void setOnItems() {
        onBackgroungColor();
        onBorderColor();
        onGradientColor1();
        onGradientColor2();
        onOrientation();
        onGravity();
        onAnimation();
    }

    private void onAnimation() {
        animation.setOnItemClickListener((adapterView, view, i, l) -> animationStr = animArr[i].trim());
    }

    private void onGravity() {
        gravity.setOnItemClickListener((adapterView, view, i, l) -> gravityStr = gravityArr[i].trim());
    }

    private void onOrientation() {
        orientation.setOnItemClickListener((adapterView, view, i, l) -> orientationStr = orientArr[i].trim());
    }

    private void onGradientColor2() {
        gradientColor2.setOnItemClickListener((adapterView, view, i, l) -> {
            gradientColor2Str = colorOptions[i].trim();
            if (!"NONE".equals(gradientColor2Str)) {
                oneColorStr = "NONE";
            }
        });
    }

    private void onGradientColor1() {
        gradientColor1.setOnItemClickListener((adapterView, view, i, l) -> {
            gradientColor1Str = colorOptions[i].trim();
            if (!"NONE".equals(gradientColor1Str)) {
                oneColorStr = "NONE";
            }
        });
    }

    private void onBorderColor() {
        colorBorder.setOnItemClickListener((adapterView, view, i, l) -> borderColorStr = colorOptions[i].trim());
    }

    private void onBackgroungColor() {
        oneColor.setOnItemClickListener((adapterView, view, i, l) -> {
            oneColorStr = colorOptions[i].trim();
            if (!"NONE".equals(oneColorStr)) {
                gradientColor1Str = "NONE";
                gradientColor2Str = "NONE";
            }
        });
    }

    private void initAllAdapters() {
        initAdapter(colorBorder, colorOptions);
        initAdapter(oneColor, colorOptions);
        initAdapter(gradientColor1, colorOptions);
        initAdapter(gradientColor2, colorOptions);
        initAdapter(orientation, orientArr);
        initAdapter(gravity, gravityArr);
        initAdapter(animation, animArr);
    }

    private void initAdapter(AutoCompleteTextView autoCompleteTextView, String[] arr) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item, arr);
        autoCompleteTextView.setAdapter(adapter);
    }

    private void findViewsCustom(View customView) {
        width = customView.findViewById(R.id.width);
        height = customView.findViewById(R.id.height);
        cornerRadius = customView.findViewById(R.id.cornerRadius);
        colorBorder = customView.findViewById(R.id.colorBorder);
        borderWidth = customView.findViewById(R.id.borderWidth);
        oneColor = customView.findViewById(R.id.oneColor);
        gradientColor1 = customView.findViewById(R.id.gradientColor1);
        gradientColor2 = customView.findViewById(R.id.gradientColor2);
        orientation = customView.findViewById(R.id.orientation);
        gravity = customView.findViewById(R.id.gravity);
        animation = customView.findViewById(R.id.animation);
        confirmButton = customView.findViewById(R.id.confirmButton);
    }


    private void findViews() {
        main_BTN_click = findViewById(R.id.main_BTN_click);
    }

    private void updatePopupConditions() {
        String widthStr = width.getText().toString().trim();
        String heightStr = height.getText().toString().trim();
        String cornerRadiusStr = cornerRadius.getText().toString().trim();
        String borderWidthStr = borderWidth.getText().toString().trim();


        try {
            if (!widthStr.isEmpty()) {
                int width = Integer.parseInt(widthStr);
                customPopup.changeWidth(width);
            }

            if (!heightStr.isEmpty()) {
                int height = Integer.parseInt(heightStr);
                customPopup.changeHeight(height);
            }

            if (!cornerRadiusStr.isEmpty()) {
                float radius = Float.parseFloat(cornerRadiusStr);
                customPopup.setCornerRadius(radius);
            }

            if (oneColorStr != null && !oneColorStr.isEmpty() && !"NONE".equals(oneColorStr)) {
                int colorId = getColorIdFromString(oneColorStr);
                if (colorId != -1) {
                    customPopup.setBackgroundOneColor(colorId);
                }
            }

            if (gradientColor1Str != null && !gradientColor1Str.isEmpty() && !"NONE".equals(gradientColor1Str)
                    && gradientColor2Str != null && !gradientColor2Str.isEmpty() && !"NONE".equals(gradientColor2Str)) {
                int startColorId = getColorIdFromString(gradientColor1Str);
                int endColorId = getColorIdFromString(gradientColor2Str);
                GradientDrawable.Orientation gradientOrientation = getGradientOrientation(orientationStr);
                if (startColorId != -1 && endColorId != -1) {
                    customPopup.setGradientBackgroundColor(startColorId, endColorId, gradientOrientation);
                }
            }

            if (borderWidthStr != null && !borderWidthStr.isEmpty() &&
                    borderColorStr != null && !borderColorStr.isEmpty()) {
                float borderWidth = Float.parseFloat(borderWidthStr);
                int colorID = getColorIdFromString(borderColorStr);
                if (colorID != -1) {
                    customPopup.setBorder(colorID, borderWidth);
                }
            }

            if (gravityStr == null) {
                gravityStr = "center";
            }
            if (animationStr == null) {
                animationStr = "scale";
            }

            customPopup.dismissPopup();
            customPopup.show(customView, gravityStr, animationStr);
        } catch (Exception e) {
            Log.e("Error", "Error ", e);
        }
    }

    private int getColorIdFromString(String colorStr) {
        switch (colorStr.toLowerCase()) {
            case "black":
                return R.color.black;
            case "white":
                return R.color.white;
            case "blue":
                return R.color.blue;
            case "lightblue":
                return R.color.lightBlue;
            case "lightorange":
                return R.color.lightOrange;
            case "orange":
                return R.color.orange;
            case "green":
                return R.color.green;
            case "pink":
                return R.color.pink;
            case "purple":
                return R.color.purple;
            case "red":
                return R.color.red;
            case "yellow":
                return R.color.yellow;
            default:
                return -1;
        }
    }

    private GradientDrawable.Orientation getGradientOrientation(String orientationStr) {
        switch (orientationStr.toLowerCase()) {
            case "tl_br":
                return GradientDrawable.Orientation.TL_BR;
            case "tr_bl":
                return GradientDrawable.Orientation.TR_BL;
            case "bl_tr":
                return GradientDrawable.Orientation.BL_TR;
            case "br_tl":
                return GradientDrawable.Orientation.BR_TL;
            case "top_bottom":
                return GradientDrawable.Orientation.TOP_BOTTOM;
            case "bottom_top":
                return GradientDrawable.Orientation.BOTTOM_TOP;
            case "left_right":
                return GradientDrawable.Orientation.LEFT_RIGHT;
            case "right_left":
                return GradientDrawable.Orientation.RIGHT_LEFT;
            default:
                return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }
}