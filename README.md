# WebDriver_TheInternet_Advanced
Testing against Dave Haeffner's site The-Internet, building up a suite of Common Utilities to help the process.

Dave Haeffner built The-Internet... at https://the-internet.herokuapp.com/. This is the site I am testing against.

From my blog, <b>Adventures in Automation</b> at http://www.tjmaher.com/:
<blockquote>
<ul>
<li><b>Part One:</b>&nbsp;Sketching out the&nbsp;<a href="http://adventuresinautomation.blogspot.com/2015/06/simple-manipulation-of-login-page.html">simple manipulation of a login page</a></li>
<li><b>Part Two</b>: Drafting&nbsp;<a href="http://adventuresinautomation.blogspot.com/2015/06/creating-common-utilities-for-webdriver.html" target="_blank">a set of common utilities</a>, refactoring the initial code</a></li>
<li><b>Part Three:</b>&nbsp;Storing constants:&nbsp;<a href="http://adventuresinautomation.blogspot.com/2015/07/how-java-stores-constants-static-final.html">public final vs enums</a></li>
<li><b>Part Four:</b> Storing&nbsp;<a href="http://adventuresinautomation.blogspot.com/2015/07/storing-locators-for-web-elements.html" target="_blank">locators in enums</a></li>
<li><b>Part Five:</b> The&nbsp;<a href="http://adventuresinautomation.blogspot.com/2015/07/the-internet-page-object-model-examples.html">Page Object Model</a>&nbsp;</li>
<li><b>Part Six:</b><a href="http://adventuresinautomation.blogspot.com/2015/07/the-internet-writing-automated-test.html">Writing the Automated Test</a></li>
</ul>
</blockquote>

WebDriver_TheInternet_Advanced is a suite of automated Selenium WebDriver / Java tests that I am building
to test The-Internet. This is based on the automated test suite that I am seeing
as an automation engineeer at Fitbit-Boston to test their eCommerce application. To deepen my understanding 
of the many libraries that have been created at Fitbit, I am examining them, playing with them, taking them 
apart, and putting them back together. 

Permission has been granted to blog about my understanding about their automation code, as long as no proprietary information
is revealed. 

I have only been coding automated tests on-the-job since March 2015. Please don't assume any of this code works and
use it in your production environment without testing it first. 

The pages this projects currently test against:

* Login 

Utilities written:
* CommonUtils: Methods of the WebDriver API are individually wrapped up in try / catch / throw blocks, with 
     built in logging functionality, suitable for a Jenkins console.





