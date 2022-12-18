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
import javax.swing.*; 
import java.awt.event.ActionListener;
import java.util.List;

public class JenisVaksinFrame extends JFrame {
    private List<JenisVaksin> jenisVaksinList;
    private final JTextField textFieldNama;
    private JenisVaksinTableModel tableModel;
    private final JTable table;
    private final JButton buttonSimpan;
    
    public JenisVaksinFrame(){
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JLabel labelInput = new JLabel("Jenis Vaksin :");
            labelInput.setBounds(15,40,350,10);
            textFieldNama = new JTextField();
            textFieldNama.setBounds(15,60,350,30);
            buttonSimpan = new JButton("Simpan");
            buttonSimpan.setBounds(15,100,100,40);
            table = new JTable();
            JScrollPane scrollableTable = new JScrollPane(table);
            scrollableTable.setBounds(15,150,350,200);
        
            this.add(buttonSimpan);
            this.add(textFieldNama);
            this.add(labelInput);
            this.add(scrollableTable);
        
            this.setSize(400,500);
            this.setLayout(null);
    }
    
    public String getNama(){
        return textFieldNama.getText();
    }
    
    public void addJenisVaksin(JenisVaksin jenisVaksin){
        tableModel.add(jenisVaksin);
        textFieldNama.setText("");
    }
    
    public void addButtonSimpanActionListener(ActionListener actionListener){
        buttonSimpan.addActionListener(actionListener);
    }
    
    public void populateTable(List<JenisVaksin> jenisVaksinList){
        this.jenisVaksinList = jenisVaksinList;
        tableModel = new JenisVaksinTableModel(jenisVaksinList);
        table.setModel(tableModel);
    }
}