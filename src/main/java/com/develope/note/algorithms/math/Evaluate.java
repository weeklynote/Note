package com.develope.note.algorithms.math;

import java.util.Stack;

/**
 * 模拟算术表达式求值过程
 */
public class Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        String exp = "(1 + ((2 + 3) * (4 * 5)))";
        int len = exp.length();
        for (int i = 0; i < len; i++){
            char s = exp.charAt(i);
            if ('(' == s || ' ' == s){
                continue;
            }
            if ('+' == s){
                ops.push("+");
            }else if ('-' == s){
                ops.push("-");
            }else if ('*' == s){
                ops.push("*");
            }else if ('/' == s){
                ops.push("/");
            }else if (')' == s){
                String op = ops.pop();
                double v = vals.pop();
                if ("+".equals(op)){
                    v = vals.pop() + v;
                }else if ("-".equals(op)){
                    v = vals.pop() - v;
                }else if ("*".equals(op)){
                    v = vals.pop() * v;
                }else if ("/".equals(op)){
                    v = vals.pop() / v;
                }
                vals.push(v);
            }else {
                vals.push(Double.parseDouble(String.valueOf(s)));
            }
        }
        System.out.println(vals.pop());
    }
}
