package dao;

import DB.jav;
import models.Domain;
import org.sql2o.*;
import java.util.List;

public class Sql2oDomainDao implements DomainDao {
    private final Sql2o sql2o;

    public Sql2oDomainDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public List<Domain> getAll() {
        try(Connection con = jav.sql2o.open()){
            return con.createQuery("SELECT * FROM domains") //raw sql
                    .executeAndFetch(Domain.class); //fetch a list
        }
    }

    @Override
    public void add(Domain domain) {
        String sql = "INSERT INTO domains (name,maxSize,cause) VALUES (:name,:maxSize,:cause)";
        try(Connection con = jav.sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(domain)
                    .executeUpdate()
                    .getKey();
            domain.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Domain findById(int id) {
        try(Connection con = jav.sql2o.open()){
            return con.createQuery("SELECT * FROM domains WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Domain.class);
        }
    }



    @Override
    public void update(int id, String name, int maxSize, String cause){
        String sql = "UPDATE domains SET name = :name, maxSize = :maxSize, cause =:cause  WHERE id=:id";
        try(Connection con = jav.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("id", id)
                    .addParameter("maxSize", maxSize)
                    .addParameter("cause", cause)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from domains WHERE id=:id";
        try (Connection con = jav.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


    @Override
    public void clearAllDomains() {
        String sql = "DELETE from domains";
        try (Connection con = jav.sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
