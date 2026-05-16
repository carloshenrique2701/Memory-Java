package entities;

public class Rooms {

	private int number;
	private String name;
	private String email;

	public Rooms(int number, String name, String email) {
		super();
		this.number = number;
		this.name = name;
		this.email = email;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Room: " + number + ", " + name + ", " + email + "";
	}

}
