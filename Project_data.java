public class Project_data{
  private String title;
  private String number;
  public Project_data(String title, String number){
    this.title=title;
    this.number=number;
  }
  public String get_title(){
    return title;
  }
  public String get_number(){
    return number;
  }
  public String output_project(){
    return "Title:" +title+ "; Number:" +number;
  }
}
