# UAT AUtomation for Monefy

**Automation for android devices. It  uses Appium + TestNG maven project.**

Why this technology stack? 
1. Appium can be used for both iOS and Andoroid. It is open source and has very active community. Flexibility to choose programming language as it supports multiple. Also it can be used for web for hybrid applications . 
2. TestNG provides a lots of flexibility to command and structure the framework. 
3. Maven helps in maintaing the dependencies. 
4. We can import many other dependencies such as OpenCV for image compare, testinium to get the UDIDs of devices so that device identification is dynamic, sikuli for desktop interaction, selenium grid for parallel execution etc. All this provides a lot of flexibility for the engineer.


**Set up and Procedure:**
1. We can execute through jenkins and version contral tool. If executing locally, please clone the code. Please change the desired capabilities to your device. I have also added testinum code but have commented  it out as you will need to set your env variables. Testinum get the device info dynamically and is very useful.
2. maven cmd to execute is : clean install test  -Dsurefire.suiteXmlFiles=BasicE2E.xml --log-file log.txt 
3. Otherwise Run the main class BasicE2E as TestNG or run the testNG xml (directly BasicE2E.xml ).
4. Appium server must be running to intercept the request of the client.
5. Once the appium server receives the request, it starts execution on the device to be tested.

TestCase: 
Automate a sample E2E flow. 
* create two accounts
* validate that the accounts are added correctly by asserting the account name.
* select account A and add few income and expenses.
* validate the total income and expense in the chart.
* in balance overview window, validate that the expenses/income are added in correct categories.
* validate the amount(value) against category(key) using hash map. 
* go to Settings, scroll to clear data and select clear data.

        
    
**Running the automation:**
1. Complete the installation for appium client and server (steps below). 
2. In the maven project, Go to 'Android.IOSConstants.java' and change the desired capabilities as per the device to be tested (steps below)
3. Start appium server. It can be done in two ways:
    * from terminal, type 'appium'
    * install appium desktop and start it from the UI
4. Run the project as maven via pom.xml or as TestNG via testng.xml 
    
**Set the desired capabilities**
1. The capabilities should set for the device and application used for testing. Go to uatregression.utils.IOSConstants.java., update the below capabilities as per your device requirement.
    * CAP_APPIUM_PLATFORMVERSION = iOS version of the device
    * CAP_APPIUM_DEVICENAME = iPhone or iPad
    * CAP_APPIUM_APP = File location for the app to be tested 
    * CAP_APPIUM_UDID = udid of the device


 
## For appium client (Android):
*It is the same maven project as the iOS Automation workspace. It is also written in Java and TestNG framework. *
#### Workspace setup:
1. Install Java 8 or above
2. Install an IDE (Eclipse / IntelliJ)
3. Clone the git repository . 
4. Import the project as 'maven project' and build the maven dependencies.
5. 'Logcat' is laso be used for logs validation. Here we are using the UI as we are focusing in UAT test.

## For appium server(iOS):
*The server executes the client request on physical devices or simulators.*
#### Workspace setup:
1. Install Appium (steps below)

**Steps for installing appium on MacOS:**
1. Install node.js : brew install node 
2. Check node and npm version to make sure they are installed properly : node -v or npm -v
3. Install aapium : npm install -g appium
## For appium server(Android):
*The server executes the client request on physical devices or simulators.*
#### Workspace setup:
1. Install Appium (steps below)
2. Install Andoid SDK (for adb, logcat & uiautomator) by downloading Android Studio or just the Android SDK. 
3. Set up ANDROID_HOME & JAVA_HOME. eg:
    * export ANDROID_HOME="$HOME/Android/android-sdk-macosx"
    * export JAVA_HOME='/Library/Java/JavaVirtualMachines/jdk-13.jdk/Contents/Home'



