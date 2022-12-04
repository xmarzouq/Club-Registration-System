
public class Member {
	private int memberId;
	private String name, mobileNo, nationality, gender;
	//-------------------------------------------------------------------------------------------------

	//Needed Constructors
	public Member(int memberId, String name, String mobileNo, String nationality, String gender) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.nationality = nationality;
		this.gender = gender;
	}
	//-------------------------------------------------------------------------------------------------


	public Member() {
	}


	//Setters
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	//-------------------------------------------------------------------------------------------------

	//Getters
	public String getName() {
		return name;
	}
	public int getMemberId() {
		return memberId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public String getNationality() {
		return nationality;
	}
	public String getGender() {
		return gender;
	}
	//-------------------------------------------------------------------------------------------------


	@Override
	public String toString() {
		return "Member  ID: " + getMemberId() + ", Name: " + getName() + ", Mobile Number:" + getMobileNo() + ", Nationality: "
				+ getNationality() + ", Gender: " + getGender() + "";
	}





}
