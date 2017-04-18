/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.blj;

import java.util.*;

abstract class Human {
    protected ArrayList<String> myCards = new ArrayList<String>();
    
    abstract public int open(ArrayList<String> cd);
    abstract public void setCard(ArrayList<String> cd);
    abstract public boolean checkSum(ArrayList<String> cd);
    
}
