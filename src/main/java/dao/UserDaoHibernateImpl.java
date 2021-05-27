package dao;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Util util = new Util();
        try {
            SessionFactory sessionFactory = util.getConfiguration().buildSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        Util util = new Util();
        try {
            SessionFactory sessionFactory = util.getConfiguration().buildSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();
            session.createSQLQuery("DROP TABLE Userz").executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            Util util = new Util();

            SessionFactory sessionFactory = util.getConfiguration().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(new User(name, lastName, age));

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        Util util = new Util();
        try {
            SessionFactory sessionFactory = util.getConfiguration().buildSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();
            Query query = session.createQuery("DELETE Userz where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Util util = new Util();
        List<User> list;
        try {

            SessionFactory sessionFactory = util.getConfiguration().buildSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();
            Query query = session.createQuery("from Userz");
            list = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Util util = new Util();
        try {
            SessionFactory sessionFactory = util.getConfiguration().buildSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();
            session.createQuery("DELETE Userz ").executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
