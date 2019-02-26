# List-Generator

Welcome to List-Generator!

## Setup:
In order to run the application, you need to have JDK installed in your system.

Tools needed for running the app:

Link to installing JDK: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Running the application:

Note: You should have two CSV files in the “Data” folder inside “List-Generator” before running the application. Refer to the sample format for student roster and project roster. 

- Open the "List-Generator.jar" file. Once you open, a dialog box will appear with a welcome message 

- Enter the student roster CSV file (Ex. student_roster.csv)

- Enter the project roster CSV file (Ex. project_roster.csv)

- Enter the year (Ex. 2019)

- Enter the month (Ex. 01)

- Enter the semester (Ex. Spring)

- Enter the course as abbreviation (Ex. Capstone = CAP)

- You will then be asked what you would like to do. Currently, the application can only generate team agreements, so enter “1”. 

- You will recieve a "Success!" message indicating that the list generation is completed. The output will be stored in the “List-Generator” folder

## Troubleshooting (Unix)
If you are having issues follow these steps.

### This program requires the latest version of Java. Follow these steps to reinstall

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

