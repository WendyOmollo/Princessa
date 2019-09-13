package models;

import java.util.ArrayList;
import java.util.Objects;

public class Domain {
    private String name;
    private int id;
    private int maxSize;
    private String cause;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domain domain = (Domain) o;
        return getMaxSize() == domain.getMaxSize() &&
                getName().equals(domain.getName()) &&
                getCause().equals(domain.getCause());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMaxSize(), getCause());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Domain(String name, String cause, int maxSize){
        this.name = name;
        this.cause = cause;
        this.maxSize=maxSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }




}
