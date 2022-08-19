package main;
//Задание 4.
//Дана скобочная последовательность: [((())()(())]]
//        - Можно ли считать эту последовательность правильной?
//        - Если ответ на предыдущий вопрос “нет” - то что необходимо в ней изменить, чтоб она стала правильной?

import java.util.Stack;

public class Parentheses {

    private static Stack<Character> stack;
    private static int badIndex;

    public static void main(String[] args) {
        String s = "[((())()(())]]";
        System.out.println("Можно ли считать эту последовательность правильной?");
        boolean isValid = isValid(s);
        System.out.println(isValid ? "ДА" : "НЕТ");
        if (!isValid) {
            System.out.println("Что необходимо в ней изменить, чтоб она стала правильной?");
            if (!stack.empty()) {
                char ch = stack.peek();
                System.out.println("Заменить элемент с индексом " + badIndex +
                        " (нумерация начинается с 0) c \"" +
                        s.charAt(badIndex) + "\" на \"" + exchange(ch) + "\"");
            }
        }
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
        stack = new Stack<>();
        badIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[') stack.push(ch);
            else {
                char sch;
                if (!stack.empty()) sch = stack.pop();
                else return false;
                if ((sch == '(' && ch != ')') || (sch == '[' && ch != ']')) {
                    badIndex = i;
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static char exchange(char ch) {
        return ch == '(' ? ']' : ')';
    }
}
