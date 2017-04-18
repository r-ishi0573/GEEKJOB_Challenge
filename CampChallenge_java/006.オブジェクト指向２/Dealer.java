/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.blj;


import java.util.*;
import org.camp.blj.Human;

public class Dealer extends Human {
    
    private ArrayList<String> cards = new ArrayList<String>();
    
    Dealer() {
        cards = new ArrayList<>(Arrays.asList(
                "1","2","3","4","5","6","7","8","9","10","10","10","10",
                "1","2","3","4","5","6","7","8","9","10","10","10","10",
                "1","2","3","4","5","6","7","8","9","10","10","10","10",
                "1","2","3","4","5","6","7","8","9","10","10","10","10"));
        //cards.add("a");
    }
    
    public ArrayList<String> deal() {
        //リターン用配列
        ArrayList<String> temp = new ArrayList<String>();
        
        //乱数取得
        Random rand = new Random();
        int index = rand.nextInt(cards.size());
        
        temp.add(cards.get(index)); //カードからランダムにひとつ選びリターン用配列に追加
        cards.remove(index); //選んだカードを除外
        
        index = rand.nextInt(cards.size()); //カード選択2回目
        temp.add(cards.get(index));
        cards.remove(index);
        
        return temp;
    } 
    
    public ArrayList<String> hit() {
        //リターン用配列
        ArrayList<String> temp = new ArrayList<String>();
        
        //乱数取得
        Random rand = new Random();
        int index = rand.nextInt(cards.size());
        
        temp.add(cards.get(index)); //カードからランダムにひとつ選びリターン用配列に追加
        cards.remove(index); //選んだカードを除外
        
        return temp;
    }
    
    //テスト用表示メソッド
    //public String tes(int i) {
    //    return cards.get(i);
    //}
    
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
