0. Install JDK 1.7
1. Install IntellIj Community Idea
2. Download and install Maven
3. Create account on github / Download and install git locally http://git-scm.com/download/win 
4. Generate SSH keys. Add public key to github account
5. Create github repository: AmazonTest
6. Add and configure .gitignore file http://git-scm.com/docs/gitignore 
7. Clone (checkout) repository on local machine. 
	$ git  clone git@github.com:me-high/AmazonTest.git8. Create files locally
8. Commit them and push them on remote repository
9. Configure pom.xml as indicated on http://docs.seleniumhq.org/docs/03_webdriver.jsp and run mvn clean install in project folder (this will download all selenium resources). 
	Dependencies imported: junit, selenium, operaDriver, cucumber, cucumber reporting, ...
10. Run tests using junit, or from console: -DbrowserType=firefox
11. Report is in \target\html folder.