package com.talshavit.a24b_10242_hw_2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MaterialButton main_BTN_click, confirmButton;
    private CustomPopup customPopup;
    private TextInputEditText width, height, cornerRadius, borderWidth;
    private CheckBox focuseCheckBox;
    private Spinner colorBorder, oneColor, gradientColor1, gradientColor2, orientation, gravity, animation;

    String oneColorStr, gradientColor1Str, gradientColor2Str, orientationStr, gravityStr, animationStr;
    int borderColorId;
    View customView;

    private String[] colorOptions = {"NONE", "BLACK", "WHITE", "BLUE"};
    private String[] gravityArr = {"NONE", "TOP", "BOTTOM", "CENTER"};
    private String[] animArr = {"NONE", "TOP", "BOTTOM", "LEFT", "RIGHT", "ROTATE", "ROTATE_SCALE", "SCALE_ROTATE", "BOUNCE", "SCALE"};

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

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colorOptions);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            colorBorder.setAdapter(adapter);
            oneColor.setAdapter(adapter);
            gradientColor1.setAdapter(adapter);
            gradientColor2.setAdapter(adapter);

            List<String> ori = new ArrayList<>();
            ori.add("tl_br");
            ArrayAdapter<String> adapterOrientation = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ori);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            orientation.setAdapter(adapterOrientation);

            ArrayAdapter<String> adapterGravity = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, gravityArr);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            gravity.setAdapter(adapterGravity);

            ArrayAdapter<String> adapterAnim = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, animArr);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            animation.setAdapter(adapterAnim);

            colorBorder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    borderColorId = getColorIdFromString(colorOptions[position]);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // Handle no selection
                }
            });

            oneColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    oneColorStr = colorOptions[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // Handle no selection
                }
            });

            gradientColor1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    gradientColor1Str = colorOptions[i];
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            gradientColor2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    gradientColor2Str = colorOptions[i];
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            orientation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    orientationStr = ori.get(i);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            gravity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    gravityStr = gravityArr[i].trim();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            animation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    animationStr = animArr[i].trim();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updatePopupConditions();
                }
            });

            customPopup.setCustomView(customView);
            //customPopup.setBackgroundOneColor(R.color.orange);
            //customPopup.setCornerRadius(30);
            //customPopup.setBorder(R.color.black, 4);
            //customPopup.setGradientBackgroundColor(R.color.lightOrange, R.color.lightBlue, GradientDrawable.Orientation.BOTTOM_TOP);
            customPopup.setFocusable(false);

            customPopup.show(view, "center", "scale");

        });
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
        focuseCheckBox = customView.findViewById(R.id.focuseCheckBox);
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

        boolean isFocusable = focuseCheckBox.isChecked();

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

            if (!oneColorStr.isEmpty() && !oneColorStr.equals("NONE")) {
                int colorId = getColorIdFromString(oneColorStr);
                if (colorId != -1) {
                    customPopup.setBackgroundOneColor(colorId);
                }
            }

            if (!gradientColor1Str.isEmpty() && !gradientColor2Str.isEmpty()) {
                int startColorId = getColorIdFromString(gradientColor1Str);
                int endColorId = getColorIdFromString(gradientColor2Str);
                GradientDrawable.Orientation gradientOrientation = getGradientOrientation(orientationStr);

                if (startColorId != -1 && endColorId != -1) {
                    customPopup.setGradientBackgroundColor(startColorId, endColorId, gradientOrientation);
                }
            }

            if (!borderWidthStr.isEmpty() && borderColorId != -1) {
                float borderWidth = Float.parseFloat(borderWidthStr);
                customPopup.setBorder(borderColorId, borderWidth);
            }

            customPopup.setFocusable(isFocusable);
            customPopup.update();

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

    private int getAnimationResource(String animationStr) {
        switch (animationStr.toLowerCase()) {
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
            default:
                return R.style.PopupAnimation_Scale;

        }
    }
}