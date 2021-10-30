package registration;

import enums.Building;
import enums.Quarter;
import person.Faculty;

/**
 * The Section class holds information about a course section.
 * 
 * For example, CPSC 5011-01: Object-Oriented Concepts
 * - course: CPSC 5011
 * - section: 02
 * - instructor: Sheila Oh
 * - quarter/year: FQ18
 * - capacity: 30
 * - building/room: LEML 122
 * 
 * @author 
 */
public class Section {	
	
	/**
	 * 
	 * @param course	 The course associated with the section
	 * @param section	 The section number for the course
	 * @param instructor The faculty instructor teaching the course
	 * @param quarter	 The quarter that the course section is held 
	 * @param year		 The year that the course section is held
	 * @param cap		 The capacity of the course section
	 * @param bldg		 The building that the course section is held
	 * @param room		 The room that the course section is held
	 */
	public Section(Course course, int section, Faculty instructor, Quarter quarter, 
					int year, int cap, Building bldg, int room) {
		
		this.course = course;
		this.section = section;
		this.instructor = instructor;
		this.quarter = quarter;
		this.year = year;
		this.cap = cap;
		this.bldg = bldg;
		this.room = room;
		
	}

	public Course getCourse() {
		return this.course;
	}
	
	public int getSection() {
		return this.section;
	}
	
	public Faculty getInstructor() {
		return this.instructor;
	}
	
	public Quarter getQuarter() {
		return this.quarter;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getCapacity() {
		return this.cap;
	}
	
	public Building getBuilding() {
		return this.bldg;
	}
	
	public int getRoom() {
		return this.room;
	}
	

	public String toString() {
		return String.format("%-10s %-10s %-10s %-15s %-15s %-1s",
				course.getCode() + " " + course.getCourseNum(), section, instructor.getLastName(),
				quarter.toString() + " " + year, cap, bldg.toString() + room) + "\n";
	}
	
	// course, section, instructor, quarter/year, capacity, building, room 
	private Course course;
	private int section,year,cap, room;
	Faculty instructor;
	Quarter quarter;
	Building bldg;

}
