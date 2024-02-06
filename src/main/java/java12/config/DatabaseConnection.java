package java12.config;

import jakarta.persistence.EntityManagerFactory;
import java12.entit.Addresses;
import java12.entit.Companies;
import java12.entit.Programmer;
import java12.entit.Project;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DatabaseConnection {
    public static EntityManagerFactory getEntityManager() {
        try {
            Properties properties = new Properties();
            properties.put(Environment.JAKARTA_JDBC_DRIVER, "org.postgresql.Driver");
            properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/cascade_type");
            properties.put(Environment.JAKARTA_JDBC_USER, "postgres");
            properties.put(Environment.JAKARTA_JDBC_PASSWORD, "Urmat0204");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            properties.put(Environment.SHOW_SQL, "true");

            Configuration configuration = new Configuration();
            configuration.addProperties(properties);
            configuration.addAnnotatedClass(Addresses.class);
            configuration.addAnnotatedClass(Companies.class);
            configuration.addAnnotatedClass(Project.class);
            configuration.addAnnotatedClass(Programmer.class);
            return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
