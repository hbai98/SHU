/*  @Author: Haotian Bai @Github: https://github.com/164140757 @Date: 2020-05-09
 *  11:58:44 @LastEditors: Haotian Bai @LastEditTime: 2020-05-10 12:00:30 @FileP
 * ath: \PLO\src\main\java\Utils\Grammer\Production.java @Description:

 */

package Utils.Grammer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Utils.Token.NonTerminal;
import Utils.Token.Token;

public class Production {
    public NonTerminal index;
    public List<Vector<Token>> target;
    // index --> aAb...
    public Production(NonTerminal index, List<Vector<Token>> target) {
        this.index = index;
        this.target = target;
    }
    public Production(NonTerminal index, Vector<Token> target) {
        this.index = index;
        this.target = Collections.singletonList(target);
    }
    public Production(NonTerminal index) {
        this.index = index;
    }
    public Production(String index) {
        this.index = new NonTerminal(index);
    }
    /**
     * A -> BMsf  no '|'
     */
    public Production(String index, String target) {
        this.index = new NonTerminal(index);
        List<Vector<Token>> res = new ArrayList<>();
        char[] charArray = target.toCharArray();
        Vector<Token> tmp = new Vector<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            tmp.add(new Token(String.valueOf(c)));
        }
        res.add(tmp);
        this.target = res;
    }
    /**
     * @description: define grammar, # means empty set
     * @param productions String representation of the productions, like "A BaMC;M Bd; B #"
     * @return:
     */
    static List<Production> translate(String productions)throws Exception {
        List<Production> res = new ArrayList<>();
        Pattern p = Pattern.compile(".*;");
        Matcher matcher = p.matcher(productions);
        // check input format is right
        if (!matcher.find()) {
            throw new Exception("Your grammar input format is not valid.");
        }
        while (matcher.find()) {
            String[] splits = matcher
                .group()
                .split("\\s*");
            String index = splits[0];
            String target = splits[1].split(";")[0];
            char[] charArray = target.toCharArray();
            Production production = new Production(new NonTerminal(index));
            Vector<Token> toAdd = new Vector<>();
            for (char c : charArray) {
                switch (c) {
                        // handle operator

                    case '+' -> {}
                    case '-' -> {}
                    case '*' -> {}
                    case '/' -> {}
                        // empty set
                    case '#' -> {
                            Vector<Token> tmp = new Vector<>();
                            tmp.add(new Token("#"));
                            Production pt = new Production(new NonTerminal(index), tmp);
                            production.or(pt);
                        }
                        // or
                    case '|' - > {
                            Production pt = new Production(new NonTerminal(index), toAdd);
                            production.or(pt);
                            toAdd = new Vector<>();
                        }

                    default -> {
                            toAdd.add(new Token(String.valueOf(c)));
                        }
                }

            }

            res.add(production);
        }

        return res;
    }

    public boolean or(Production p) {
        // same index
        assert this
            .index
            .equals(p.index);
        return target.addAll(p.target);
    }

    public Production or(char c) {
        Token t = new Token(String.valueOf(c));
        Vector<Token> nv = new Vector<>();
        nv.add(t);
        target.add(nv);
        return this;
    }
}
