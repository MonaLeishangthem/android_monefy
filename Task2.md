## Task2

**Below are the ideas which I would test for Monefy application**

## 1. Adding/deleting/ Updating an expense/income:
i.  addition/deletion/updating entries for the predefined income category
ii.  addition of a new income category and addition/deletion/updating the new income entries
iii. addition/deletion/updating entries for the predefined expense category
iv. addition of a new income category and addition/deletion/updating the new expense entries
v. adding expenses and income using images and +/- icons
vi. make sure the data is reflected corected.
vii. scheduling feature for income/expenses
viii. multiple schedule to add income/expense at the same time to check the performance of the app
ix. edge case of maximum expense category which can be added 

## 2. Chart display & Filter
i. validate that the expense calculation(the percentile values) is correct
ii. filter between multiple accounts and check the chart display
iii. filtering by predefined timelines(week/month etc) and validating the displayed chart is as expected 
iv. choose a date in past/future/present and validating the displayed chart is as expected 

## 3. Balance Overview display
i. detailed overview - validate the displayed data
ii. detailed overview - check the edge cases. This case do not need to be executed every regression but we can automate to have hundreds of data and see now the overview will behave.
iii. filtering between calender date and money

## 4 Search :
i. search with numerical which will be found in the entries
ii. search with numerical which will NOT be found in the entries 
iii. search with alphabetic which will be found in the entries
iv. search with alphabetic which will NOT be found in the entries
v. search with special characters
vi. search with numerical and alphabets together

## 5. MonefyPro features:
i. make sure that features are correctly offer with respect to the subscription
ii. Validate the features of MonefyPro users

## 6. Additional options menu /kebab menu :
#### Categories
*   Add new categories of income and expense
#### Accounts
* Add new accounts if different types
* New transfer between accounts
#### Currencies 
* due to lack of test data, unable to identify the TCs
#### Settings
i. Balance: enable the checkboxes (budgetmode, carryover and future recurring records) and validate its functionality
ii. Balance: disable the checkboxes and validate the functionalities are turned off
iii. Settings: Unlock Moneyfypro feature
iv. Settings: Enabling dark theme
v. Settings: Change language
vi. Settings: Change currency
vii. Settings: Change language
viii. Settings: Passcode protection
ix. Settings: Review application
x. Settings: Export to file (all possible destination file location options needs to be checked)
xi. Settings: About Monefy. Check the text displays is correct in multiple language 
xii. Synchronization: Google Drive flow. 
xiii. Synchronization: DropBox flow.
xiv. Data Backup: Create data backup flow
xv. Data Backup: Restore data flow
xvi. Data Backup: Clear data flow. Validate all data is cleared



Regarding the prioritization, I would have the below test suites in the sanity and smoke test. 
* Adding/deleting/ Updating an expense/income (from i to vi are critical in the above list )
* Chart display & Filter
* MonefyPro features. They are paid users so the functionality which are most widely used by these users should not break in any scenario.
* Balance Overview display: probably the overview per calender day

Automation: 
Unit Test : Each features/module must have unit test written and executed. 
Pros: It makes sure that  the smallest modules are working as expected. It find the bugs earliest in the core/basic functionality as it can be executed after the module is developed. 
Cons: An app is made of multiple modules. It can not test the integration detects.

Integreation test: 
Pros: Best for automating/testing the third party dependent modules. Like test case for synchronization and data backup and  review. We can mock reponses so that our testing is not dependent on third party module.
It is also faster than UI testing so we can test some integration of different modules
Cons: It doesnot test the UI. As Monefy is a customer facing application, we need to make sure that the UI are as expected

EndUser/UAT test:
Most test cases mentioned above  can be automated. We can ecen use image compare to make sure the colors of chart is displayed correctly. 
Pros: It will make sure the application UI presentation is as expected. It will perform E2E flows.
Cons: It is slower and time consuming compared to integration and UI test.  

Performance test: 
Have thousands of data and see the performance of app. We can find out the response time of API.
Pro: It will have sure the app do not crash or hang or reduce performace when used extensively. 
Cons: It is the non functional testing and do not test the functionality of the app itself.


I would automate the UAT Test. Unit and integration needs the source code. Performance test can also be added in the source code itself. 
I  use Appium tool as it can be used for iOS. One source code for both Android and iOS is easier to maintain for QE. The build tool is maven and language is java. The framework is TestNG as it provides various possibilities to control the execution. 


 
