# AspireApp-hybrid-maven-project
Build a hybrid maven framework to order amanufacturing and verify inputted information displayed correctly on Manufacturing Order page by using:
- Language: Java
- Tool: Eclipse, Selenium, TestNG, Maven


# Setup environment
1. Download and Install: Eclipse/ Intellji app, jdk1.8, apache Maven, Firefox/ Chrome browser, Allure libraries
2. Add paths of allure-2.13.6, apache-maven-3.6.3, jdk1.8.0_271 in enviroment variable
For example: add and save content in .bash_profile file on Macos
export  JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_271.jdk/Contents/Home/
export PATH=$PATH:$JAVA_HOME/bin

# How to run tests
1. Download this project to your computer. Unzip folder and import it into Eclipse/ Intellji application
2. R-click on AspireApp-hybrid-maven-project, click Maven/Update Project to download dependencies libraries. Please a few minutes to download completely.
3. R-click on AspireApp-hybrid-maven-project, click TestNG/ Convert to TestNG.
4. Open terminal app:
- Go to AspireApp-hybrid-maven-project folder, 
- Run "mvn clean test" 
(Testcase will be run at this step. Please for completing all steps in testcase. Run below command)
- Run "chmod 775 runAllureOnMac.sh
- Run ./runAllureOnMac.sh
(Allure report will show after some minutes)
