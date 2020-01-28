package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import exception.IncorrectNameStudentException;

public class Student {

	private String firstName;
	private String lastName;
	private Integer gradeYear;
	private Integer studentId;
	private List<String> courses = new ArrayList<>();
	private Integer tuitionBalance = 0;
	static final Integer costOfCourse = 600;
	
	public Student(){
	}

	public void setFirstName() throws IncorrectNameStudentException {
		System.out.println("Enter student first name: ");
		this.firstName = createNameForStudent();
	}



	public void setLastName() throws IncorrectNameStudentException{
		System.out.println("Enter student last name: ");
		this.lastName = createNameForStudent();
	}
	
	public void setGradeYear() {
		System.out.println("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level: ");
		Scanner in = new Scanner(System.in);
		int selectedNumber = in.nextInt();
		this.gradeYear = selectedNumber;
	}
	
	public void setStudentId() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<9999; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        this.studentId = list.get(0);
	}



	private String createNameForStudent() throws IncorrectNameStudentException {
		try {
			Scanner in = new Scanner(System.in);
			String name = in.nextLine();
			boolean firstNameOfStudentIsOk = verifyName(name);
			if(firstNameOfStudentIsOk) {
				return name;
			} else {
				throw new IncorrectNameStudentException("Incorrect name for student");
			}
		} finally {
			
		}
	}
	
	private boolean verifyName(String firstName) {
		char[] characters = firstName.toCharArray();
		int numberOfCapitalLetters = 0 ;
		for (char c : characters) {
			if(!Character.isLetter(c)) {
				return false;
			}
			if(Character.isUpperCase(c)) {
				numberOfCapitalLetters++;
			}
		}
		if(numberOfCapitalLetters >= 2) {
			return false;
		}
		if(!Character.isUpperCase(characters[0])) {
			return false;
		}
		if(characters.length <= 3) {
			return false;
		}
		return true;
	}

	public void enroll() {
		System.out.println("The student's name is: " + this.getFirstName());
		while(true) {
			System.out.println("Enter course to enroll student(Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if(course.equals("Q")) {
				break;
			} else {
				courses.add(course);
				tuitionBalance = tuitionBalance + costOfCourse;
			}
		}
	}
	
	public void payTaxes() {
		if(tuitionBalance == 0) {
			System.out.println("The student has no fee to pay!");
		} else {
			System.out.println("Enter payment: ");
			Scanner in = new Scanner(System.in);
			Integer priceForTax = in.nextInt();
			tuitionBalance = tuitionBalance - priceForTax;
			System.out.println("Thank you!");
			System.out.println("This student still has to pay " + tuitionBalance + " dollars");
		}
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Student contain : firstName=" + firstName + ", lastName=" + lastName + ", gradeYear=" + gradeYear
				+ ", studentId=" + studentId + ", courses=" + courses + ", tuitionBalance=" + tuitionBalance + "";
	}
	
	
	
}
