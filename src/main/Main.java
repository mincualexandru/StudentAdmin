package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entity.Student;
import exception.IncorrectNameStudentException;

public class Main {

	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<Student>();
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome!");
		int numberOfStudents = 0;
		do {
			try {
				System.out.println("\nHow many students do you want to add?");
				numberOfStudents = in.nextInt();
				for (int i = 0; i < numberOfStudents; i++) {
					int numberOfAttempts = 3;
					boolean ok = false;
					Student student = new Student();
					while(numberOfAttempts != 0 && ok == false) {
						try {
							if(student.getFirstName() == null) {
								student.setFirstName();
							}
							if(student.getLastName() == null) {
								student.setLastName();
							}
							if(student.getFirstName() != null && student.getLastName() != null) {
								student.setStudentId();
								student.setGradeYear();
								students.add(student);
								ok = true;
							}
							
						} catch (IncorrectNameStudentException e) {
							numberOfAttempts--;
							if(numberOfAttempts != 0) {
								System.out.println(e.getMessage() + "\nPlease try again\n");
							}
							if(numberOfAttempts == 0) {
								System.out.println("You have entered the wrong student's name too many times!");
							}
							continue;
						}
					}
					System.out.println("\n");
				}
			} catch (InputMismatchException e) {
				System.out.print("Invalid number of students. \n");
			}
			in.nextLine();
		} while(numberOfStudents <= 0);
		
		
		for (Student student : students) {
			System.out.println("What you want to do next for " + student.getFirstName() + " ?");
			System.out.println("\n1 - Choose courses for the student\n2 - Pay taxes\n3 - View more information\n4 - Move on\n5 - Exit");
			Scanner input = new Scanner(System.in);
			Integer choice;
			boolean ok = false;
			do {
				choice = input.nextInt();
				switch (choice) {
				case 1:
					student.enroll();
					break;
				case 2:
					student.payTaxes();
					break;
				case 3:
					System.out.println(student.toString());
					break;
				case 4:
					ok = true;
					break;
				case 5: 
					System.exit(0);
				default:
					break;
				}
				System.out.println("\n1 - Choose courses for the student\n2 - Pay taxes\n3 - View more information\n4 - Move on\n5 - Exit");
			} while(choice < 6 && ok == false);
		}
	}
}
