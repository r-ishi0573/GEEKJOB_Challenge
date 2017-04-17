/*
 * 作成したクラス
 */

package org.camp.obj1;

import java.io.PrintWriter;

public class TestValue {
    public String valueA = "";
    public String valueB = "";
    
    public void setValue(String a, String b) {
        valueA = a;
        valueB = b;
    }
    
    public void printValue(PrintWriter out) {
        out.println(valueA);
        out.println(valueB);
    }
    
}
