package edu.fdiazaguirre.predicates;

public class Candidate {

	private String firstName;
	private String lastName;
	private int dni;
	private char gender;
	private boolean isBackend;
	private boolean isFrontEnd;

	public Candidate (String firstName, String lastName, int dni, char gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.gender = gender;
	}
	
	public void setBackend(boolean isBackend) {
		this.isBackend = isBackend;
	}
	
	public void setFrontEnd(boolean isFrontEnd) {
		this.isFrontEnd = isFrontEnd;
	}
	
	public boolean isBackend() {
		return this.isBackend;
	}
	
	public boolean isFrontEnd() {
		return this.isFrontEnd;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public int getDni() {
		return this.dni;
	}
}
