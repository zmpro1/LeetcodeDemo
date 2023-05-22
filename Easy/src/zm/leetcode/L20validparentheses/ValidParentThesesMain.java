package zm.leetcode.L20validparentheses;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. 有效的括号  https://leetcode.cn/problems/valid-parentheses/
 */
public class ValidParentThesesMain {

    public boolean isValid(String s) {
        if ((s.length() & 1) != 0)
            return false;
        Deque<Character> list = new LinkedList<>();
        for (int i = 0 ; i < s.length() ; i++) {
            Character c = s.charAt(i);
            if (getLeft(c) == 'n')
                list.push(c);
            else {
                if (getLeft(c) != list.peek())
                    return false;
                else
                    list.pop();
            }
        }
        if (list.isEmpty())
            return true;
        return false;
    }

    public Character getLeft(Character character) {
        switch (character) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
        }
        return 'n';
    }

    public boolean isValid_Official(String s) {

        return true;
    }

    public static void main(String[] args) {
        String s = "{{";
        ValidParentThesesMain main = new ValidParentThesesMain();
        System.out.println(main.isValid(s));
    }
}
