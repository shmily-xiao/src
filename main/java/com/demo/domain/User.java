package com.demo.domain;
import java.util.List;
import java.util.Objects;

/**
 * Created by YB on 2015/5/21.
 */
public class User {

    private String id;   //用户的ID
    private String name;  //用户的名字
    private int salt; //每个用户的随机值
    private String password;  //密码
    private boolean specialRoot;  //是否具有特殊的权限

    private List<Detail> detail;  //和detail是一对多的关系
    public int getSalt() {
        return salt;
    }

    public void setSalt(int salt) {
        this.salt = salt;
    }

    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }

    public User() {

    }

    public boolean isSpecialRoot() {
        return specialRoot;
    }

    public void setSpecialRoot(boolean specialRoot) {
        this.specialRoot = specialRoot;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String id, String name, String password, boolean specialRoot) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.specialRoot = specialRoot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return getClass().getName() + "[id=" + id + ",name=" + name + ",password=" + password +"]";
    }

    public int hashCode(){
        return Objects.hash(id,name,password);
    }

    public boolean equals(Object otherObject){
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;
        User other = (User)otherObject;
        return Objects.equals(id,other.id) && name == other.name &&
                Objects.equals(password,other.password);
    }

}
