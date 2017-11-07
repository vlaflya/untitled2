package com.company;

import java.util.Stack;

public class rRN {
    //ctan = f
    //sin = s
    //cos = c
    //tan = t
    //ln = n
    //lg = g
       public static String Transform(String input){
        String output = "";
        Stack<Character> stack = new Stack<>();
        for(int i= 0;i<input.length();){
            if(Character.isDigit(input.charAt(i))){
                try {
                while (Character.isDigit(input.charAt(i))){
                    output += input.charAt(i);
                    i++;
                }}
                catch (Throwable e){}
                output += " ";
            }
            else if(stack.size() == 0){
                if(!rRN.isPer(input.charAt(i))){
                    String scn = "";
                    while (!rRN.isPer(input.charAt(i)) && !Character.isDigit(input.charAt(i))){
                        scn += input.charAt(i);
                        i++;
                    }
                    stack.push(rRN.toChar(scn));
                }
                else{
                    stack.push(input.charAt(i));
                    i++;
                }
            }
            else{
                if(!rRN.isPer(input.charAt(i))){
                    String scn = "";
                    Character sc = '0';
                    while (!rRN.isPer(input.charAt(i)) && !Character.isDigit(input.charAt(i))){
                        scn += input.charAt(i);
                        i++;
                    }
                    sc = rRN.toChar(scn);
                    if(rRN.Prior(sc) < rRN.Prior(stack.peek())){
                        output += stack.peek() + " ";
                        stack.pop();
                        stack.push(sc);
                        //i++;
                    }
                    else {
                        stack.push(sc);
                        //i++;
                    }
                }
                else{
                    Character sc = input.charAt(i);
                    if(rRN.Prior(sc) < rRN.Prior(stack.peek())){
                        output += stack.peek() + " ";
                        stack.pop();
                        stack.push(sc);
                        i++;
                    }

                    else {
                        //System.out.println(output);
                        stack.push(sc);
                        i++;
                    }
                }
            }
        }
        int o = stack.size();
        for(int i = 0;i < o;i++){
            if(stack.peek() != '(' && stack.peek() != ')'){
            output += stack.peek() + " ";
            stack.pop();}
            else
            stack.pop();
        }
        return output;
       }
    private static char toChar(String input){
        switch (input){
            case "(": return '(';
            case ")": return ')';
            case "+": return  '+';
            case "-": return '-';
            case "*": return '*';
            case "/": return '/';
            case "^": return '^';
            case "ln":return 'n';
            case "lg":return 'g';
            case "cos":return 'c';
            case "sin":return 's';
            case "tan":return 't';
            case "ctan":return 'f';
            default: return 'o';
        }
    }
    private static byte Prior(Character input){
           switch (input){
               case '(': return 0;
               case ')': return 0;
               case '+': return  1;
               case '-': return 1;
               case '*': return 2;
               case '/': return 2;
               case '^': return 3;
               case 'n':return 4;
               case 'g':return 4;
               case 'c':return 4;
               case 's':return 4;
               case 't':return 4;
               case 'f':return 4;
               default: return 5;
           }
       }
    private static boolean isPer(Character input) {
        switch (input) {
            case '(':
                return true;
            case ')':
                return true;
            case '+':
                return true;
            case '-':
                return true;
            case '*':
                return true;
            case '/':
                return true;
            case '^':
                return true;
            default: return false;
        }
    }
}
