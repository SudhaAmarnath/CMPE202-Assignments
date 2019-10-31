# To Run the project
cd starbucks/

./Makefile

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
  

# Starbucks Class Diagram
![Starbucks Class Diagram](https://user-images.githubusercontent.com/42689991/56943525-bdb6de00-6ad4-11e9-9d54-60098b877545.png)


# Add Card Sequence Diagram
![Add Card Sequence Diagram](https://user-images.githubusercontent.com/42689991/56943521-bdb6de00-6ad4-11e9-8fd4-00040a4d9150.png)


# Add Card Composite Class Diagram
![ADd Card Composite Class Diagram](https://user-images.githubusercontent.com/42689991/56943520-bdb6de00-6ad4-11e9-840f-70842e078d08.png)


# Observer Pattern Diagram
![Observer Pattern Diagram](https://user-images.githubusercontent.com/42689991/56943523-bdb6de00-6ad4-11e9-9b5c-ba0cf2f46272.png)


# Pin Entry Machine State Pattern Diagram
![Pin Entry Machine State Pattern Diagram](https://user-images.githubusercontent.com/42689991/56943524-bdb6de00-6ad4-11e9-85fb-8b737e5f172f.png)


# Command Pattern Diagram
![Command Pattern Diagram](https://user-images.githubusercontent.com/42689991/56943522-bdb6de00-6ad4-11e9-91b4-2a24b34c1e94.png)


# Test run results
![2](https://user-images.githubusercontent.com/42689991/56944131-138c8580-6ad7-11e9-809d-55310ed57a76.PNG)


# Gradle Codesmells
![3](https://user-images.githubusercontent.com/42689991/56944132-138c8580-6ad7-11e9-9715-c427bb561784.PNG)


# Gradle SpotBugsMain
![1](https://user-images.githubusercontent.com/42689991/56944130-138c8580-6ad7-11e9-881c-f85855b32a31.PNG)

