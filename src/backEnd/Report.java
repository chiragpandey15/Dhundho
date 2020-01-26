package backEnd;


public class Report 
{
	int id;
	String name,height,weight,desc,gender,age,loc,Photo;
	public Report() {
		
	}
	public Report(int id,String name,String height,String age,String desc,String gender,String loc,String photo) 
	{
		this.id=id;
		this.name=name;
		this.desc=desc;
		this.height=height;
		this.age=age;
		this.gender=gender;
		this.loc=loc;
		this.Photo=photo;
		
	}
	public Report(int id,String desc,String loc) 
	{
//		name="";
//		height="";
//		weight="";
//		gender="";
//		age="";
//		Photo="";
		this.id=id;
		this.loc=loc;
		this.desc=desc;
		//System.out.println("achaaaaaaaaaaaa2");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getID() {
		return id;
	}
	public void setPhoto(String photo) {
		this.Photo = photo;
	}
	public String getPhoto() {
		return Photo;
	}


	
	public void setID(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}

