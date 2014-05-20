/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;


public class MySecurity {
    //-114x92x62x-93x125x-56x116x-8x
    
//    public static void main(String[] args) {
//        System.out.println(new MySecurity().decrypt("-106x-87x-103x-9x125x-21x112x118x"));
//    }
    private Cipher c;
    private SecretKey cretKey;
    private PBEParameterSpec para;
    private PBEKeySpec key;

    public MySecurity() {
        try {
            c = Cipher.getInstance("PBEWithMD5AndDES");
            
            byte[] bytes = {
                (byte) 0x11,
                (byte) 0xab,
                (byte) 0xab,
                (byte) 0xab,
                (byte) 0xab,
                (byte) 0xab,
                (byte) 0xab,
                (byte) 0xab
            };
            int loop = 60;
            para = new PBEParameterSpec(bytes, loop);
            
            char[] chars = {'L','A','M','J'};
            key = new PBEKeySpec(chars);
            
            SecretKeyFactory keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            cretKey = keyFac.generateSecret(key);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String crypt(String str) {
        try {
            c.init(Cipher.ENCRYPT_MODE, cretKey, para);
            byte[] bytesCrypt = c.doFinal(str.getBytes());
            
            String result = "";
            for(int i=0; i<bytesCrypt.length; i++){
                result += bytesCrypt[i]+"x";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String decrypt(String str){
        try{
            ArrayList<Byte> tmp = new ArrayList<Byte>();
            int flag = 0;
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)=='x'){
                    tmp.add(Byte.parseByte(str.substring(flag, i)));
                    flag = i+1;
                }
            }
            
            byte[] bytesCrypt = new byte[tmp.size()];
            for(int i=0; i<tmp.size(); i++){
                bytesCrypt[i] = tmp.get(i);
            }
            
            c.init(Cipher.DECRYPT_MODE, cretKey, para);
            byte[] bytesDecrypt = c.doFinal(bytesCrypt);
            
            return new String(bytesDecrypt);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
