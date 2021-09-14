## Task2

**Below are the ideas which I would test for Monefy application**

## 1. Adding/deleting/ Updating an expense/income:
i.  addition/deletion/updating entries for the predefined income category<br/>
ii.  addition of a new income category and addition/deletion/updating the new income entries<br/>
iii. addition/deletion/updating entries for the predefined expense category<br/>
iv. addition of a new income category and addition/deletion/updating the new expense entries<br/>
v. adding expenses and income using images and +/- icons<br/>
vi. make sure the data is reflected corected.<br/>
vii. scheduling feature for income/expenses<br/>
viii. multiple schedule to add income/expense at the same time to check the performance of the app<br/>
ix. edge case of maximum expense category which can be added <br/>

## 2. Chart display & Filter
i. validate that the expense calculation(the percentile values) is correct<br/>
ii. filter between multiple accounts and check the chart display<br/>
iii. filtering by predefined timelines(week/month etc) and validating the displayed chart is as expected <br/>
iv. choose a date in past/future/present and validating the displayed chart is as expected<br/>

## 3. Balance Overview display
i. detailed overview - validate the displayed data<br/>
ii. detailed overview - check the edge cases. This case do not need to be executed every regression but we can automate to have hundreds of data and see now the overview will behave.
iii. filtering between calendar date and money<br/>

## 4 Search :
i. search with numerical which will be found in the entries<br/>
ii. search with numerical which will NOT be found in the entries<br/>
iii. search with alphabetic which will be found in the entries<br/>
iv. search with alphabetic which will NOT be found in the entries<br/>
v. search with special characters<br/>
vi. search with numerical and alphabets together<br/>

## 5. MonefyPro features: 
i. make sure that features are correctly offered with respect to the subscription<br/>
ii. Validate the features of MonefyPro users<br/>

## 6. Additional options menu /kebab menu : 
#### Categories 
*   Add new categories of income and expense<br/>
#### Accounts 
* Add new accounts if different types<br/>
* New transfer between accounts<br/>
#### Currencies 
* due to lack of test data, unable to identify the TCs<br/>
#### Settings 
i. Balance: enable the checkboxes (budgetmode, carryover and future recurring records) and validate its functionality<br/>
ii. Balance: disable the checkboxes and validate the functionalities are turned off<br/>
iii. Settings: Unlock Moneyfypro feature<br/>
iv. Settings: Enabling dark theme<br/>
v. Settings: Change language<br/>
vi. Settings: Change currency<br/>
vii. Settings: Change language<br/>
viii. Settings: Passcode protection<br/>
ix. Settings: Review application<br/>
x. Settings: Export to file (all possible destination file location options needs to be checked)<br/>
xi. Settings: About Monefy. Check the text displays is correct in multiple language<br/>
xii. Synchronization: Google Drive flow.<br/>
xiii. Synchronization: DropBox flow.<br/>
xiv. Data Backup: Create data backup flow<br/>
xv. Data Backup: Restore data flow<br/>
xvi. Data Backup: Clear data flow. Validate all data is cleared<br/>



Regarding the prioritization, I would have the below test suites in the sanity and smoke test. 
* Adding/deleting/ Updating an expense/income (from i to vi are critical in the above list )
* Chart display & Filter
* MonefyPro features. They are paid users so the functionality which are most widely used by these users should not break in any scenario.
* Balance Overview display: probably the overview per calender day

Automation:<br/>
Unit Test : Each features/module must have unit test written and executed.<br/>
Pros: It makes sure that  the smallest modules are working as expected. It find the bugs earliest in the core/basic functionality as it can be executed after the module is developed.<br/>
Cons: An app is made of multiple modules. It can not test the integration defects.

Integreation test:<br/>
Pros: Best for automating/testing the third party dependent modules. Like test case for synchronization and data backup and  review. We can mock reponses so that our testing is not dependent on third party module.
It is also faster than UI testing so we can test some integration of different modules<br/>
Cons: It doesnot test the UI. As Monefy is a customer facing application, we need to make sure that the UI are as expected

EndUser/UAT test:<br/>
Most test cases mentioned above  can be automated. We can even use image compare to make sure the colors of chart is displayed correctly.<br/>
Pros: It will make sure the UI presentation of the app is as expected. It will perform E2E flows.<br/>
Cons: It is slower and time consuming compared to integration and UI test.  

Performance test:<br/>
Have thousands of data and see the performance of app. We can find out the response time of API.<br/>
Pro: It will have sure the app do not crash or hang or reduce performace when used extensively.<br/>
Cons: It is the non functional testing and do not test the functionality of the app itself.


I would automate the UAT Test. Unit and integration needs access to the source code. Performance test can also be added in the source code itself. 
I  use Appium tool as it can be used for iOS. One source code for both Android and iOS is easier to maintain for QE. The build tool is maven and language is java. The framework is TestNG as it provides various possibilities to control the execution. 


 
