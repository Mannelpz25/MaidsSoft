
package maids;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Records {
    
    JPanel pnlConsulta = new javax.swing.JPanel();
    DefaultTableModel modelo = new DefaultTableModel();
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();
    
    public void aparienciaConsulta(){
        pnlConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));
        modelo.addColumn("Fecha");
        modelo.addColumn("Trabajador");        
        modelo.addColumn("Cliente");        
        modelo.addColumn("Tiempo transcurrido");
        modelo.addColumn("Comisión");
        modelo.addColumn("Descuento");
        modelo.addColumn("Sueldo obtenido");
        tabla.setModel(modelo);
        tabla.setEnabled(false);
        scroll.setViewportView(tabla);        
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        pnlConsulta.setLayout(gbl);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 0;
        gbc.insets = new Insets(0,10,0,10);
        pnlConsulta.add(scroll,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        
    }    
    public void BuscarConsulta(){    
        try{    
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_ea","manne","Fco-1402");
                Statement st = conexion.createStatement();
                String consulta = "SELECT * FROM bd_ea.tbl_comisiones;";
                ResultSet rs=null;
                rs = st.executeQuery(consulta);
                while(rs.next()){                    
                    Object[] data ={rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)};
                    modelo.addRow(data);
                }                
                rs.close();
                st.close();
                conexion.close();
        }
        catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null,"Error al conectar con la Base de Datos","Error", JOptionPane.ERROR_MESSAGE);
            }      
        
    }  
}
