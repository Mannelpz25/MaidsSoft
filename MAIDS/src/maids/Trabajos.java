
package maids;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Trabajos {     
    Thread trabajador1 = new Thread();     
    Thread trabajador2 = new Thread();     
    Thread trabajador3 = new Thread();     
    int sueldo, comision, descuento, tiempo, random1,random2,random3;
    //Se crea objeto de la clase Conexion
    Conexion BD = new Conexion();
    //Componentes graficos Registro
    JPanel pnlAsignar = new javax.swing.JPanel();
    JPanel pnlFecha = new javax.swing.JPanel();
    JPanel pnlTrabajador1 = new javax.swing.JPanel();
    JPanel pnlTrabajador2 = new javax.swing.JPanel();
    JPanel pnlTrabajador3 = new javax.swing.JPanel();
    JPanel pnlBotones = new javax.swing.JPanel();
    JLabel lblFecha= new javax.swing.JLabel();
    JTextField txtFecha =  new javax.swing.JTextField();
    JLabel lblTrabajador1 = new javax.swing.JLabel();
    JTextField txtTrabajador1 =  new javax.swing.JTextField();    
    JLabel lblCliente1 = new javax.swing.JLabel();
    JTextField txtCliente1=  new javax.swing.JTextField();    
    JLabel lblAvance1 = new javax.swing.JLabel();
    JProgressBar pbTrabajador1 =  new javax.swing.JProgressBar();
    JLabel lblTrabajador2 = new javax.swing.JLabel();
    JTextField txtTrabajador2 =  new javax.swing.JTextField();    
    JLabel lblCliente2 = new javax.swing.JLabel();
    JTextField txtCliente2=  new javax.swing.JTextField();    
    JLabel lblAvance2 = new javax.swing.JLabel();
    JProgressBar pbTrabajador2 =  new javax.swing.JProgressBar();
    JLabel lblTrabajador3 = new javax.swing.JLabel();
    JTextField txtTrabajador3 =  new javax.swing.JTextField();    
    JLabel lblCliente3 = new javax.swing.JLabel();
    JTextField txtCliente3=  new javax.swing.JTextField();    
    JLabel lblAvance3 = new javax.swing.JLabel();
    JProgressBar pbTrabajador3 =  new javax.swing.JProgressBar();
    JLabel lblTiempo = new javax.swing.JLabel();
    JLabel lblTiempoTrans = new javax.swing.JLabel();
    JButton btnIniciar = new javax.swing.JButton();
    JButton btnRegistrar = new javax.swing.JButton();
    
        
    public void aparienciaAsignar(){
        pnlAsignar.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignar"));
        lblFecha.setText("Fecha:");
        lblTiempoTrans.setText("Tiempo Transcurrido:");
        lblTiempo.setText("");
        lblTrabajador1.setText("Nombre del Trabajador 1:");       
        lblCliente1.setText("Nombre del Cliente 1:");       
        lblAvance1.setText("Avance 0%");       
        lblTrabajador2.setText("Nombre del Trabajador 2:");       
        lblCliente2.setText("Nombre del Cliente 2:");       
        lblAvance2.setText("Avance 0%");    
        lblTrabajador3.setText("Nombre del Trabajador 3:");       
        lblCliente3.setText("Nombre del Cliente 3:");       
        lblAvance3.setText("Avance 0%");    

        btnIniciar.setText("Iniciar Jornada");
        btnIniciar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    iniciar();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Trabajos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnRegistrar.setText("Registrar");
        btnRegistrar.setEnabled(false);
        btnRegistrar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                registrar();
            }
        });
        
        pnlTrabajador1.setBackground(new java.awt.Color(204, 204, 204));
        pnlTrabajador2.setBackground(new java.awt.Color(204, 204, 204));
        pnlTrabajador3.setBackground(new java.awt.Color(204, 204, 204));
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        pnlAsignar.setLayout(gbl);
        pnlFecha.setPreferredSize(new java.awt.Dimension(100, 24));

        javax.swing.GroupLayout pnlFechaLayout = new javax.swing.GroupLayout(pnlFecha);
        pnlFecha.setLayout(pnlFechaLayout);
        pnlFechaLayout.setHorizontalGroup(
            pnlFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlFechaLayout.setVerticalGroup(
            pnlFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 2, 2);
        pnlFecha.setLayout(flowLayout1);
        pnlFecha.add(lblFecha);
        txtFecha.setPreferredSize(new java.awt.Dimension(115, 20));
        pnlFecha.add(txtFecha);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        pnlAsignar.add(pnlFecha, gridBagConstraints);

        pnlTrabajador1.setPreferredSize(new java.awt.Dimension(100, 100));
        pnlTrabajador1.setLayout(new java.awt.GridBagLayout());

        lblTrabajador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrabajador1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTrabajador1.add(lblTrabajador1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 15, 5);
        pnlTrabajador1.add(txtTrabajador1, gridBagConstraints);

        lblCliente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTrabajador1.add(lblCliente1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 15, 5);
        pnlTrabajador1.add(txtCliente1, gridBagConstraints);

        lblAvance1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTrabajador1.add(lblAvance1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTrabajador1.add(pbTrabajador1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlAsignar.add(pnlTrabajador1, gridBagConstraints);

        pnlTrabajador2.setPreferredSize(new java.awt.Dimension(100, 100));
        pnlTrabajador2.setLayout(new java.awt.GridBagLayout());

        lblTrabajador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrabajador2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTrabajador2.add(lblTrabajador2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 15, 5);
        pnlTrabajador2.add(txtTrabajador2, gridBagConstraints);

        lblCliente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTrabajador2.add(lblCliente2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 15, 5);
        pnlTrabajador2.add(txtCliente2, gridBagConstraints);

        lblAvance2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTrabajador2.add(lblAvance2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTrabajador2.add(pbTrabajador2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlAsignar.add(pnlTrabajador2, gridBagConstraints);

        pnlTrabajador3.setPreferredSize(new java.awt.Dimension(100, 100));
        pnlTrabajador3.setLayout(new java.awt.GridBagLayout());

        lblTrabajador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrabajador3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTrabajador3.add(lblTrabajador3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 15, 5);
        pnlTrabajador3.add(txtTrabajador3, gridBagConstraints);

        lblCliente3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTrabajador3.add(lblCliente3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 15, 5);
        pnlTrabajador3.add(txtCliente3, gridBagConstraints);

        lblAvance3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTrabajador3.add(lblAvance3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTrabajador3.add(pbTrabajador3, gridBagConstraints);
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlAsignar.add(pnlTrabajador3, gridBagConstraints);

        pnlBotones.setMinimumSize(new java.awt.Dimension(100, 100));
        pnlBotones.setPreferredSize(new java.awt.Dimension(100, 50));
        pnlBotones.setLayout(new java.awt.GridBagLayout());
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        pnlBotones.add(lblTiempo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        pnlBotones.add(lblTiempoTrans, gridBagConstraints);

        btnIniciar.setPreferredSize(new java.awt.Dimension(150, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        pnlBotones.add(btnIniciar, gridBagConstraints);

        btnRegistrar.setPreferredSize(new java.awt.Dimension(150, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        pnlBotones.add(btnRegistrar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        pnlAsignar.add(pnlBotones, gridBagConstraints);
    }
    public void iniciar() throws InterruptedException{
       trabajador1 = new Thread(){
                @Override
                public void run(){                
                    try {                    
                        long velocidad = ((random1+5)*60000)/100;
                        for(int seg=1; seg<=100;seg++){
                            lblAvance1.setText("Avance "+seg+"%");
                            pbTrabajador1.setValue(seg);
                            trabajador1.sleep(velocidad);
                            if(random1>=random2 && random1 >=random3)
                                if(((velocidad*seg)/60000)>=1&&((velocidad*seg)/60000)<2)
                                    lblTiempo.setText(((velocidad*seg)/60000)+" minuto");
                                else
                                    lblTiempo.setText(((velocidad*seg)/60000)+" minutos");
                            
                        }
                        if(random1>=random2 && random1 >=random3)
                            btnRegistrar.setEnabled(true);
                    }catch (Exception e){

                    }
                }
           };
       trabajador2 = new Thread(){            
                @Override
                public void run(){                
                    try {                    
                        long velocidad = ((random2+5)*60000)/100;
                        for(int seg=1; seg<=100;seg++){
                            lblAvance2.setText("Avance "+seg+"%");
                            pbTrabajador2.setValue(seg);
                            trabajador2.sleep(velocidad);
                            if(random2>=random1 && random2 >=random3)
                                if(((velocidad*seg)/60000)>=1&&((velocidad*seg)/60000)<2)
                                    lblTiempo.setText(((velocidad*seg)/60000)+" minuto");
                                else
                                    lblTiempo.setText(((velocidad*seg)/60000)+" minutos");
                        }
                        if(random2>=random1 && random2 >=random3)
                            btnRegistrar.setEnabled(true);
                    }catch (Exception e){

                    }
                }
        };     
       trabajador3 = new Thread(){            
                @Override
                public void run(){                
                    try {                    
                        long velocidad = ((random3+5)*60000)/100;
                        for(int seg=1; seg<=100;seg++){
                            lblAvance3.setText("Avance "+seg+"%");
                            pbTrabajador3.setValue(seg);
                            trabajador3.sleep(velocidad);
                            if(random3>=random2 && random3 >=random1)
                                if(((velocidad*seg)/60000)>=1&&((velocidad*seg)/60000)<2)
                                    lblTiempo.setText(((velocidad*seg)/60000)+" minuto");
                                else
                                    lblTiempo.setText(((velocidad*seg)/60000)+" minutos");
                        }
                        if(random3>=random2 && random3 >=random1)
                            btnRegistrar.setEnabled(true);
                    }catch (Exception e){

                    }
                }
        };
       if("".equals(txtFecha.getText()) || "".equals(txtTrabajador1.getText()) || "".equals(txtCliente1.getText()) || "".equals(txtTrabajador2.getText()) || "".equals(txtCliente2.getText()) || "".equals(txtTrabajador3.getText()) || "".equals(txtCliente3.getText()) ){
            JOptionPane.showMessageDialog(null,"Algunos campos se encuentran vacios","Error", JOptionPane.ERROR_MESSAGE);
       }else{
            random1=(int) (Math.floor(Math.random()*(3-(-3)+1)+(-3)));
            trabajador1.start();
            random2=(int) (Math.floor(Math.random()*(3-(-3)+1)+(-3)));
            trabajador2.start();
            random3=(int) (Math.floor(Math.random()*(3-(-3)+1)+(-3)));
            trabajador3.start();
            
       }
       
    }
    
    public int[] calcularSueldo(int aleatorio){
        if (aleatorio == 0){
            comision=200;
            tiempo = 5+aleatorio;
            descuento=0;
            sueldo = 500+comision-descuento;
        }else{
            if(aleatorio >0){
                comision=0;
                tiempo = 5+aleatorio;
                descuento=aleatorio*50;
                sueldo = 500+comision-descuento;
            }else{
                if(aleatorio <0){
                    comision=0;
                    tiempo = 5+aleatorio;
                    descuento=aleatorio*100;
                    sueldo = 500+comision+descuento;
                }
            }          
        }
        int sueldos [] = new int []{comision,tiempo,descuento,sueldo};
        return sueldos;
    }
    
    public void registrar(){
        int sueldos [];
        if(trabajador1.isAlive()|| trabajador2.isAlive() || trabajador3.isAlive()){
            JOptionPane.showMessageDialog(null,"Aun no terminan los trabajadores","Error", JOptionPane.ERROR_MESSAGE);
            
        }else{
            sueldos=calcularSueldo(random1);
            BD.insertarRegistro(txtFecha.getText(), txtTrabajador1.getText(), txtCliente1.getText(), sueldos[1], sueldos[0], sueldos[2], sueldos[3]);
            sueldos=calcularSueldo(random2);
            BD.insertarRegistro(txtFecha.getText(), txtTrabajador2.getText(), txtCliente2.getText(), sueldos[1], sueldos[0], sueldos[2], sueldos[3]);
            sueldos=calcularSueldo(random3);
            BD.insertarRegistro(txtFecha.getText(), txtTrabajador3.getText(), txtCliente3.getText(), sueldos[1], sueldos[0], sueldos[2], sueldos[3]);
            JOptionPane.showMessageDialog(null,"Registro Completado","Registro", JOptionPane.PLAIN_MESSAGE);
            limpiar();
        }
    }
    
    public void limpiar(){
        pbTrabajador1.setValue(0);
        pbTrabajador2.setValue(0);
        pbTrabajador3.setValue(0);
        lblAvance1.setText("Avance 0%");
        lblAvance2.setText("Avance 0%");
        lblAvance3.setText("Avance 0%");
        txtTrabajador1.setText("");
        txtCliente1.setText("");        
        txtTrabajador2.setText("");
        txtCliente2.setText("");        
        txtTrabajador3.setText("");
        txtCliente3.setText("");
        txtFecha.setText("");        
        lblTiempo.setText("");
        btnRegistrar.setEnabled(false);
    }
}

