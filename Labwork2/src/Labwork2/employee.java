package Labwork2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class employee {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//1. load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","vaishnawi@123");
		  Scanner sc = new Scanner(System.in);
		  employee employee = new employee();
			while(true) {
				System.out.println("------------Menu-----------");
				System.out.println("1. Add New employee");
				System.out.println("2. Display All employee");
				System.out.println("3. Update Name of employee");
				System.out.println("4. Delete a employee");
				System.out.println("5. Exit");
				System.out.println("Your Choice...");
int choice = sc.nextInt();
				
				switch(choice) {
				case 1: employee.addEmployee(con, sc);
				break;
				
			case 2:employee.displayEmployee(con);
				break;
				
			case 3: employee.updateEmployeeName(con, sc);
				break;
				
			case 4: employee.deleteEmployee(con, sc);
				break;
				
			case 5:
				System.out.println("Exit the Application! Thank You");
				System.exit(0);
			default:
				System.out.println("Invalid Choice!!");
			}
		}
		
	}
	
	 public void addEmployee(Connection con, Scanner sc) throws SQLException {
			//create statement
			Statement st = con.createStatement();
			
			//read student details
			System.out.println("Enter Employee Id: ");
			int id = sc.nextInt();
			
			System.out.println("Enter Employee Name: ");
			String name = sc.next();
			
			System.out.println("Enter Employee City: ");
			String city = sc.next();
			
			
			System.out.println("Enter Employee Gender: ");
			String gender = sc.next();
			
			//create sql squery string
			String query = String.format("Insert Into employee values(%d,'%s', '%s','%s') ", id, name,city, gender);
			
			//execute sql query
			int rows = st.executeUpdate(query);
			
			System.out.println(rows + " record inserted!!!");
			
		}

	

public void displayEmployee(Connection con) throws SQLException {
	Statement st = con.createStatement();
	
	ResultSet rs = st.executeQuery("select * from employee");
	
	while(rs.next()) {
		System.out.println(rs.getInt(1)+ "\t"+rs.getString(2)+ "\t"+rs.getString(3)+ "\t"+ "\t"+rs.getString(4));
	}
}

public void updateEmployeeName(Connection con, Scanner sc) throws SQLException {
	Statement st = con.createStatement();
	System.out.println("Enter Employee ID: ");
	int id = sc.nextInt();
	System.out.println("Enter Employee New Name: ");
	String name = sc.next();
	
	String query = String.format("update Employee set name='%s' where id = %d", name, id);
	int rowsAffected = st.executeUpdate(query);
	System.out.println(rowsAffected+" recored updated!!!");

}

public void deleteEmployee(Connection con, Scanner sc) throws SQLException {
	Statement st = con.createStatement();
	System.out.println("Enter Employee ID: ");
	int id = sc.nextInt();
	
	int rowAffected = st.executeUpdate("delete from Employee where id = "+id);
	System.out.println(rowAffected + " recored deleted!!!");
}
}
