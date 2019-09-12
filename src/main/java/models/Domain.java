package models;

import java.util.ArrayList;
import java.util.Objects;

public class Domain {
    private String name;
    private int id;
    private String course;
    private static ArrayList<Domain> kingdoms= new ArrayList<>();
    private static ArrayList<Princess> princesses= new ArrayList<Princess>();

    public Domain(String name,int id,String course){
        this.name = name;
        this.id = kingdoms.size();
        this.course = course;
        kingdoms.add(this);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return kingdoms.size();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public static ArrayList<Domain> getAll() {
        return kingdoms;
    }

    public static void setKingdoms(ArrayList<Domain> kingdoms) {
        Domain.kingdoms = kingdoms;
    }

    public static ArrayList<Princess> getPrincesses
            () {
        return princesses;
    }

    public static void setPrincesses(ArrayList<Princess> princesses) {
        Domain.princesses = princesses;
    }

    public static Domain findById(int id){
        return kingdoms.get(id-1);
    }
    public void update(String name,int id,String course){
        this.name = name;
        this.id =id;
        this.course =course;
    }
    public void add(Princess princess){
        princesses.add(princess);
    }


}
