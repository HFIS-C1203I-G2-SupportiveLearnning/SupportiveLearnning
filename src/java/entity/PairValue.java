/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class PairValue {
    private String value1;
    private String value2;

    public PairValue() {
    }

    public PairValue(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
    
    
}
