package com.sjprogramming.dao;

import java.util.Scanner;

public class Client {
	static String name;
	static String standard;
	static String clgName;
	static String city;
	static int roll;
	static int rollnum;
	static int rnum;
	static String sname;
	static String clgname;
	static String City;
	static String Standard;
	static boolean flag;
	static boolean ff;
	static boolean f;
	static boolean ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Scanner class to give console based inputs

		StudentDaoInterface dao = new StudentDao(); // Object creation
		System.out.println("Welcome to Student Management application");
		while (true) {
			System.out.println("\n|==============================================|"
					+ "\n                                                        "
					+ "\n|==============================================|" + "\n1.Add Student"
					+ "\n2.Show All Students " + "\n3.Get student based on roll number " + "\n4.Delete Student"
					+ "\n5.Update Student" + "\n6.Exit");
			System.out.println("Enter choice"); // The main interface of application.
			int ch = sc.nextInt();
			switch (ch) { // switch cases for different modules of application
			case 1:
				System.out.println("Add Student"); // case for adding the student module
				System.out.println("Enter student name");
				name = sc.next();
				System.out.println("Enter student standard");
				standard = sc.next();
				System.out.println("Enter student School or College name");
				clgName = sc.next();
				System.out.println("Enter city");
				city = sc.next();
				System.out.println("Enter Percentage");
				double percentage = sc.nextDouble();
				Student st = new Student(name, standard, clgName, city, percentage); // object creation for student
																						// along with parameters
				ans = dao.insertStudent(st);
				
				if (ans)
					System.out.println("Record inserted Successfully!!!");
				else
					System.out.println("something went wrong, please try again");

				break; // break statement takes the flow of control out of the switch statement
			case 2:
				System.out.println("Show all students "); // Case for getting all the students from the database
				dao.showAllStudent();

				break;
			case 3:
				System.out.println("Get student based on rollnumber"); // Case for getting particular student details
																		// via roll number
				System.out.println("enter roll number");
				roll = sc.nextInt();
				f = dao.showStudentById(roll); // Condition if student ID is not available in database
				if (!f)
					System.out.println("Student with this ID is not available in our system");

				break; // break statement takes the flow of control out of the switch statement
			case 4:
				System.out.println("Delete Student"); // Case for deletion of the students
				System.out.println("Enter Roll number to delete");
				
				rollnum = sc.nextInt();
				ff=dao.showStudentById(rollnum);
				if(ff) {
					ff = dao.delete(rollnum);
					System.out.println("Record deleted succesfully");
				}else {
					System.out.println("Student with this ID is not available in our system");
			}

			/*
			 * if (ff) System.out.println("Record deleted successfully...!!"); else
			 * System.out.println("Something went wrong");
			 */

				break; // break statement takes the flow of control out of the switch statement
			case 5:
				System.out.println("Update the student"); // Case for updating of the student details
				System.out.println("\n1.Update name\n2.Update School/College Name\n3.Update City\n4.Update Standard");
				System.out.println("Enter your choice");
				int choice = sc.nextInt();
				if (choice == 1) { // choices are again divided for multiple details updating.
					System.out.println("Enter roll number");
					rnum = sc.nextInt();
					System.out.println("Enter the New name"); // Student name updating
					sname = sc.next();
					Student std = new Student();
					std.setName(sname);
					flag = dao.update(rnum, sname, choice, std); // dao refers to data access object
					if (flag)
						System.out.println("Name updated successfully");
					else
						System.out.println("Something went wrong...");
				}

				else if (choice == 2) {
					System.out.println("Enter Roll number");
					rnum = sc.nextInt();
					System.out.println("Enter the New School or College Name"); // Student college name updating
					clgname = sc.next();
					Student std = new Student();
					std.setClgName(clgname);
					flag = dao.update(rnum, clgname, choice, std);
					if (flag) // flag is used to let program know that certain conditions are met.
						System.out.println("School or College Name updated successfully");
					else
						System.out.println("Something went wrong...");
				} else if (choice == 3) {
					System.out.println("Enter roll number");
					rnum = sc.nextInt();
					System.out.println("Enter the New City"); // Student city name updating
					City = sc.next();
					Student std = new Student();
					std.setCity(City);
					flag = dao.update(rnum, City, choice, std);
					if (flag)
						System.out.println("City updated successfully");
					else
						System.out.println("Something went wrong...");
				} else if (choice == 4) {
					System.out.println("Enter roll number");
					rnum = sc.nextInt();
					System.out.println("Enter the New Standard"); // Student standard updating
					Standard = sc.next();
					Student std = new Student();
					std.setStandard(Standard);
					flag = dao.update(rnum, Standard, choice, std);
					if (flag)
						System.out.println("Standard updated successfully");
					else
						System.out.println("Something went wrong...");
				}

				break; // break statement takes the flow of control out of the switch statement

			case 6:
				System.out.println("Thank You for using Student management application!!!");
				System.exit(0); // Terminates the current java running machine.
			default: // exiting the application and terminating the program.
				System.out.println("Please enter valid choice.."); // to specify the set of statements to execute if
																	// there is no case match.
			}
		}

	}
}