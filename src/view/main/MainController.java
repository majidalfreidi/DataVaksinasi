/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.main;

/**
 *
 * @author majid
 */
import module.DaoModule;
import view.jenisvaksin.JenisVaksinController;
import view.vaksin.VaksinController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private final MainFrame mainFrame;
    private final VaksinController vaksinController;
    private final JenisVaksinController jenisVaksinController;
    
    public MainController(){
        mainFrame = new MainFrame();
        DaoModule daoModule = new DaoModule();
        vaksinController = new VaksinController(daoModule);
        jenisVaksinController = new JenisVaksinController(daoModule);
        mainFrame.addButtonJenisVaksinActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showJenisVaksinFrame();
            }
        });
        mainFrame.addButtonVaksinActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showVaksinFrame();
            }
        });
    }
    
    public void showMainFrame(){
        this.mainFrame.setVisible(true);
    }
    
    public void showJenisVaksinFrame(){
        jenisVaksinController.showJenisVaksinFrame();
    }
    
    public void showVaksinFrame(){
        vaksinController.showVaksinFrame();
    }
}