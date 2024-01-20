package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;

/**
 * A roster of students
 */
public class StudentRoster {

	// ADD INSTANCE VARIABLES HERE
	HashSet<Student> students;

	/**
	 * creates a StudentRoster object based on the given file
	 * 
	 * @param rosterFileName	filename of roster
	 */
	public StudentRoster(String rosterFileName) {
		this.students = loadStudents(rosterFileName);
	}

	private HashSet<Student> loadStudents(String fileName){
		HashSet<Student> students = new HashSet<Student>();
		try(Scanner in = new Scanner(new File(fileName))){
			while(in.hasNextLine()){
				String[] fields = in.nextLine().split(";");
				students.add(new Student(fields));//special constructor invoke
			}
		} catch (FileNotFoundException e){
			System.out.println(String.format("File:[%s] not found",fileName));
		}
		return students;
	}
	/**
	 * Returns the total amount of tuition paid for the given course
	 * 
	 * @param course	name of course
	 * 
	 * @return	total tuition paid for the given course
	 */
	public double getCourseTotalTuition(String course) {
		double totalTuition = 0.0;
		for(Object s : students.toArray()){
			Student this_student = (Student)s;
			if(this_student.getCourse().equals(course)){
				totalTuition += this_student.getTuition();
			}
		}
		return totalTuition;
	}
	
	
	/**
	 * Returns the total number of students in the given course
	 * 
	 * @param course	name of course
	 * 
	 * @return	total number of students in the given course
	 */
	public int getNumStudentsInCourse(String course) {
		int counter = 0;
		for(Object s : students.toArray()){
			Student this_student = (Student)s;
			if(this_student.getCourse().equals(course)){
				counter++;
			}
		}
		return counter;
	}
}
