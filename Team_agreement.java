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
  private String title="";
  private String[] student;
  public Team_agreement(String project_title, String[] list){
    title=project_title;
    int i=0;
    student=new String[list.length];
    while(list[i]!=null){
      student[i]=list[i];
      i++;
    }
  }
  public void get_candidates(){
    int i=0;
    System.out.println("Testing the roster");
    while(student[i]!=null){
      System.out.println(student[i]);
      i++;
    }
  }
  public void output_roster(int index){
    String fileName = "test"+index+".txt";
    try{
      PrintWriter outputStream = new PrintWriter(fileName);
       outputStream.println("successful");
       outputStream.close();
    }
    catch(FileNotFoundException e){
      e.printStackTrace();
    }
  }
}
