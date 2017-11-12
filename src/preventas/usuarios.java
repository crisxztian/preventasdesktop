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
public class usuarios {
    private int id;
    private String documento;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String clave;
    private String privilegios;
    
    public usuarios() {
        this.documento=null;
        this.usuario = null;
        this.nombres = null;
        this.apellidos = null;
        this.clave = null;
        this.id = 0;
        this.privilegios = null;
    }

    public usuarios(String usuario, String clave) {
        this.usuario= usuario;
        this.clave = clave;
    }
    
    public int getid() {
        return id;
    }


    public String getusuario() {
        return usuario;
    }

    public String getnombres() {
        return nombres;
    }

    public String getapellidos() {
        return apellidos;
    }

    public String getdocumento() {
        return documento ;
    }
    
    
    public String getclave() {
        return clave ;
    }
    
    public String getprivilegios(){
        return privilegios;
    }
    
    public void setid(int id) {
        this.id = id;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public void setnombres(String nombres) {
        this.nombres = nombres;
    }

    public void setapellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public void setdocumento(String documento) {
        this.documento = documento;
    }
    
    public void setclave(String clave) {
        this.clave = clave;
    }
    
    public void setprivilegios(String privilegios){
        this.privilegios=privilegios;
    }

    
    public void insert(Connection conexion) throws SQLException{
        try{
            PreparedStatement consulta;
                consulta = conexion.prepareStatement("INSERT INTO usuarios" + "(documento, nombres, apellidos, usuario, clave, privilegios) VALUES(?, ?, ?, ?, ?, ?)");
                consulta.setString(1, this.getdocumento());
                consulta.setString(2, this.getnombres());
                consulta.setString(3, this.getapellidos());
                consulta.setString(4, this.getusuario());
                consulta.setString(5, this.getclave());
                consulta.setString(6, this.getprivilegios());
                consulta.executeUpdate();
        }catch(SQLException ex){
                      throw new SQLException(ex);  
                        }
        }
    
    public void update(Connection conexion ) throws SQLException{
        try{
                PreparedStatement consulta;
                consulta = conexion.prepareStatement("UPDATE usuarios" + " SET clave=? WHERE usuario = ?");
                consulta.setString(1, this.getclave());
                consulta.setString(2, this.getusuario());
             consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    
    public String selectadmin(Connection conexion, String usuario) throws SQLException {
       String sec=null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT clave FROM  usuarios" + " WHERE usuario = ? and privilegios='Administrador'" );
            consulta.setString(1, usuario);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                sec=resultado.getString("clave");
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return sec;
    }
    
    public int selectid(Connection conexion, String usuario) throws SQLException {
       int sec=0;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT id FROM  usuarios" + " WHERE usuario = ? and privilegios='Administrador'" );
            consulta.setString(1, usuario);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                sec=resultado.getInt("id");
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        
        return sec;
    }
    
    public List<String[]> selecttodo(Connection conexion) throws SQLException {
        List<String[]> ob = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT id, documento, usuario, apellidos, nombres FROM  usuarios ");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ob.add(new String[]{resultado.getString("id"),resultado.getString("documento"),resultado.getString("usuario"),resultado.getString("apellidos"),resultado.getString("nombres")});
             }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ob;
    }
    
    public void delete(Connection conexion) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM usuarios" + " WHERE usuario = ?");
            consulta.setString(1, this.getusuario());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
}
