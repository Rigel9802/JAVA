/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package coretam;

/**
 *
 * @author Lucky
 */
public class Sambungkata {
    public static void main(String[] args) {
        String username = "lukcy";
        String password = "lucky";
        
        String sql = "UPDATE data_user SET username='["+ username +"]' WHERE " + 3;
        System.out.println(sql);
    }
}
