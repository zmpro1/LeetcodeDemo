package zm.leetcode.L13romantoInt;

import java.util.HashMap;
import java.util.Map;

/**
 * 13.罗马数字转整数 https://leetcode.cn/problems/roman-to-integer/
 */

public class RomanToIntMain {
    Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt_official(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = map.get(s.charAt(i));
            if (i < n - 1 && value < map.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    //小数据量map不占优势，可以使用switch
    public int romanToInt_others(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }



    public int romanToInt(String s) {
        char last = 'M';
        int sum = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            sum += map.get(c);
            if (map.get(c) > map.get(last))
                sum-= 2*map.get(last);
            last = c;
        }
        return sum;
    }


    public static void main(String[] args) {
        RomanToIntMain romanToIntMain = new RomanToIntMain();
        int i = romanToIntMain.romanToInt("LVIII");
        System.out.println(i);
    }
}
