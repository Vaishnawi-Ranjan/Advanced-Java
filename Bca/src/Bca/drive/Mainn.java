package Bca.drive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import Bca.model.Student;

public class Mainn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//1. load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_db","root","vaishnawi@123");
		
	    Scanner sc = new Scanner(System.in);
		Student student = new Student();
	
		
		while(true) {
			menu();
			int choice = sc.nextInt();
			switch(choice) {
			case 1: student.addStudent(con, sc);
				break;
				
			case 2: student.displayStudents(con);
				break;
				
			case 3: student.updateStudentName(con, sc);
				break;
				
			case 4: student.deleteStudent(con, sc);
				break;
				
			case 5:
				System.out.println("Exit the Application! Thank You");
				System.exit(0);
			default:
				System.out.println("Invalid Choice!!");
			}
		}
		
	}
	
	public static void menu() {
		System.out.println("------------Menu-----------");
		System.out.println("1. Add New Student");
		System.out.println("2. Display All Students");
		System.out.println("3. Update Name of Student");
		System.out.println("4. Delete a Student");
		System.out.println("5. Exit");
		System.out.println("Your Choice...");
	}

}