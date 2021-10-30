package system;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import enums.Building;
import enums.FacultyType;
import exception.DuplicatePersonException;


public class RegistrationSystemTest {

	@Before
	public void setUp() throws Exception {
		s = new RegistrationSystem();
	}

	@Test
	public void testRegistrationSystem() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddFaculty() throws DuplicatePersonException {
		s = new RegistrationSystem();
		s.addFaculty("Abc","DEF", FacultyType.ADJUNCT, Building.ADMN , 207, "alboe@faejf.com" );
		s.addFaculty("Abc","DEF", FacultyType.ADJUNCT, Building.ADMN , 207, "alboe@faejf.com" );
	}

	@Test
	public void testAddSubject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCourse() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddPrerequisite() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSection() {
		fail("Not yet implemented");
	}

	@Test
	public void testReturnList() {
		fail("Not yet implemented");
	}

	RegistrationSystem s;
}
