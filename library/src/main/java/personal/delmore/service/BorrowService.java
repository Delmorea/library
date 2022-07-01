package personal.delmore.service;

import personal.delmore.entity.Borrow;
import personal.delmore.entity.Reader;
import personal.delmore.entity.User;

import java.util.List;

public interface BorrowService {
    /**
     * @return void
     * @param: borrow
     * @author 86176
     * @description 对借阅记录的增删改查
     * @date 2022/3/26 17:31
     */
    void addBorrow(Borrow borrow);

    void deleteBorrow(Borrow borrow);

    void updateBorrow(Borrow borrow);

    List<Borrow> selectAllBorrow();

    /**
     * @param :
     * @return
     * @author 86176
     * @description TODO
     * @date 2022/4/28 9:20
     */
    List<Borrow> getRecord(User user);

    /**
     * @param borrow:
     * @return void
     * @author 86176
     * @description 添加还书时间
     * @date 2022/5/6 10:19
     */
    void updateLendAct(Borrow borrow);
}