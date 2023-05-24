import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {

	List<User> userList;
	
	public Login() {
		Scanner in = new Scanner(System.in);
		loadUser("users.txt");
		while (!login()) {
			System.out.println("Incorrect username or password!");
		}
	}


	private void loadUser(String string){
		userList = new ArrayList<User>();
		Scanner in;
		try {
			in = new Scanner(new File(string));
			in.nextLine();
			String username, password;
			while (in.hasNextLine()) {
				username = in.next();
				password = in.next();
				userList.add(new User(username, password));
				in.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
	public boolean login() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your username: ");
		String username = in.next();
		System.out.print("Enter your password: ");
		String password = in.next();
		return authenticate(username, password); 	
	}
	
	private boolean authenticate(String username, String password) {
		for (User u : userList) {
			if (u.authenticate(username, password)) return true;
		}
		return false;
		
	}
}
