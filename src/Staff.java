import java.time.LocalDate;

public class Staff extends Member{
	private LocalDate hireDate;
	private double salary;
	//-------------------------------------------------------------------------------------------------

	//Needed Constructors
	public Staff(int memberId, String name, String mobileNo, String nationality, String gender) {
		super(memberId, name, mobileNo, nationality, gender);
	}
	public Staff(int memberId, String name, String mobileNo, String nationality, String gender, LocalDate hireDate,
			double salary) {
		super(memberId, name, mobileNo, nationality, gender);
		this.hireDate = hireDate;
		this.salary = salary;
	}
	//-------------------------------------------------------------------------------------------------

	//Setters
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	//-------------------------------------------------------------------------------------------------

	//Getters
	public double getSalary() {
		return salary;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	//-------------------------------------------------------------------------------------------------




}
