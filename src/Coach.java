import java.time.LocalDate;

public class Coach extends Staff{
	//Instance variables
	private String speciality;
	private double overTime;
	//-------------------------------------------------------------------------------------------------

	//Needed Constructors
	public Coach(int memberId, String name, String mobileNo, String nationality, String gender,
			LocalDate hireDate, double salary, String speciality, double overTime) {
		super(memberId, name, mobileNo, nationality, gender, hireDate, salary);
		this.speciality = speciality;
		this.overTime = overTime;
	}
	
	//-------------------------------------------------------------------------------------------------


	//Setters
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public void setOverTime(double overTime) {
		this.overTime = overTime;
	}
	//-------------------------------------------------------------------------------------------------

	//Getters
	public double getOverTime() {
		return overTime;
	}
	public String getSpeciality() {
		return speciality;
	}
	//-------------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		return super.toString()+", Speciality: " + speciality + ", OverTime: " + overTime + "\n";
	}

	


}
