# List-Generator

Welcome to List-Generator!

#Setup:
In order to run the application, you need to have JDK installed in your system.

Tools needed for running the app:

Link to installing JDK: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Running the application:

Note: You should have two CSV files in the “Data” folder inside “List-Generator” before running the application. Refer to the sample format for student roster and project roster. 

- Once your computer is set up with JDK, open terminal (if you are using Mac) or command prompt (if using windows)

-  Navigate to the directory where “List-Generator” is located on your local computer

-  Once you are inside the “List-Generator” directory, type: `javac app.java`. If you do not get any message after typing the 

-  Type `java app`. You will be asked enter the student and project CSV roster. (You need to type the name of the csv file with the “.csv” extension)

- Enter the year (Ex. 2019)

- Enter the month (Ex. 01)

- Enter the semester (Ex. Spring)

- Enter the course as abbreviation (Ex. Capstone = CAP)

- You will then be asked what you would like to do. Currently, the application can only generate team agreements, so enter “1”. 

- The output will be stored in the “List-Generator” folder

#Troubleshooting
If you are having issues follow these steps.

##This program requires the latest version of Java. Follow these steps to reinstall

- Uninstall previous versions of Java 
   - `sudo rm -fr /Library/Internet\ Plug-Ins/JavaAppletPlugin.plugin `
   - `sudo rm -fr /Library/PreferencePanes/JavaControlPanel.prefPane `
   - `sudo rm -fr ~/Library/Application\ Support/Oracle/Java`

- To check if uninstallation happened successfully
  - `java -version`

- Download and install the JDK: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
   - Check if the JRE and JDK are the same versions using `java -version `
 
- If problems persist try to remove any bad class files (./Team_Agreement.class), we might have to delete. 
  - `rm -rf *.class`

