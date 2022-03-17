echo "----Step 01: Set project path to variable-----"
project_path="/Users/macintoshhd/git/Selenium-Practices/Hybrid-Maven-AspireApp"
echo"------Step 02: Go to Project path folder"
cd "$project_path"
echo"------Step 03: Run the testcases"
java -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
echo "------ Step 04: Load allure command line setting -------"
source ~ /.bash_profile
echo "------ Step 05: Generate Allure HTML Report -------"
allure serve ./allure-json/
