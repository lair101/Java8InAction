package com.guo.j8.nineChapter.searching;


import org.junit.jupiter.api.Test;

/**
 * 给一串阿拉伯数字，要输出对应的中文读法。
 * 例：
 * 输入：1030000.
 * 输出：一百零三万
 * <p>
 * 输入：301000010.
 * 输出：三亿零一百万零一十
 */
public class Word {

    /**
     * 数字 000 0000 0000
     * 中文  亿   千万  万
     * 数字不超过百亿， 就是说数字 不超过11位。 我们直接按12位算， 分割为三分
     *
     * @param num
     * @return
     */
    public String readNumber(int num) {

        StringBuilder sb = new StringBuilder();

        String nums = String.valueOf(num);

        int digits = nums.length();

        int index = 0;

        while(index < nums.length()){

            if(nums.charAt(index) == '0' && index > 0 && index < nums.length()){
                sb.append("零");
                while(nums.charAt(index) == '0'){
                    digits--;
                    index++;
                }
            }

            buildNumber(sb, digits, nums.charAt(index));
            index++;
            digits--;

        }
        return sb.toString();
    }

    private void buildNumber(StringBuilder sb, int digits, Character tmp) {
        switch (tmp) {
            case '0':
                sb.append("零");
                break;
            case '1':
                sb.append("一");
                break;
            case '2':
                sb.append("二");
                break;
            case '3':
                sb.append("三");
                break;
            case '4':
                sb.append("四");
                break;
            case '5':
                sb.append("五");
                break;
            case '6':
                sb.append("六");
                break;
            case '7':
                sb.append("七");
                break;
            case '8':
                sb.append("八");
                break;
            case '9':
                sb.append("九");
                break;
        }

        switch (digits) {
            case 12:
                sb.append("千亿");
                break;
            case 4:
                sb.append("千");
                break;
            case 3:
                sb.append("百");
                break;
            case 2:
                sb.append("十");
                break;
            case 1:
                sb.append("");
                break;
        }

    }

    @Test
    public void test1() {
        Word w = new Word();
        System.out.println(w.readNumber(1034));
    }
}
