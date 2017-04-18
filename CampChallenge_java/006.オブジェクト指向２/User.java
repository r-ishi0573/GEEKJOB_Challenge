/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.blj;


import java.util.*;
import org.camp.blj.Human;

public class User extends Human {
    
   public int open(ArrayList<String> cd) {
        int num = 0;
        for(String val : cd) {
            num += Integer.parseInt(val);
        }
        return num;
    }
    
    public void setCard(ArrayList<String> cd) {
        for(String val : cd) {
            myCards.add(val);
        }
    
    }
    
    public boolean checkSum(ArrayList<String> cd) {
        boolean flag;
        
        if(open(cd) < 17) {
            flag = true;
        }
        else {
            flag = false;
        }
        
        return flag;
    }
}
