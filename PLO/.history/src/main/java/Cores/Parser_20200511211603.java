/*
 * @Author: Haotian Bai
 * @Github: https://github.com/164140757
 * @Date: 2020-05-09 12:16:24
 * @LastEditors: Haotian Bai
 * @LastEditTime: 2020-05-11 21:16:03
 * @FilePath: \PLO\src\main\java\Cores\Parser.java
 * @Description: 
 */
/*  @Author: Haotian Bai @Github: https://github.com/164140757 @Date: 2020-05-09
 *  12:16:24 @LastEditors: Haotian Bai @LastEditTime: 2020-05-11 19:13:38 @FileP
 * ath: \PLO\src\main\java\Cores\Parser.java @Description:

 */
package Cores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

import Utils.Grammer.Grammar;
import Utils.Grammer.Production;
import Utils.Token.NonTerminal;
import Utils.Token.Token;

public class Parser {
    
    // ready to analyse
    Stack<Token> stack;
    // predicting table
    HashMap<Token, Production> parsingTable;
    // grammar
    Grammar grammar;
    // map for first and follow
    HashMap<Token, Set<Token>> first;
    HashMap<Token, Set<Token>> follow;
    HashMap<NonTerminal, Production> productions;

    public Parser(Grammar grammar) {
        stack = new Stack<>();
        stack.add(new Token("Terminal", "#"));
        parsingTable = new HashMap<>();
        this.grammar = grammar;
        productions = grammar.getProductionsMap();
        first = new HashMap<>();
        follow = new HashMap<>();
    }

    Production parse(Token t) {
        return parsingTable.get(t);
    }
 /**
 * make sure their is no left recursion before using this class. 
 * @param t token to process
 */
   public void getFirst(Token t) {
        Set<Token> firstSet = new HashSet<>();
        // terminal itself
        if (isTer(t)) {
            firstSet.add(t);
        }
        else{
            // non terminal plus "#"
            Production production = productions.get(t);
            checkNonTerminal(production,firstSet,false);
            // add to first map
            first.put(t,firstSet);
        }
    }
/**
 * Recursively check NonTerminal t's targets, and find the NonTerminals and add.
 * @param production production to observe
 * @param firstSet results
 */
    private void checkNonTerminal(Production production,Set<Token> firstSet,boolean recursive) {
        // check target, all productions with the same index
        for (Vector<Token> tokens : production.target) {
            // check a certain production
            // prepare a temp set to 
            for (Token token : tokens) {
                // only A -> # 
                if(token.context.equals("#")){
                    // empty
                    firstSet.add(token);
                    // go on
                    continue;
                }
                // check every possible token for a given production
                if (isTer(token)) {
                    // the token deduces terminal add to firstSet
                    firstSet.add(token);
                    // then break the loop and check another production if there is one
                    break;
                } else {
                    // nonTerminal and cannot deduce empty
                    Production p_ = productions.get(token.toNonTerminal());
                    checkNonTerminal(p_,firstSet);
                }
            }
        }

    }

    boolean isTer(Token t) {
        return t.type != "NonTerminal";
    }

}