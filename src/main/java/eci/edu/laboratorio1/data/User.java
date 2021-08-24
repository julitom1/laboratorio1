package eci.edu.laboratorio1.data;

public class User {

    private String id;
    private String name;
    private String email;
    private String lastName;
    private String created;
    
    public User(String name,String email, String lastName,String created) {
    	this.name=name;
    	this.email=email;
    	this.lastName=lastName;
    	this.created=created;
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

    public String isCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
