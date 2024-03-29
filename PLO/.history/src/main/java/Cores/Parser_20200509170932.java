package Cores;
/*
 * @Author: Haotian Bai
 * @Github: https://github.com/164140757
 * @Date: 2020-05-09 12:16:24
 * @LastEditors: Haotian Bai
 * @LastEditTime: 2020-05-09 17:09:32
 * @FilePath: \PLO\src\main\java\Cores\Parser.java
 * @Description: Parser for syntax analysis in PLO using LL 
 */

import java.util.HashMap;
import java.util.Stack;

import Utils.Grammer.Grammer;
import Utils.Grammer.Production;
import Utils.Token.NonTerminal;
import ch.qos.logback.core.subst.Token;

public class Parser {
    Stack<NonTerminal> grammarStack;
    HashMap<Token,Production> parsingTable;
    
    public Parser(Grammer g) 
        grammarStack = new Stack<>();
        parsingTable = new HashMap<>();
        
    }

    Production parse(Token t){
        return parsingTable.get(t);
    }
}