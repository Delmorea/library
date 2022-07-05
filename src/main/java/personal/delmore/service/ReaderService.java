package personal.delmore.service;

import personal.delmore.entity.Reader;
import personal.delmore.entity.User;

public interface ReaderService {


    /**
     * @param reader:
     * @return void
     * @author 86176
     * @description 数量
     * @date 2022/5/4 17:29
     */
    void updateReader(Reader reader);

    /**
     * @param :reader
     * @return void
     * @author 86176
     * @description 修改密码
     * @date 2022/4/27 23:59
     */
    void updateInform(Reader reader);

    /**
     * @param :user
     * @return boolean
     * @author 86176
     * @description 判断用户名是否能注册(在reader表中查询是否有此userName)
     * @date 2022/3/25 20:16
     */
    boolean adjustUsername(User user);

    /**
     * @param : reader
     * @return Reader
     * @author 86176
     * @description 通过userName查询reader, 用于向前端返回reader信息
     * @date 2022/4/27 16:12
     */
    Reader findReader(User user);

    /**
     * @param :
     * @param :
     * @return boolean
     * @author 86176
     * @description 通过用户名与姓名的一一对应来赋予修改密码的权限
     * @date 2022/4/27 16:32
     */
    boolean adjustReader(User user, Reader reader);

    /**
     * @param :
     * @return int
     * @author 86176
     * @description 获取reader的可借天数与时间
     * @date 2022/4/29 8:33
     */
    int getLendQty(Reader reader);

    int getLendDay(Reader reader);
}
