## SimpleHUD [![](https://jitpack.io/v/Doublemine/SimpleHud.svg)](https://jitpack.io/#Doublemine/SimpleHud)

  **FORK　FROM [wangvsa/SimpleHUD](https://github.com/wangvsa/SimpleHUD)**

## BUG FIX:

  - Fix memory leak 

## USAGE:

### Android Studio

#### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

#### Step 2. Add the dependency

 * CURRENT VERSION: [![](https://jitpack.io/v/Doublemine/SimpleHud.svg)](https://jitpack.io/#Doublemine/SimpleHud)

```gradle
dependencies {
	        compile 'com.github.Doublemine:SimpleHud:<VERSION>
	}
```


### Eclipse

![](https://camo.githubusercontent.com/8caa3693b4268c095c001089313d687f647d551a/687474703a2f2f696d67322e77696b69612e6e6f636f6f6b69652e6e65742f5f5f636232303133303831393134323932382f6361726466696768742f696d616765732f7468756d622f352f35352f476f2d686f6d652d796f7572652d6472756e6b2e6a70672f35303070782d476f2d686f6d652d796f7572652d6472756e6b2e6a7067)


### Showing the loading dialog

```java
SimpleHUD.showLoadingMessage(this, "loading data, please wait...", true);
```

Note the third parameter `boolean cancelable`, if you set it to `true` then you can tap the back button to cancel the HUD.

When your operation is completed, call `dismiss()` method to dismiss it.
```java
SimpleHUD.dismiss();
```

### Showing the message dialog

The next three HUD are the same except the icon.
It will dismiss itself so no need to to invoke `dismiss()` explicitly.

```java
SimpleHUD.showInfoMessage(this, "This is a info message.");
SimpleHUD.showErrorMessage(this, "This ia an error message.");
SimpleHUD.showSuccessMessage(this, "This ia a success message.");
```

### Invoke your method when the HUD dismiss

Create an object of the  `SimpleHUDCallback` interface and implement its `onSimpleHUDDismissed` method.
Then pass it to SimpleHUD as an argument. Here's an example:

```java
private SimpleHUDCallback simplehudCallback = new SimpleHUDCallback() {
  @Override
  public void onSimpleHUDDismissed() {
    // your code goes here...
  }
};
SimpleHUD.showInfoMessage(this, "This is a info message.", simplehudCallback);
// SimpleHUD.showErrorMessage(this, "This ia an error message.", simplehudCallback);
// SimpleHUD.showSuccessMessage(this, "This ia a success message.", simplehudCallback);
```


## Customization

### Change the display time

Set the variable `dismissDelay` to one of the three constants.
```java
SimpleHUD.dismissDelay = SimpleHUD.DISMISS_DELAY_SHORT;     // 2s
SimpleHUD.dismissDelay = SimpleHUD.DISMISS_DELAY_MIDIUM;    // 4s
SimpleHUD.dismissDelay = SimpleHUD.DISMISS_DELAY_LONG;      // 6s
```

Or a arbitrary value.
```java
SimpleHUD.dismissDelay = 8000;                              // 8s
```

### Change the background
Set the variable `backgroundHexColor` to a arbitrary value:

***NOTE: you'd better set alpha Color .***

```java
SimpleHUD.backgroundHexColor="#aa817EDF"
```