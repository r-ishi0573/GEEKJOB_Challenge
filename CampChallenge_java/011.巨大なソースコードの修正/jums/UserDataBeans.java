/**
 * 課題3のソース修正
 * フォームから受け取った情報を保持するJavaBeans
 * 直リンク防止用の制御変数も保持すす
 */

package jums;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

public class UserDataBeans implements Serializable{
    private int isAccess; //直リンク防止用の変数
    private String name;
    private String year;
    private String month;
    private String day;
    private String type;  //InsertResultでint型に変換するのでこちらはStirng型
    private String tell;
    private String comment;
    
    public UserDataBeans() {
        
    }
    
    public int getIsAccess() {
        return isAccess;
    }
    
    public void setIsAccess(int isAccess) {
        this.isAccess = isAccess;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getYear(){
        return year;
    }
    public void setYear(String year){
        this.year = year;
    }
    
    public String getMonth(){
        return month;
    }
    public void setMonth(String month){
        this.month = month;
    }
    
    public String getDay(){
        return day;
    }
    public void setDay(String day){
        this.day = day;
    }
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
}
