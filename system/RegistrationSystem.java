package system;

import java.util.ArrayList;
import java.util.List;
import enums.Building;
import enums.FacultyType;
import enums.Quarter;
import enums.StudentProgram;
import enums.StudentType;
import enums.SubjectCode;
import exception.CourseNotFoundException;
import exception.DuplicateCourseException;
import exception.DuplicatePersonException;
import exception.DuplicateSubjectException;
import exception.PersonNotFoundException;
import javafx.util.Pair;
import person.Faculty;
import person.Student;
import registration.Course;
import registration.Section;
/**
 * The RegistrationSystem class stores information about the school, including
 * the ability to add students, add faculty, add courses, and add prerequisite(s).
 * 
 * @author ohsh
 */
public class RegistrationSystem {

	
	/**
	 * 
	 */
	public RegistrationSystem() { 
		studentList = new ArrayList<>();
		facultyList = new ArrayList<>();
		subjectList = new ArrayList<>();
		courseList = new ArrayList<>();
		sectionList = new ArrayList<>();
	}
	
	/**
	 * Add a student to the student list collection.
	 * 
	 * @param firstName	The first name of the student
	 * @param lastName	The last name of the student
	 * @param type		The student type
	 * @param program	The student program	
	 * @param quarter	The start quarter of the student
	 * @param year		The start year of the student
	 * @throws existPersonException The person is already in the system
	 */
	public void addStudent(String firstName, String lastName, 
							StudentType type, StudentProgram program,
							Quarter quarter, int year) 
							throws DuplicatePersonException {
		
		//throw exist exception
		if(existStudent(firstName,lastName) == true) throw 
		new DuplicatePersonException();

		Student newStudent = new Student(firstName, lastName);
		newStudent.setStatus(type);
		newStudent.setProgram(program);
		newStudent.setQuarter(quarter);
		newStudent.setYear(year);
		studentList.add(newStudent);
		
		//added message
		//System.out.println("new student " + firstName + " " + lastName + " added");
	}
	
	/**
	 * Add a faculty to the faculty list collection.
	 * 
	 * @param firstName	The first name of the faculty
	 * @param lastName	The last name of the faculty
	 * @param type		The faculty type
	 * @param bldg		The building of the faculty office
	 * @param room		The (building) room of the faculty office
	 * @param email		The email of the faculty
	 * @throws existPersonException The person is already in the system
	 */
	public void addFaculty(String firstName, String lastName,
							FacultyType type, Building bldg, int room, String email) 
							throws DuplicatePersonException {	
	
		//throw exist exception
		if(existFaculty(firstName,lastName) == true) throw 
		new DuplicatePersonException();

		Faculty newFaculty = new Faculty(firstName, lastName);
		newFaculty.setType(type);
		newFaculty.setBuilding(bldg);
		newFaculty.setRoom(room);
		newFaculty.setEmail(email);
		facultyList.add(newFaculty);
		
		//add message test
		//System.out.println("new faculty " + firstName + " " + lastName + " added");

	}
	
	/**
	 * Adds a subject to the subject list collection.
	 * (hint: use a Pair instead of creating a class)
	 * 
	 * @param code	The subject code
	 * @param desc	The subject description
	 * 
	 * @throws existSubjectException The subject is already in the system
	 */
	public void addSubject(SubjectCode code, String desc) 
							throws DuplicateSubjectException {
		
		//throw exist exception
		if(existSubject(code) == true) throw 
		new DuplicateSubjectException();
		Pair<SubjectCode, String> subject = new Pair<SubjectCode, String>(code, desc);
		subjectList.add(subject);
		//added message
		//System.out.println("new subject " + code + " " + desc + " added");
	}
	
	/**
	 * Adds a course to the course list collection.
	 * 
	 * @param code		The subject code of the course
	 * @param num		The course number of the course
	 * @param name		The course name
	 * @param creditNum	The number of the credits of the course
	 * @throws existCourseException	The course is already in the system 
	 */
	public void addCourse(SubjectCode code, int num, String name, 
							int creditNum) throws DuplicateCourseException {
		if(existCourse(code, num) == true) throw 
		new DuplicateCourseException();
		
		Course course = new Course(code, num, name, creditNum);
		courseList.add(course);
		//added message
		//System.out.println("new Course " + code + " " + num + " "+ name + " added");
	}
	
