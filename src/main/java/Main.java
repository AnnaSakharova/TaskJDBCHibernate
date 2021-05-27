import dao.UserDaoHibernateImpl;
import service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Galina", "Blanka", (byte) 30);
        userService.saveUser("Ivan", "Ivanov", (byte) 30);
        userService.saveUser("Petr", "Petrov", (byte) 30);
        userService.saveUser("Max", "Maximus", (byte) 30);
        userService.removeUserById(1);
        userService.cleanUsersTable();
        System.out.println(userService.getAllUsers().toString());
        userService.dropUsersTable();


        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Galina", "Blanka", (byte) 40);
        userDaoHibernate.saveUser("Ivan", "Ivanov", (byte) 40);
        userDaoHibernate.saveUser("Petr", "Petrov", (byte) 40);
        userDaoHibernate.saveUser("Max", "Maximus", (byte) 40);
        userDaoHibernate.removeUserById(2);
        userDaoHibernate.cleanUsersTable();
        System.out.println(userDaoHibernate.getAllUsers().toString());
        userDaoHibernate.dropUsersTable();
    }
}
