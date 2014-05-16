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
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kanyu
 */
public class Producto {
    private int idal;
    private int idtit;
    private int idcat;
    private Timestamp fechaAlta;
    private String alquilado="disponible";
    
    public static Producto insertarProducto(String idtit, String idcat){
        Producto nuevo=null;
        try {
            String insercion="INSERT INTO alquilables(idtit, idcat, fechaalta, alquilado)"
                    + " VALUES ("+idtit+", "
                    + idcat +", "
                    + "CURRENT_TIMESTAMP, "
                    + "'disponible')";
            ResultSet resultado=SQLHelper.ejecutarInsert(insercion);
            if(resultado.next()){
                try {
                    String consulta = "SELECT * FROM alquilables WHERE idtit=idtit AND idcat=idcat ORDER BY idal DESC";
                    ResultSet rs = SQLHelper.ejecutarConsulta(consulta);
                    rs.first();
                    nuevo=getProducto(rs.getInt("idal"));
                } catch (SQLException ex) {
                    Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevo;
    }
    public static Producto getProducto(int idAl){
        Producto nuevo=null;
     String consulta="SELECT * FROM alquilables where "
                    +"idal="+idAl;
            ResultSet rs=SQLHelper.ejecutarConsulta(consulta);
            try {
                rs.first();
                if(rs.getInt("idal")!=0){
                    nuevo=new Producto();
                    nuevo.setIdal(rs.getInt("idal"));
                    nuevo.setIdtit(rs.getInt("idtit"));
                    nuevo.setIdcat(rs.getInt("idcat"));
                    nuevo.setFechaAlta(rs.getTimestamp("fechaalta"));
                    nuevo.setAlquilado(rs.getString("alquilado"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            return nuevo;
    }

public static String mostrarProductos(Statement s){
        ResultSet r= null;
        try {
           r = s.executeQuery("SELECT * FROM alquilables");
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return VistaPrincipal.mostrarDatos(r);
    }
public static String mostrarProductoPorCategoria(Statement s, String categoria){
    ResultSet r = null;
    try{
        r= s.executeQuery("FROM alquilables INNER JOIN titulo ON titulo.idtit=alquilables.idtit INNER JOIN categoria "
                + "ON categoria.idcat= alquilables.idcat WHERE categoria.nombre='"+categoria+"'");
    }
     catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    return VistaPrincipal.mostrarDatos(r);
}

public String getNombreCategoria(){
    return SQLHelper.categorias[this.getIdcat()];
}

    public void setAlquilado(String alquilado) {
        this.alquilado = alquilado;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public void setIdtit(int idtit) {
        this.idtit = idtit;
    }

    public void setIdal(int idal) {
        this.idal = idal;
    }

    public String getAlquilado() {
        return alquilado;
    }

    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    public int getIdcat() {
        return idcat;
    }

    public int getIdtit() {
        return idtit;
    }

    public int getIdal() {
        return idal;
    }

}