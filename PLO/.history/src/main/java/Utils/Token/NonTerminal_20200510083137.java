/*
 * @Author: Haotian Bai
 * @Github: https://github.com/164140757
 * @Date: 2020-05-09 16:53:02
 * @LastEditors: Haotian Bai
 * @LastEditTime: 2020-05-10 08:31:37
 * @FilePath: \PLO\src\main\java\Utils\Token\NonTerminal.java
 * @Description: 
 */
package Utils.Token;

/**
 * NonTerminal
 */
public class NonTerminal extends Token {
    public NonTerminal(String letter){
        super("NonTerminal",letter);
    }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
      return super.equals(o);
  }
}