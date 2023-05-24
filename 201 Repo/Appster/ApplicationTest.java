import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ApplicationTest {

	@Test
	public final void testApplication() {
		Application app = new Application();
		assertEquals(app.name, "No name inputted");
		assertEquals(app.price, "No Price entered");
		assertEquals(app.version, "No version number");
		assertEquals(app.description, "No Description");
		assertEquals(app.downloads, 0);
		assertEquals(app.link, "No Link");
	}


	@Test
	public final void testApplication2() {
		Application app = new Application("APP", "Do app things", "Appster", "CSE", "v1.0", "game", 
				"free", "www.internet.com", 50, 3.5);
		assertEquals(app.name, "APP");
		assertEquals(app.description, "Do app things");
		assertEquals(app.Organization, "Appster");
		assertEquals(app.Platform, "CSE");
		assertEquals(app.version, "v1.0");
		assertEquals(app.type, "game");
		assertEquals(app.price, "free");
		assertEquals(app.link, "www.internet.com");
		assertEquals(app.downloads, 50);
	}

	@Test
	public final void testSortName() {
		Application app1 = new Application();
		app1.name = "B";
		Application app2 = new Application();
		app2.name = "C";
		Application app3 = new Application();
		app3.name = "A";
		
		ArrayList<Application> list = new ArrayList<>();
		list.add(app1); list.add(app3); list.add(app2);
		
		Application.sortName(list);
		
		assertEquals("A", list.get(0).name);
		assertEquals("B", list.get(1).name);
		assertEquals("C", list.get(2).name);
	}

	@Test
	public final void testSortRating() {
		Application app1 = new Application();
		app1.rating=2.1;
		Application app2 = new Application();
		app2.rating=4.6;
		Application app3 = new Application();
		app3.rating=1.1;
		
		ArrayList<Application> list = new ArrayList<>();
		list.add(app1); list.add(app3); list.add(app2);
		
		Application.sortRating(list);
		
		assertTrue(1.1 == list.get(0).rating);
		assertTrue(2.1 == list.get(1).rating);
		assertTrue(4.6 == list.get(2).rating);
	}

	@Test
	public final void testSortDownloads() {
		Application app1 = new Application();
		app1.downloads=50;
		Application app2 = new Application();
		app2.downloads=30;
		Application app3 = new Application();
		app3.downloads=75;
		
		ArrayList<Application> list = new ArrayList<>();
		list.add(app1); list.add(app3); list.add(app2);
		
		Application.sortDownloads(list);
		
		assertEquals(30, list.get(0).downloads);
		assertEquals(50, list.get(1).downloads);
		assertEquals(75, list.get(2).downloads);
	}

}
