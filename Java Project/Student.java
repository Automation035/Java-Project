package com.sjprogramming.dao;

public class Student {
	private int rollNum;
	private String standard; // declaring the variables in the private method
	private String name;
	private String clgName;
	private String city;
	private double percentage;

	public Student() {

	}

	public Student(String name, String standard, String clgName, String city, double percentage) {
		this.name = name; // constructor = method that is used to initialize the objects
		this.standard = standard; // this is used to refer the current object
		this.clgName = clgName;
		this.city = city;
		this.percentage = percentage;
	}

	public Student(int rollNum, String standard, String name, String clgName, String city, double percentage) {
		this.rollNum = rollNum; // to construct an object and assign values to the object's members
		this.standard = standard; // refers to the current object in a method or constructor.
		this.name = name;
		this.clgName = clgName;
		this.city = city;
		this.percentage = percentage;
	}

	public int getRollNum() { // getters and setters for the constructor
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClgName() {
		return clgName;
	}

	public void setClgName(String clgName) {
		this.clgName = clgName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() { // built in method of java which returns itself a string
		return "Student [rollNum=" + rollNum + ", standard=" + standard + ", name=" + name + ", clgName=" + clgName
				+ ", city=" + city + ", percentage=" + percentage + "]";
	}

}
