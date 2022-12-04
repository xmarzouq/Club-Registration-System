import java.util.ArrayList;

public class Club {

	//Instance variables
	private String name, city, website, phone;
	private ArrayList<Member> members;
	private ArrayList<Session> sessions;
	//-------------------------------------------------------------------------------------------------	

	//Needed Constructors
	public Club(String name, String city, String website, String phone, ArrayList<Member> members,
			ArrayList<Session> sessions) {
		super();
		members = new ArrayList<>();
		sessions= new ArrayList<>();
		this.name = name;
		this.city = city;
		this.website = website;
		this.phone = phone;
		this.members = members;
		this.sessions = sessions;
	}
	//-------------------------------------------------------------------------------------------------	

	public Club() {
	}

	//Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//-------------------------------------------------------------------------------------------------

	//Getters
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public String getWebsite() {
		return website;
	}
	public String getPhone() {
		return phone;
	}
	public ArrayList<Member> getMembers() {
		return members;
	}
	public ArrayList<Session> getSessions() {
		return sessions;
	}
	//-------------------------------------------------------------------------------------------------



	/**
	 * This method to add a member to the club
	 * @param member
	 * @return String
	 */
	public String addMember(Member member) {
		String text = " ";
		if(member instanceof Administrator || member instanceof Coach || member instanceof Customer) {
			if(!members.contains(member)) {
				members.add(member);
				text = "Member is added successfully";

			} else {
				System.err.println("This member already exists !");
			}
		}

		return text;
	}
	/**
	 * this method to find a specific member
	 * @param memberId
	 * @return
	 */
	public Member findMember(int memberId) {
		boolean found = false;
		Member member = new Member();
		for(Member x: members) {
			if(x.getMemberId() == memberId) {
				found = true;
				member = x;
			}
		}
		if(!found) {
			System.err.println("No member assigned to that id !");
			return null;
		}
		return member;
	}
	/**
	 * This method to delete a member using his id
	 * @param memberId
	 * @return
	 */
	public Member deleteMember(int memberId) {
		Member member = new Member();
		boolean found = false;
		for(int i=0; i<members.size(); i++) {
			if(members.get(i).getMemberId() == memberId) {
				member = members.get(i);
				members.remove(i);
				found = true;
			}
		} if(!found) {
			System.out.println("Member not found !");
		}
		//		for(Member x: members) {
		//			if(x.getMemberId() == memberId) {
		//				member = x;
		//				found = true;
		//			}
		//		}
		//		if(found) {
		//			members.remove(member);
		//		} else {
		//			System.out.println("Member not found !");
		//		}

		return member;
	}
	/**
	 * This method to add a session to the club
	 * @param session
	 * @return
	 */
	public String addSession(Session session) {
		String text = "";
		for(Member x: members) {
			if(session.getSessionId()== x.getMemberId()) {
				text = "This session already exists !";
			} else {
				sessions.add(session);
				text = "Session added successfully";
			}
		}
		return text;
	}
	/**
	 * This method to find a specific session with the id
	 * @param sessionId
	 * @return
	 */
	public Session findSession(int sessionId) {
		boolean found = false;
		Member member = new Member();
		Session session = new Session();
		for(Session x: sessions) {
			if(x.getSessionId() == sessionId) {
				found = true;
				session = x;
			}
		}
		if(!found) {
			System.out.println("No session assigned to that id !");
			return null;
		}
		return session;
	}
	/**
	 * This method to delete a session with a specific id
	 * @param sessionId
	 * @return
	 */
	public Session deleteSession(int sessionId) {
		Session session = new Session();
		boolean found = false;
		for(int i=0; i<sessions.size(); i++) {
			if(sessions.get(i).getSessionId() == sessionId) {
				session = sessions.get(i);
				sessions.remove(i);
				found = true;
			}
		} if(!found) {
			System.out.println("Session not found !");
		}

		return session;

	}
	/**
	 * This method calculates the total profit for the club
	 * @return double 
	 */
	public double totalProfit() {
		//Staff xx = (Staff) new Member();
		double salaries = 0;
		double sessionsPrices = 0;
		for(Session x: sessions) {
			sessionsPrices += x.getPrice();
		} for(Member x: members) {
			if (x instanceof Staff) {
				//Staff staff = (Staff) x;
				salaries += ((Staff) x).getSalary();
			}
		}
		return sessionsPrices - salaries;
	}
	/**
	 * This method to calculate the fees for each customer using his id
	 * @param id
	 * @return
	 */
	public double feesPerCustomer(int id) {
		double fees = 0;
		for(Session session: sessions) {
			for(Member member: members) {
				if(member instanceof Customer) {
					if(member.getMemberId() == id)
					{
						fees+= session.getPrice() - (session.getPrice()*((Customer) member).getDiscount());
					}
				}
			}
		}
		return fees;

	}
	//-------------------------------------------------------------------------------------------------





	@Override
	public String toString() {
		return "Club [name=" + name + ", city=" + city + ", website=" + website + ", phone=" + phone + ", members="
				+ members + ", sessions=" + sessions + "]\n";
	}












}
