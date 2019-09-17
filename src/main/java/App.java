
import dao.Sql2oDomainDao;
import dao.Sql2oPrincessDao;
import models.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

    public class App {
        public static void main(String[] args) {
            
            staticFileLocation("/public");
            String connectionString = "jdbc:postgresql:~/Princessa.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
            Sql2o sql2o = new Sql2o(connectionString, "", "");
            Sql2oPrincessDao princessDao = new Sql2oPrincessDao(sql2o);
            Sql2oDomainDao domainDao = new Sql2oDomainDao(sql2o);

            Map<String, Object> model = new HashMap<>();


            get("/",(request, response) -> {
                return new ModelAndView(model,"layout.hbs");
            },new HandlebarsTemplateEngine());

            get("/cards",(request, response) -> {
                List<Domain> domains = domainDao.getAll();
                List<Princess> princesses = princessDao.getAll();
                model.put("princesses", princesses);
                model.put("domains", domains);
                return new ModelAndView(model,"index.hbs");
            },new HandlebarsTemplateEngine());

            get("/form",(request, response) -> {
                List<Domain> domains = domainDao.getAll();
                List<Princess> princesses = princessDao.getAll();
                model.put("princesses", princesses);
                model.put("domains", domains);
                return new ModelAndView(model,"princess-form.hbs");
            },new HandlebarsTemplateEngine());

            get("/princesses/:id",(request, response) -> {
                int idOfPrincess = Integer.parseInt(request.params("id"));
                Princess princess = princessDao.findById(idOfPrincess);
                Domain domain = domainDao.findById(princess.getDomain_id());
                model.put("domain", domain);
                model.put("princess",princess);
                return new ModelAndView(model,"princess-details.hbs");
            },new HandlebarsTemplateEngine());

            get("/domains/:id",(request, response) -> {
                int idOfDomain = Integer.parseInt(request.params("id"));
                Domain domain = domainDao.findById(idOfDomain);
                model.put("domain", domain);
                return new ModelAndView(model,"domain-details.hbs");
            },new HandlebarsTemplateEngine());

            post("/princesses/new",(request, response) -> {
                String lovelyName = request.queryParams("name");
                int lovelyAge = Integer.parseInt(request.queryParams("age"));
                String lovelyStrength = request.queryParams("strength");
                String lovelyWeakness = request.queryParams("weakness");
                int lovelyDomain_id = Integer.parseInt(request.queryParams("domain_id"));
                Princess princess = new Princess(lovelyName,lovelyAge,lovelyStrength,lovelyWeakness,lovelyDomain_id);
                princessDao.add(princess);
                List<Domain> domains = domainDao.getAll();
                List<Princess> princesses = princessDao.getAll();
                model.put("princesses", princesses);
                model.put("domains", domains);
                response.redirect("/cards");
                return null;
            },new HandlebarsTemplateEngine());

            post("/domains/new",(request, response) -> {
                String lovelyName = request.queryParams("domainName");
                int lovelySize = Integer.parseInt(request.queryParams("domainMaxSize"));
                String lovelyCause = request.queryParams("domainCause");
                Domain domain = new Domain(lovelyName,lovelyCause,lovelySize);
                domainDao.add(domain);
                List<Domain> domains = domainDao.getAll();
                List<Princess> princesses = princessDao.getAll();
                model.put("princesses", princesses);
                model.put("domains", domains);
                response.redirect("/cards");
                return null;
            },new HandlebarsTemplateEngine());

            get("/princesses/:id/delete",(request, response) -> {
                int idOfPrincess = Integer.parseInt(request.params("id"));
                Princess princess = princessDao.findById(idOfPrincess);
                Domain domain = domainDao.findById(princess.getDomain_id());
                model.put("domain", domain);
                model.put("princess",princess);
                response.redirect("/cards");
                return null;
            },new HandlebarsTemplateEngine());


        }
    }
