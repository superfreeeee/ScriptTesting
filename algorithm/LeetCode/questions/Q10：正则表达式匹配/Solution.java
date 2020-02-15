import java.util.LinkedList;

import javax.management.RuntimeErrorException;

class Solution {
    public boolean isMatch(String s, String p) {
        parsePattern(p);
        printPattern();
        initConds();
        for(char c : s.toCharArray()) {
            System.out.println("meet " + c);
            LinkedList<Token> other = new LinkedList<>();
            for(int i=0,end=conds.size() ; i<end ; i++) {
                Token t = conds.poll();
                if(match(t, c)) {
                    addNext(other, t);
                }
            }
            conds = other;
            System.out.println(conds);
        }
        for(Token t : conds) {
            if(t.c == '$') {
                return true;
            }
        }
        return false;
    }

    private void addNext(LinkedList<Token> other, Token t) {
        if(t.mul) {
            addToken(other, t);
        }
        t = t.next;
        while(t.mul) {
            addToken(other, t);
            t = t.next;
        }
        addToken(other, t);
    }

    private void addToken(LinkedList<Token>other, Token t) {
        if(!other.contains(t)) {
            other.add(t);
        }
    }

    private void initConds() {
        conds = new LinkedList<>();
        Token t = pattern;
        while(t.mul) {
            conds.add(t);
            t = t.next;
        }
        conds.add(t);
        System.out.println(conds);
    }

    private void parsePattern(String p) {
        System.out.println("invoke parsePattern");
        Token head = new Token(' ');
        Token cur = head;
        for(char c : p.toCharArray()) {
            if(c == '*') {
                cur.mul = true;
            } else {
                cur.next = new Token(c);
                cur = cur.next;
            }
        }
        cur.next = new Token('$');
        this.pattern = head.next;
    }

    private boolean match(Token t, char c) {
        if(t == null) {
            return false;
        }
        if(t.c == '.') {
            return true;
        }
        return t.c == c;
    }

    LinkedList<Token> conds;
    Token pattern;
    
    private static class Token {
        static int counter = 0;
        int id;
        char c;
        boolean mul;
        Token next;
    
        Token(char c) {
            id = counter++;
            this.c = c;
        }

        @Override
        public String toString() {
            return "{id = " + id + ", c = " + c + ", mul = " + mul + "}";
        }
    }

    private void printPattern() {
        System.out.println("invoke printPattern");
        Token p = pattern;
        while(p != null) {
            System.out.println(p);
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aaa";
        String p = "ab*a*c*a";
        boolean result = sol.isMatch(s, p);
        System.out.println(result);
    }
}

