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
  public String output_roster(){
    String final_output="";
    int next=0;
    final_output="Title: "+ title + " ; Students: ";
    int i=0;
    if(student[i]==null){
      final_output += "There are no data to display";
    }
    else{
      while(student[i]!=null){
        next=i+1;
        if(student[next]==null){
          final_output+=student[i];
        }
        else{
          final_output+=student[i]+",";
        }
        i++;
      }
    }
    return final_output;
  }
}
