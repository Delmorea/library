package personal.delmore.dao;

import personal.delmore.entity.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    /**
     * @param :user
     * @return void
     * @author 86176
     * @description 用户的增删改查
     * @date 2022/3/25 12:47
     */
    void userAdd(User user);
    void userUpdate(User user);
    /**
     * @param :user
     * @return List<User>
     * @author 86176
     * @description 查询出所有用户，在service层再做判断
     * @date 2022/3/25 12:48
     */
    List<User> userSelectAll();
}
