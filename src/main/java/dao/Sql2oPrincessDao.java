package dao;

import DB.jav;
import models.Princess;
import org.sql2o.*;
import java.util.List;
import java.util.Objects;

public class Sql2oPrincessDao implements PrincessDao {

    private final Sql2o sql2o;

    public Sql2oPrincessDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }
    
    @Override
    public List<Princess> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM princesses") //raw sql
                    .executeAndFetch(Princess.class); //fetch a list
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sql2oPrincessDao that = (Sql2oPrincessDao) o;
        return Objects.equals(sql2o, that.sql2o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sql2o);
    }

    @Override
    public void add(Princess princess) {
        String sql = "INSERT INTO princesses (name,age,strength,weakness,domain_id) VALUES (:name,:age,:strength,:weakness,:domain_id)";
        try(Connection con = jav.sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(princess)
                    .executeUpdate()
                    .getKey();
            princess.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Princess findById(int id) {
        try(Connection con = jav.sql2o.open()){
            return con.createQuery("SELECT * FROM princesses WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Princess.class);
        }
    }



    @Override
    public void update(int id, String newName, int newAge, String newStrength, String newWeakness, int newDomain_id){
        String sql = "UPDATE princesses SET name = :name, age = :age, strength = :strength, weakness = :weakness, domain_id = :domain_id  WHERE id=:id";
        try(Connection con = jav.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("id", id)
                    .addParameter("strength", newStrength)
                    .addParameter("weakness", newWeakness)
                    .addParameter("domain_id", newDomain_id)
                    .addParameter("age", newAge)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from princesses WHERE id=:id";
        try (Connection con = jav.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


    @Override
    public void clearAllPrincesses() {
        String sql = "DELETE from princesses";
        try (Connection con = jav.sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}
