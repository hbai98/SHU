/*
 * @Author: Haotian Bai
 * @Github: https://github.com/164140757
 * @Date: 2020-05-09 11:58:44
 * @LastEditors: Haotian Bai
 * @LastEditTime: 2020-05-10 10:02:25
 * @FilePath: \PLO\src\main\java\Utils\Grammer\Production.java
 * @Description: 
 */
/*  @Author: Haotian Bai @Github: https://github.com/164140757 @Date: 2020-05-09
 *  11:58:44 @LastEditors: Haotian Bai @LastEdPitTime: 2020-05-09 18:06:30 @FileP
 * ath: \PLO\src\main\java\Utils\Grammer\Production.java @Description: Productio
 * n in Grammer

 */
package Utils.Grammer;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
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

    List<Production> translate(String... productions){
        List<Production> res = new ArrayList<>();
        Pattern p = Pattern.compile("[a-zA-Z]\\s*[a-zA-Z]*;");
        productions.for 
        Matcher matcher = p.matcher(s);
        if (!matcher.find()) {
            throw new Exception("Your input is not valid.");
        }
        functions = new HashSet<>();     
        return null;
    }
    
    public boolean or(Production p) {
        // same index
        assert this.index.equals(p.index);
        return target.addAll(p.target);
    }
}
