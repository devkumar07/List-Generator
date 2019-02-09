public class Project_data{
  private String project_id;
  private String number;
  private String organization;
  private String title;
  public Project_data(String title, String number, String project_id, String organization){
    this.project_id=project_id;
    this.number=number;
    this.organization=organization;
    this.title=title;
  }
  public String get_title(){
    return title;
  }
  public String get_number(){
    return number;
  }
  public String get_project_id(){
    return project_id;
  }
  public String get_organization(){
    return organization;
  }
  public String output_project(){
    return "Title:" +title+ "; Number:" +number;
  }
}
