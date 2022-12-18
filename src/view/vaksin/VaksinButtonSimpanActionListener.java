/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.vaksin;

/**
 *
 * @author majid
 */
import java.awt.event.*;
import java.util.UUID;
import model.*;
import dao.VaksinDao;

public class VaksinButtonSimpanActionListener implements ActionListener {
    private VaksinFrame vaksinFrame;
    private VaksinDao vaksinDao;

    public VaksinButtonSimpanActionListener(VaksinFrame vaksinFrame, VaksinDao vaksinDao){
        this.vaksinFrame = vaksinFrame;
        this.vaksinDao = vaksinDao;
    }

    
    @Override
    public void actionPerformed(ActionEvent e){
        String nama = this.vaksinFrame.getNama();
        String noTelp = this.vaksinFrame.getNoTelp();
        String vaksinKe = this.vaksinFrame.getVaksinKe();
        if (nama.isEmpty()){
            this.vaksinFrame.showAlert("Nama tidak boleh kosong");
        } if (noTelp.isEmpty()){
            this.vaksinFrame.showAlert("No Telepon tidak boleh kosong");
        } if (vaksinKe.isEmpty()){
            this.vaksinFrame.showAlert("Vaksin Ke- tidak boleh kosong");
        }else{

            JenisVaksin jenisVaksin = this.vaksinFrame.getJenisVaksin();
            Vaksin vaksin = new Vaksin();
            vaksin.setId(UUID.randomUUID().toString());
            vaksin.setNama(nama);
            vaksin.setJenisVaksin(jenisVaksin);
    
            this.vaksinFrame.addVaksin(vaksin);
            this.vaksinDao.insert(vaksin);
        }
    }
}