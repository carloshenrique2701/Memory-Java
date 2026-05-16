package model.entities;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;

public class User implements Comparable<User> {

	private String name;

	private LinkedHashSet<Instant> accsDate  = new LinkedHashSet<>(); 
	
	public User(String name, Instant accsDate) {
		super();
		this.name = name;
		this.accsDate.add(accsDate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public LinkedHashSet<Instant> getAccsDAte() {
		return accsDate;
	}

	public void addAccsDate(Instant accsDate) {
		this.accsDate.add(accsDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(User other) {
		return this.name.toUpperCase().compareTo(other.getName().toUpperCase());
	}

	@Override
	public String toString() {
		return "User name:" + name + ", accsDate: " + accsDate + "]";
	}
	

}
