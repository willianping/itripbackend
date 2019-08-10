package cn.itrip.common;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.apache.log4j.Logger;

/**
 * 汉字转拼音的工具类
 */
public class ChineseToEnglish {

    static Logger logger = Logger.getLogger(ChineseToEnglish.class);
    static StringBuilder py = new StringBuilder();

    public static String getPinYin(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = word.charAt(i);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c);
            py.append(pinyinArray[0].substring(0, pinyinArray[0].length() - 1));
            logger.debug("word:" + word + " pingyin:" + py.toString());
        }
        return py.toString();
    }

    public static void main(String args[]) {
        String result = getPinYin("我爱你们");
        System.out.println(result);
    }
}