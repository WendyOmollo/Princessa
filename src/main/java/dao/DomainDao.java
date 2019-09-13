package dao;

import models.Domain;

import java.util.List;

public interface DomainDao {


    List<Domain> getAll();


    void add(Domain domain);


    Domain findById(int id);

     void update(int id, String name, int maxSize, String cause);


     void deleteById(int id);
     void clearAllDomains();
}
