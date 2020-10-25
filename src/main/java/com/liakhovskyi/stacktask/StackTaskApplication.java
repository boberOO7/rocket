package com.liakhovskyi.stacktask;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Stack;

public class StackTaskApplication {

    private final Map<Character, Character> OPPOSITE_CHAR = ImmutableMap.of(
            ')', '(',
            ']', '[',
            '}', '{');

    public boolean checkBracketsWithStack(String inputString) {
        Stack<Character> characters = new Stack<>();

        if (inputString == null || inputString.isEmpty()) {
            return false;
        }

        for (int i = 0; i < inputString.length(); i++) {
            char symbol = inputString.charAt(i);

            if (symbol == '(' || symbol == '{' || symbol == '[') {
                characters.push(symbol);
                continue;
            }

            if (isStackEmpty(characters)) {
                return false;
            }

            if (!checkCloseBracket(symbol, characters)) {
                return false;
            }
        }

        return isStackEmpty(characters);
    }

    public boolean checkBracketsWithoutStack(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return false;
        }

        while (!inputString.isEmpty()) {
            String temp = inputString;
            inputString = inputString.replaceAll("\\(\\)|\\[]|\\{}", "");

            if (inputString.length() == temp.length()) {
                break;
            }
        }
        return inputString.isEmpty();
    }

    private boolean checkCloseBracket(char symbol, Stack<Character> characters) {
        char lastSymbol = characters.pop();
        return lastSymbol == OPPOSITE_CHAR.get(symbol);
    }

    private boolean isStackEmpty(Stack<Character> characters) {
        return characters.isEmpty();
    }
}
