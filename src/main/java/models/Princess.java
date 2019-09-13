package models;

import java.util.ArrayList;
import java.util.Objects;

public class Princess {
    private String name;
    private int id;
    private int age;
    private String strength;
    private String weakness;
    private int domain_id;
//    private static ArrayList<Princess> princesses = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Princess princess = (Princess) o;
        return getAge() == princess.getAge() &&
                getName().equals(princess.getName()) &&
                getStrength().equals(princess.getStrength()) &&
                getWeakness().equals(princess.getWeakness());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getStrength(), getWeakness());
    }

    public int getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(int domain_id) {
        this.domain_id = domain_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Princess(String name, int age, String strength, String weakness, int domain_id){
        this.name = name;

        this.age = age;
        this.strength=strength;
        this.weakness = weakness;
        this.domain_id = domain_id;
//        princesses.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }



}
