package lk.ijse;

import lk.ijse.confit.FactoryConfiguration;
import lk.ijse.entiity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*JPQL SAVE*/
        //This does not have an insert query only this type can do save
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

        /*JPQL UPDATE*/
       /* Query query = session.createQuery("UPDATE Customer c SET c.name = :name WHERE c.id = :id");
        query.setParameter("name", "Sehan");
        query.setParameter("id", 1);

        int result = query.executeUpdate();
        System.out.println("Number of records updated: " + result);*/

        /*JPQL DELETE*/
       /* Query query = session.createQuery("DELETE FROM Address  WHERE aid = :id");
        query.setParameter("id", 2);

        int result = query.executeUpdate();
        System.out.println("Number of records deleted: " + result);*/

        /*JPQL SEARCH*/
        /*Query query = session.createQuery("SELECT c FROM Customer c WHERE c.name = :name");
        query.setParameter("name", "Sehan");

        List<Customer> customers = query.getResultList();
        for (Customer customer : customers) {
            System.out.println(customer.getId() + ": " + customer.getName());
        }*/

        /*JPQL JOIN*/
      /*  String join = "SELECT c.id, c.name, a.aid, a.no, a.road, a.city " +
                "FROM Customer c JOIN c.addresses a";
        Query query = session.createQuery(join);

        List<Object[]> results = query.getResultList();
        for (Object[] result : results) {
            int customerId = (Integer) result[0];
            String customerName = (String) result[1];
            int addressId = (Integer) result[2];
            String addressNo = (String) result[3];
            String addressRoad = (String) result[4];
            String addressCity = (String) result[5];

            System.out.println("Customer ID: " + customerId + ", Name: " + customerName);
            System.out.println("Address ID: " + addressId + ", No: " + addressNo + ", Road: " + addressRoad + ", City: " + addressCity);
        }*/
        transaction.commit();
        session.close();
    }
}