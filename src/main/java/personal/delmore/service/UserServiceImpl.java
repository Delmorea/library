package personal.delmore.service;

import personal.delmore.dao.UserDao;
import personal.delmore.dao.UserDaoImpl;
import personal.delmore.entity.User;

import java.util.List;
import java.util.stream.Collectors;

//实现登录服务
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    public UserServiceImpl() {
    }

    //判断用户是否存在，从而实现登录功能
    public boolean adjustUser(User user) {
        List<User> list = userDao.userSelectAll();
        List<String> userName = list.stream().map(User::getUserName).collect(Collectors.toList());
        List<String> password = list.stream().map(User::getPassword).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++)
            if (user.getUserName().equals(userName.get(i)) && user.getPassword().equals(password.get(i))) {
                return true;
            }
        return false;
    }

    //判断用户名是否存在
    public boolean adjustId(User user) {
        List<User> list = userDao.userSelectAll();
        boolean flag = false;
        List<String> userName = list.stream().map(User::getUserName).collect(Collectors.toList());
        flag = userName.contains(user.getUserName());
        return flag;
    }

    //用户的增删改查
    public void addUser(User user) {
        userDao.userAdd(user);
    }

    public void updateUser(User user) {
        userDao.userUpdate(user);
    }


}