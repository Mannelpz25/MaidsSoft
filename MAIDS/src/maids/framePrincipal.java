package maids;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
public class framePrincipal {
    static JFrame frame = new JFrame("Maids at home"); //Creación del frame principal
    static Trabajos t= new Trabajos(); //Creación del objeto de tipo Reservaciones    
    static Records r= new Records(); //Creación del objeto de tipo Reservaciones
    JPanel pnlInicio = new javax.swing.JPanel(); //Se crea el panel de Inicio
    
    /* 
    Funcion para limpiar el frame
    */
    public void limpiarFrame(){
        frame.remove(t.pnlAsignar);
        frame.remove(r.pnlConsulta);
        frame.remove(pnlInicio);  
        r.modelo.setNumRows(0);
    }
     
    /*
    Funcion para crear todos los componentes de la apariencia
    */
    public void aparienciaTotal(){
        //Se pone titulo al Panel
        pnlInicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Inicio")); 
        t.aparienciaAsignar(); 
        r.aparienciaConsulta();
        //Se crea una etiqueta para mostrar el texto Biembenido a la Estancia
        JLabel ini = new javax.swing.JLabel(); 
        ini.setText("Bienvenidos a Maids at home");
        //Se añade al panel
        pnlInicio.add(ini);
        //Se ingresan los atributos del frame
        frame.setLocation(250,200);
        frame.setVisible(true);
        frame.setSize(850,400);
        //Se crea un evento para salir de la aplicación al pulsar la equis
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        }); 
        //Se crea un menu
        JMenuBar menu = new javax.swing.JMenuBar();
        //Se crea el item inicio
        JMenuItem inicio = new javax.swing.JMenuItem("Inicio");
        inicio.addActionListener((ActionEvent e) -> {
            if(e.getSource()==inicio){  
                frame.setTitle("Maids at home");
                limpiarFrame();
                frame.add(pnlInicio,BorderLayout.CENTER);
                frame.repaint();
                frame.validate();
            }                
        });
        //Se crea el item trabajo
        JMenu trabajos = new javax.swing.JMenu("Trabajos");        
        JMenuItem asignar = new javax.swing.JMenuItem("Asignar");
        asignar.addActionListener((ActionEvent e) -> {
            if(e.getSource()==asignar){
                frame.setTitle("Maids at home - Trabajos");
                limpiarFrame();
                frame.add(t.pnlAsignar,BorderLayout.CENTER);
                frame.repaint();
                frame.validate();
            }                
        });
        JMenu records = new javax.swing.JMenu("Records");        
        JMenuItem reportes = new javax.swing.JMenuItem("Reportes");
        reportes.addActionListener((ActionEvent e) -> {
            if(e.getSource()==reportes){                
                frame.setTitle("Maids at home - Records");
                limpiarFrame();
                r.BuscarConsulta();
                frame.add(r.pnlConsulta,BorderLayout.CENTER);
                frame.repaint();
                frame.validate();
            }                
        });
        //Se añaden los items al menu
        menu.add(inicio);
        menu.add(trabajos);
        trabajos.add(asignar);        
        menu.add(records);
        records.add(reportes);
        frame.add(menu, BorderLayout.PAGE_START);
        frame.add(pnlInicio,BorderLayout.CENTER);
        frame.repaint();
        frame.validate();       
    }
}