	/**
	 * Adds a prerequisite to an existing course in the course
	 * list collection.
	 * 
	 * @param code			The subject code of the course
	 * @param num			The course number of the course
	 * @param prereqCode	The subject code of the prerequisite
	 * 						to add to the course
	 * @param prereqNum		The course number of the prerequisite
	 * 						to add to the course
	 * @throws CourseNotFoundException The course was not found in the system
	 */
	public void addPrerequisite(SubjectCode code, int num, 
							SubjectCode prereqCode, int prereqNum) 
							throws CourseNotFoundException {
		if(findCourse(code, num) == null) throw new CourseNotFoundException();
		if(findCourse(prereqCode, prereqNum) == null) throw new CourseNotFoundException();
		Course course = findCourse(code, num);
		Course prereq = findCourse(prereqCode, prereqNum);
		course.setPrerequisite(prereq);
		//added message
		//System.out.println("new Prerequisitie " + prereqCode + " " + prereqNum 
		//		+ " was added to " + code + " " + num);
	}
	
	
	
	/**
	 * Adds a section to the section list collection.
	 * 
	 * @param code		 The subject code of the course
	 * @param courseNum	 The course number of the course
	 * @param sectionNum The section number for the course
	 * @param facultyLN	 The last name for the faculty teaching the course
	 * @param quarter	 The quarter that the course section is held 
	 * @param year		 The year that the course section is held
	 * @param cap		 The capacity of the course section
	 * @param bldg		 The building that the course section is held
	 * @param room		 The room that the course section is held
	 * @throws CourseNotFoundException The course was not found in the system
	 * @throws PersonNotFoundException The person was not found in the system
	 */
	public void addSection(SubjectCode code, int courseNum, int sectionNum,
							String lastName, Quarter quarter, int year, 
							int cap, Building bldg, int room) 
							throws CourseNotFoundException, PersonNotFoundException {

		if(findCourse(code, courseNum) == null) throw new CourseNotFoundException();
		if(findFaculty(lastName) == null) throw new PersonNotFoundException();
		Course course = findCourse(code, courseNum);
		Faculty instructor = findFaculty(lastName);
		Section newSection = new Section(course, sectionNum, instructor, quarter, 
				year, cap, bldg, room);
		sectionList.add(newSection);
	
		//added message
		//System.out.println(code + " " + courseNum + " has section " + sectionNum);
	}
	
	// student list, faculty list, subject list, course list, section list
	// note that there is not list for prerequisites - these should be included 
	// as part of the course list
	private List<Student> studentList;
	private List<Faculty> facultyList;
	private List<Pair<SubjectCode, String>> subjectList;
	private List<Course> courseList;
	private List<Section> sectionList;
	
	private boolean existStudent(String firstName, String lastName) {
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getLastName().equals(lastName) ) {
				if(studentList.get(i).getFirstName().equals(firstName))
					return true;
			}
		}
		return false;
	}
	
	
	
	private boolean existFaculty(String firstName, String lastName) {
		for(int i = 0; i < facultyList.size(); i++) {
			if(facultyList.get(i).getLastName().equals(lastName)) {
				if(facultyList.get(i).getFirstName().equals(lastName))
					return true;
			}
		}
		return false;
	}
	
	private boolean existSubject(SubjectCode s) {
		for(int i = 0; i < subjectList.size(); i++) {
			if(subjectList.get(i).equals(s)) {
					return true;
			}
		}
		return false;
	}
	
	private boolean existCourse(SubjectCode c, int n) {
		for(int i = 0; i < courseList.size(); i++) {
			if(courseList.get(i).getCode().equals(c) ) {
				if(courseList.get(i).getCourseNum() == n)
					return true;
			}
		}
		return false;
	}
	
	private Course findCourse(SubjectCode c, int n) {
		for(int i = 0; i < courseList.size(); i++) {
			if(courseList.get(i).getCode().equals(c) ) {
				if(courseList.get(i).getCourseNum() == n)
					return courseList.get(i);
			}
		}return null;
	}
	
	private Faculty findFaculty(String lastname) {
		for(int i = 0; i < facultyList.size(); i++) {
			if(facultyList.get(i).getLastName().equals(lastname) ) {
				return facultyList.get(i);
			}
		}return null;
	}
	
	public List<?> returnList(String s){
		if(s.equals("faculty")) return facultyList;
		if(s.equals("student")) return studentList;
		if(s.equals("subject")) return subjectList;
		if(s.equals("course")) return courseList;
		if(s.equals("section")) return sectionList;
		else return null;
	}
}
	