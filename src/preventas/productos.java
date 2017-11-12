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
public class productos {
    private int id;
    private String descripcion;
    private int precio;
    private int stock;

    public productos() {
        this.id = 0;
        this.descripcion = null;
        this.precio= 0;
        this.stock= 0;
    }

    public productos(int id, String descripcion, int precio, int stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio=precio;
        this.stock=stock;
    }

    public int getid() {
        return id;
    }

    public String getdescripcion() {
        return descripcion;
    }
    

    public int getprecio() {
        return precio;
    }
    
    public int getstock(){
        return stock;
    }
 

    public void setid(int id) {
        this.id = id;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    public void setprecio(int precio) {
        this.precio = precio;
    }
    
   public void setstock(int stock) {
        this.stock = stock;
    } 
   
   public void insert(Connection conexion) throws SQLException{
        try{
            PreparedStatement consulta;
                consulta = conexion.prepareStatement("INSERT INTO productos" + "(descripcion, precio, stock) VALUES(?, ?, ?)");
                consulta.setString(1, this.getdescripcion());
                consulta.setInt(2, this.getprecio());
                consulta.setInt(3, this.getstock());
                consulta.executeUpdate();
        }catch(SQLException ex){
                      throw new SQLException(ex);  
                        }
        }
   
   public void update(Connection conexion ) throws SQLException{
        try{
                PreparedStatement consulta;
                consulta = conexion.prepareStatement("UPDATE productos" + " SET stock= ?,precio=? WHERE id = ?");
                consulta.setInt(1, this.getstock());
                consulta.setInt(2, this.getprecio());
                consulta.setInt(3, this.getid());
             consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
   
   public void updatestock(Connection conexion ) throws SQLException{
        try{
                PreparedStatement consulta;
                consulta = conexion.prepareStatement("UPDATE productos" + " SET stock= ? WHERE id = ?");
                consulta.setInt(1, this.getstock());
                consulta.setInt(2, this.getid());
             consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
   public void delete(Connection conexion) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM productos" + " WHERE id = ?");
            consulta.setInt(1, this.getid());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
   
   public List<String[]> selecttodo(Connection conexion) throws SQLException {
        List<String[]> ob = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT id, descripcion, precio, stock FROM  productos");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob.add(new String[]{resultado.getString("id"),resultado.getString("descripcion"),resultado.getString("precio"),resultado.getString("stock")});
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
   
   public String[] selectnuevo(Connection conexion) throws SQLException {
        String[] ob=null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT id, descripcion, precio, stock FROM  productos where descripcion= ?");
            consulta.setString(1, this.getdescripcion());
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob=new String[]{resultado.getString("id"),resultado.getString("descripcion"),resultado.getString("precio"),resultado.getString("stock")};
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }

    
    public List<String> selectdes(Connection conexion) throws SQLException {

        List<String> ob = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT descripcion FROM  productos;");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob.add(resultado.getString("descripcion"));
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
    
    public int selectid(Connection conexion) throws SQLException {
        int ob=0;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT id FROM  productos where descripcion = ?;");
            consulta.setString(1, this.getdescripcion());
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob=resultado.getInt("id");
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
    
    public int selectstock(Connection conexion) throws SQLException {
        int ob=0;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT stock FROM  productos where id = ?;");
            consulta.setInt(1, this.getid());
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob=resultado.getInt("stock");
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
    
    public int selectprecio(Connection conexion) throws SQLException {
        int ob=0;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT precio FROM  productos where id = ?;");
            consulta.setInt(1, this.getid());
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob=resultado.getInt("precio");
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
}
