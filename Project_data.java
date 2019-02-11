public class Project_data{
  private String project_id;
  private String number;
  private String organization;
  private String title;
  public Project_data(String project_id, String number, String organization, String title){
    this.project_id=project_id;
    this.number=number;
    this.organization=organization;
    this.title=title;
  }
  public Project_data(Project_data list){
    this.project_id=list.project_id;
    this.number=list.number;
    this.organization=list.organization;
    this.title=list.title;
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
