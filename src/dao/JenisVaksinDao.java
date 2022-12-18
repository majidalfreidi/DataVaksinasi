/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import javax.swing.JOptionPane;
import model.JenisVaksin;

public class JenisVaksinDao {
    public int insert(JenisVaksin jenisVaksin){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("insert into jenis_vaksin (id, nama_vaksin) values (?,?)");
            statement.setString(1, jenisVaksin.getId());
            statement.setString(2, jenisVaksin.getNama());

            result = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result; 
    }

    public int update(JenisVaksin jenisVaksin){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement("update jenis_vaksin set nama = ? where id = ?");
            statement.setString(1, jenisVaksin.getId());
            statement.setString(2, jenisVaksin.getNama());

            result = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah!");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public int delete(JenisVaksin jenisVaksin){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement("delete jenis_vaksin where id = ?");
            statement.setString(1, jenisVaksin.getId());

            result = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public List<JenisVaksin> findAll(){
        List<JenisVaksin> list = new ArrayList<>();
        try( Connection connection = MySqlConnection.getInstance().getConnection();
        Statement statement = connection.createStatement(); ){
            try( ResultSet resultSet = statement.executeQuery("select * from jenis_vaksin"); ){
                // retrieving the data
                while(resultSet.next()){
                    JenisVaksin jenisVaksin = new JenisVaksin();
                    jenisVaksin.setId(resultSet.getString("id"));
                    jenisVaksin.setNama(resultSet.getString("nama_vaksin"));
                    list.add(jenisVaksin);
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
