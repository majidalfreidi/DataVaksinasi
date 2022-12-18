/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.vaksin;

/**
 *
 * @author majid
 */
import model.JenisVaksin;
import model.Vaksin;
import module.DaoModule;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class VaksinController {
    private final DaoModule daoModule;
    private final VaksinFrame vaksinFrame;
    private final VaksinPdfExport vaksinPdfExport;
    public VaksinController(DaoModule daoModule){
        this.daoModule = daoModule;
        this.vaksinFrame = new VaksinFrame();
        this.vaksinPdfExport = new VaksinPdfExport();
        this.vaksinFrame.addButtonSimpanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VaksinController.this.simpan();
            }
        });
        
        this.vaksinFrame.addButtonExportPdfActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VaksinController.this.exportPdf();
            }
        });
    }

    public void showVaksinFrame(){
        List<Vaksin> vaksinList = daoModule.getVaksinDao().findAll();
        vaksinFrame.populateTable(vaksinList);
        List<JenisVaksin> jenisVaksinList =
        daoModule.getJenisVaksinDao().findAll();
        vaksinFrame.populateComboJenis(jenisVaksinList);
        vaksinFrame.setVisible(true);
    }
    
    public void simpan(){
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
            vaksin.setNoTelp(noTelp);
            vaksin.setVaksinKe(vaksinKe);
            this.vaksinFrame.addVaksin(vaksin);
            daoModule.getVaksinDao().insert(vaksin);
        }
    }
    
    public void exportPdf(){
        try {
        vaksinPdfExport.export(vaksinFrame.getVaksinList());
        } catch (IOException e){
            e.printStackTrace();
        }
    } 
}