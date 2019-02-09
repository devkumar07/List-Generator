import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.PrintWriter;
public class Team_agreement{
  private Project_data[] project;
  private Student_data[] student;
  //This method is used for testing purposes to see if the objects were storing the appropriate data.
  public String get_candidates(int a){
      return project[a].get_title()+" "+student[a].get_first_name()+" "+student[a].get_last_name()+" "+student[a].get_Team()+" "+student[a].get_Time();
  }

  public void set_student_roster(Student_data[] list){
    student=new Student_data[list.length];
    int i=0;
    while(list[i]!=null){
      student[i]=new Student_data(list[i].get_Team(),list[i].get_first_name(),list[i].get_last_name(),list[i].get_email_id(),list[i].get_agree(),list[i].get_Time());
      i++;
    }
  }
  public void set_project_roster(Project_data[] list){
    project=new Project_data[list.length];
    int i=0;
    while(list[i]!=null){
      project[i]=new Project_data(list[i].get_title(),list[i].get_number(),list[i].get_project_id(),list[i].get_organization());
      i++;
    }
  }
  public void output_roster(int index){
    String fileName = "test"+index+".txt";
    try{
      PrintWriter outputStream = new PrintWriter(fileName);
       outputStream.println();
       outputStream.close();
    }
    catch(FileNotFoundException e){
      e.printStackTrace();
    }
  }
}
