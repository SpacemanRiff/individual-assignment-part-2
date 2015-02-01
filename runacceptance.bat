cd acceptance
javac -cp .;..\build\classes\main TicTacToeKeywords.java
java -cp .;..\build\classes\main;C:\RobotFramework\robotframework-2.8.5.jar;C:\SwingLibrary\swinglibrary-1.9.1.jar org.robotframework.RobotFramework TicTacToeTests.txt
cd ..