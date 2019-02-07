public class Student_data{
  private String Team;
  private String first_name;
  private String last_name;
  private String email_id;
  private String agreement;
  private String timestamp;
  public Student_data(String team, String first, String last, String email, String agree,String time){
    Team = team;
    first_name = first;
    last_name = last;
    email_id = email;
    agreement = agree;
    timestamp = time;
  }
  public String get_first_name(){
    return first_name;
  }
  public String get_last_name(){
    return last_name;
  }
  public String get_email_id(){
    return email_id;
  }
  public String get_agree(){
    return agreement;
  }
  public String get_Team(){
    return Team;
  }
  public String get_Time(){
    return timestamp;
  }
  public String output_student(){
    return "Team:"+Team+";First Name:"+first_name+"; Last Name:"+last_name+"; email:"+email_id+";Agree:"+agreement;
  }
}
