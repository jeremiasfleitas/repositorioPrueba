/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class ConexionAlumnosMaterias {
    public Conexion cc = new Conexion();
    public Connection cn = cc.conexion();
    public int alumno;
    
    public ResultSet buscarNombreAlumno(int id_alumno){
        String sql = "SELECT * FROM alumnos WHERE id_alumno='"+id_alumno+"'";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionCarreras.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public ResultSet buscarMaterias(int semestre, int carrera){
        String sql = "SELECT * FROM materias WHERE anho_materia='"+semestre+"' AND id_carrera='"+carrera+"'";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionCarreras.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet buscarAlumnosMaterias(int id_alumno_materia){
        String sql = "SELECT * FROM alumnos_materias WHERE id_alumno_materia='"+id_alumno_materia+"'";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionCarreras.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void guardar(String nombre, String detalles){
        try{
            
            PreparedStatement pst = cc.conexion().prepareStatement("INSERT INTO carreras(nombre_carrera, detalles_carrera) VALUES (?,?)");
            pst.setString(1, nombre);
            pst.setString(2, detalles);
            pst.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void actualizar(Integer id, String nombre, String detalles){
        try {
            PreparedStatement pst;
            pst = cc.conexion().prepareStatement("UPDATE carreras SET nombre_carrera='"+nombre+"', detalles_carrera='"+detalles+"'WHERE id_carrera='"+id+"'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionCarreras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id){
        try {
            PreparedStatement pst;
            pst = cc.conexion().prepareStatement("DELETE FROM carreras WHERE id_carrera='"+id+"'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionCarreras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList getListaCarreras(){
        ArrayList listaCarreras = new ArrayList();
        Carrera carrera = null;
        Statement consulta;
        ResultSet resultado;
        try {
            consulta = cn.createStatement();
            resultado = consulta.executeQuery("SELECT * FROM carreras");
            while(resultado.next()){
                carrera = new Carrera();
                carrera.setId(resultado.getInt("id_carrera"));
                carrera.setNombre(resultado.getString("nombre_carrera"));
                listaCarreras.add(carrera);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionCarreras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCarreras;
    }
}
