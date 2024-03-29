/*
 * @Author: Haotian Bai
 * @Github: https://github.com/164140757
 * @Date: 2020-05-09 11:54:52
 * @LastEditors: Haotian Bai
 * @LastEditTime: 2020-05-13 20:13:23
 * @FilePath: \PLO\src\main\java\Utils\Grammer\Grammar.java
 * @Description: 
 */
/*  @Author: Haotian Bai @Github: https://github.com/164140757 @Date: 2020-05-09
 *  11:54:52 @LastEditors: Haotian Bai @LastEditTime: 2020-05-09 21:09:40 @FileP
 * ath: \PLO\src\main\java\Utils\Grammer\Grammar.java @Description: Grammer clas
 * s for PLO

 */
package Utils.Grammer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Utils.Token.NonTerminal;
import Utils.Token.Terminal;

public class Grammar {
    List<Production> productions;
    NonTerminal startToken;
    public Grammar(NonTerminal startToken, List<Production> productions) {
        this.productions = productions;
        this.startToken = startToken;
    }
    /**
     * @return the productions map after connecting counterparts with the same index
     */
    public HashMap<NonTerminal,Production> getProductionsMap() {
        connectProductions();
        HashMap<NonTerminal,Production> res = new HashMap<>();
        productions.forEach(p->{
            res.put(p.index,p);
        });
        return res;
    }
     /**
     * @return the productions after connecting counterparts with the same index
     */
    public List<Production> getProductions() {
        connectProductions();
        return productions;
    }

    private void connectProductions() {
        List<Production> res = new ArrayList<>();
        // set to collect its index
        Set<NonTerminal> indexes = new HashSet<>();
        productions.forEach(p->{
            indexes.add(p.index);
        });
        // after grouping connect
        indexes.forEach(index->{
            Production pNew = new Production(index);
            productions.forEach(pt->{
                if(pt.index.equals(index)){
                    pNew.or(pt);
                }
            });
            res.add(pNew);
        });
        productions = res;
    }
    /**
     * @return the startToken
     */
    public NonTerminal getStartToken() {
        return startToken;
    }

    /**
     *
     * @return all nonTerminals in the grammar
     */
    public List < NonTerminal > getNonTerminals() {
        List<NonTerminal> res = new ArrayList<>();
        productions.forEach(pl -> {
            NonTerminal nt = (NonTerminal) pl.index;
            res.add(nt);
            
            pl.target.forEach(p->{
                p.forEach(t->{
                    if(t.type.equals("NonTerminal")){
                        res.add((NonTerminal) t);
                    }
                });
                
            });
        });
        return res;
    }

}