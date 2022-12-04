import java.time.LocalDate;

public class Administrator extends Staff{
	private String jobTitle;
	//-------------------------------------------------------------------------------------------------
	
	//Needed Constructors
	public Administrator(int memberId, String name, String mobileNo, String nationality, String gender,
			LocalDate hireDate, double salary, String jobTitle) {
		super(memberId, name, mobileNo, nationality, gender, hireDate, salary);
		this.jobTitle = jobTitle;
	}
	
	//-------------------------------------------------------------------------------------------------
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	
}
