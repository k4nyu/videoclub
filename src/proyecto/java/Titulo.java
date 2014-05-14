/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.java;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kanyu
 */
public class Titulo {
    private String titulo, sinopsis;
    private Date fechaAlta;
    private int idTit;
   public static Titulo insertarTitulo(String titulo, String sinopsis){
       Titulo nuevo=null;
       try {
            String insercion="INSERT INTO titulo(titulo, fechaalta, sinopsis)"
                    + " VALUES ('"+titulo+"',"
                    + "CURRENT_TIMESTAMP ,"
                    + "'"+sinopsis+")";
            ResultSet resultado=SQLHelper.ejecutarInsert(insercion);
            if(resultado.next()){
                nuevo=getTitulo(titulo);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Titulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevo;
    }
   public static Titulo getTitulo(String titulo){
        Titulo nuevo=null;
     String consulta="SELECT * FROM titulo where "
                    +"titulo='"+titulo+"'";
            ResultSet rs=SQLHelper.ejecutarConsulta(consulta);
            try {
                rs.first();
                if(rs.getInt("idcli")!=0){
                    nuevo=new Titulo();
                    nuevo.setIdTit(rs.getInt("idtit"));
                    nuevo.setTitulo(rs.getString("titulo"));
                    nuevo.setFechaAlta(rs.getDate("fechaalta"));
                    nuevo.setSinopsis(rs.getString("sinopsis"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            return nuevo;
    }
   
   public static String mostrarTodos(Statement s){
       ResultSet r= null;
        try {
           r = s.executeQuery("SELECT * FROM titulo");
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return VistaPrincipal.mostrarDatos(r);
   }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setIdTit(int idTit) {
        this.idTit = idTit;
    }

    public int getIdTit() {
        return idTit;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }
   
}
