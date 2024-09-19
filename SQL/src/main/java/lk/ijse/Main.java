package lk.ijse;

import lk.ijse.confit.FactoryConfiguration;
import lk.ijse.entiity.Address;
import lk.ijse.entiity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*SQL SAVE*/
        /*  Address address1 = new Address();
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


        /*SQL UPDATE*/
        /*Customer customer = session.get(Customer.class, 1);
        customer.setName("Sassara");
        session.update(customer);*/

        /*SQL DELETE*/
        /*Address address = session.get(Address.class, 1);
        session.delete(address);*/

        /*SQL SearchByName*/
        /*String searchName = "Sassara";
        NativeQuery query = session.createNativeQuery("select * from customer where name = ?1");
        query.addEntity(Customer.class);
        query.setParameter(1, searchName);

        List<Customer> customer = query.list();
        for (Customer c : customer){
            System.out.println(c.getName());
        }*/

        /*JOIN Query*/
        String sql = "SELECT c.id AS customerId, c.name AS customerName, a.aid AS addressId, a.no AS addressNo, a.road AS addressRoad, a.city AS addressCity " +
                "FROM Customer c " +
                "INNER JOIN Address a ON c.id = a.customer_id";
        NativeQuery query = session.createNativeQuery(sql);

        List<Object[]> results = query.list();

        for (Object[] result : results) {
            int customerId = (Integer) result[0];
            String customerName = (String) result[1];
            int addressId = (Integer) result[2];
            String addressNo = (String) result[3];
            String addressRoad = (String) result[4];
            String addressCity = (String) result[5];

            System.out.println("Customer ID: " + customerId + ", Name: " + customerName);
            System.out.println("Address ID: " + addressId + ", No: " + addressNo + ", Road: " + addressRoad + ", City: " + addressCity);
        }
        transaction.commit();
        session.close();
    }
}