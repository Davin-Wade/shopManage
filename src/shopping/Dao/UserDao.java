package shopping.Dao;

import shopping.entity.User;

import java.util.List;


public interface UserDao {

    /**
     *
     * @param u
     * @return
     */
    int insertUser(User u);
//    List<User> selectUser(User u);
    int deleteUser(String[] u);
}
