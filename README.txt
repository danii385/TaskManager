Docker image setup:

1. run-configuration 
	-> clean compile install
	-> skip tests
	-> use jdk1.8
	
2. pom.xml 
	-> run as maven-build
	
3. cmd (main-directory of Task-Manager)
	-> docker build -t taskmanager .
	-> docker-compose up -d