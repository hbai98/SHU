/*
 * @Author: Haotian Bai
 * @Date: 2020-05-07 16:20:20
 * @LastEditTime: 2020-05-09 16:47:37
 * @LastEditors: Haotian Bai
 * @Description: NonTerminal in production
 * @FilePath: \PLO\src\main\java\Utils\Token\NonTerminal.java
 */
package Utils.Token;

import Utils.Grammer.Production;

/**
 * NonTerminal
 */
public class NonTerminal extends Token{
    Production production;
    public NonTerminal(Production production){
        super("NonTerminal");
        this.production = production;
    }
    
    
}