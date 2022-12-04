import java.time.LocalDate;
import java.util.ArrayList;
/**
 * 
 * @author Nasser Alhajri
 * @author Abdullah Nagib
 * @author Abdullah Khan
 *
 */
public class Main {
	private static Club club1;
	private static Club club2;
	private static ArrayList<Member> members1;
	private static ArrayList<Member> members2;
	private static ArrayList<Session> sessions1;
	private static ArrayList<Session> sessions2;
	public static void main(String[] args) {
		members1 = new ArrayList<>();
		members2 = new ArrayList<>();
		sessions1 = new ArrayList<>();
		sessions2 = new ArrayList<>();
		createClub();
		addAdmin(club1);
		addAdmin(club2);
		createSessions(club1);
		createSessions(club2);
		createCoaches(club1);
		createMembers(club1);
		createCoaches(club2);
		createMembers(club2);
		displayCustomer(club1);
		//addMembers(club1);

		for(Session session: club2.getSessions()) {
			System.out.println(session);
		}
		System.out.println("Members for CLUB1: " + countMembers(club1));
		System.out.println("Members for CLUB2: " + countMembers(club2));
		System.out.println("Fees for each customer in CLUB1");
		displayFees(club1);
		System.out.println("Fees for each customer in CLUB2");
		displayFees(club2);
		//System.out.println(club1);



	}

	
	private static void createClub() {
		club1 = new Club("CLUB 1", "Doha", "www.club1.com", "4444 4401",members1, sessions1);
		club2 = new Club("CLUB 2", "Doha", "www.club2.com","4444 4402",members2, sessions2);
	}

	private static Club addAdmin(Club club) {
		Administrator admin1 = new Administrator(22001, "Ahmed", "77777701", "Qatari", "Male", LocalDate.now(), 7000, "Manager");
		boolean found = false;
		for(Member x: club.getMembers()) {
			if (x instanceof Administrator) {
				found = true;
				break;
			}
		} if(!found) {
			System.out.println(club.addMember(admin1));
			System.out.println("Admin Added successfully !");
		} else {
			System.err.println("This club already has an admin !");
		}
		return club;
	}
	private static Club createCoaches(Club club) {
		int id = 22002, mobile = 77777702, salary = 5000, overTime = 0;
		for(int i=0; i<3; i++) {
			Coach coach = new Coach(id, "Mohamed", Integer.toString(mobile), "Egyptian", "Male", LocalDate.now(), 
					(double) salary, "Boxing", (double) overTime); 
			id++; mobile++; salary += 100;
			System.out.println(club.addMember(coach));
			club.getSessions().get(i).setCoach(coach);
		}


		return club;
	}
	private static Club createMembers(Club club) {
		int id = 22100, mobile = 77778800;
		int j=0;
		for(int i = 0; i<13; i++) {
			Customer customer = new Customer(id++, "ALI", Integer.toString(mobile++),"Tunisian", "Male", Type.MONTHLY, 0);
			System.out.println(club.addMember(customer));
			if(i<4) {
				club.getSessions().get(0).registerCustomer((Customer)customer);
			} else if(i>=4 && i<8) {
				club.getSessions().get(1).registerCustomer((Customer)customer);
			} else if(i>=8 && i<13) {
				club.getSessions().get(2).registerCustomer((Customer)customer);
			}
		}
		return club;
	}

	private static Club createSessions(Club club) {
		int day = 1, price = 500, id=2230;
		LocalDate date= LocalDate.now();
		for(int i=0; i<3; i++) {
			Session session = new Session(id++, "Boxing", null, date.plusDays(day), date.plusDays(30),
					date.plusDays(day++), date.plusDays(30), price, new ArrayList<>());
			System.out.println(club.addSession(session));
			price += 100;
		}
		return club;
	}
	private static void displayCustomer(Club club) {
		for(Session x: club.getSessions()) {
			System.out.println("Customers in session number: " + x.getSessionId());
			for(Customer customer: x.getCustomers()) {
				System.out.println(customer);
			}
			System.out.println();
		}
	}
	private static String countMembers(Club club) {
		int customer = 0, admin = 0, coach = 0;
		for(Member member: club1.getMembers()) {
			if (member instanceof Customer) {
				customer++;
			} else if (member instanceof Coach) {
				coach++;
			} else if (member instanceof Administrator) {
				admin++;
			}
		}
		return "Club Members: \nAdmins: " + admin+ ", Coaches: " + coach + ", Customers: " + customer;
	}
	private static void displayFees(Club club) {
		for(Member member: club.getMembers()) {
			if (member instanceof Customer) {
				Customer customer = (Customer) member;
				System.out.print("Member ID: "+ customer.getMemberId());
				System.out.println(", Fees" + club.feesPerCustomer(customer.getMemberId()));
			}
		}
	}

}
