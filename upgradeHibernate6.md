# read this article
https://jtuto.com/solved-using-hibernate-6-x-with-spring-boot-2-7-x-not-working/

Solution
Hibernate 6 uses the JPA version (JPA 3) that uses the jakarta.persistence package names introduced in JakartaEE 9. Spring Boot still uses the javax.* package namespace of JakartaEE 8 and earlier (JPA 2.2 and earlier), and thus only supports Hibernate 5.x (for Spring Boot 2.7, Hibernate 5.6.x is the default).

You will need to wait for Spring Boot 3, which switches to the jakarta.* packages of JakartaEE 9+, before you can use Hibernate 6. Until that time, you’ll need to use Hibernate 5.6.


tasks :

1) upgrade to spring boot 3, dependencies: (by example 3.0.0-M5)
   spring-boot-starter-web
   spring-boot-starter-test

2) upgrade to hibernate-core 6.1.3.Final
¿org.springframework:spring-orm:5.2.2.RELEASE?

3) change code (HibernateRepository, MySqlEventBus, MySqlDomainEventsConsumer..)
