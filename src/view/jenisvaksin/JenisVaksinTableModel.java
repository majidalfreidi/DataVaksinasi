/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.jenisvaksin;

/**
 *
 * @author majid
 */
import javax.swing.table.*;
import java.util.List;
import model.JenisVaksin;

class JenisVaksinTableModel extends AbstractTableModel {
    private String[] columnNames = {"Jenis Vaksin"};
    private List<JenisVaksin> data;

    public JenisVaksinTableModel(List<JenisVaksin> data){
        this.data = data;
    }

    public int getColumnCount(){
        return columnNames.length;
    }

    public int getRowCount(){
        return data.size();
    }

    public String getColumnNames(int col){
        return columnNames[col];
    }

    public String getValueAt(int row, int col){
        JenisVaksin rowItem = data.get(row);
        String value = "";
        switch(col){
            case 0:
            value = rowItem.getNama();
            break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col){
        return false;
    }

    public void add(JenisVaksin value){
        data.add(value);
        fireTableRowsInserted(data.size() -1, data.size() -1);
    }
}