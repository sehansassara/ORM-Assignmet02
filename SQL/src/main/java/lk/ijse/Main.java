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
         /* String address1 = "INSERT INTO Address (aid, no, road, city) VALUES (:aid, :no, :road, :city)";
        Query query1 = session.createQuery(address1);
        query1.setParameter("aid", 1);
        query1.setParameter("no", "100/2");
        query1.setParameter("road", "kkkk");
        query1.setParameter("city", "llll");
        query1.executeUpdate();

        String address2 = "INSERT INTO Address (aid, no, road, city) VALUES (:aid, :no, :road, :city)";
        Query query2 = session.createQuery(address2);
        query2.setParameter("aid", 2);
        query2.setParameter("no", "200/2");
        query2.setParameter("road", "mmmm");
        query2.setParameter("city", "hhhh");
        query2.executeUpdate();

        String sqlInsertCustomer = "INSERT INTO Customer (id, name) VALUES (:id, :name)";
        Query customerQuery = session.createQuery(sqlInsertCustomer);
        customerQuery.setParameter("id", 1);
        customerQuery.setParameter("name", "Sehan");
        customerQuery.executeUpdate();*/


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