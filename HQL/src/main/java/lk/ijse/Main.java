package lk.ijse;

import lk.ijse.confit.FactoryConfiguration;
import lk.ijse.entiity.Address;
import lk.ijse.entiity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*HQL SAVE*/
        /*Address address1 = new Address();
        address1.setAid(1);
        address1.setNo("100/2");
        address1.setRoad("kkkk");
        address1.setCity("llll");

        Address address2 = new Address();
        address2.setAid(2);
        address2.setNo("200/2");
        address2.setRoad("mmmm");
        address2.setCity("hhhh");

        List<Address> addresses = new ArrayList<Address>();
        addresses.add(address1);
        addresses.add(address2);

        Customer customer = new Customer();

        customer.setId(1);
        customer.setName("Sehan");
        customer.setAddresses(addresses);

        address1.setCustomer(customer);
        address2.setCustomer(customer);

        session.save(address1);
        session.save(address2);
        session.save(customer);*/

        /*HQL UPDATE*/
       /* String update = "UPDATE Customer c SET c.name = :name WHERE c.id = :id";
        Query query = session.createQuery(update);
        query.setParameter("name", "Sassara");
        query.setParameter("id", 1);

        int result = query.executeUpdate();*/

        /*HQL DELETE*/
        /*String delete = "DELETE Address a WHERE aid = :id";
        Query query = session.createQuery(delete);
        query.setParameter("id", 1);

        int result = query.executeUpdate();*/

        /*HQL Select with Parameter*/
        /*Query query1 = session.createQuery("SELECT c.id, c.name FROM Customer c WHERE c.id = :cid");
        query1.setParameter("cid", 1);
        List<Object[]> result1 = query1.list();
        for (Object[] row : result1) {
            System.out.println("ID: " + row[0] + ", Name: " + row[1]);
        }*/

        /*HQL Select All*/
        /*Query query2 = session.createQuery("SELECT c.id, c.name FROM Customer c");
        List<Object[]> result2 = query2.list();
        for (Object[] row : result2) {
            System.out.println("ID: " + row[0] + ", Name: " + row[1]);
        }*/

        /*HQL Join Query*/
        /*Query query3 = session.createQuery("SELECT a.id, a.no, a.road, a.city FROM Address a INNER JOIN a.customer c");
        List<Object[]> result3 = query3.list();
        for (Object[] row : result3) {
            System.out.println("Address ID: " + row[0] + ", No: " + row[1] + ", Road: " + row[2] + ", City: " + row[3]);
        }*/

        transaction.commit();
        session.close();
    }
}