# Custom Pop-Up Library

Welcome to the Custom Pop-Up Library! This library allows developers to easily create and customize pop-ups in their Android applications with minimal effort. By simply providing a general design file with the desired elements, you can make extensive modifications to the pop-up appearance and behavior.

## Features
### 1. Customizable Dimensions
- **Width & Height:** Easily adjust the width and height of the pop-up to fit your needs.
### 2. Background Customization
- **Solid Color Background:** Change the background color of the pop-up to any solid color.  
- **Gradient Background:** Apply a gradient background with multiple customization options for a more dynamic look.
### 3. Border Customization
- **Add Border:** Option to add a border around the pop-up.  
- **Border Thickness:** Choose the thickness of the border to match your design preferences.
### 4. Corner Customization
- **Rounded Corners:** Round the corners of the pop-up to create a smooth, modern appearance.
### 5. Animation Effects
- **Rotation:** Add a rotation effect to the pop-up.  
- **Grow from Small to Large:** Animate the pop-up to grow from a smaller size to its full size.  
- **Entry Animation:** Customize the entry animation of the pop-up to make it appear from different directions.  
- **Bounce:** Add a bounce effect to make the pop-up appear with a bouncing motion.  
- **Scale & Rotate:** Combine scaling and rotating effects for a dynamic animation.  
### 6. Display Position
- **Top of the Screen:** Display the pop-up at the top of the screen.  
- **Center of the Screen:** Center the pop-up on the screen for a balanced look.  
- **Bottom of the Screen:** Position the pop-up at the bottom of the screen.
### 7. Ease of Use
- **General Design File:** Simply provide a design file with the elements you want in the pop-up, and the library takes care of the rest.

  ## Usage
 ```java
// Initialize the CustomPopup with the context
CustomPopup customPopup = new CustomPopup(context);

// Inflate the custom layout
LayoutInflater inflater = LayoutInflater.from(context);
View customView = inflater.inflate(R.layout.custom_content, null);

// Set the custom view to the pop-up
customPopup.setCustomView(customView);

// Set only the width
customPopup.changeWidth(1000);
// Set only the height
customPopup.changeHeight(1500);
// Set both width and height
customPopup.setPopUpSize(1000, 1500);
// Set the corner radius
// customPopup.setCornerRadius(90);
// Set the color and width of border
// customPopup.setBorder(R.color.black, 4);
// Set solid color background
// customPopup.setBackgroundOneColor(R.color.orange);
// Set gradient background - insert two colors and style
// customPopup.setGradientBackgroundColor(R.color.lightOrange, R.color.lightBlue, GradientDrawable.Orientation.BOTTOM_TOP);

// Show the pop-up with position and custom animation
customPopup.show(customView, "center", "scale");
// Or simply show the pop-up in the center without animation
// customPopup.show(customView);
```



https://github.com/user-attachments/assets/a71266db-5047-4bdf-acde-ade6464ebb90


## implementation
