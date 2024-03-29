/*
 * @Author: Haotian Bai
 * @Github: https://github.com/164140757
 * @Date: 2020-04-12 14:12:33
 * @LastEditors: Haotian Bai
 * @LastEditTime: 2020-05-22 15:28:52
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
    public String sign;
    public String type;
    public Token(String type,String sign) {
        this.type = type;
        this.sign = sign;
    }

    public Token (String letter) {
        this.sign = letter;
    }
    public NonTerminal toNonTerminal(){
        return new NonTerminal(sign);
    }

    public Terminal toTerminal(){
        
    }
    // same if letter equals with o
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Token token = (Token) o;
        return this
            .sign
            .equals(token.sign);
    }
    @Override public int hashCode() {
        return Objects.hash(this.sign);
    }
}
