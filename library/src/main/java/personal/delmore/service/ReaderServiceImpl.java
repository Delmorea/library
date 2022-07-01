package personal.delmore.service;

import personal.delmore.dao.RdTypeDao;
import personal.delmore.dao.RdTypeDaoImpl;
import personal.delmore.dao.ReaderDao;
import personal.delmore.dao.ReaderDaoImpl;
import personal.delmore.entity.Reader;
import personal.delmore.entity.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: IDEA-workspace
 * @package: personal.delmore.service
 * @className: ReaderService
 * @author: Delmore
 * @description: TODO
 * @date: 2022/3/25 12:56
 * @version: 1.0
 */
public class ReaderServiceImpl implements ReaderService {

    private final ReaderDao readerDao = new ReaderDaoImpl();
    private final RdTypeDao rdTypeDao = new RdTypeDaoImpl();

    public ReaderServiceImpl(){}

    //增删改查
    public void addReader(Reader reader){ readerDao.readerAdd(reader); }
    public void deleteReader(Reader reader){ readerDao.readerDelete(reader); }
    public void updateReader(Reader reader){readerDao.readerUpdate(reader);}


    //判断用户名是否存在
    public boolean adjustUsername(User user){
        List<Reader> list = readerDao.readerSelectAll();
        boolean flag = false;
        List<String> userName = list.stream().map(Reader::getUserName).collect(Collectors.toList());
        flag = userName.contains(user.getUserName());
        return flag;
    }

    //通过userName查询reader
    public Reader findReader(User user){
        List<Reader> list = readerDao.readerSelectAll();
        boolean flag = false;
        List<String> userName = list.stream().map(Reader::getUserName).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if (userName.get(i).equals(user.getUserName())) {
                return (Reader) list.get(i);
            }
        }
        return null;
    }

    //通过用户名与姓名的一一对应来赋予修改密码与QQ的权限
    public boolean adjustReader(User user, Reader reader){
        List<Reader> list = readerDao.readerSelectAll();
        List<String> userName = list.stream().map(Reader::getUserName).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if (userName.get(i).equals(user.getUserName())) {
                Reader rder = (Reader) list.get(i);
                if (rder.getRdName().equals(reader.getRdName())) {
                    return true;
                }
            }
        }
        return false;
    }
    //修改密码与QQ
    public void updateInform(Reader reader){
        List<Reader> list = readerDao.readerSelectAll();
        List<String> userName = list.stream().map(Reader::getUserName).collect(Collectors.toList());
        for(int i=0;i<list.size();i++){
            if (reader.getUserName().equals(userName.get(i))){
                Reader rder=(Reader)list.get(i);
                rder.setRdQQ(reader.getRdQQ());
                readerDao.readerUpdate(rder);
            }
        }
    }
    //识别读者类别。并且返回可借书的数量与天数
    public int getLendQty(Reader reader) {
        return rdTypeDao.getLendQty(reader);
    }

    public int getLendDay(Reader reader) {
        return rdTypeDao.getLendDay(reader);
    }

}
