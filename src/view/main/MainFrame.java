/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.main;

/**
 *
 * @author majid
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final JButton buttonJenisVaksin;
    private final JButton buttonVaksin;
    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(400,500);
        this.setLayout(new FlowLayout());
        this.buttonJenisVaksin = new JButton("Jenis Vaksin");
        this.buttonVaksin = new JButton("Data Vaksinasi");
        this.add(buttonJenisVaksin);
        this.add(buttonVaksin);
    }
    
    public JButton getButtonJenisVaksin(){
        return buttonJenisVaksin;
    }
    
    public JButton getButtonVaksin(){
        return buttonVaksin;
    }
    
    public void addButtonJenisVaksinActionListener(ActionListener actionListener){
        buttonJenisVaksin.addActionListener(actionListener);
    }
    
    public void addButtonVaksinActionListener(ActionListener actionListener){
        buttonVaksin.addActionListener(actionListener);
    }

    public void showJenisVaksinFrame() {
    }

    public void showVaksinFrame() {
    }
}