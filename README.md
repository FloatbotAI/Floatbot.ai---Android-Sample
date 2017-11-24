# Floatbot.ai SDK Android Sample Project

### This app uses floatbot.ai SDK.

[About Floatbot](http://floatbot.ai)

## Prerequisite

* Bot_ID
* ToKen

You can get Bot_ID and Token for your app from https://floatbot.ai/portal/dashboard/login 

## Download

Add maven { ... } part of code like below inside project level **build.gradle** file.

```java
allprojects {
  repositories {
    maven { url "https://jitpack.io" }
    maven {
        url "http://13.77.84.178:8081/artifactory/libs-release-local"
    }
  }
}
```

Open **build.gradle** inside module that will use floatbot and simply add a dependency.

```java
dependencies {
  compile 'ai.floatbot:floatbot:1.3.8'
}
```


To start using Floatbot in android app, write below line anywhere in your activity/fragment

```java
FloatBot.startChat(this,Bot_ID,Token,"Bot name");
```

To Set Mobile number in Floatbot to identify a particular user (Optional)

```java

FloatBot.setMobileNumber("91XXXXXXXXXX");
//Note : Call this function before calling startchat()

```

To receive broadcast messages from Floatbot.ai set push notification token [gcm] and also set gcm server key on dashboard

```java

FloatBot.setPushToken("push_token")
//Note : Call this function before calling startchat()

//To update push token later use below method
FloatBot.updatePushToken(this,push_token);

```

Modify your onMessageReceived function in GcmListenerService class

```
@Override
public void onMessageReceived(String s, Bundle bundle) {
  super.onMessageReceived(s, bundle);
  FloatBot.processmessage(this,bundle);
}

```






