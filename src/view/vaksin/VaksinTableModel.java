/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.vaksin;

/**
 *
 * @author majid
 */
import javax.swing.table.*;
import java.util.List;
import model.Vaksin;

public class VaksinTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nama", "Jenis Vaksin", "No Telp", "Vaksin ke"};
    private List<Vaksin> data;

    public VaksinTableModel(List<Vaksin> data){
        this.data = data;
    }

    public int getColumnCount(){
        return columnNames.length;
    }

    public int getRowCount(){
        return data.size();
    }

    public String getColumnName(int col){
        return columnNames[col];
    }

    public Object getValueAt(int row, int col){
        Vaksin rowItem = data.get(row);
        String value = "";
        switch(col){
            case 0:
                value = rowItem.getNama();
                break;
            case 1:
                value = rowItem.getJenisVaksin().getNama();
                break;
            case 2:
                value = rowItem.getNoTelp();
                break;
            case 3:
                value = rowItem.getVaksinKe();
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col){
        return false;
    }

    public void add(Vaksin value){
        data.add(value);
        fireTableRowsInserted(data.size() -1, data.size() -1);
    }
}