clean:
	gradle clean

compile:
	gradle build -x test 

test:
	gradle test

spotbugs:
	gradle spotbugsMain

codesmells:
	gradle smartsmells

run: 
	java -cp build/libs/starbucks.jar starbucks.Main  2>debug.log

