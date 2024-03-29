/*
 * @Author: Haotian Bai
 * @Github: https://github.com/164140757
 * @Date: 2020-04-12 14:12:33
 * @LastEditors: Haotian Bai
 * @LastEditTime: 2020-05-10 10:20:36
 * @FilePath: \PLO\src\main\java\Utils\Token\Token.java
 * @Description: 
 */
/*  @Author: Haotian Bai @Github: https://github.com/164140757 @Date: 2020-04-12
 *  14:12:33 @LastEditors: Haotian Bai @LastEditTime: 2020-05-10 08:46:48 @FileP
 * ath: \PLO\src\main\java\Utils\Token\Token.java @Description:

 */

package Utils.Token;

import java.util.Objects;

public class Token {
    public String context;
    public final String type;
    public Token(String type, String letter) {
        this.type = type;
        this.context = letter;
    }
    public Token(){
        
    }
    // same if letter equals with o
    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NonTerminal nonTerminal = (NonTerminal)o;
        return this
            .context
            .equals(nonTerminal.context);
    }
    @Override public int hashCode() {
        return Objects.hash(this.context);
    }
}
