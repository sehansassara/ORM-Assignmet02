package lk.ijse.confit;


import lk.ijse.entiity.Address;
import lk.ijse.entiity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class);
        sessionFactory= configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration== null) ?factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
