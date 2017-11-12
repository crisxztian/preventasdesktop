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
public class pedidos {
    private int id;
    private String fecha;
    private String hora;
    private int total;
    private int clientes_id;
    private int usuarios_id;

    public pedidos() {
        this.id = 0;
        this.hora = null;
        this.fecha = null;
        this.total = 0;
        this.clientes_id = 0;
        this.usuarios_id = 0;

    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getid() {
        return id;
    }

    public String getfecha() {
        return fecha;
    }

    public int gettotal() {
        return total;
    }
    
    public int getclientes_id() {
        return clientes_id;
    }
    
    public int getusuarios_id() {
        return usuarios_id;
    }

    public void setid(int id) {
        this.id = id;
    }
    
    public void setfecha(String fecha){
        this.fecha= fecha;
    }

    public void settotal(int total) {
        this.total = total;
    }

    public void setclientes_id(int clientes_id) {
        this.clientes_id = clientes_id;
    }
    
    public void setusuarios_id(int usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public void insert(Connection conexion) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO pedidos" + "(fecha, hora, total, clientes_id, usuarios_id) VALUES(?, ?, ?, ?, ?)");
            consulta.setString(1, this.getfecha());
            consulta.setString(2, this.getHora());
            consulta.setInt(3, this.gettotal());
            consulta.setInt(4, this.getclientes_id());
            consulta.setInt(5, this.getusuarios_id());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }


    public void delete(Connection conexion) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM pedidos" + " WHERE id = ?");
            consulta.setInt(1, this.getid());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
     public void updateestado(Connection conexion, String estado ) throws SQLException{
        try{
                PreparedStatement consulta;
                consulta = conexion.prepareStatement("UPDATE pedidos" + " SET estado= ? WHERE id = ?");
                consulta.setString(1, estado);
                consulta.setInt(2, this.getid());
             consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
     
     public void update(Connection conexion ) throws SQLException{
        try{
                PreparedStatement consulta;
                consulta = conexion.prepareStatement("UPDATE pedidos" + " SET total= ? WHERE id = ?");
                consulta.setInt(1, this.gettotal());
                consulta.setInt(2, this.getid());
             consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
     public int selectid(Connection conexion) throws SQLException {
        int ob=0;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT id FROM pedidos ORDER BY id DESC LIMIT 1");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob=resultado.getInt("id");
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
     
     public int selecttotal(Connection conexion) throws SQLException {
        int ob=0;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT total FROM pedidos WHERE id = ?");
            consulta.setInt(1, this.getid());
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob=resultado.getInt("total");
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
     
     public String selectestado(Connection conexion) throws SQLException {
        String ob = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT estado FROM pedidos where id = ?");
            consulta.setInt(1, this.getid());
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob=resultado.getString("estado");
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
     
    public List<String[]> selectquery(Connection conexion) throws SQLException {
        List<String[]> ob = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT pedidos.id, pedidos.fecha, pedidos.hora, usuarios.usuario, clientes.documento, pedidos.total, pedidos.estado FROM  clientes,pedidos,usuarios where clientes.id=pedidos.clientes_id and usuarios.id=pedidos.usuarios_id and pedidos.fecha = ?");
            consulta.setString(1, this.getfecha());
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob.add(new String[]{resultado.getString("pedidos.id"),resultado.getString("pedidos.fecha"),resultado.getString("pedidos.hora"),resultado.getString("usuarios.usuario"),resultado.getString("clientes.documento"),resultado.getString("pedidos.total"),resultado.getString("pedidos.estado")});
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
    
    public List<String[]> selectporcliente(Connection conexion) throws SQLException {
        List<String[]> ob = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT pedidos.id,pedidos.fecha, pedidos.hora, usuarios.usuario, clientes.documento, pedidos.total,pedidos.estado FROM  clientes,pedidos,usuarios where clientes.id=pedidos.clientes_id and usuarios.id=pedidos.usuarios_id and pedidos.clientes_id = ?");
            consulta.setInt(1, this.getclientes_id());
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob.add(new String[]{resultado.getString("pedidos.id"),resultado.getString("pedidos.fecha"),resultado.getString("pedidos.hora"), resultado.getString("usuarios.usuario"),resultado.getString("clientes.documento"),resultado.getString("pedidos.total"),resultado.getString("pedidos.estado")});
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
    
    
}
