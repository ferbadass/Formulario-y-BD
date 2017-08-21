
package formulario;
import java.sql.*;
public class Conexion {
    
        static Statement stm = null;
        
        public static Connection getConexion(){
            Connection cn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost/practicaformulario", "root", "n0m3l0");
                stm = cn.createStatement();
                System.out.print("Conexion Satisfactoria");
            }
            catch (Exception e){
                System.out.print("Error de conexion: "+e);
            }
            return cn;
        } 
        
        public void SubirDatos(String Nombre, String APP, String APM, String Escuela){
            try{
                stm.executeUpdate("INSERT INTO datosformulario (Nombre, App, Apm, Escuela) VALUES (" + 
                    "'" + Nombre + "', '" + APP + "', '" + APM + "', '" + Escuela + "');");
            }catch(SQLException error)
            {
                System.out.println(error.toString());
            }
        }      
}
