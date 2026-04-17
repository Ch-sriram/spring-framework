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
    - [Create Spring Project](#create-spring-project)
      - [Examine a Spring Boot Skeleton](#examine-a-spring-boot-skeleton)
    - [Spring Boot Annotations](#spring-boot-annotations)
      - [Details on Auto-configuration](#details-on-auto-configuration)
      - [Details on Proxies](#details-on-proxies)

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

### Create Spring Project

1. Open <https://start.spring.io>, and set the following options:
   1. Project: `Maven`
   2. Language: `Java`
   3. Spring Boot: `Latest` (`4.0.5` for this project)
   4. Project Metadata:
      1. Group: `com.<your-name>.lil`
      2. Artifact: `landon-hotel`
      3. Name: `landon-hotel`
      4. Description: \<Empty> | \<Anything you prefer>
      5. Packaging: `Jar`
      6. Configuration: `Properties`
      7. Java: `17`
   5. Dependencies: `Spring Web` (There are other dependencies, which can be added later. In the real world, all the dependencies are added in the beginning itself).
   6. Click `Generate`, and it'll generate a zip file with the `Artifact` you've mentioned. For example, if the details are as is as mentioned above, the zip file should be: `landon-hotel.zip`.

[⬆️](#table-of-contents)

#### Examine a Spring Boot Skeleton

Open the zip file, and delete (OPTIONAL):

1. `.mvn` directory (if maven is already installed, no need for this package).
2. `mvnw` and `mvnw.cmd` command files (if maven is already installed, delete these).
3. `.gitignore` and `HELP.md` files.
4. Right Click on `src/main/resources/static` and create `index.html`, add HTML to it.
5. Then click on eclipse/intellij Run button.
6. Open <https://localhost:8080> to check the output: `Hello World!` [or whatever you've added in `index.html`].

[⬆️](#table-of-contents)

### Spring Boot Annotations

- Spring Boot is driven by Auto-Configuration and Component Scanning, and **Annotations drive the component scanning**.
- What are Annotations?
  1. Native feature and support by Java.
  2. Metadata for your code.
  3. Often used for compiler or runtime instructions.
  4. Great leverage point for pointcuts (Used in AOP: Aspect Oriented Programming)
- How does Annotation aid Configuration?
  1. **IoC Container is Driven by Configuration**.
  2. XML Configuration: Spring used to be entirely configured using XML, while the support still exists, it has been deprecated by the community, and is almost entirely phased out in active development.
  3. Java Configuration: replacement for the XML Configuration, where Beans are destined for the `BeanFactory` [which is the essential component of the IoC container] can be defined with functions annotated with `@Bean`. These beans can be served to any class in your application. The functions themselves are pure Java, and they exist in the `@SpringBoot` annotated class.
  4. Component Scanning: easiest method of configuration today, through this method, annotations are added to classes, attributes, and methods that allow the framework to define a Bean for use in the application. Indeed, *Java Configuration*, is driven by Component Scanning of the annotated class and then the method(s) within it.
  5. Auto-configuration: is an aspect of Spring Boot where beans are added to the `BeanFactory` (IoC Container) based on Annotations and Conditions. This is the power of Spring Boot, because it allows default Bean creation based on presence/absence of classes in the classpath, or already in the `BeanFactory` (IoC Container).

[⬆️](#table-of-contents)

#### Details on Auto-configuration

- Bootstrapping an application with `@SpringBootApplication`, or annotating a config class with `@EnableAutoConfiguration` turns on Auto-configuration, once that class' component is scanned.
- The IoC container configuration [through auto-configuration] is dependent entirely on the classes included on the classpath, via the dependency JARs included in the project, as well as conditions.
- Can be customized &mdash; you've control over auto-config's behaviour, and hence you can turn off certain parts of the framework's behaviour around aut-config strategy. **Exclusions** provide the customized behaviour.
- Driven by properties - Spring gives you common properties, to specific data points. These common properties give you exposure to the most common overrides, without actually having to override the auto-configuration behaviour itself.
- Developer can configure everything - if the properties are not sufficient for the dev's needs, Spring's auto-configuration operations will stop trying to configure a Bean, if the dev has already defined it, in their configuration, or in components that are annotated.

[⬆️](#table-of-contents)

#### Details on Proxies

- Outside of configuration, behaviour can be added to configured beans, specifically through the Proxy Pattern.
- Beans in `BeanFactory` are proxied by Spring. Spring already adds various types of behaviour based on the class, and based on any annotations that are on it already.
- Annotations drive proxies; 99% of the behaviour is defined by proxies through annotations, unless, the dev configures the behaviour via their proxy, without an annotation through the use of Aspecting.
- Annotations are easy extension points.
- Order of method calling matters! This is an important thing to note for Proxied code.

[⬆️](#table-of-contents)

## Data Access in Spring

We'll take a look into the following concepts:

1. Spring Data & Repositories
2. Embedded DB in Spring Boot
3. Using a Remote Database

### Spring Data

- With the Spring framework, there are a series of top-level projects that provide a robust set of implementations, and **Spring Data** is one such project that provides data access. Spring Data comes with the following out of the box:
  1. **Provides a common set of interfaces** that can be used across many different data sources, from traditional RDMBS to NoSQL, and some database adjacent technologies like Redis, Memcached, and Search Engines.
  2. **Provides a common naming convention**. Some patterns in Spring Data, like JDBC template follows a pattern across the entire platform. Others like Repository, are used across all of Spring Data; within the Repositories, naming is also at play when building dynamic queries based on method naming.
  3. **Provides aspected behaviour** around transaction management, that can be used to build transactions that span single or multiple methods.
  4. **Provides repository and data mapping convention** through either repository pattern with an ORM (JPA), or through data mappers when using JDBC template.

[⬆️](#table-of-contents)

#### Benefits of Spring Data

1. **Removes boilerplate code**; if you're w/ ORMs, you can change many repetitive lines of code for a single method, into a simple interface definition at most. If you don't like ORMs and use JDBC templates, you still save a lot of repetitive code, on building the connection, committing, and then tearing down what has happened, for every database call.
2. **Allows for ease of swapping data sources**; you can easily build POCs locally using a different database like `H2`, and then converting it to use Postgres [or whatever production database is in-use] with no real code changes.
   - In addition, because of the similarities across the framework, switching from relational to NoSQL, is generally pretty clean and easy.
3. **Allows you to focus on Business logic**: Pt. 1 & 2 combined [along with other benefits of the framework itself], allow you focus on your business logic, and not so much on the scaffolding or plumbing code [setup code], that has nothing to do with the business needs, and everything to do with just using the technology.

[⬆️](#table-of-contents)

#### Key Components of Spring Data

1. **Repository Interface**: Gives an extension point for your own database objects utilizing the repository design pattern. This is by far the easiest way to get data, to and from a database of any programming language [or framework] out there, and this same pattern, is being mimicked in other frameworks both within the JVM, and external to it.
2. **`JdbcTempalte`**: Gives you an easy way to execute raw JDBC queries w/o a lot of overhead, dealing with connections. This template pattern is used across Spring, but with databases, it gives you way to not use an ORM, but to get a huge benefit from reduction of repetitive code.
3. **`Jakarta EE` Entity Object**: from the `JPA` specification, Spring uses it in the same way that you would use it with JPA, whether you are consuming a relational database or not.
4. `DataSource`: is a Java construct that represents a unique connection pattern to a database. You can have multiple data sources, in a single Spring application, but it does require a little more effort, because of the bean rules around having a certain no. of items in the `BeanFactory` that implement a class.

[⬆️](#table-of-contents)

#### Repository Method Names

Spring Data doesn't just provide a set of common methods with the Repository interface. It gives you dynamically generated queries.

The interface method names follow a convention to create queries:

- `findAllBy...` and then some value, and that value has to exist on the entity itself.
- `findBy...`, which will get a single instance, again, based on that same pattern of the name, or being an attribute on the Entity.
- `findBy...And...`, has the same idea as mentioned in `findAllBy` and `findBy`, but now you've multiple values coming in.
  - `findBy...Or...` is also another variant of this use-case.

NOTE: All of these strategies aforementioned, are very well documented in **[Spring's JPA &mdash; Repository Query Keywords Documentation.](https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html)**.

[⬆️](#table-of-contents)
