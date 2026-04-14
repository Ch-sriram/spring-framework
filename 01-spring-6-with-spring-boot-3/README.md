# Learning Spring 6 & Spring Boot 3

- Course is offered by [*Frank P Moley III*](https://www.linkedin.com/learning/instructors/frank-p-moley-iii?u=73591282) on [LinkedIn Learning](https://www.linkedin.com/learning/learning-spring-6-with-spring-boot-3).

## Prerequisite Knowledge

- Java

## Table of Contents

- [Learning Spring 6 \& Spring Boot 3](#learning-spring-6--spring-boot-3)
  - [Prerequisite Knowledge](#prerequisite-knowledge)
  - [Table of Contents](#table-of-contents)
  - [Setting Up PostgreSQL using Docker](#setting-up-postgresql-using-docker)
  - [Getting Started with Spring Boot](#getting-started-with-spring-boot)
    - [Introduction to Spring](#introduction-to-spring)
      - [Java \& Spring Definitions](#java--spring-definitions)
      - [Why is Spring Popular \& Widely Used?](#why-is-spring-popular--widely-used)
    - [Introduction to Spring Boot](#introduction-to-spring-boot)
      - [Key Components of Spring Boot](#key-components-of-spring-boot)

## Setting Up PostgreSQL using Docker

- Run the shell script [`start_postgres.sh`](./course-exercise-files/00_03_begin/bin/postgresql/start_postgres.sh) to start the PostgreSQL docker container:

  ```sh
  # If it's not already executable, then just run: `chmod +x ./start_postgres.sh` and then it'll work correctly
  ./start_postgres.sh
  ```

  O/P:

  > ```terminal
  > user@host:~$ ./start_postgres.sh
  > Unable to find image 'postgres:latest' locally
  > latest: Pulling from library/postgres
  > 5435b2dcdf5c: Pull complete 
  > baf06005f9e9: Pull complete 
  > 7cec73702fc3: Pull complete 
  > fecac0093525: Pull complete 
  > eb4cdb4c077a: Pull complete 
  > f4deb76cb231: Pull complete 
  > 11c182969642: Pull complete 
  > 2140605cc9e3: Pull complete 
  > 7a79188b0f04: Pull complete 
  > 484cf2ee784f: Pull complete 
  > b21c9fd89a08: Pull complete 
  > 8d02d282ee5a: Pull complete 
  > 464872ed796d: Pull complete 
  > Digest: sha256:52e6ffd11fddd081ae63880b635b2a61c14008c17fc98cdc7ce5472265516dd0
  > Status: Downloaded newer image for postgres:latest
  > 82a1a0d7e9c4f06d46321bdb3df871780bb5b2e3489145d0aaaa6b3af0e708b0
  > ```

- Then run the SQL files located inside [`schema.sql`](./course-exercise-files/00_03_begin/bin/postgresql/schema.sql) and [`data.sql`](./course-exercise-files/00_03_begin/bin/postgresql/data.sql) in that order.
  1. You can either login to the docker container as follows:

     ```sh
     docker exec -it pg-docker /bin/bash
     ```

     And then you can open the postgres shell as follows [from inside the docker container]:

     ```sh
     psql -d local postgres # `postgres` is the user for which, the password is already mentioned in the docker run command. So password won't be asked.
     ```

     Then you can paste the SQL commands present in [`schema.sql`](./course-exercise-files/00_03_begin/bin/postgresql/schema.sql) and [`data.sql`](./course-exercise-files/00_03_begin/bin/postgresql/data.sql) and [`data.sql`](./course-exercise-files/00_03_begin/bin/postgresql/data.sql), and it would work.
  
  2. The other way is to make use of `docker exec` and just feed it the SQL file without ever getting into the container and logging into postgres shell.

     ```sh
     docker exec -i pg-docker psql -U postgres < /path/to/schema.sql
     docker exec -i pg-docker psql -U postgres < /path/to/data.sql
     ```

     O/P:

     > ```terminal
     > user@host:~$ docker exec -i pg-docker psql -U postgres < ./course-exercise-files/03_03_begin/bin/postgresql/schema.sql
     > CREATE SCHEMA
     > CREATE TABLE
     > CREATE TABLE
     > CREATE TABLE
     > ALTER TABLE
     > ALTER TABLE
     > CREATE INDEX
     >
     > user@host:~$ docker exec -i pg-docker psql -U postgres < ./course-exercise-files/03_03_begin/bin/postgresql/data.sql
     > INSERT 0 1
     > INSERT 0 1
     > INSERT 0 1
     > INSERT 0 1
     > INSERT 0 1
     > INSERT 0 1
     > INSERT 0 1
     > INSERT 0 1
     > ...
     > ...
     > (243 inserts)
     > ```

     **NOTE**: Check the data once the query(s) run, as follows:

     ```sh
     # Get all the databases in the Postgres DB
     docker exec -i pg-docker psql -U postgres --list

     # Get 
     docker exec -i pg-docker psql -U postgres -e 'select * from lil.rooms;'
     ```

     You should see something like the following:

     > ```terminal
     > user@host:~$ docker exec -i pg-docker psql -U postgres --list
     >                                                     List of databases
     >    Name    |  Owner   | Encoding | Locale Provider |  Collate   |   Ctype    | Locale | ICU Rules |   Access privileges   
     > -----------+----------+----------+-----------------+------------+------------+--------+-----------+-----------------------
     >  local     | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |        |           | 
     >  postgres  | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |        |           | 
     >  template0 | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |        |           | =c/postgres          +
     >            |          |          |                 |            |            |        |           | postgres=CTc/postgres
     >  template1 | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |        |           | =c/postgres          +
     >            |          |          |                 |            |            |        |           | postgres=CTc/postgres
     > (4 rows)
     >
     > user@host:~$ docker exec -i pg-docker psql -U postgres -c 'select * from lil.rooms;'
     >  room_id |    name     | room_number | bed_info 
     > ---------+-------------+-------------+----------
     >        1 | Piccadilly  | P1          | 1Q
     >        2 | Piccadilly  | P2          | 1Q
     >        3 | Piccadilly  | P3          | 1Q
     >        4 | Piccadilly  | P4          | 2D
     >        5 | Piccadilly  | P5          | 2D
     >        6 | Piccadilly  | P6          | 2D
     >        7 | Cambridge   | C1          | 1K
     >        8 | Cambridge   | C2          | 1K
     >        9 | Cambridge   | C3          | 1K
     >       10 | Westminster | W1          | 1K
     >       11 | Westminster | W2          | 1K
     >       12 | Westminster | W3          | 1K
     >       13 | Westminster | W4          | 1K
     >       14 | Westminster | W5          | 2D
     >       15 | Westminster | W6          | 2D
     >       16 | Westminster | W7          | 2D
     >       17 | Oxford      | O1          | 1K
     >       18 | Oxford      | O2          | 1K
     >       19 | Oxford      | O3          | 1Q
     >       20 | Oxford      | O4          | 1Q
     >       21 | Oxford      | O5          | 1Q
     >       22 | Victoria    | V1          | 1K
     >       23 | Victoria    | V2          | 2D
     >       24 | Victoria    | V3          | 2D
     >       25 | Manchester  | M1          | 1K
     >       26 | Manchester  | M2          | 1K
     >       27 | Manchester  | M3          | 1K
     >       28 | Manchester  | M4          | 1K
     > (28 rows)
     > ```

[⬆️](#table-of-contents)

## Getting Started with Spring Boot

- Contains details on Spring, Spring Boot, project Creation, Spring Boot Skeleton, and Annotations, etc.

### Introduction to Spring

- What is Spring?
  - A Framework for providing infrastructural support for developing Java applications.
  - The framework provides the plumbing and scaffolding, to ensure that devs can focus primarily on the business logic, instead of setting up things.
    - It does this by relying on **Object Oriented Programming (OOP)** abstractions in the framework.
    - And all of this is based on the **Don't Repeat Yourself (DRY)** Principle.

#### Java & Spring Definitions

1. POJO: Plain Old Java Object is a Java class in the purest sense. POJO contains both attributes and methods for working with the class.
2. JavaBeans (from EJB): are simple objects/instances with only getters and setters for the attributes.
3. **Spring Beans**: POJOs configured in the *application context* (application context will be explained later).
4. Data Transfer Objects (DTOs): Javabeans used to move state between layers.

#### Why is Spring Popular & Widely Used?

- Well documented.
- The framework builds its constructs based on Common patterns accross differing uses.
- Configuration by annotation based - component scanning or Java (earlier, it used to be configured using XML): When SpringBoot is added, you get Auto Configuration as well, making configuration even easier.
- **Inversion of Control (IoC)** is the primary focus of how the framework works. What we're actually configuring, is the IoC container, which is the most central part of a running Spring application.
- IoC is one of the OOP patterns that Spring leverages to its core.
- IoC provides the mechanism of dependency injection, allowing a shift in object creation and management, compared to how it's done in a trditional java application.
- `ApplicationContext` wraps the `BeanFactory` (which is ultimately the IoC container), which serves te beans to the runtime of the application.
- Spring Boot provides auto-confuration of the `ApplicationContext` [of the `BeanFactory`] based on the presence/absence of classes, among other conditionals; thus greatly improving the speed of application development.

[⬆️](#table-of-contents)

### Introduction to Spring Boot

The Benefits of Spring Boot:

- Supports Rapid Development: Fully functional apps can be built w/ minimal effort.
- Removes boilerplates of application setup of the Spring framework, and got abstracted through Auto Configuration.
- Many modern application uses &mdash; even beyond webapps.
  - The modern app use-cases include traditional and cloud-native application development.
- Aut-configuration and embdded offerings like DBs, servlet containers, tomcat webserver, etc, speeds up the development process.

#### Key Components of Spring Boot

- Embedded Apache Tomcat (and others); we used to build WAR (web archive) files and run them in a web server like apache tomcat.
- Auto-configuration of `ApplicationContext` removes the need to configure every single aspect of the running application. We used to spend a lot of time configuring, just to make a "Hello World!" type application run; we don't do that now.
- Automatic Servlet Mapping: we used to map servlets to get the applications up and running in `web.xml` file (web descriptor file), and now, we do none of that.
- Embedded database support and Hibernate/JPA dialect: no configuration is needed to setup databases, thanks to Auto Configuration feature of Spring Boot, based on the classes present on the classpath, the database and related ORMs are configured automatically.
- Automatic Controller Mappings: allows you to serve web pages with no extra configuration.

[⬆️](#table-of-contents)
