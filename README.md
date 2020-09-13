# thinkbridge

1. Clone the gitrepo https://github.com/chintamoni/thinkbridge.git into your IDE. Set JDK 1.8
2. Perform maven clean/update to download  all dependencies
3. D:\thinkbridge\src\main\java\Resources\logger.properties here update the path to logs path since we are using logger.properties for file as well as console
4. D:\thinkbridge\src\test\java\steps\ThinkBridgeSteps.java here for step "I should be receiving Registration Confirmation Email" specify your email,password and email subject content
5. D:\thinkbridge\src\main\java\features\thinkbridge.feature here under Examples. specify the email same as mentioned in Step4
6. After above changes made save all changes, followed by project clean and refresh
7. Right click on D:\thinkbridge\src\main\java\features\thinkbridge.feature and run as Cucumber Feature
8. Runnig the project is also possible using D:\thinkbridge\src\test\java\Runner\CucumberRunner.java but there is some jar dependency and time constraint so didnt recitify
