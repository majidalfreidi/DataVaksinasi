/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author majid
 */
public class Vaksin {
    private String id;
    private String nama;
    private String noTelp;
    private String vaksinKe;
    private JenisVaksin jenisVaksin;

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }
    
    public void setNoTelp(String noTelp){
        this.noTelp = noTelp;
    }
    
    public String getNoTelp(){
        return noTelp;
    }
    
    public void setVaksinKe(String vaksinKe){
        this.vaksinKe = vaksinKe;
    }
    
    public String getVaksinKe(){
        return vaksinKe;
    }

    public void setJenisVaksin(JenisVaksin jenisVaksin){
        this.jenisVaksin = jenisVaksin;
    }

    public JenisVaksin getJenisVaksin(){
        return jenisVaksin;
    }
}