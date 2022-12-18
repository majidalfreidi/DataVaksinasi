/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.jenisvaksin;

/**
 *
 * @author majid
 */
import java.awt.event.*;
import java.util.UUID;
import model.JenisVaksin;
import dao.JenisVaksinDao;

class JenisVaksinButtonSimpanActionListener implements ActionListener{
    private JenisVaksinFrame jenisVaksinFrame;
    private JenisVaksinDao jenisVaksinDao;

    public JenisVaksinButtonSimpanActionListener(JenisVaksinFrame jenisVaksinFrame, JenisVaksinDao jenisVaksinDao){
        this.jenisVaksinFrame = jenisVaksinFrame;
        this.jenisVaksinDao = jenisVaksinDao;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String nama = this.jenisVaksinFrame.getNama();
        JenisVaksin jenisVaksin = new JenisVaksin();
        jenisVaksin.setId(UUID.randomUUID().toString());
        jenisVaksin.setNama(nama);

        this.jenisVaksinFrame.addJenisVaksin(jenisVaksin);
        this.jenisVaksinDao.insert(jenisVaksin);
    }
}