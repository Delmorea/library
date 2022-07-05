package personal.delmore.service;

import personal.delmore.entity.User;

public interface UserService {
    /**
     * @param :user
     * @return boolean
     * @author 86176
     * @description :判断账户密码是否存在(登录验证)，1为存在，0反之
     * @date 2022/3/24 19:27
     */
    boolean adjustUser(User user);

    /**
     * @param :user
     * @return boolean
     * @author 86176
     * @description 判断此用户名是否已存在(注册验证)
     * @date 2022/3/24 19:26
     */
    boolean adjustId(User user);

    /**
     * @param :user
     * @return void
     * @author 86176
     * @description 注册（增），用户修改信息（改）
     * @date 2022/3/24 19:30
     */
    void addUser(User user);

    void updateUser(User user);

}
