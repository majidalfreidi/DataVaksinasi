/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module;

/**
 *
 * @author majid
 */
import dao.JenisVaksinDao;
import dao.VaksinDao;

public class DaoModule {
    private final JenisVaksinDao jenisVaksinDao;
    private final VaksinDao vaksinDao;
    public DaoModule(){
        this.jenisVaksinDao = new JenisVaksinDao();
        this.vaksinDao = new VaksinDao();
    }
    
    public JenisVaksinDao getJenisVaksinDao() {
        return jenisVaksinDao;
    }
    
    public VaksinDao getVaksinDao() {
        return vaksinDao;
    }
}