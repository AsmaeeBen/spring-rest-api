package net.javaguides.springboot.crudrestfulwebservices.model;

import javax.persistence.*;

@Entity

@Table(name = "employees")
public class Employee {
    public String getLastName;
    @Id
     @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;
     @Column(name = "fist_name")
    private String firstName;
    @Column(name = "last_name")
     private String lastName;
    @Column(name = "email_id")
    private String emailId;



    public Employee(long id, String firstName, String lastName, String emailId) {
        super();
        this.id=id;
        this.firstName =firstName;
        this.lastName =lastName;
        this.emailId = emailId;}
      public Employee() {
            super();
        }


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


    public String getEmailId() {
        return emailId;
    }
}

