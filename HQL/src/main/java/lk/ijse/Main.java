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