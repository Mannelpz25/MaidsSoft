package maids;
/**
 * Clase encargada de las funciones SQL
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Conexion {
    //Funcion encargada de la inserción en la tabla comisiones
    public void insertarRegistro(String fecha,String trabajador, String cliente, int tiempo, int comision,int descuento,int sueldo){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_ea","manne","Fco-1402");
                Statement st = conexion.createStatement();
                String insercion ="INSERT INTO tbl_comisiones VALUES (0,'"+fecha+"','"+trabajador+"','"+cliente+"',"+tiempo+","+comision+","+descuento+","+sueldo+");";
                st.executeUpdate(insercion);
                st.close();
                conexion.close();
            }
            catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null,"Error al conectar con la Base de Datos","Error", JOptionPane.ERROR_MESSAGE);
            }
                
    }
}
