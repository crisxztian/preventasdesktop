/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crisi
 */
public class clientes {

    private int id;
    private String nombre;
    private String documento;
    private String direccion;

    public clientes() {
        this.id = 0;
        this.nombre = null;
        this.direccion = null;
        this.documento= null;
    }

    public String getdocumento() {
        return documento;
    }

    public void setdocumento(String documento) {
        this.documento = documento;
    }

    public int getid() {
        return id;
    }

    public String getnombre() {
        return nombre;
    }

    public String getdireccion() {
        return direccion;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public List<String> selectdoc(Connection conexion) throws SQLException {

        List<String> ob = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT documento FROM clientes;");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob.add(resultado.getString("documento"));
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }

    public void insert(Connection conexion) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO clientes" + "(documento, nombre, direccion) VALUES(?, ?, ?)");
            consulta.setString(1, this.getdocumento());
            consulta.setString(2, this.getnombre());
            consulta.setString(3, this.getdireccion());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    public List<String[]> selecttodo(Connection conexion) throws SQLException {
        List<String[]> ob = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT id, documento, nombre, direccion FROM  clientes");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob.add(new String[]{resultado.getString("id"),resultado.getString("documento"),resultado.getString("nombre"),resultado.getString("direccion")});
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
    
   public int selectid(Connection conexion, String documento) throws SQLException {
       int sec=0;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT id FROM  clientes" + " WHERE documento = ? " );
            consulta.setString(1, documento);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                sec=resultado.getInt("id");
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        
        return sec;
    }

   public int selectultimoid(Connection conexion, String documento) throws SQLException {
       int sec=0;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT id FROM detallepedido ORDER BY id DESC LIMIT 1;" );
            consulta.setString(1, documento);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                sec=resultado.getInt("id");
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        
        return sec;
    }
    public void update(Connection conexion) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("UPDATE clientes" + " SET direccion=? WHERE id = ?");
            consulta.setString(1, this.getdireccion());
            consulta.setInt(2, this.getid());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void delete(Connection conexion) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM clientes" + " WHERE id = ?");
            consulta.setInt(1, this.getid());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
}
