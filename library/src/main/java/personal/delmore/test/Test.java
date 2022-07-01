package personal.delmore.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @projectName: IDEA-workspace
 * @package: personal.delmore.test
 * @className: Test
 * @author: Delmore
 * @description: 利用map对文章单词进行查询
 * @date: 2022/3/29 10:22
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\86176\\Desktop\\word.txt");                  //读取文件
        if (!file.exists()) {
            System.out.println("文件不存在");
        }
        Scanner scanner = new Scanner(file);
        Map<String, List<Word>> map = new HashMap<String, List<Word>>();
        //单词的坐标
        int i = 0, j = 0, k = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("  ")) {
                i++;
                j = k = 0;
                line = line.trim();
            }
            j++;
            String[] lineWords = line.split("[^\\w\\-]+");      //lineWords按顺序存储(\\W+)
            for (String lineWord : lineWords) {
                List<Word> words;
                k++;
                Word word = new Word();
                word.setPara(i);
                word.setRow(j);
                word.setList(k);
                if (map.containsKey(lineWord)) {
                    words = map.get(lineWord);
                } else {
                    words = new ArrayList<>();
                }
                words.add(word);
//                System.out.println(words);
                map.put(lineWord, words);
            }
        }
        while (true) {
            System.out.println("您所需查找的单词是:");
            Scanner sc = new Scanner(System.in);
            String string = sc.next();
            List<Word> words = map.get(string);
            System.out.println("单词所在位置:");
            for (Word word : words)
                System.out.println("para= " + word.getPara() + ",row= " + word.getRow() + ",list= " + word.getList());
            System.out.println("单词出现的次数:" + words.size());
        }
    /*    Set<String> wordSet = map.keySet();输出所有的键值对
        Iterator<String> it = wordSet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            List<Word> words = map.get(key);
            System.out.println("key=" + key + " value=" + words);
        }*/
    }
}