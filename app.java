import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.PrintWriter;
public class app{
      public static Team_agreement matcher(String value, Student_data student[], Project_data project){
    			if(project!=null){
    				int j=0;
    				int k=0;
    				Student_data updated_student[]=new Student_data[student.length];
    				while(student[k]!=null){
    					if(project.get_number().equals(student[k].get_Team())){
    						if(student[k].get_agree().equals(value)){
    							updated_student[j]=new Student_data(student[k]);
    							j++;
    						}
    					}
    					k++;
    				}
    				if(updated_student[0]!=null){
    					Team_agreement data=new Team_agreement(updated_student,project);
    					return data;
    				}
    			}
    			return null;
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
    		String project_id="";
    		String organization="";
    		String primary_first_name="";
    		String primary_last_name="";
    		String primary_email="";
    		int project_length=0;
    		int student_length=0;
    		int i=0;
    		String choice_value="";
    		Student_data student_list[] = new Student_data[1000];
    		Project_data project_list[] = new Project_data[1000];
    		Scanner input = new Scanner(System.in);

    		data_CSV="data/"+JOptionPane.showInputDialog(null,"Welcome to List Generator!\nPlease input your Student Roster");
				if(data_CSV.equals("data/"+null)){
					System.exit(0);
				}
    		project_CSV="data/"+JOptionPane.showInputDialog(null,"Please input your Project Roster");
				if(project_CSV.equals("data/"+null)){
					System.exit(0);
				}
    		String year=JOptionPane.showInputDialog(null,"Please enter the year");
				if(year==null){
					System.exit(0);
				}
    		String month=JOptionPane.showInputDialog(null,"Please enter the month");
				if(month==null){
					System.exit(0);
				}
    		String semester=JOptionPane.showInputDialog(null,"Please enter the semester");
				if(semester==null){
					System.exit(0);
				}
    		String abb=JOptionPane.showInputDialog(null,"Please enter the class abbreviation");
				if(abb==null){
					System.exit(0);
				}

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
    					 	project_id=st.nextToken();
    					}
    					if(tokenNumber==2){
    						number=st.nextToken();
    					}
    					if(tokenNumber==3){
    						organization=st.nextToken();
    					}
    					if(tokenNumber==4){
    						title=st.nextToken();
    					}
    					if(tokenNumber==5){
    						primary_first_name=st.nextToken();
    					}
    					if(tokenNumber==6){
    						primary_last_name=st.nextToken();
    					}
    					if(tokenNumber==7){
    						primary_email=st.nextToken();
    					}
    				}
    				project_list[i] = new Project_data(project_id,number,organization,title, primary_first_name, primary_last_name, primary_email);
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
				int choice=Integer.parseInt(JOptionPane.showInputDialog(null,"What would you like to do?\n1. Generate PDF of Student Agreements\n2. Generate list of students who have not agreed to the Student Agreement\n3. Generate list of students who have partially completed the Student registration\n4. Generate list of students who have not done the Student registration form\nPlease enter the appropriate input:"));
				if(year==null){
					System.exit(0);
				}
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
    		 int c=0;
    		 for(int a=0; a<final_output.length;a++){
    			 final_output[c]=matcher(choice_value,student_list,project_list[a]);
    			 if(final_output[c]!=null){
    				 c++;
    			 }
    		 }
    		 for(int b=0;b<final_output.length;b++){
    			 if(final_output[b]!=null){
    				 String fileName = year+"-"+month+"-"+semester+"-"+abb+"-StudentAgreements-Team"+final_output[b].Project.get_number()+"-"+final_output[b].Project.get_organization()+"-"+final_output[b].Project.get_project_id()+".htm";
    				 try{
    					 i = 0;

    					 PrintWriter outputStream = new PrintWriter(fileName);
    					 outputStream.println("<!DOCTYPE html>\n<html>");
    					 outputStream.println("<p> Dear " +final_output[b].Project.get_primary_first_name()+",</p>");
    					 outputStream.println("<p> These <b>students digitally signed the IP+NDA agreement</b> 'UC Merced Innovate to Grow Program - Student Registration and Agreement' with UC Merced ID credentials:</p>");
    					 outputStream.println("<table style=\"text-align:left;width:100%\">\n<tr>\n<th>Timestamp</th>\n<th>First Name</th>\n<th>Last Name</th>\n<th>Email</th>\n</tr>");

    					 while(final_output[b].Student[i] != null){
    					 			outputStream.println("<tr>\n<td>"+final_output[b].Student[i].get_Time()+"</td>\n<td>"+final_output[b].Student[i].get_first_name()+"</td>\n<td>"+final_output[b].Student[i].get_last_name()+"</td>\n<td>"+final_output[b].Student[i].get_email_id()+"</td>\n</tr>");
    					 			i++;
    					 }

    					 outputStream.println("</table>");

    					 outputStream.println("<p> to <b>participate in your project</b>: </p>");

    					 outputStream.println("<table style=\"text-align:left;width:100%\">");
    					 outputStream.println("<tr>\n<td>Project ID:</th>\n<td>"+final_output[b].Project.get_project_id()+"</th>\n</tr>");
    					 outputStream.println("<tr>\n<td>Project Title:</th>\n<td>"+final_output[b].Project.get_title()+"</th>\n</tr>");
    					 outputStream.println("<tr>\n<td>Team #:</th>\n<td>"+final_output[b].Project.get_number()+"</th>\n</tr>");
    					 outputStream.println("<tr>\n<td>Organization:</th>\n<td>"+final_output[b].Project.get_organization()+"</th>\n</tr>");
    					 outputStream.println("<tr>\n<td>Primary Contact First Name:</th>\n<td>"+final_output[b].Project.get_primary_first_name()+"</th>\n</tr>");
    					 outputStream.println("<tr>\n<td>Primary Contact Last Name:</th>\n<td>"+final_output[b].Project.get_primary_last_name()+"</th>\n</tr>");
    					 outputStream.println("<tr>\n<td>Primary Contact Email:</th>\n<td>"+final_output[b].Project.get_primary_email()+"</th>\n</tr>");
    					 outputStream.println("</table>");

    					 outputStream.println("<p><b>We have a digital record and timestamp of their agreement:</b> the table above includes their credentials and time of acceptance. <b>For your reference </b>this is the <a href=\"https://docs.google.com/document/d/1aj17d_u5Fir1_Q3TaTISZKyXnwN_JJkqdOux-TC_4ks/edit\">language of the agreement</a> that the students digitally signed.</p>");

    					 outputStream.println("<p>Thank you for your participation in the Innovate to Grow program.  Please let us know if you have any questions, or special circumstances to address.</p>");

    					 outputStream.println("<p>Stefano Foresti<br/>+1-801-971-3680<br/>Stefano.Foresti@UCMerced.edu<br/>");
    					 outputStream.println("<p>University of California Merced, Director of Innovation -> engineering.ucmerced.edu<p>");

    					 outputStream.close();
    						//for .txt output

    						// outputStream.println("Dear"+" "+final_output[b].Project.get_primary_first_name()+",");
    						// outputStream.println("These students digitally signed the IP+NDA agreement 'UC Merced Innovate to Grow Program - Student Registration and Agreement' with UC Merced ID credentials:\n");
    						//
    						// outputStream.println(String.format("%30s %20s %20s %30s", "Timestamp", "First Name", "Last Name", "Email"));
    						// //outputStream.println(String.format("%s", "_______________________________________________________________________________________________________"));
    						//
    						// while(final_output[b].Student[i] != null){
    						// 			outputStream.println(String.format("%30s %20s %20s %30s", final_output[b].Student[i].get_Time(),final_output[b].Student[i].get_first_name(), final_output[b].Student[i].get_last_name(), final_output[b].Student[i].get_email_id()));
    						// 			i++;
    						// }
    						//
    						// outputStream.println("\nto participate in your project:\n");
    						// outputStream.println(String.format("%30s %50s","Project ID:", final_output[b].Project.get_project_id()));
    						// outputStream.println(String.format("%30s %50s","Project Title:", final_output[b].Project.get_title()));
    						// outputStream.println(String.format("%30s %50s","Team #:", final_output[b].Project.get_number()));
    						// outputStream.println(String.format("%30s %50s","Organization:", final_output[b].Project.get_organization()));
    						// outputStream.println(String.format("%30s %50s","Primary Contact First Name:", final_output[b].Project.get_primary_first_name()));
    						// outputStream.println(String.format("%30s %50s","Primary Contact Last Name:", final_output[b].Project.get_primary_last_name()));
    						// outputStream.println(String.format("%30s %50s","Primary Contact Email:", final_output[b].Project.get_primary_email()));
    						//
    						// outputStream.println("\nWe have a digital record and timestamp of their agreement: the table above includes their credentials and time of acceptance. For your reference this is the language of the agreement that the students digitally signed:\n");
    						// outputStream.println("https://docs.google.com/document/d/1aj17d_u5Fir1_Q3TaTISZKyXnwN_JJkqdOux-TC_4ks/\n");
    						// outputStream.println("Thank you for your participation in the Innovate to Grow program.  Please let us know if you have any questions, or special circumstances to address.\n");
    						// outputStream.println("Stefano Foresti\n+1-801-971-3680\nStefano.Foresti@UCMerced.edu\n");
    						// outputStream.println("University of California Merced, Director of Innovation -> engineering.ucmerced.edu");
    		        // outputStream.close();
    		     }
    		     catch(FileNotFoundException e){
    		       e.printStackTrace();
    		     }
    			 }
    		 }
				 JOptionPane.showMessageDialog(null, "Success!");
				 System.exit(0);
    	}
}
