# Princessa

## Description
in this project,a user gets to see princesses who represent a good course.
Apart from that , they also see domains of princesses.
They can add a princess and also assign a princess a domain.



## Setup and Installation
##### For your app:
* ``Intellij`` needs to in your machine.
* You can run it using ``Gradle`` or ``Maven.``
* You will also need ``templates `` for your User Interface.
##### For your database:
* You can use ``PostgreSQL``
* ``sudo apt install postgresql postgresql-contrib``
* After installing you navigate into the database by writing ``psql``
##### In creating your tables
* You will also need tables to collect data.
* You first create a database ``CREATE DATABASE princessdomain``
* Then you navigate to the database ``\c princessdomain``
* Then create the tables that you will need:
``CREATE TABLE princesses`` , ``CREATE TABLE domains`` 
* Each table will have the input it is taking.
* For reference visit ``Digital Ocean``

#####For deploying to Heroku:
* You will need a ``Procfile`` that has your dyno.This is a dyno >``web:.build/install/princessa/bin/princessa``
* In your ``build.gradle`` you will need some dependencies and tasks
``task stage(dependsOn: ['clean', 'installDist'])``
* You will also need a file called jav that has the following:

```import java.net.URI;
  import java.net.URISyntaxException;
  
  public class jav {
  
      private static URI dbUri;
      public static Sql2o sql2o;
      static Logger logger = LoggerFactory.getLogger(jav.class);
      static {
  
          try {
              if (System.getenv("DATABASE_URL") == null) {
                  dbUri = new URI("postgres://localhost:5432/<your database name>");
              } else {
                  dbUri = new URI(System.getenv("DATABASE_URL"));
              }
              int port = dbUri.getPort();
              String host = dbUri.getHost();
              String path = dbUri.getPath();
              String username = (dbUri.getUserInfo() == null) ? <your username> : dbUri.getUserInfo().split(":")[0];
              String password = (dbUri.getUserInfo() == null) ? <your password> : dbUri.getUserInfo().split(":")[1];
              sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
          } catch (URISyntaxException e ) {
              logger.error("Unable to connect to database.");
          }
  
      }
  }
```
* Don't forget ``create.sql`` and ``drop.sql`` files for your tables and database
* Then add ``Gradle Wrapper `` to github so that Heroku can run your app.
* Then run the following commands on your terminal:
* ``heroku login``
* ``heroku create``
* ``heroku addons:create heroku-postgresql:hobby-dev --app`` plus the random app name that heroku has given you.
* ``heroku pg:push your local database name the database heroku has created --app the random app name``
* ``./gradlew build deployHeroku``

* This deploys your app to Heroku.
In case the app crashed go to sources like Heroku and Medium for help.

## Authors
Wendy Omollo

## Contributors
Wendy Omollo

## Tech used
* Java
* Spark 
* PostgreSQL

## License
MIT License
Copyright 2019.