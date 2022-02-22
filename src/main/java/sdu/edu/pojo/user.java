package sdu.edu.pojo;

import java.util.ArrayList;

public class user {
    private String name;
    private String age;
    private ArrayList<String> friends;
    private ArrayList<String> classmates;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public user(){

    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

    public ArrayList<String> getClassmates() {
        return classmates;
    }

    public void setClassmates(ArrayList<String> classmates) {
        this.classmates = classmates;
    }
}
