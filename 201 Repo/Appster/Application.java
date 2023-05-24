
//Application class written by Scott Hutchins
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
//Could try hard coding path to file
import java.io.File;
import java.io.FileNotFoundException;

public class Application {
	// TODO Add functionality for images
	String name;
	// Image; perhaps just saving path to file, but that could cause trouble moving
	// it around
	String price;
	String version;
	String description;
	String Organization;
	String Platform;
	String type;
	double rating;
	int downloads;
	String link;
	ArrayList<String> comments;
	ArrayList<String> requests;

	// Default constructor
	public Application() {
		this.name = "No name inputted";
		this.price = "No Price entered";
		this.version = "No version number";
		this.description = "No Description";
		this.rating = 0.0;
		this.downloads = 0;
		this.link = "No Link";
		this.comments = new ArrayList<>();
	}

	// TODO Full constructor after figure out all elements to app
	public Application(String name, String description, String organization, String Platform, String version,
			String type, String price, String link, int downloads, double rating) {
		this.name = name;
		this.price = price;
		this.version = version;
		this.description = description;
		this.rating = rating;
		this.downloads = downloads;
		this.link = link;
		this.Organization = organization;
		this.Platform = Platform;
		this.type = type;
		// this.comments = Comments;
	}

	// Sort function/class for sorting by the name
	public static class sortByName implements Comparator<Application> {
		public int compare(Application o1, Application o2) {
			return o1.name.compareTo(o2.name);
		}
	}

	// Calls sort method
	public static void sortName(ArrayList<Application> listofApps) {
		Collections.sort(listofApps, new sortByName());
	}

	// Sort comparator for the rating
	public static class sortByRating implements Comparator<Application> {
		public int compare(Application o1, Application o2) {
			return Double.compare(o1.rating, o2.rating);
		}
	}

	// Calls the sort method
	public static void sortRating(ArrayList<Application> listofApps) {
		Collections.sort(listofApps, new sortByRating());
	}

	// Sort comparator for sorting by downloads
	public static class sortByDownloads implements Comparator<Application> {
		public int compare(Application o1, Application o2) {
			return Integer.compare(o1.downloads, o2.downloads);
		}
	}

	// Calls the sort method/comparator
	public static void sortDownloads(ArrayList<Application> listofApps) {
		Collections.sort(listofApps, new sortByDownloads());
	}

	// Searches for apps of the same name inputed by the user
	public static ArrayList<Application> search(ArrayList<Application> listofApps, String name) {
		ArrayList<Application> filtered = new ArrayList<>();
		for (Application a : listofApps) {
			if (a.name.equals(name))
				filtered.add(a);
		}
		return filtered;

	}

	// TODO Figure out if file loads would work.
	public static ArrayList<Application> loadApps() throws FileNotFoundException {
		ArrayList<Application> apps = new ArrayList<>();
		Scanner scanner = new Scanner(new File("FixedDatabase - Application Database - Sheet1.csv"));
		while (scanner.hasNextLine()) {
			// Going through file line by line
			String temp = scanner.nextLine();
			String[] split = temp.split(",");
			// Pulling out and parseing certain data members
			int downloads = Integer.parseInt(split[9]);
			double rating = Double.parseDouble(split[10]);
			// Getting the comments
			// Creates the object
			Application quickStore= new Application(split[0],split[1],split[2],split[3],split[4],split[5],split[6],split[7],downloads,rating);
			apps.add(quickStore);
		}
		scanner.close();
		return apps;
	}

	// TODO
	public void saveComment() {
		// Stub method
	}

	// TODO
	public void appRequest() {
		// Stub method
	}

	public String toString() {
		String appData = "|" + this.name + "|" + this.Organization + "|" + this.Platform + "|" + this.version + "|"
				+ this.type + "|" + this.price + "|" +this.downloads+"|"+this.rating+"|"+ this.link +"|"+ this.description+"|";
		return appData;

	}

	public static void coolPrint(ArrayList<Application> a1) {
		String coolPadding = "|Name|Company|Platforms|Version|Category|Price|Downloads|Rating|Link|Description|";
		System.out.println(coolPadding);
		for (Application a : a1) {
			System.out.println(a.toString());
		}
		System.out.print("\n");
	}

}
