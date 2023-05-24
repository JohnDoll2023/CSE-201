import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunApp extends Application{
	List<Application> appList;
	List<User> userList;
	List<Administrator> adminList;
	List<Moderator> modList;
	
	public RunApp() throws FileNotFoundException {
		Login login= new Login();
			ArrayList<Application> loadedApps = loadApps();
			coolPrint(loadedApps);
			int input = 0;
			String options = "Enter your selection:\n1.)Sort by name\n2.)Sort by Rating\n3.)Sort by Downloads\n4.)Search apps\n5.)Exit";
			while (input != 5) {
				System.out.println(options);
				Scanner userIn = new Scanner(System.in);
				input = Integer.parseInt(userIn.nextLine());
				switch (input) {
				case 1:
					sortName(loadedApps);
					coolPrint(loadedApps);
					break;
				case 2:
					sortRating(loadedApps);
					coolPrint(loadedApps);
					break;
				case 3:
					sortDownloads(loadedApps);
					coolPrint(loadedApps);
					break;
				case 4:
					System.out.println("Enter app name: ");
					String nameSearch = userIn.nextLine();
					coolPrint(search(loadedApps, nameSearch));
					break;
				case 5:
					break;
				default:
					System.out.println("Please enter a valid choice");
					break;
				}
			}
	}

	public static void main(String[] args) throws FileNotFoundException {
		RunApp app = new RunApp();
	}
}
