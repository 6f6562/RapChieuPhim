/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datve;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JToggleButton;
/**
 *
 * @author Admin
 */
public class Doimaughe extends JToggleButton{
    public void paintComponent(Graphics g){
        Color bg , selected;
        
        if(isSelected()){
            bg = Color.decode("#A9C1F1");
            selected = Color.decode("#FFFFFF");
        }
        else{
           bg = Color.decode("#000");
           selected = Color.decode("#FFFFFF");
    }
        setBackground(bg);
        setForeground(selected);
        super.paintComponent(g);
}

}