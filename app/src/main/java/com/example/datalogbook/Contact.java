package com.example.datalogbook;

public class Contact {
    private int _id;
    private String name;
    private String dob;
    private String email;
    private int imageID;

    public Contact(int _id, String name, String dob, String email) {
        this._id = _id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Contact(String name, String dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
