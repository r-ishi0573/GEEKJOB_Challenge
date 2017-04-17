/*
 * 課題「クラスの作成」で作成したクラス
 */

package org.camp.obj;

import java.io.PrintWriter;

public class TestValue {
    public String valueA = "";
    public String valueB = "";
    
    public void setValue(String a, String b) {
        valueA = a;
        valueB = b;
    }
    
    public void printValue(PrintWriter out) {
        out.print(valueA);
        out.print(" , ");
        out.print(valueB);
    }
    
}
