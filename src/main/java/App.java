
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


        }
    }
