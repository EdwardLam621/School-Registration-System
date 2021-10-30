package person;

import enums.Building;
import enums.FacultyType;
import enums.PersonStatus;

/**
 * The Faculty class holds information about a faculty member.
 * 
 * - first name: first name of the student
 * - last name: last name of the student
 * - suid: Seattle U identification number
 * - status: the status of the faculty (see PersonStatus enum)
 * - faculty type: the type of faculty (see FacultyType enum)
 * - office: includes building (i.e. ENGR) and room number (i.e 504)
 * - email: the school (i.e. SU) email address
 * 
 * @author 
 */
public class Faculty {
	
	/**
	 * 
	 * @param firstName	The first name of the faculty
	 * @param lastName	The last name of the faculty
	 */
	public Faculty(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
	
	}
	
	public void setSUID(int id) {
		this.suid = id;
	}
	
	public void setStatus(PersonStatus s) {
		this.status = s;
	}
	
	public void setType(FacultyType t) {
		this.type = t;
	}
	
	public void setBuilding(Building b) {
		this.building = b;
	}
	
	public void setRoom(int room) {
		this.room = room;
	}
	
	public void setEmail(String e) {
		this.email = e;
	}
	
	public int getSUID() {
		return this.suid;
	}
	
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	@Override
	public String toString() {
		return String.format("%-12s %-12s %-15d %-15s %-4s %-10d %-1s",
				lastName, firstName, suid, type, building, room, email + "\n");
	}
	
	
	// first name, last name, SUID, status, faculty type, office (see building), email
	String firstName, lastName, email;
	int suid, room;
	PersonStatus status;
	FacultyType type;
	Building building;
}