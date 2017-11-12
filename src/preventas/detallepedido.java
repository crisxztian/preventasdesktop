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
public class detallepedido {
    private int id;
    private int cantidad;
    private int pedidos_id;
    private int productos_id;

    public detallepedido() {
        this.id = 0;
        this.cantidad = 0;
        this.pedidos_id = 0;
        this.productos_id = 0;

    }

    public detallepedido(int id, int cantidad, int pedidos_id, int productos_id) {
        this.id = id;
        this.cantidad = cantidad;
        this.pedidos_id = pedidos_id;
        this.productos_id = productos_id;
    }

    public int getid() {
        return id;
    }

    public int getcantidad() {
        return cantidad;
    }
    
    public int getpedidos_id() {
        return pedidos_id;
    }
    
    public int getproductos_id() {
        return productos_id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setcantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setpedidos_id(int pedidos_id) {
        this.pedidos_id = pedidos_id;
    }
    
    public void setproductos_id(int productos_id) {
        this.productos_id = productos_id;
    }

    public void insert(Connection conexion) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO detallepedido" + "(cantidad, pedidos_id, productos_id) VALUES(?, ?, ?)");
            consulta.setInt(1, this.getcantidad());
            consulta.setInt(2, this.getpedidos_id());
            consulta.setInt(3, this.getproductos_id());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }


    public void delete(Connection conexion) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM detallepedido" + " WHERE id = ?");
            consulta.setInt(1, this.getid());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    public List<String[]> selectdetalles(Connection conexion) throws SQLException {
        List<String[]> ob = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT productos.id,productos.descripcion, productos.precio, detallepedido.cantidad FROM  detallepedido,productos,pedidos where pedidos.id=detallepedido.pedidos_id and productos.id=detallepedido.productos_id and detallepedido.pedidos_id = ?");
            consulta.setInt(1, this.pedidos_id);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob.add(new String[]{resultado.getString("productos.id"),resultado.getString("productos.descripcion"),resultado.getString("productos.precio"),resultado.getString("detallepedido.cantidad")});
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
    
    public List<Integer> selectiddetalles(Connection conexion) throws SQLException {
        List<Integer> ob = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT id FROM  detallepedido where pedidos_id = ?");
            consulta.setInt(1, this.pedidos_id);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob.add(resultado.getInt("id"));
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
    
    public List<String[]> selectcancel(Connection conexion) throws SQLException {
        List<String[]> ob = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT productos.id, detallepedido.cantidad FROM  detallepedido,productos where productos.id=detallepedido.productos_id and detallepedido.pedidos_id = ?");
            consulta.setInt(1, this.getpedidos_id());
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob.add(new String[]{resultado.getString("productos.id"),resultado.getString("detallepedido.cantidad")});
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
    
    public int selectcantidad(Connection conexion) throws SQLException {
        int ob=0;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT cantidad FROM detallepedido where id = ?;");
            consulta.setInt(1, this.getid());
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob=resultado.getInt("cantidad");
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
    
    public void update(Connection conexion ) throws SQLException{
        try{
                PreparedStatement consulta;
                consulta = conexion.prepareStatement("UPDATE detallepedido" + " SET cantidad= ? WHERE id = ?");
                consulta.setInt(1, this.getcantidad());
                consulta.setInt(2, this.getid());
             consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
}
