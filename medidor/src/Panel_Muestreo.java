
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulo
 */
public class Panel_Muestreo {
    JPanel panelselec;
    JPanel Promedio;
    JPanel Tvoltaje;
    JPanel Tcorriente;
    JPanel TMvoltaje;
    JPanel TMcorriente;
    
    JLabel n_promedios;
    JLabel t_voltaje;
    JLabel t_corriente;
    JLabel tv_muestreo;
    JLabel tc_muestreo;
    JComboBox promedios;
    JComboBox tvoltaje;
    JComboBox tcorriente;
    JLabel tcmuestreo;
    JLabel tvmuestreo;
    JLabel nombre;
    JButton setter;
    
    int valor_promedios=3;
    int valor_tvoltaje=4;
    int valor_tcorriente=4;
    
    Color Fondo=new Color(164, 213, 237);
    public Panel_Muestreo(){
        panelselec= new JPanel();
        panelselec.setLayout(new GridLayout(7,1,5,5));
        panelselec.setBackground(Fondo);//cambia el color del fondo
        nombre= new JLabel("MUESTREO CONVERSOR", JLabel.CENTER);
        panelselec.add(nombre);
                
        //panel numero de promedios
        Promedio= new JPanel();
        Promedio.setLayout(new GridLayout(1,2,5,5));
        Promedio.setBackground(Fondo);//cambia el color del fondo
        n_promedios= new JLabel("N° de Promedios:");
        Promedio.add(n_promedios);
        // Creacion del JComboBox de numero de promedios
	promedios = new JComboBox();
	promedios.addItem("1");
	promedios.addItem("4");
	promedios.addItem("16");
        promedios.addItem("64");
	promedios.addItem("128");
	promedios.addItem("256");
        promedios.addItem("512");
	promedios.addItem("1024");
        promedios.setSelectedItem("64");
        Promedio.add(promedios);
        panelselec.add(Promedio);
        
        //panel tiempo de conversion de voltajes
        Tvoltaje= new JPanel();
        Tvoltaje.setLayout(new GridLayout(1,2,5,5));
        Tvoltaje.setBackground(Fondo);//cambia el color del fondo
        t_voltaje= new JLabel("Tiempo de Conversión de Voltaje:");
        Tvoltaje.add(t_voltaje);
        // Creacion del JComboBox de tiempo conversion voltaje
	tvoltaje = new JComboBox();
	tvoltaje.addItem("140 us");
	tvoltaje.addItem("204 us");
	tvoltaje.addItem("332 us");
        tvoltaje.addItem("588 us");
	tvoltaje.addItem("1.1 ms");
	tvoltaje.addItem("2.116 ms");
        tvoltaje.addItem("4.156 ms");
	tvoltaje.addItem("8.244 ms");
        tvoltaje.setSelectedItem("1.1 ms");
        Tvoltaje.add(tvoltaje);
        panelselec.add(Tvoltaje);
        
        //panel tiempo de conversion de voltajes
        Tcorriente= new JPanel();
        Tcorriente.setLayout(new GridLayout(1,2,5,5));
        Tcorriente.setBackground(Fondo);//cambia el color del fondo
        t_corriente= new JLabel("Tiempo de Conversión de Corriente:");
        Tcorriente.add(t_corriente);
        // Creacion del JComboBox de tiempo conversion voltaje
	tcorriente = new JComboBox();
	tcorriente.addItem("140 us");
	tcorriente.addItem("204 us");
	tcorriente.addItem("332 us");
        tcorriente.addItem("588 us");
	tcorriente.addItem("1.1 ms");
	tcorriente.addItem("2.116 ms");
        tcorriente.addItem("4.156 ms");
	tcorriente.addItem("8.244 ms");
        tcorriente.setSelectedItem("1.1 ms");
        Tcorriente.add(tcorriente);
        panelselec.add(Tcorriente);
        //panel tiempo de muestreo de voltaje
        TMvoltaje= new JPanel();
        TMvoltaje.setLayout(new GridLayout(1,2,5,5));
        TMvoltaje.setBackground(Fondo);//cambia el color del fondo
        tv_muestreo= new JLabel("Tiempo de Muestreo de Voltaje:");
        TMvoltaje.add(tv_muestreo);
        //creacion del Jpanel de tiempo de muestreo de voltaje
        tvmuestreo= new JLabel("70.4 ms");
        tvmuestreo.setOpaque(true);
        tvmuestreo.setBackground(Color.WHITE);
        TMvoltaje.add(tvmuestreo);
        panelselec.add(TMvoltaje);
        
        //panel tiempo de muestreo de corriente
        TMcorriente= new JPanel();
        TMcorriente.setLayout(new GridLayout(1,2,5,5));
        TMcorriente.setBackground(Fondo);//cambia el color del fondo
        tc_muestreo= new JLabel("Tiempo de Muestreo de Corriente:");
        TMcorriente.add(tc_muestreo);
        //creacion del Jpanel de tiempo de muestreo de corriente
        tcmuestreo= new JLabel("70.4 ms");
        tcmuestreo.setOpaque(true);
        tvmuestreo.setBackground(Color.WHITE);
        TMcorriente.add(tcmuestreo);
        panelselec.add(TMcorriente);
        
        setter= new JButton("SET");
        setter.setBounds(3,2,1,3);
        panelselec.add(setter);          
   }
    
