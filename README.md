# WebDriver_TheInternet_Advanced
Testing against Dave Haeffner's site The-Internet, building up a suite of Common Utilities to help the process.

Dave Haeffner built The-Internet... at https://the-internet.herokuapp.com/. This is the site I am testing againt.

WebDriver_TheInternet_Advanced is a suite of automated Selenium WebDriver / Java tests that I am building
to test The-Internet. This is not original work. It is based on the automated test suite that I am seeing
as an automation engineeer at Fitbit-Boston to test their eCommerce application. To deepen my understanding 
of the many libraries that have been created at Fitbit, I am examining them, playing with them, taking them 
apart, and putting them back together. 

Permission has been granted to blog about my understanding about the code, as long as I make sure to not 
reveal any proprietary information. 

I have only been coding automated tests on-the-job since March 2015. Please don't assume any of this code works and
use it in your production environment without testing it first. 

The pages this projects currently test against:

* Login 

Utilities written:
* CommonUtils: Methods of the WebDriver API are individually wrapped up in try / catch / throw blocks, with 
     built in logging functionality, suitable for a Jenkins console.
     


