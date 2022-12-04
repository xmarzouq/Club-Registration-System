import java.time.LocalDate;
import java.util.ArrayList;

public class Session {

	//Instance variables
	private int sessionId;
	private String name;
	private Coach coach;
	private LocalDate startDate, endDate, startTime, endTime;
	private double price;
	private ArrayList<Customer> customers;
	//-------------------------------------------------------------------------------------------------

	//Needed Constructors
	public Session(int sessionId, String name, Coach coach, LocalDate startDate, LocalDate endDate, LocalDate startTime,
			LocalDate endTime, double price, ArrayList<Customer> customers) {
		super();
		this.sessionId = sessionId;
		this.name = name;
		this.coach = coach;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.customers = customers;
	}
	//-------------------------------------------------------------------------------------------------

	public Session() {
	}

	//Setters
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	//-------------------------------------------------------------------------------------------------

	//Getters
	public int getSessionId() {
		return sessionId;
	}
	public String getName() {
		return name;
	}

	public Coach getCoach() {
		return coach;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public double getPrice() {
		return price;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	//-------------------------------------------------------------------------------------------------

	public String registerCustomer(Customer customer) {
		customers.add(customer);
		return "Customer added successfully";
	}

	public String unregisterCustomer(int customerId) {
		for(int i=0; i<customers.size(); i++) {
			if(customers.get(i).getMemberId() == customerId) {
				customers.remove(i);
				return "Customer is deleted successfully ";
			}
		} 
		return "No customer with that ID";


	}
	//-------------------------------------------------------------------------------------------------




	@Override
	public String toString() {
		return "Session ID: " + sessionId + ", Name: " + name + ", Coach: " + coach + " Start Date=" + startDate
				+ ", End Date: " + endDate + ", Start Time: " + startTime + ", End Time: " + endTime + ", Price:" + price
				+ ", Customers numbers: " + customers.size() + "\n";
	}












}
