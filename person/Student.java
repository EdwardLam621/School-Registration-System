package person;

import java.util.Calendar;

import enums.Quarter;
import enums.StudentProgram;
import enums.StudentType;
import enums.StudentYear;

/**
 * The Student class holds information about a student. 
 * 
 * - first name: first name of the student
 * - last name: last name of the student
 * - suid: Seattle U identification number
 * - status: the status of the student (see PersonStatus enum)
 * - student type: a student can only be assigned a single student type
 *   (see StudentType enum)
 * - student program: a student can only be assigned to a single program at 
 *   a point of time, but can switch from one program to another (i.e. when 
 *   they've graduated from a program (see StudentProgram enum)
 * - student year: only relevant for undergraduates (see StudentYear enum)
 * - faculty advisor: students are assigned a faculty advisor, but may switch 
 *   advisors (i.e. faculty leaves or on sabbatical); may not be assigned an
 *   advisor for a period of time when first enrolled as a student
 * - start term: associated with the quarter and year a student starts a
 *   particular program; for example, a single student may start the CERT in 
 *   RQ17 and then continue the MSCS in FQ18 (see Quarter enum)
 * - email: the school (i.e. SU) email address
 * 
 * @author 
 */
public class Student {

	private StudentProgram program;
	private StudentYear year;
	private StudentType status;
	private Quarter quarter;
	private Faculty faculty;
	private String firstName, lastName, email;
	private int suid,enrollYear;
	
	/**
	 * 
	 * @param firstName	The first name of the student
	 * @param lastName	The last name of the student
	 */
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	// first name, last name, SUID, status, student type, student program, 
	// start quarter/year, faculty advisor, email
	// if undergrad, also add student year (default to freshman)
	// Note -- do not need to worry about registering students for courses;
	//         will implement this functionality during HW5
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String n) {
		this.firstName = n;
	}
	
	public void setLastName(String n) {
		this.lastName = n;
	}
	
	/**
	 * set a student's program
	 * @param p Student program
	 */
	public void setProgram(StudentProgram p) {
		this.program = p;
	}
	
	/**
	 * set a student's study year
	 * @param p student study year
 	 */
	public void setYear(int enrollYear) {
		this.enrollYear = enrollYear;
		int level = Calendar.getInstance().get(Calendar.YEAR) - enrollYear;
		if(level <= 0) this.year = StudentYear.FRESHMAN;
		else if(level == 1) this.year = StudentYear.SOPHOMORE;
		else if(level == 2) this.year = StudentYear.JUNIOR;
		else if(level >= 3) this.year = StudentYear.SENIOR;		
	}
	
	/**
	 * set a students study status
	 * @param p student current status
	 */
	public void setStatus(StudentType p) {
		this.status = p;
	}
	
	public void setSUID(int id) {
		this.suid = id;
	}
	
	/**
	 * set a student's current quarter
	 * @param p student current quarter
	 */
	public void setQuarter(Quarter p) {
		this.quarter = p;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setFaculty(Faculty f) {
		this.faculty = f;
	}
	
	public StudentProgram getProgram() {
		return program;
	}
	
	public StudentYear getYear() {
		return year;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	
	/**
	 * get student's status
	 * @return students current status;
	 */
	public StudentType getStatus() {
		return status;
	}
	
	public Quarter getQuarter() {
		return quarter;
	}
	
	public int getSUID() {
		return suid;
	}
	
	public String getEmaio() {
		return email;
	}
	
	@Override
	public String toString() {
		if(status == StudentType.NONMAT_UNDERGRAD || status == StudentType.UNDERGRAD)
		return String.format("%-12s %-12s %-15d %-18s %-15s %-10s %-10s %-8s %-1s",
				lastName, firstName, suid, status, year, program, quarter, enrollYear, email + "\n");
		else 		return String.format("%-12s %-12s %-15d %-18s %-15s %-10s %-10s %-8s %-1s",
				lastName, firstName, suid, status, " ", program, quarter, enrollYear, email + "\n");

	}
}
