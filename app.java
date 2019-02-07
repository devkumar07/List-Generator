import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.PrintWriter;
public class app {
	public static void matcher(Team_agreement final_roster[], String value, int slength, int plength, Student_data student[], Project_data project[]){
		int j=0;
		for(int i = 0; i<plength; i++){
			if(project[i].get_number().isEmpty()){
				break;
			}
			String roster[] = new String[slength];
			for(int k = 0; k<slength; k++){
				if(student[k].get_Team().isEmpty()){
					break;
				}
				else{
					if(student[k].get_agree().equals(value)){
						if(student[k].get_Team().equals(project[i].get_number())){
							roster[j]=student[k].get_email_id();
							j++;
						}
					}
				}
			}
			j=0;
			final_roster[i]=new Team_agreement(project[i].get_title(), roster);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variable declarations
		String team = "";
		String data_CSV; //= "test_data.csv";
		String project_CSV;//= "test_project.csv";
		String firstName="";
		String lastName="";
		String email_address="";
		String Agree="";
		String Time="";
		String title="";
		String number="";
		int project_length=0;
		int student_length=0;
		int i=0;
		String choice_value="";
		Student_data student_list[] = new Student_data[1000];
		Project_data project_list[] = new Project_data[1000];
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to List generator!");
		System.out.println("Please input your Student Roster");
		data_CSV=input.nextLine();
		System.out.println("Please input your Project Roster");
		project_CSV=input.nextLine();

		//fetching data from CSV files
		try {
			BufferedReader read_student_data = new BufferedReader( new FileReader(data_CSV));
			BufferedReader read_project_data = new BufferedReader( new FileReader(project_CSV));
			String strLine = null;
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;
			while( (data_CSV = read_student_data.readLine()) != null)
			{
				lineNumber++;
				//break comma separated line using ","
				st = new StringTokenizer(data_CSV, ",");

				while(st.hasMoreTokens())
				{
					//display csv values
					tokenNumber++;
					if(tokenNumber==1){
						team=st.nextToken();
					}
					if(tokenNumber==2){
						firstName=st.nextToken();
					}
					if(tokenNumber==3){
						lastName=st.nextToken();
					}
					if(tokenNumber==4){
						email_address=st.nextToken();
					}
					if(tokenNumber==5){
						Agree=st.nextToken();
					}
					if(tokenNumber==6){
						Time=st.nextToken();
					}
				}
				student_list[i] = new Student_data(team,firstName,lastName,email_address,Agree,Time);
				//reset token number
				tokenNumber = 0;
				i++;
			}
			student_length=i;
			lineNumber=0;
			tokenNumber=0;
			i=0;
			while( (project_CSV = read_project_data.readLine()) != null)
			{
				lineNumber++;
				//break comma separated line using ","
				st = new StringTokenizer(project_CSV, ",");

				while(st.hasMoreTokens())
				{
					//display csv value
					tokenNumber++;
					if(tokenNumber==1){
					 	title	=st.nextToken();
					}
					if(tokenNumber==2){
						number=st.nextToken();
					}
				}
				project_list[i] = new Project_data(title,number);
				//reset token number
				tokenNumber = 0;
				i++;
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Program begins
		System.out.println("What would you like to do?");
		System.out.println("1. Generate PDF of Student Agreements");
		System.out.println("2. Generate list of students who have not agreed to the Student Agreement");
		System.out.println("3. Generate list of students who have partially completed the Student registratiom");
		System.out.println("4. Generate list of students who have not done the Student registration form");
		System.out.println("Please enter the appropriate input");
		int choice=input.nextInt();
		switch(choice){
			case 1:
				choice_value="1";
				break;
			case 2:
				choice_value="0";
				break;
			case 3:
				choice_value="-1";
				break;
			case 4:
				choice_value="-2";
				break;
			default:
				System.out.println("Invalid input");
				break;
		}
		project_length=i;
		 Team_agreement final_output[] = new Team_agreement[project_length];
		 matcher(final_output,choice_value,student_length,project_length,student_list,project_list);
		 System.out.println("Success");
		 /*for(int a=0;a<final_output.length;a++){
			 System.out.println(final_output[a].output_roster());
		 }*/
		 String fileName = "test.txt";
	   try{
	     PrintWriter outputStream = new PrintWriter(fileName);
			 for(int a=0;a<final_output.length;a++){
				 String result = final_output[a].output_roster();
	 			outputStream.println(result);
	 		}
			 outputStream.close();
	     System.out.println("Done!");
	   }
	   catch(FileNotFoundException e){
	     e.printStackTrace();
	   }
	}
}
