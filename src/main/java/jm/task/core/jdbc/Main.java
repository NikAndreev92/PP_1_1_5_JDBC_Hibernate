package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        try {
//            UserDao userDao = new UserDaoJDBCImpl();

            UserDao userDao = new UserDaoHibernateImpl();
            userDao.createUsersTable();
            userDao.saveUser("Ivan", "Ivanov", (byte) 20);
            userDao.saveUser("Petr", "Petrov", (byte) 30);
            userDao.saveUser("Pavel", "Sidorov", (byte) 40);
            userDao.saveUser("Andrey", "Leonidov", (byte) 50);
            userDao.removeUserById(1);
            List<User> userArrayList = userDao.getAllUsers();
            for (User user : userArrayList) {
                System.out.println(user.toString());
            }
            userDao.cleanUsersTable();
            userDao.dropUsersTable();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