    public JPanel getPanel(){
       return panelselec;
        }
        
    public JButton get_button(){
        
        return setter;
    } 
    
    public int get_valor_promedio(){
        return valor_promedios;
    }
    
    public int get_valor_tvoltaje(){
        return valor_tvoltaje;
    }
    
    public int get_valor_tcorriente(){
        return valor_tcorriente;
    }
    
    //accion combobox promedios///////////////////////////////////////////////////////////////////////////////////////
    public void activar_listener(){
       //accion combobox promedio de muestras
        promedios.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
        if("1".equals(promedios.getSelectedItem())){
            valor_promedios=0;
            if("140 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("140 us");}
            else if("204 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("204 us");}
            else if("332 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("332 us");}
            else if("588 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("588 us");}
            else if("1.1 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("1.1 ms");}
            else if("2.116 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("2.116 ms");}
            else if("4.156 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("4.156 ms");}
            else if("8.244 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("8.244 ms");}
            
            if("140 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("140 us");}
            else if("204 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("204 us");}
            else if("332 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("332 us");}
            else if("588 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("588 us");}
            else if("1.1 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("1.1 ms");}
            else if("2.116 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("2.116 ms");}
            else if("4.156 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("4.156 ms");}
            else if("8.244 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("8.244 ms");}
            }
      
      else if("4".equals(promedios.getSelectedItem())){
            valor_promedios=1;
            if("140 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("560 us");}
            else if("204 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("816 us");}
            else if("332 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("1.328 ms");}
            else if("588 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("2.352 ms");}
            else if("1.1 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("4.4 ms");}
            else if("2.116 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("8.264 ms");}
            else if("4.156 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("16.624 ms");}
            else if("8.244 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("32.976 ms");}
            
            if("140 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("560 us");}
            else if("204 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("816 us");}
            else if("332 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("1.328 ms");}
            else if("588 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("2.352 ms");}
            else if("1.1 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("4.4 ms");}
            else if("2.116 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("8.264 ms");}
            else if("4.156 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("16.624 ms");}
            else if("8.244 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("32.976 ms");}
            }
           
      else if("16".equals(promedios.getSelectedItem())){
             valor_promedios=2;
             if("140 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("2.240 ms");}
            else if("204 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("3.264 ms");}
            else if("332 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("5.312 ms");}
            else if("588 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("9.408 ms");}
            else if("1.1 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("17.6 ms");}
            else if("2.116 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("33.856 ms");}
            else if("4.156 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("66.496 ms");}
            else if("8.244 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("131.904 ms");}
            
            if("140 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("2.240 ms");}
            else if("204 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("3.264 ms");}
            else if("332 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("5.312 ms");}
            else if("588 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("9.408 ms");}
            else if("1.1 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("17.6 ms");}
            else if("2.116 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("33.856 ms");}
            else if("4.156 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("66.496 ms");}
            else if("8.244 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("131.904 ms");}
            }
            
      else if("64".equals(promedios.getSelectedItem())){
            valor_promedios=3;
            if("140 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("8.960 ms");}
            else if("204 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("13.056 ms");}
            else if("332 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("21.248 ms");}
            else if("588 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("37.632 ms");}
            else if("1.1 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("70.4 ms");}
            else if("2.116 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("135.424 ms");}
            else if("4.156 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("265.984 ms");}
            else if("8.244 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("527.616 ms");}
            
            if("140 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("8.960 ms");}
            else if("204 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("13.056 ms");}
            else if("332 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("21.248 ms");}
            else if("588 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("37.632 ms");}
            else if("1.1 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("70.4 ms");}
            else if("2.116 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("135.424 ms");}
            else if("4.156 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("265.984 ms");}
            else if("8.244 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("527.616 ms");}
            }
      
      else if("128".equals(promedios.getSelectedItem())){
            valor_promedios=4;
            if("140 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("17.920 ms");}
            else if("204 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("26.112 ms");}
            else if("332 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("42.496 ms");}
            else if("588 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("75.264 ms");}
            else if("1.1 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("140.8 ms");}
            else if("2.116 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("270.848 ms");}
            else if("4.156 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("531.968 ms");}
            else if("8.244 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("1.055232 s");}
            
            if("140 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("17.920 ms");}
            else if("204 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("26.112 ms");}
            else if("332 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("42.496 ms");}
            else if("588 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("75.264 ms");}
            else if("1.1 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("140.8 ms");}
            else if("2.116 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("270.848 ms");}
            else if("4.156 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("531.968 ms");}
            else if("8.244 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("1.055232 s");}
            }
      
       else if("256".equals(promedios.getSelectedItem())){
            valor_promedios=5;
            if("140 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("35.840 ms");}
            else if("204 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("52.224 ms");}
            else if("332 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("84.992 ms");}
            else if("588 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("150.528 ms");}
            else if("1.1 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("281.6 ms");}
            else if("2.116 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("541.696 ms");}
            else if("4.156 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("1.063936 s");}
            else if("8.244 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("2.110464 s");}
            
            if("140 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("35.840 ms");}
            else if("204 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("52.224 ms");}
            else if("332 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("84.992 ms");}
            else if("588 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("150.528 ms");}
            else if("1.1 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("281.6 ms");}
            else if("2.116 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("541.696 ms");}
            else if("4.156 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("1.063936 s");}
            else if("8.244 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("2.110464 s");}
            }
      else if("512".equals(promedios.getSelectedItem())){
             valor_promedios=6;
             if("140 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("71.680 ms");}
            else if("204 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("104.448 ms");}
            else if("332 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("169.984 ms");}
            else if("588 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("301.056 ms");}
            else if("1.1 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("563.2 ms");}
            else if("2.116 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("1.083392 s");}
            else if("4.156 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("2.127872 s");}
            else if("8.244 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("4.220928 s");}
            
            if("140 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("71.680 ms");}
            else if("204 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("104.448 ms");}
            else if("332 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("169.984 ms");}
            else if("588 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("301.056 ms");}
            else if("1.1 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("563.2 ms");}
            else if("2.116 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("1.083392 s");}
            else if("4.156 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("2.127872 s");}
            else if("8.244 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("4.220928 s");}
            }
      
      else if("1024".equals(promedios.getSelectedItem())){
            valor_promedios=7;
            if("140 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("143.360 ms");}
            else if("204 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("208.896 ms");}
            else if("332 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("339.968 ms");}
            else if("588 us".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("602.112 ms");}
            else if("1.1 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("1.1264 s");}
            else if("2.116 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("2.166784 s");}
            else if("4.156 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("4.255744 s");}
            else if("8.244 ms".equals(tvoltaje.getSelectedItem())){tvmuestreo.setText("8.441856 s");}
            
            if("140 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("143.260 ms");}
            else if("204 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("208.896 ms");}
            else if("332 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("339.968 ms");}
            else if("588 us".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("602.112 ms");}
            else if("1.1 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("1.1264 s");}
            else if("2.116 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("2.166784 s");}
            else if("4.156 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("4.255744 s");}
            else if("8.244 ms".equals(tcorriente.getSelectedItem())){tcmuestreo.setText("8.441856 s");}
            }
      
   }});
       //accion combobox  tiempo muestreo voltajes
        tvoltaje.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
        if("140 us".equals(tvoltaje.getSelectedItem())){
            valor_tvoltaje=0;
            if("1".equals(promedios.getSelectedItem())){tvmuestreo.setText("140 us");}
            else if("4".equals(promedios.getSelectedItem())){tvmuestreo.setText("560 us");}
            else if("16".equals(promedios.getSelectedItem())){tvmuestreo.setText("2.240 ms");}
            else if("64".equals(promedios.getSelectedItem())){tvmuestreo.setText("8.960 ms");}
            else if("128".equals(promedios.getSelectedItem())){tvmuestreo.setText("17.920 ms");}
            else if("256".equals(promedios.getSelectedItem())){tvmuestreo.setText("35.840 ms");}
            else if("512".equals(promedios.getSelectedItem())){tvmuestreo.setText("71.680 ms");}
            else if("1024".equals(promedios.getSelectedItem())){tvmuestreo.setText("143.360 ms");}
            }
      
      else if("204 us".equals(tvoltaje.getSelectedItem())){
            valor_tvoltaje=1;
            if("1".equals(promedios.getSelectedItem())){tvmuestreo.setText("204 us");}
            else if("4".equals(promedios.getSelectedItem())){tvmuestreo.setText("816 us");}
            else if("16".equals(promedios.getSelectedItem())){tvmuestreo.setText("3.264 ms");}
            else if("64".equals(promedios.getSelectedItem())){tvmuestreo.setText("13.056 ms");}
            else if("128".equals(promedios.getSelectedItem())){tvmuestreo.setText("26.112 ms");}
            else if("256".equals(promedios.getSelectedItem())){tvmuestreo.setText("52.224 ms");}
            else if("512".equals(promedios.getSelectedItem())){tvmuestreo.setText("104.448 ms");}
            else if("1024".equals(promedios.getSelectedItem())){tvmuestreo.setText("208.896 ms");}
            }
           
      else if("332 us".equals(tvoltaje.getSelectedItem())){
             valor_tvoltaje=2;
             if("1".equals(promedios.getSelectedItem())){tvmuestreo.setText("332 us");}
            else if("4".equals(promedios.getSelectedItem())){tvmuestreo.setText("1.238 ms");}
            else if("16".equals(promedios.getSelectedItem())){tvmuestreo.setText("5.312 ms");}
            else if("64".equals(promedios.getSelectedItem())){tvmuestreo.setText("21.248 ms");}
            else if("128".equals(promedios.getSelectedItem())){tvmuestreo.setText("42.496 ms");}
            else if("256".equals(promedios.getSelectedItem())){tvmuestreo.setText("84.992 ms");}
            else if("512".equals(promedios.getSelectedItem())){tvmuestreo.setText("169.984 ms");}
            else if("1024".equals(promedios.getSelectedItem())){tvmuestreo.setText("339.968 ms");}
             }
            
      else if("588 us".equals(tvoltaje.getSelectedItem())){
            valor_tvoltaje=3;
            if("1".equals(promedios.getSelectedItem())){tvmuestreo.setText("558 us");}
            else if("4".equals(promedios.getSelectedItem())){tvmuestreo.setText("2.232 ms");}
            else if("16".equals(promedios.getSelectedItem())){tvmuestreo.setText("8.928 ms");}
            else if("64".equals(promedios.getSelectedItem())){tvmuestreo.setText("35.712 ms");}
            else if("128".equals(promedios.getSelectedItem())){tvmuestreo.setText("71.424 ms");}
            else if("256".equals(promedios.getSelectedItem())){tvmuestreo.setText("142.848 ms");}
            else if("512".equals(promedios.getSelectedItem())){tvmuestreo.setText("285.696 ms");}
            else if("1024".equals(promedios.getSelectedItem())){tvmuestreo.setText("571.392 ms");}
             }
            
      
      else if("1.1 ms".equals(tvoltaje.getSelectedItem())){
            valor_tvoltaje=4;
            if("1".equals(promedios.getSelectedItem())){tvmuestreo.setText("1.1 ms");}
            else if("4".equals(promedios.getSelectedItem())){tvmuestreo.setText("4.4 ms");}
            else if("16".equals(promedios.getSelectedItem())){tvmuestreo.setText("17.6 ms");}
            else if("64".equals(promedios.getSelectedItem())){tvmuestreo.setText("70.4 ms");}
            else if("128".equals(promedios.getSelectedItem())){tvmuestreo.setText("140.8 ms");}
            else if("256".equals(promedios.getSelectedItem())){tvmuestreo.setText("281.6 ms");}
            else if("512".equals(promedios.getSelectedItem())){tvmuestreo.setText("563.2 ms");}
            else if("1024".equals(promedios.getSelectedItem())){tvmuestreo.setText("1.1264 s");}
            }
      
      
      else if("2.116 ms".equals(tvoltaje.getSelectedItem())){
             valor_tvoltaje=5;
             if("1".equals(promedios.getSelectedItem())){tvmuestreo.setText("2.116 ms");}
            else if("4".equals(promedios.getSelectedItem())){tvmuestreo.setText("8.464 ms");}
            else if("16".equals(promedios.getSelectedItem())){tvmuestreo.setText("33.856 ms");}
            else if("64".equals(promedios.getSelectedItem())){tvmuestreo.setText("135.424 ms");}
            else if("128".equals(promedios.getSelectedItem())){tvmuestreo.setText("270.848 ms");}
            else if("256".equals(promedios.getSelectedItem())){tvmuestreo.setText("541.696 ms");}
            else if("512".equals(promedios.getSelectedItem())){tvmuestreo.setText("1.083392 s");}
            else if("1024".equals(promedios.getSelectedItem())){tvmuestreo.setText("2.166784 s");}
            }
      
      else if("4.156 ms".equals(tvoltaje.getSelectedItem())){
            valor_tvoltaje=6;
            if("1".equals(promedios.getSelectedItem())){tvmuestreo.setText("4.156 ms");}
            else if("4".equals(promedios.getSelectedItem())){tvmuestreo.setText("16.624 ms");}
            else if("16".equals(promedios.getSelectedItem())){tvmuestreo.setText("66.496 ms");}
            else if("64".equals(promedios.getSelectedItem())){tvmuestreo.setText("265.984 ms");}
            else if("128".equals(promedios.getSelectedItem())){tvmuestreo.setText("531.968 ms");}
            else if("256".equals(promedios.getSelectedItem())){tvmuestreo.setText("1.063936s");}
            else if("512".equals(promedios.getSelectedItem())){tvmuestreo.setText("2.127872 s");}
            else if("1024".equals(promedios.getSelectedItem())){tvmuestreo.setText("4.255744 s");}
            }
      else if("8.244 ms".equals(tvoltaje.getSelectedItem())){
            valor_tvoltaje=7;
            if("1".equals(promedios.getSelectedItem())){tvmuestreo.setText("8.244 ms");}
            else if("4".equals(promedios.getSelectedItem())){tvmuestreo.setText("32.976 ms");}
            else if("16".equals(promedios.getSelectedItem())){tvmuestreo.setText("131.904 ms");}
            else if("64".equals(promedios.getSelectedItem())){tvmuestreo.setText("527.616 ms");}
            else if("128".equals(promedios.getSelectedItem())){tvmuestreo.setText("1.055232 s");}
            else if("256".equals(promedios.getSelectedItem())){tvmuestreo.setText("2.110464 s");}
            else if("512".equals(promedios.getSelectedItem())){tvmuestreo.setText("4.220928 s");}
            else if("1024".equals(promedios.getSelectedItem())){tvmuestreo.setText("8.441856 s");}
            }
      
   }});
       //accion combobox tiempo muestreo corrientes 
        tcorriente.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
        if("140 us".equals(tcorriente.getSelectedItem())){
            valor_tcorriente=0;
            if("1".equals(promedios.getSelectedItem())){tcmuestreo.setText("140 us");}
            else if("4".equals(promedios.getSelectedItem())){tcmuestreo.setText("560 us");}
            else if("16".equals(promedios.getSelectedItem())){tcmuestreo.setText("2.240 ms");}
            else if("64".equals(promedios.getSelectedItem())){tcmuestreo.setText("8.960 ms");}
            else if("128".equals(promedios.getSelectedItem())){tcmuestreo.setText("17.920 ms");}
            else if("256".equals(promedios.getSelectedItem())){tcmuestreo.setText("35.840 ms");}
            else if("512".equals(promedios.getSelectedItem())){tcmuestreo.setText("71.680 ms");}
            else if("1024".equals(promedios.getSelectedItem())){tcmuestreo.setText("143.360 ms");}
            }
      
      else if("204 us".equals(tcorriente.getSelectedItem())){
            valor_tcorriente=1;
            if("1".equals(promedios.getSelectedItem())){tcmuestreo.setText("204 us");}
            else if("4".equals(promedios.getSelectedItem())){tcmuestreo.setText("816 us");}
            else if("16".equals(promedios.getSelectedItem())){tcmuestreo.setText("3.264 ms");}
            else if("64".equals(promedios.getSelectedItem())){tcmuestreo.setText("13.056 ms");}
            else if("128".equals(promedios.getSelectedItem())){tcmuestreo.setText("26.112 ms");}
            else if("256".equals(promedios.getSelectedItem())){tcmuestreo.setText("52.224 ms");}
            else if("512".equals(promedios.getSelectedItem())){tcmuestreo.setText("104.448 ms");}
            else if("1024".equals(promedios.getSelectedItem())){tcmuestreo.setText("208.896 ms");}
            }
           
      else if("332 us".equals(tcorriente.getSelectedItem())){
             valor_tcorriente=2;
             if("1".equals(promedios.getSelectedItem())){tcmuestreo.setText("332 us");}
            else if("4".equals(promedios.getSelectedItem())){tcmuestreo.setText("1.238 ms");}
            else if("16".equals(promedios.getSelectedItem())){tcmuestreo.setText("5.312 ms");}
            else if("64".equals(promedios.getSelectedItem())){tcmuestreo.setText("21.248 ms");}
            else if("128".equals(promedios.getSelectedItem())){tcmuestreo.setText("42.496 ms");}
            else if("256".equals(promedios.getSelectedItem())){tcmuestreo.setText("84.992 ms");}
            else if("512".equals(promedios.getSelectedItem())){tcmuestreo.setText("169.984 ms");}
            else if("1024".equals(promedios.getSelectedItem())){tcmuestreo.setText("339.968 ms");}
             }
            
      else if("588 us".equals(tcorriente.getSelectedItem())){
            valor_tcorriente=3;
            if("1".equals(promedios.getSelectedItem())){tcmuestreo.setText("558 us");}
            else if("4".equals(promedios.getSelectedItem())){tcmuestreo.setText("2.232 ms");}
            else if("16".equals(promedios.getSelectedItem())){tcmuestreo.setText("8.928 ms");}
            else if("64".equals(promedios.getSelectedItem())){tcmuestreo.setText("35.712 ms");}
            else if("128".equals(promedios.getSelectedItem())){tcmuestreo.setText("71.424 ms");}
            else if("256".equals(promedios.getSelectedItem())){tcmuestreo.setText("142.848 ms");}
            else if("512".equals(promedios.getSelectedItem())){tcmuestreo.setText("285.696 ms");}
            else if("1024".equals(promedios.getSelectedItem())){tcmuestreo.setText("571.392 ms");}
             }
            
      
      else if("1.1 ms".equals(tcorriente.getSelectedItem())){
            valor_tcorriente=4;
            if("1".equals(promedios.getSelectedItem())){tcmuestreo.setText("1.1 ms");}
            else if("4".equals(promedios.getSelectedItem())){tcmuestreo.setText("4.4 ms");}
            else if("16".equals(promedios.getSelectedItem())){tcmuestreo.setText("17.6 ms");}
            else if("64".equals(promedios.getSelectedItem())){tcmuestreo.setText("70.4 ms");}
            else if("128".equals(promedios.getSelectedItem())){tcmuestreo.setText("140.8 ms");}
            else if("256".equals(promedios.getSelectedItem())){tcmuestreo.setText("281.6 ms");}
            else if("512".equals(promedios.getSelectedItem())){tcmuestreo.setText("563.2 ms");}
            else if("1024".equals(promedios.getSelectedItem())){tcmuestreo.setText("1.1264 s");}
            }
      
      
      else if("2.116 ms".equals(tcorriente.getSelectedItem())){
             valor_tcorriente=5;
             if("1".equals(promedios.getSelectedItem())){tcmuestreo.setText("2.116 ms");}
            else if("4".equals(promedios.getSelectedItem())){tcmuestreo.setText("8.464 ms");}
            else if("16".equals(promedios.getSelectedItem())){tcmuestreo.setText("33.856 ms");}
            else if("64".equals(promedios.getSelectedItem())){tcmuestreo.setText("135.424 ms");}
            else if("128".equals(promedios.getSelectedItem())){tcmuestreo.setText("270.848 ms");}
            else if("256".equals(promedios.getSelectedItem())){tcmuestreo.setText("541.696 ms");}
            else if("512".equals(promedios.getSelectedItem())){tcmuestreo.setText("1.083392 s");}
            else if("1024".equals(promedios.getSelectedItem())){tcmuestreo.setText("2.166784 s");}
            }
      
      else if("4.156 ms".equals(tcorriente.getSelectedItem())){
            valor_tcorriente=6;
            if("1".equals(promedios.getSelectedItem())){tcmuestreo.setText("4.156 ms");}
            else if("4".equals(promedios.getSelectedItem())){tcmuestreo.setText("16.624 ms");}
            else if("16".equals(promedios.getSelectedItem())){tcmuestreo.setText("66.496 ms");}
            else if("64".equals(promedios.getSelectedItem())){tcmuestreo.setText("265.984 ms");}
            else if("128".equals(promedios.getSelectedItem())){tcmuestreo.setText("531.968 ms");}
            else if("256".equals(promedios.getSelectedItem())){tcmuestreo.setText("1.063936s");}
            else if("512".equals(promedios.getSelectedItem())){tcmuestreo.setText("2.127872 s");}
            else if("1024".equals(promedios.getSelectedItem())){tcmuestreo.setText("4.255744 s");}
            }
      else if("8.244 ms".equals(tcorriente.getSelectedItem())){
            valor_tcorriente=7;
            if("1".equals(promedios.getSelectedItem())){tcmuestreo.setText("8.244 ms");}
            else if("4".equals(promedios.getSelectedItem())){tcmuestreo.setText("32.976 ms");}
            else if("16".equals(promedios.getSelectedItem())){tcmuestreo.setText("131.904 ms");}
            else if("64".equals(promedios.getSelectedItem())){tcmuestreo.setText("527.616 ms");}
            else if("128".equals(promedios.getSelectedItem())){tcmuestreo.setText("1.055232 s");}
            else if("256".equals(promedios.getSelectedItem())){tcmuestreo.setText("2.110464 s");}
            else if("512".equals(promedios.getSelectedItem())){tcmuestreo.setText("4.220928 s");}
            else if("1024".equals(promedios.getSelectedItem())){tcmuestreo.setText("8.441856 s");}
            }
      
   }});
            }
    
    
}
