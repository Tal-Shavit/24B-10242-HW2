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
 ``` java
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
// Set solid color background
customPopup.setBackgroundOneColor(R.color.orange);
// Set gradient background - insert two colors and style
customPopup.setGradientBackgroundColor(R.color.lightOrange, R.color.lightBlue, GradientDrawable.Orientation.BOTTOM_TOP);
// Set the corner radius
customPopup.setCornerRadius(90);
// Set the color and width of border
customPopup.setBorder(R.color.black, 4);

// Show the pop-up with position and custom animation
customPopup.show(customView, "center", "scale");
// Or simply show the pop-up in the center without animation
customPopup.show(customView);
```

In this example, customView contains the layout that the developer using the library has prepared. They can then apply the various customization functions to it as needed. For gradient backgrounds, use GradientDrawable.Orientation to specify the direction of the gradient. Use the provided gravity and animation options to position and animate the pop-up.

### Important Note

❗ For changing the design of corners or borders, you must select a background color first. ❗

### Gradient Orientation
using GradientDrawable.Orientation.  
You can choose from the following types:

**GradientDrawable.Orientation.BL_TR** (Bottom-Left to Top-Right)    
**GradientDrawable.Orientation.BOTTOM_TOP** (Bottom to Top)  
**GradientDrawable.Orientation.BR_TL** (Bottom-Right to Top-Left)  
**GradientDrawable.Orientation.LEFT_RIGHT** (Left to Right)  
**GradientDrawable.Orientation.RIGHT_LEFT** (Right to Left)  
**GradientDrawable.Orientation.TL_BR** (Top-Left to Bottom-Right)  
**GradientDrawable.Orientation.TOP_BOTTOM** (Top to Bottom)  
**GradientDrawable.Orientation.TR_BL** (Top-Right to Bottom-Left) 

### Animation Options
You can choose from the following animation types: (upperCase and LowerCase) 

**TOP:** Entrance from the top to the chosen position.  
**BOTTOM:** Entrance from the bottom to the chosen position.  
**LEFT:** Entrance from the left to the chosen position.  
**RIGHT:** Entrance from the right to the chosen position.  
**ROTATE:** Entrance with a rotation to the chosen position.  
**ROTATE_SCALE** / **SCALE_ROTATE:** Entrance with a rotation and scaling from small to large to the chosen position.  
**BOUNCE:** Appears in the chosen position with small bounces.  
**SCALE:** Entrance from small to large to the chosen position.  
**NONE:** Entrance to the chosen position without animation.  

### Position
You can position the pop-up using the following gravity options: (upperCase and LowerCase)  

**TOP:** Entrance from the top to the chosen position.  
**BOTTOM:** Entrance from the bottom to the chosen position.  
**CENTER:** Entrance from the left to the chosen position.  

## Examples
 ### Regular Pop-Up

 <img src="https://github.com/user-attachments/assets/de880a4c-5111-4aeb-9a03-f9f194d806fe" alt="Regular Pop-Up" height="250">

### Pop-Up with Width and Height

 <img src="https://github.com/user-attachments/assets/7a6f8ba0-436a-4f2e-8e68-54392db36a59" alt="Regular Pop-Up" height="250">

### Pop-Up with Gradient Background

<img src="https://github.com/user-attachments/assets/1a2374f9-90df-445a-b2fc-035ec018f3e6" alt="Regular Pop-Up" height="250">

### Pop-Up with Rounded Corners

<img src="https://github.com/user-attachments/assets/01c82432-3af4-4bce-94ae-a97f45f01d31" alt="Regular Pop-Up" height="250">

### Pop-Up with Border

<img src="https://github.com/user-attachments/assets/dd455801-da05-4b65-a8df-cffff8d0bd56" alt="Regular Pop-Up" height="250">

### Pop-Up with Animation and Position

https://github.com/user-attachments/assets/33b8bda1-2cce-46b2-8370-ca69682e0547

https://github.com/user-attachments/assets/35b34850-cb3b-42c5-97d6-6a982c1062ff

https://github.com/user-attachments/assets/e41c02c4-a143-4ed1-8d7e-0d5b7aa21574

### Demonstration Video

Here is a demonstration video showing how the features work within the pop-up itself, where the user inputs the details they want to change and the pop-up updates accordingly.  

https://github.com/user-attachments/assets/67e0f365-453c-42dc-a7bf-f5119f52540f

