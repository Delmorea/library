package personal.delmore.dao;

import personal.delmore.entity.Reader;

public interface RdTypeDao {
    /**
     * @param :reader
     * @return int
     * @author 86176
     * @description 获取可借数量与天数，用于判断用户借书权限
     * @date 2022/3/26 18:34
     */
    int getLendQty(Reader reader);

    int getLendDay(Reader reader);
}
