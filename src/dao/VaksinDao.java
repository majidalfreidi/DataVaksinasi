/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dao;

/**
 *
 * @author majid
 */

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import model.Vaksin;
import model.JenisVaksin;

public class VaksinDao {
    public int insert(Vaksin vaksin){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("insert into data_vaksin (id, nama, jenis_vaksin_id, no_telp, vaksin_ke) values (?,?,?,?,?)");
            statement.setString(1, vaksin.getId());
            statement.setString(2, vaksin.getNama());
            statement.setString(3, vaksin.getJenisVaksin().getId());
            statement.setString(4, vaksin.getNoTelp());
            statement.setString(5, vaksin.getVaksinKe());

            result = statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result; 
    }

    public int update(Vaksin vaksin){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement("update data_vaksin set nama = ?, jenis_vaksin_id = ?, no_telp = ?, vaksin_ke = ? where id = ?");
            statement.setString(1, vaksin.getNama());
            statement.setString(2, vaksin.getJenisVaksin().getId());
            statement.setString(3, vaksin.getId());
            statement.setString(4, vaksin.getNoTelp());
            statement.setString(5, vaksin.getVaksinKe());

            result = statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public int delete(Vaksin vaksin){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement("delete data_vaksin where id = ?");
            statement.setString(1, vaksin.getId());

            result = statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public List<Vaksin> findAll(){
        List<Vaksin> list = new ArrayList<>();
        try( Connection connection = MySqlConnection.getInstance().getConnection();
        Statement statement = connection.createStatement(); ){
            try( ResultSet resultSet = statement.executeQuery("select data_vaksin.id, data_vaksin.nama, data_vaksin.no_telp, data_vaksin.vaksin_ke, jenis_vaksin.id jenis_vaksin_id, jenis_vaksin.nama_vaksin "+
                "jenis_vaksin_nama from data_vaksin join jenis_vaksin on jenis_vaksin.id = data_vaksin.jenis_vaksin_id"); ){
                // retrieving the data
                while(resultSet.next()){
                    Vaksin vaksin = new Vaksin();
                    vaksin.setId(resultSet.getString("id"));
                    vaksin.setNama(resultSet.getString("nama"));
                    vaksin.setNoTelp(resultSet.getString("no_telp"));
                    vaksin.setVaksinKe(resultSet.getString("vaksin_ke"));

                    JenisVaksin jenisVaksin = new JenisVaksin();
                    jenisVaksin.setId(resultSet.getString("jenis_vaksin_id"));
                    jenisVaksin.setNama(resultSet.getString("jenis_vaksin_nama"));

                    vaksin.setJenisVaksin(jenisVaksin);

                    list.add(vaksin);
                }
            } catch ( SQLException e ){
                e.printStackTrace();
            }
        } catch ( SQLException e ){
            e.printStackTrace();
        }
        return list;
    }    
}