package com.sjprogramming.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao implements StudentDaoInterface {
	Connection con;
	String query;
	PreparedStatement pst;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;

	@Override
	public boolean insertStudent(Student s) {
		boolean flag = false;
		try {
			con = DBConnection.createConnection(); // Returns a new instance of the provider's class that implements the
													// DBConnection class.

			query = "insert into student_details(sname,standard,clgname,city,percentage) value(?,?,?,?,?)"; // Insterting
																											// data
			pst = con.prepareStatement(query); // PreparedStatement object provides a feature to execute a parameterized
												// query. to return the object of PreparedStatement.
			pst.setString(1, s.getName()); // Data insertion into database
			pst.setString(2, s.getStandard());
			pst.setString(3, s.getClgName());
			pst.setString(4, s.getCity());
			pst.setDouble(5, s.getPercentage());
			pst.executeUpdate(); // execution of update    //execution of DML statement UPDATE which is return int value, count of the affected rows.
			flag = true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int roll) {
		boolean flag = false;
		try {
			con = DBConnection.createConnection(); // calling the connection
			query = "delete from student_details where rollnum=" + roll;
			pst = con.prepareStatement(query); // to return the object of PreparedStatement.
			pst.executeUpdate(); // execution of update //execution of DML statement UPDATE which is return int
									// value, count of the affected rows.

			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(int roll, String update, int ch, Student s) {
		int choice = ch; // Updation of student details
		boolean flag = false;
		try {
			if (choice == 1) {
				con = DBConnection.createConnection(); // Returns a new instance of the provider's class that implements
														// the DBConnection class.

				query = "update student_details set sname=? where rollnum=?";
				ps = con.prepareStatement(query);
				ps.setString(1, update); // updating student details based on roll number input.
				ps.setInt(2, roll);
				ps.executeUpdate(); // execution of DML statement UPDATE which is return int value, count of the
									// affected rows.
				flag = true;

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (choice == 2) {
				con = DBConnection.createConnection(); // Calling the connection
				query = "update student_details set clgname=? where rollnum=?";
				ps = con.prepareStatement(query); // to return the object of PreparedStatement.
				ps.setString(1, update);
				ps.setInt(2, roll); // updating the college name
				ps.executeUpdate(); // execution of DML statement UPDATE which is return int value, count of the
									// affected rows.
				flag = true;

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (choice == 3) {
				con = DBConnection.createConnection(); // Returns a new instance of the provider's class that implements
														// the DBConnection class.

				query = "update student_details set city=? where rollnum=?";
				ps = con.prepareStatement(query); // to return the object of PreparedStatement.
				ps.setString(1, update);
				ps.setInt(2, roll);
				ps.executeUpdate(); // updating the city //execution of DML statement UPDATE which is return int
									// value, count of the affected rows.
				flag = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (choice == 4) {
				con = DBConnection.createConnection(); // Returns a new instance of the provider's class that implements
														// the DBConnection class.

				query = "update student_details set standard=? where rollnum=?";
				ps = con.prepareStatement(query); // to return the object of PreparedStatement.
				ps.setString(1, update);
				ps.setInt(2, roll); // updating the standard //execution of DML statement UPDATE which is return int
									// value, count of the affected rows.

				ps.executeUpdate();
				flag = true;

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return flag;
	}

	@Override
	public void showAllStudent() {
		try { // getting all the students
			con = DBConnection.createConnection(); // Returns a new instance of the provider's class that implements the
													// DBConnection class.
			query = "select * from student_details"; // query is used to update the details and run the queries.
			stmt = con.createStatement(); // to return the object of PreparedStatement.
			rs = stmt.executeQuery(query); // executing the result query.
			while (rs.next()) {
				System.out.println("RollNumber: " + rs.getInt(1) + "\n" + "Name: " + rs.getString(2) + "\n "
						+ "Standard: " + rs.getString(3) + "\n" + "School/College name: " + rs.getString(4) + "\n"
						+ "City: " + rs.getString(5) + "\n" + "Percentage : " + rs.getDouble(6));
				System.out.println("----------------------------------");

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public boolean showStudentById(int roll) {
		boolean flag = false;
		try {

			con = DBConnection.createConnection(); // Returns a new instance of the provider's class that implements the
													// DBConnection class.

			query = "select * from student_details where rollnum=" + roll; // getting particular student details via
																			// roll number
			stmt = con.createStatement();
			rs = stmt.executeQuery(query); // executing the result query.
			while (rs.next()) {
				System.out.println("RollNumber: " + rs.getInt(1) + "\n" + "Name: " + rs.getString(2) + "\n "
						+ "Standard: " + rs.getString(3) + "\n" + "School/College name: " + rs.getString(4) + "\n"
						+ "City: " + rs.getString(5) + "\n" + "Percentage : " + rs.getDouble(6));
				// System.out.println("----------------------------------");
				flag = true;

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return flag;
	}
}