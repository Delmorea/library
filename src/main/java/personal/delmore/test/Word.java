package personal.delmore.test;

/**
 * @projectName: IDEA-workspace
 * @package: personal.delmore.test
 * @className: Word
 * @author: Delmore
 * @description: TODO
 * @date: 2022/3/29 10:31
 * @version: 1.0
 */
public class Word {
    private int para;
    private int row;
    private int list;

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getList() {
        return list;
    }

    public void setList(int list) {this.list = list;}

    @Override
    public String toString() {
        return "Word{" +
                "para=" + para +
                ", row=" + row +
                ", list=" + list +
                '}';
    }
}
