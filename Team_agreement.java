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
  public Project_data Project;
  public Student_data[] Student;
  public Team_agreement(Student_data student_roster[], Project_data project_roster){
    Project=new Project_data(project_roster);
    Student=new Student_data[student_roster.length];
    int i=0;
    while(student_roster[i]!=null){
      Student[i]=new Student_data(student_roster[i]);
      i++;
    }
  }
}
