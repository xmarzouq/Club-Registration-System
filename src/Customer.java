
public class Customer extends Member{
	private Type membershipType;
	private double discount;
	//TODO 
	//-------------------------------------------------------------------------------------------------
	//Needed Constructors
	
	public Customer(int memberId, String name, String mobileNo, String nationality, String gender, Type membershipType,
			double discount) {
		super(memberId, name, mobileNo, nationality, gender);
		this.membershipType = membershipType;
		this.discount = discount;
	}
	//-------------------------------------------------------------------------------------------------


	//Setters
	public void setMembershipType(Type membershipType) {
		this.membershipType = membershipType;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	//-------------------------------------------------------------------------------------------------

	//Getters
	public double getDiscount() {
		return discount;
	}
	public Type getMembershipType() {
		return membershipType;
	}
	//-------------------------------------------------------------------------------------------------
	@Override
	public String toString() {
		return "Customer :  "+ super.toString()+"MembershipType: "+ membershipType +   ", Discount: " + discount + "\n";
	}

	



}
