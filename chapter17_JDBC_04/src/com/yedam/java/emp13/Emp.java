package com.yedam.java.emp13;

public class Emp {
	private int employeeId;
	private String firstName;
	private String jobId;
	private int salary;
	private String commisionPct;
	private String departmentName;
	private int locationId;
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
	public String getCommisionPct() {
		return commisionPct;
	}
	public void setCommisionPct(String commisionPct) {
		this.commisionPct = commisionPct;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "Emp [employeeId=" + employeeId + ", firstName=" + firstName + ", jobId=" + jobId + ", salary=" + salary
				+ ", commisionPct=" + commisionPct + ", departmentName=" + departmentName + ", locationId=" + locationId
				+ "]";
	}
	
	
}
