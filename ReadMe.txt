0. Download and install JDK 1.7 and set Environment Vars: java_home, path
1. Download and install IntellIj Community Idea
2. Download and install Maven (http://maven.apache.org/download.cgi#Maven_Documentation) (when adding M2_HOME and M2, they should be added as SYSTEM VARS and not like Env Vars)
3. Create account on github.
4. Download and install git locally http://git-scm.com/download/win 
5. Generate SSH keys https://help.github.com/articles/generating-ssh-keys 
6. Add public key to github account (this will be done from all pcs that need access to github repo)
7. Create github repository: AmazonTest
8. Add .gitignore file http://git-scm.com/docs/gitignore 
9. Clone repository on local machine ( the command is clone and not checkout. ). before cloning, make sure you are located in the folder where your project will be created/imported
	$ git  clone git@github.com:me-high/AmazonTest.git
10. Create files locally
11. Commit them and push them on remote repository
12. Configure pom.xml as indicated on http://docs.seleniumhq.org/docs/03_webdriver.jsp and run mvn clean install in project folder (this will download all selenium resources). 
	Dependencies imported: junit, selenium, operaDriver