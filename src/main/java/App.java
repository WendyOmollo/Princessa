
import models.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

    public class App {
        public static void main(String[] args) {
            staticFileLocation("/public");
            Map<String, Object> model = new HashMap<>();

            get("/",(request, response) -> {
                return new ModelAndView(model,"layout.hbs");
            },new HandlebarsTemplateEngine());

            get("/cards",(request, response) -> {
                return new ModelAndView(model,"index.hbs");
            },new HandlebarsTemplateEngine());

            get("/form",(request, response) -> {
                return new ModelAndView(model,"princess-form.hbs");
            },new HandlebarsTemplateEngine());

            post("/princess",(request, response) -> {
                String lovelyName = request.queryParams("lovelyName");
                String lovelyAge = request.queryParams("lovelyAge");
                String lovelyStrength = request.queryParams("lovelyStrength");
                String lovelyWeakness = request.queryParams("lovelyWeakness");

                model.put("lovelyName",lovelyName);
                model.put("lovelyAge",lovelyAge);
                model.put("lovelyStrength",lovelyStrength);
                model.put("lovelyWeakness",lovelyWeakness);
                return new ModelAndView(model,"");

            },new HandlebarsTemplateEngine());

        }
    }
