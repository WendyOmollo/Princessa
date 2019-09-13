package dao;

import models.Princess;

import java.util.List;

public interface PrincessDao {


    List<Princess> getAll();


    void add(Princess princess);


    Princess findById(int id);

    void update(int id, String name, int age, String strength, String weakness, int domain_id);


    void deleteById(int id);

    void clearAllPrincesses();
}
