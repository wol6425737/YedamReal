package com.yedam.java.app.emp13;

public class Emp13 {
	private int employeeId;
	private String firstName;
	private String jobId;
	private int salary;
	private double commissionPct;
	private String departmentName;
	private String locationId;

	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public double getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	@Override
	public String toString() {
		return "Emp13 [employeeId=" + employeeId + ", firstName=" + firstName + ", jobId=" + jobId + ", salary="
				+ salary + ", commissionPct=" + commissionPct + ", departmentName=" + departmentName + ", locationId="
				+ locationId + "]";
	}
	
	
	
	

}
