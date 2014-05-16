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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OzChO
 */
public class SQLHelper {
    public static final String host="localhost:3306";
    public static final String db="videoclub";
    public static final String user="root";
    public static final String pass="";
//  public static final String host="144.76.19.105:3306";
//  public static final String db="kanyuclub";
//  public static final String user="kanyu";
//  public static final String pass="elestanconoheque";
    
    public static ResultSet ejecutarInsert(String query){
        ResultSet devolucion=null;
        try {
            Connection conexion=DriverManager.getConnection("jdbc:mysql://"+host+"/"+db,user ,pass);
            Statement comando= conexion.createStatement();
            comando.execute(query,Statement.RETURN_GENERATED_KEYS);
            devolucion=comando.getGeneratedKeys();
            
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
            System.out.println(consulta);
            devolucion=comando.executeQuery(consulta);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
       return devolucion;
   }
   public static int ejecutarUpdate(String update){
       int devolucion=0;
        try {
            Connection conexion=DriverManager.getConnection("jdbc:mysql://"+host+"/"+db,user ,pass);
            Statement comando= conexion.createStatement();
            devolucion = comando.executeUpdate(update);
            
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
   public static ResultSet buscar(String tabla,HashMap<String,String> busqueda,int limite, int offset,String orderby){
      return buscar(tabla,"*","", busqueda, limite, offset, orderby);
   }
   public static ResultSet buscar(String tabla,HashMap<String,String> busqueda,int limite, int offset){
    return buscar( tabla,busqueda,limite, offset,"1 ASC");
   }
   public static ResultSet buscar(String tabla, String campos,String where, HashMap<String,String> busqueda,int limite, int offset,String orderby){
      ResultSet devolucion=null;
        String consulta="SELECT "+campos+" FROM "+tabla;
        if(!busqueda.isEmpty()){
            consulta+=" WHERE ($#$";
            Set<String> keyset=busqueda.keySet();
            for(String key:keyset){
                consulta=consulta.replace("$#$"," UPPER("+key+") LIKE UPPER('%"+busqueda.get(key)+"%') OR$#$");
            }
            consulta=consulta.replace("OR$#$", "");
            consulta+=")";
            if(!where.isEmpty()){
                consulta+=" AND("+where+")";
            }
        }else{
        if(!where.isEmpty()){
                consulta+=" WHERE ("+where+")";
            }
        }
        consulta+=" ORDER BY "+orderby+" LIMIT "+limite+" OFFSET "+offset;
      return ejecutarConsulta(consulta);
   }
   public static ResultSet buscar(String tabla, String[] campos,String where, HashMap<String,String> busqueda,int limite, int offset,String orderby){
       String tmp="$#$";
       for(String campo:campos){
           tmp=tmp.replace("$#$",campo+",$#$");
       }
       tmp=tmp.replace(",$#$", "");
       tmp=tmp.replace("$#$","*");
       return buscar(tabla,tmp,where,busqueda,limite,offset,orderby);
   }
   public static ResultSet buscar(String tabla, String[] campos, HashMap<String,String> busqueda,int limite, int offset,String orderby){
   return buscar(tabla,campos,"",busqueda,limite,offset,orderby);
   }
   public static void rellenarTabla(JTable tabla, ResultSet rs, String[] cabecera) throws SQLException{
            Vector cab=new Vector(Arrays.asList(cabecera));
            Vector data=new Vector();
            rs.beforeFirst();
            while(rs.next()){
                Vector tupla=new Vector();
                for(int i=1;i<=cab.size();i++){
                    tupla.add(rs.getObject(i));
                }
                data.add(tupla);
            }
            tabla.setModel(new DefaultTableModel(data, cab){

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        });
     
       
   }
  
}
