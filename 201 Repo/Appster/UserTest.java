import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testUser() {
		User test = new User("username", "password");
		assertEquals(test.getUserName(), "username");
		assertEquals(test.getUserPassword(), "password");
		User test2 = new User("user", "pass");
		assertEquals(test2.getUserName(), "user");
		assertEquals(test2.getUserPassword(), "pass");
		assertEquals(test.getUserName(), "username");
		assertEquals(test.getUserPassword(), "password");
		
	}

	@Test
	public void testAuthenticate() {
		User test = new User("username", "password");
		User test2 = new User("user", "pass");
		assertTrue(test.authenticate("username", "password"));
		assertFalse(test.authenticate("user", "pass"));
		assertFalse(test.authenticate("user", "password"));
		assertFalse(test.authenticate("username", "pass"));
		assertTrue(test2.authenticate("user", "pass"));
	}

	@Test
	public void testGetUserName() {
		User test = new User("username", "password");
		assertEquals(test.getUserName(), "username");
		User test2 = new User("user", "pass");
		assertEquals(test2.getUserName(), "user");
		assertEquals(test.getUserName(), "username");
		
	}

	@Test
	public void testSetUserName() {
		User test = new User("username", "password");
		User test2 = new User("user", "pass");
		test.setUserName("new");
		assertEquals(test.getUserName(), "new");
		assertEquals(test2.getUserName(), "user");
		test2.setUserName("different");
		assertEquals(test.getUserName(), "new");
		assertEquals(test2.getUserName(), "different");
	}

	@Test
	public void testGetUserPassword() {
		User test = new User("username", "password");
		assertEquals(test.getUserPassword(), "password");
		User test2 = new User("user", "pass");
		assertEquals(test2.getUserPassword(), "pass");
		assertEquals(test.getUserPassword(), "password");
	}

	@Test
	public void testSetUserPassword() {
		User test = new User("username", "password");
		User test2 = new User("user", "pass");
		test.setUserPassword("new");
		assertEquals(test.getUserPassword(), "new");
		assertEquals(test2.getUserPassword(), "pass");
		test2.setUserPassword("different");
		assertEquals(test.getUserPassword(), "new");
		assertEquals(test2.getUserPassword(), "different");
	}

}
