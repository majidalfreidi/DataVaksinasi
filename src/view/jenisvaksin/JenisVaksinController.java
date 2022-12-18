/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.jenisvaksin;

/**
 *
 * @author majid
 */
import model.JenisVaksin; 
import module.DaoModule; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.List; 
import java.util.UUID;

public class JenisVaksinController {
    private final DaoModule daoModule;
    private final JenisVaksinFrame jenisVaksinFrame;
    public JenisVaksinController(DaoModule daoModule){
        this.daoModule = daoModule;
        jenisVaksinFrame = new JenisVaksinFrame();
        jenisVaksinFrame.addButtonSimpanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpan();
             }
        });
    }
    public void showJenisVaksinFrame() {
        List<JenisVaksin> jenisVaksinList = daoModule.getJenisVaksinDao().findAll();
        jenisVaksinFrame.populateTable(jenisVaksinList);
        jenisVaksinFrame.setVisible(true);
    }
    public void simpan(){
        String nama = this.jenisVaksinFrame.getNama();
        JenisVaksin jenisVaksin = new JenisVaksin();
        jenisVaksin.setId(UUID.randomUUID().toString());
        jenisVaksin.setNama(nama);
        this.jenisVaksinFrame.addJenisVaksin(jenisVaksin);
        daoModule.getJenisVaksinDao().insert(jenisVaksin);
    }
}
