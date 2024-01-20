package labs.lab6;

/**
 * Represents a single student.
 */
public class Student {
	
	// ADD INSTANCE VARIABLES HERE
	private String name;
	private int id;
	private String course;
	private double tuition;
	private String date;

	/**
	 * Constructs a Student
	 * 
	 * @param name    student name
	 * @param id      id
	 * @param course  name of course
	 * @param tuition tuition paid
	 * @param date    date signed up for course
	 */
	public Student(String name, int id, String course, double tuition, String date) {
		this.name = name;
		this.id = id;
		this.course = course;
		this.tuition = tuition;
		this.date = date;
	}

	//construct a student object from a array of string representing its field in order of
	//name, id, course, tuition, date
	public Student(String[] fields){
		this.name = fields[0];
		this.id = Integer.valueOf(fields[1]);
		this.course = fields[2];
		this.tuition = Double.valueOf(fields[3]);
		this.date = fields[4];
	}
	
	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	
	/**
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	
	/**
	 * @return course
	 */
	public String getCourse() {
		return this.course;
	}

	
	/**
	 * @return amount of tuition paid
	 */
	public double getTuition() {
		return this.tuition;
	}

	
	/**
	 * @return date they signed up
	 */
	public String getDate() {
		return this.date;
	}
}
