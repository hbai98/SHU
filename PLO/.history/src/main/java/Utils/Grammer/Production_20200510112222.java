/*
 * @Author: Haotian Bai
 * @Github: https://github.com/164140757
 * @Date: 2020-05-09 11:58:44
 * @LastEditors: Haotian Bai
 * @LastEditTime: 2020-05-10 11:22:21
 * @FilePath: \PLO\src\main\java\Utils\Grammer\Production.java
 * @Description: 
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
    /**
     * @description: # means empty set
     * @param productions String representation of the productions, like "A BaMC;M Bd; B #" 
     * @return: 
     */
    List<Production> translate(String productions) throws Exception {
        List<Production> res = new ArrayList<>();
        Pattern p = Pattern.compile(".*;");
        Matcher matcher = p.matcher(productions);
        // check input format is right
        if (!matcher.find()) {
            throw new Exception("Your input is not valid.");
        }
        while(matcher.find()){
            String[] splits = matcher.group().split("\\s*");
            String index = splits[0];
            String target = splits[1].split(";")[0];
            char[] charArray = target.toCharArray();
            Production production = new Production(new NonTerminal(index));
            Vector<Token> toAdd = new Vector<>();
            for (char c : charArray) {
                // empty set 
                if(c=='#'){
                    Production pt = new Production(new NonTerminal(index), new Vector<Token>());
                    production.or(pt);
                }
                // or 
                if(c=='|'){
                    Production pt = new Production(new NonTerminal(index), toAdd);
                    production.or(pt);
                    toAdd = new Vector<>();       
                }
                toAdd.add(new Token(String.valueOf(c)));
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
}
