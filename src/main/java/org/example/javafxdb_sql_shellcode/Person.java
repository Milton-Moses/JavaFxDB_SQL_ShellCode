package org.example.javafxdb_sql_shellcode;

public class Person {


    private Integer id;
    private String firstName;
    private String phone;
    private String email;
    private String address;
    private String password;

    public Person() {
    }


    public Person(Integer id, String firstName, String email, String phone, String address, String password) {
        this.id = id;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getPassword() {
        return password;
    }

    public String getEmail(){return email;}

    public void setEmail(String email) { this.email = email;}

    public void setPassword(String password) {
        this.password = password;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}