package models;

import java.util.ArrayList;

public class Princess {
    private String name;
    private int id;
    private String strength;
    private String weakness;
    private static ArrayList<Princess> princesses = new ArrayList<>();

    public Princess(String name,int id,String strength,String weakness){
        this.name = name;
        this.id = princesses.size();
        this.strength=strength;
        this.weakness = weakness;
        princesses.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return princesses.size();
    }

    public void setId(int id) {
        this.id = id;
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

    public static ArrayList<Princess> getPrincesses() {
        return princesses;
    }

    public static void setPrincesses(ArrayList<Princess> princesses) {
        Princess.princesses = princesses;
    }
    public static Princess findById(int id){
        return princesses.get(id-1);
    }
}
