/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class StudentObj {
    private String rollNo;
    private String password;
    private String fullName;
    private String email;
    private String classname;
    private String address;
    private float mark;
    private String strMark;
    private int submitted;
    private int pass;

    public StudentObj() {
    }

    public StudentObj(String rollNo, String password, String fullName, String email, String classname, String address) {
        this.rollNo = rollNo;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.classname = classname;
        this.address = address;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public String getStrMark() {
        return strMark;
    }

    public void setStrMark(String strMark) {
        this.strMark = strMark;
    }

    public int getSubmitted() {
        return submitted;
    }

    public void setSubmitted(int submitted) {
        this.submitted = submitted;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    
    
}
