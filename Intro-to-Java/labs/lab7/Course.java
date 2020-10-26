package lab7;

public class Course {

	private String name;
	private int credits;
	private final int capacity;
	private int takenSeats;
	private Student[] enrolledStudent;
	private int i;
	/**
	 * 
	 * @param name
	 * @param credits
	 * @param capacity
	 */
	public Course(String name, int credits, int capacity) {
		this.name = name;
		this.credits = credits;
		this.capacity = capacity;
		this.takenSeats = 0;
		this.enrolledStudent = new Student [capacity];
		this.i = 0;
	}
	/**
	 * 
	 * @return course name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * 
	 * @return course credits
	 */
	public int getCredits() {
		return this.credits;
	}
	/**
	 * 
	 * @return capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}
	/**
	 * 
	 * @return remaining seats
	 */
	public int getSeatsRemaining() {
		return this.capacity-this.takenSeats;
	}
	/**
	 * 
	 * @param student
	 * @return whether enrolled successfully
	 */
	public boolean addStudent(Student student) {
		int studentID = student.getId();
		if(this.takenSeats >= this.capacity) {
			return false;
		}
		for(int j = 0; j < this.takenSeats; ++j) {
			if(this.enrolledStudent[j].getId()== studentID) {
				return false;				
			}
		}
		this.takenSeats = this.takenSeats + 1;
		this.enrolledStudent[this.i] = student;
		++this.i;
		return true;		
	}
	/**
	 * 
	 * @return full names of the enrolled students
	 */
	public String generateRoster() {
		String enrollFullName = "";
		for(int j = 0; j < this.takenSeats; ++j) {
		  enrollFullName=enrollFullName+" "+this.enrolledStudent[j].getFullName();
		}
		return enrollFullName;
	}
	
	/**
	 * 
	 * @return Average GPA of the course
	 */
	public double calculateAverageGPA() {
		double totalGPA = 0;
		for(int j= 0; j < this.takenSeats; ++j) {
			totalGPA = totalGPA + enrolledStudent[j].calculateGradePointAverage();
		}
		return totalGPA/this.takenSeats;
	}
	/**
	 * return string
	 */
	public String toString() {
		return ""+this.name+" "+this.credits;
	}
}

