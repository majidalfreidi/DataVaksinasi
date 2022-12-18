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
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VaksinFrame extends JFrame {
    private List<JenisVaksin> jenisVaksinList;
    private List<Vaksin> vaksinList;
    private final JTextField textFieldNama, textFieldNoTelp, textFieldVaksinKe;
    private VaksinTableModel tableModel;
    private final JComboBox comboJenis;
    
    
    private final JButton buttonSimpan;
    private final JButton buttonHapus;
    private final JButton buttonEdit;
    private final JButton buttonExportPdf;
    
    private final JTable table;
    
    public VaksinFrame(){
   
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15,40,350,10);
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15,60,350,30);
        
        JLabel labelJenis = new JLabel("Jenis Vaksin:");
        labelJenis.setBounds(15,100,350,10);
    
        comboJenis = new JComboBox();
        comboJenis.setBounds(15,120,150,30);
        
        JLabel labelNoTelp = new JLabel("No Telepon :");
        labelNoTelp.setBounds(15,160,350,10);
        
        textFieldNoTelp = new JTextField();
        textFieldNoTelp.setBounds(15,180,350,30);
        
        JLabel labelVaksinKe = new JLabel("Vaksin Ke :");
        labelVaksinKe.setBounds(15,220,350,10);
        
        textFieldVaksinKe = new JTextField();
        textFieldVaksinKe.setBounds(15,240,350,30);
        
        buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15,280,80,40);
        buttonExportPdf = new JButton("Export PDF");
        buttonExportPdf.setBounds(102, 280, 100, 40);
        buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(209,280,80,40);
        buttonEdit = new JButton("Edit");
        buttonEdit.setBounds(295,280,70,40);
        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,350,350,200);
    
        this.add(buttonSimpan);
        this.add(buttonExportPdf);
        this.add(buttonHapus);
        this.add(buttonEdit);
        this.add(textFieldNama);
        this.add(textFieldNoTelp);
        this.add(textFieldVaksinKe);
        this.add(labelInput);
        this.add(labelJenis);
        this.add(labelNoTelp);
        this.add(labelVaksinKe);
        this.add(comboJenis);
        this.add(scrollableTable);
    
        this.setSize(500,600);
        this.setLayout(null);
    }
    
    public void populateTable(List<Vaksin> vaksinList){
        this.vaksinList = vaksinList;
        tableModel = new VaksinTableModel(vaksinList);
        table.setModel(tableModel);
    }
    public void populateComboJenis(List<JenisVaksin> jenisVaksinList){
        this.jenisVaksinList = jenisVaksinList;
        comboJenis.removeAllItems();
       
        for (JenisVaksin jenisVaksin: jenisVaksinList){
            comboJenis.addItem(jenisVaksin.getNama());
        }
    }
    
    public String getNama(){
        return textFieldNama.getText();
    }
    
    public String getNoTelp(){
        return textFieldNoTelp.getText();
    }
    
    public String getVaksinKe(){
        return textFieldVaksinKe.getText();
    }
    
    public JenisVaksin getJenisVaksin(){
        return jenisVaksinList.get(comboJenis.getSelectedIndex());
    }
    
    public void addVaksin(Vaksin vaksin){
        tableModel.add(vaksin);
        textFieldNama.setText("");
        textFieldNoTelp.setText("");
        textFieldVaksinKe.setText("");
    }
    
    public void showAlert(String message){
        JOptionPane.showMessageDialog(this, message);
    }
    
    public void addButtonSimpanActionListener(ActionListener actionListener){
        buttonSimpan.addActionListener(actionListener);
    }
    
    public void addButtonExportPdfActionListener(ActionListener actionListener) {
        buttonExportPdf.addActionListener(actionListener);
    }
    
    public List<Vaksin> getVaksinList(){
        return vaksinList;
    }
}