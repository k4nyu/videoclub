/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OzChO
 */
public class SQLHelper {
    public static final String host="localhost:3306";
    public static final String db="videoclub";
    public static final String user="root";
    public static final String pass="";
    public static final String[] categorias={"","DVD","Blu-Ray","XBOX","PS3"};
    
    public static ResultSet ejecutarInsert(String query){
        ResultSet devolucion=null;
        try {
            Connection conexion=DriverManager.getConnection("jdbc:mysql://"+host+"/"+db,user ,pass);
            Statement comando= conexion.createStatement();
            devolucion=comando.getGeneratedKeys();
            comando.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return devolucion;
    }
   public static ResultSet ejecutarConsulta(String consulta){
       ResultSet devolucion=null;
        try {
            Connection conexion=DriverManager.getConnection("jdbc:mysql://"+host+"/"+db,user ,pass);
            Statement comando= conexion.createStatement();
            devolucion=comando.executeQuery(consulta);
            comando.close();
            conexion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
       return devolucion;
   }
   public static Statement getStatement(){
        try {
            Connection conexion=DriverManager.getConnection("jdbc:mysql://"+host+"/"+db,user ,pass);
            return conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
   public static ResultSet buscar(String tabla,HashMap<String,String> busqueda){
      ResultSet devolucion=null;
        String consulta="SELECT * FROM "+tabla;
        if(!busqueda.isEmpty()){
            consulta+=" WHERE $#$";
            Set<String> keyset=busqueda.keySet();
            for(String key:keyset){
                consulta=consulta.replace("$#$"," UPPER("+key+") LIKE UPPER('%"+busqueda.get(key)+"%') OR$#$");
            }
            consulta=consulta.replace("OR$#$", "");
            return ejecutarConsulta(consulta);
        }
      return devolucion;
   }
}