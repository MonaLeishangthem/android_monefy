
Please find below the two charters which I have planned for this task. Also please find the bugs identified. 

* I would prioritise charter 001 and mainly focus on adding and updating the expenses. I would explore first the feature which will be frequently used by the user which is to add/update/undo multiple expenses and income. I would also check they are added to the correct category and correct accounts. This is the data on which the app works so it is very important. Secondly I would check the processed chart information. This is the main feature of the app. 
* I have specified the duration of each chater. Chapter001 should be max 2hours, Chapter002 around 30 mins and for Chapter003, I have prepared it but could not explore as i do not have subscription.
* Overtime the app will have thousand of entries. I would keep an eye on the performance and memory usage of the application when there are thousand of entries.


## Charter01: 
*Explore landing page(chart page) of the application*
*with various inputs(expenses and incomes)*
*to discover bugs in the calculation of the expense data displayed in the chart*


#### Areas:
* OS : iOS 14.7.1
* Strategy : Functional Tester
* Strategy : Functional Analyst
* Strategy : End User

#### Start Time:
12/09/2021 14:00hr

#### Duration: 
Long

#### Test Notes:
I test the chart landing page and its data. For this, i performed various tasks as follows:
* addition, deletion(undo) and updation of predefined expenses/income using the icon
* addition, deletion and updation of predefined expenses/income using the + and - icon
* validated the percentile calculation in the chart
* validated the data displayed in the chart
* validated the detailed overview and checked the edge case by adding numeruos entries
* checking of chart along with filtering options. 
* search field check
* New transfer feature
* scheduling feature


#### Bugs:
1. Description: Last account is taken by default while adding expenses/income when there is multiple accounts.<br/>
Steps to Reproduce:
    1. Open app and create two accounts- A and B. Add income for B.
    2. In the filter, select 'all counts'. Then add the a new income by clikcing on + iocn. The income is added to B. 
    3. Now add account C. 
    4. Add a new income (filter is all accounts). The income is still added to B.
    5. Select C account and add an income for C account. 
    6. Select all account and add an income. The new income is added to C. 

Actual: The account seems to be taken from the last addition cache.<br/>
Expected: It should either ask for an account or notify the user which account he/she is adding the income. 


#### Issues:
1. How many days will be listed when the overview display is 'by calender day'? 
3. I am not sure how the chart will be if there is multicurrency. Will it be just the numerical values or will it have expense rate into consideration. 


## Charter 002 :
*Explore additional menu options/kebab menu *
*with various inputs*
*to discover bugs in category/accounts/currencies options*

#### Areas:
* OS : iOS 14.7.1
* Strategy : Functional Tester
* Strategy : Functional Analyst
* Strategy : End User

#### Start Time:
12/09/2021 15:30 00hr

#### Duration: 
Short

#### Test Notes:
I touched each menu item in the additional menu options. Mainly focusing on multiple account and the general settings. Some items i explored are:
* creation of new income/expense is not allowed for all users (only for MonefyPro subscriptions)
* create multiple accounts and checking its impact on the landing page/chart page.
* navigation to an fro of different menu items
* currencies allowed only for MonefyPro users.
* general settings


#### Bugs:
1. Description: Changing of currency changes the currency of past entries. <br/>
Steps to Reproduce:
    1. Open app and enter some income and expense
    2. Change the currency. 

Actual: The new currency is reflected for the existing entries also.<br/>
Expected: The new currency should reflect for new income/expenses only. It can be that the user moved in a different country and he/she would like to keep the old record in old currency and new record in new currency. This is not exactly multicurrency but rather two uni currency . Maybe a business analyst can decide on this.


#### Issues:
1. I did not exactly understand the budget mode, carry over and future recuring records features. Maybe having an info would be helpful for user to understand what they can expect when they check the three checkboxes.
 

## Charter 003 :
*Explore features for MonefyPro *
*with various inputs*
*to discover the features are as expected*











