/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OzChO
 */
public class Cliente {
    private String nombre,apellidos,direccion,telefono,email,dni;
    private Date fechaAlta;
    private int idCliente;

    public Cliente() {
    }
    

    public Cliente(String nombre, String apellidos, String direccion, String telefono, String email, String dni, Date fechaAlta, int idCliente) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
        this.idCliente = idCliente;
    }
    
    public static Cliente insertarCliente(String nombre,String apellidos,String direccion,
            String telefono,String email,String dni){
        Cliente nuevo=null;
        try {
            String insercion="INSERT INTO cliente(nombre,apellidos,direccion,telefono,email,dni,fechaalta)"
                    + " VALUES ('"+nombre+"',"
                    + "'"+apellidos+"',"
                    + "'"+direccion+"',"
                    + "'"+telefono+"',"
                    + "'"+email+"',"
                    + "'"+dni+"',CURRENT_TIMESTAMP)";
            ResultSet resultado=SQLHelper.ejecutarInsert(insercion);
            if(resultado.next()){
                nuevo= new Cliente(
                        resultado.getString("nombre"), 
                        resultado.getString("apellidos"),
                        resultado.getString("direccion"),
                        resultado.getString("telefono"), 
                        resultado.getString("email"),
                        resultado.getString("dni"), 
                        resultado.getDate("fechaaltacli"),
                        resultado.getInt("idcli"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevo;
    }
    
    public static Cliente getCliente(String nombre,String apellidos,String direccion,
            String telefono,String dni){
        Cliente nuevo=null;
     String consulta="SELECT * FROM cliente where "
                    +"nombre='"+nombre+"' AND "
                    +"apellidos='"+apellidos+"' AND "
                    +"direccion='"+direccion+"' AND "
                    +"telefono='"+telefono+"' AND "
                    +"dni='"+dni+"'";
            ResultSet rs=SQLHelper.ejecutarConsulta(consulta);
            try {
                rs.first();
                if(rs.getInt("idcli")!=0){
                    nuevo=new Cliente();
                    nuevo.setIdCliente(rs.getInt("idcli"));
                    nuevo.setNombre(rs.getString("nombre"));
                    nuevo.setApellidos(rs.getString("apellidos"));
                    nuevo.setDireccion(rs.getString("direccion"));
                    nuevo.setTelefono(rs.getString("telefono"));
                    nuevo.setDni(rs.getString("dni"));
                    nuevo.setEmail(rs.getString("email"));
                    nuevo.setFechaAlta(rs.getDate("fechaaltacli"));
                  
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            return nuevo;
    }
     public static Cliente getCliente(int idCliente){
        Cliente nuevo=null;
     String consulta="SELECT * FROM cliente where idcli="+idCliente;
                    
            ResultSet rs=SQLHelper.ejecutarConsulta(consulta);
            try {
                rs.first();
                if(rs.getInt("idcli")!=0){
                    nuevo=new Cliente();
                    nuevo.setIdCliente(rs.getInt("idcli"));
                    nuevo.setNombre(rs.getString("nombre"));
                    nuevo.setApellidos(rs.getString("apellidos"));
                    nuevo.setDireccion(rs.getString("direccion"));
                    nuevo.setTelefono(rs.getString("telefono"));
                    nuevo.setDni(rs.getString("dni"));
                    nuevo.setEmail(rs.getString("email"));
                    nuevo.setFechaAlta(rs.getDate("fechaaltacli"));
                  
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            return nuevo;
    }
     
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
}
