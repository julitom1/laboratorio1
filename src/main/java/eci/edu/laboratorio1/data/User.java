package eci.edu.laboratorio1.data;


import java.time.LocalDate;

public class User {

    private String id;
    private String name;
    private String email;
    private String lastName;
    private LocalDate createdAt;
    
    public User(String name,String email, String lastName) {
    	this.name=name;
    	this.email=email;
    	this.lastName=lastName;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public LocalDate getCreated() {
		return createdAt;
	}

	public void setCreated(LocalDate created) {
		this.createdAt = created;
	}

   
}
