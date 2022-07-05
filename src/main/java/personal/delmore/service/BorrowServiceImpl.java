package personal.delmore.service;

import personal.delmore.dao.*;
import personal.delmore.entity.Borrow;
import personal.delmore.entity.Reader;
import personal.delmore.entity.User;
import personal.delmore.utils.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: IDEA-workspace
 * @package: personal.delmore.service
 * @className: BorrowService
 * @author: Eric
 * @description: 对借阅记录进行增删改查
 * @date: 2022/3/24 19:24
 * @version: 1.0
 */
public class BorrowServiceImpl implements BorrowService {

    private final BorrowDao borrowDao = new BorrowDaoImpl();
    List<Borrow> list = selectAllBorrow();

    //对借阅记录进行增删改查
    public void addBorrow(Borrow borrow) {
        borrowDao.borrowAdd(borrow);
    }

    public void deleteBorrow(Borrow borrow) {
        borrowDao.borrowDelete(borrow);
    }

    public void updateBorrow(Borrow borrow) {
        borrowDao.borrowUpdate(borrow);
    }

    public List<Borrow> selectAllBorrow() {
        return borrowDao.borrowSelectAll();
    }


    public void updateLendAct(Borrow borrow) {
        for (int i = 0; i < list.size(); i++) {
            if (borrow.equals(list.get(i))) {
                Date date = new Date();
                String dateLendAct = StringUtils.getDateString(date);
                borrow.setDateLendAct(dateLendAct);
                updateBorrow(borrow);
            }
        }
    }


    //获取借阅记录
    public List<Borrow> getRecord(User user) {
        List<Borrow> records = new ArrayList<>();
        List<String> userName = list.stream().map(Borrow::getUserName).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if (user.getUserName().equals(userName.get(i))) {
                records.add(list.get(i));
            }
        }
        return records;
    }
}
