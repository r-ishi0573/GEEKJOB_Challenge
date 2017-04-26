/*
  商品管理画面の入力エラーを保持するクラス
*/
package org.camp.chl13;

import java.io.Serializable;

public class ItemError implements Serializable {
    private String itemNameError = "";
    private String priceError = "";
    
    public String getINE() {
        return itemNameError;
    }
    
    public void setINE(String itemNameError) {
        this.itemNameError = itemNameError;
    }
    
    public String getPE() {
        return priceError;
    }
    
    public void setPE(String priceError) {
        this.priceError = priceError;
    }
    
}
