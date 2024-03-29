/*
 * @Author: Haotian Bai
 * @Github: https://github.com/164140757
 * @Date: 2020-04-19 16:16:38
 * @LastEditors: Haotian Bai
 * @LastEditTime: 2020-05-09 17:36:55
 * @FilePath: \PLO\src\main\java\Utils\Token\Del.java
 * @Description: 
 */
package Utils.Token;

import java.util.Arrays;
import java.util.HashSet;

public class Del extends Terminal{
    private static HashSet<Character> del;
    public Del(String context) {
        super("Del");
    }
    public static void init(){
        del = new HashSet<>();
        del.addAll(Arrays.asList('（','）','，',',','；','.','(',')',';'));
    }
    public static boolean isDel(Character c){
        return del.contains(c);
    }
}
