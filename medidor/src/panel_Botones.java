import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulo
 */
public class panel_Botones {
    JPanel panelselec;
    JLabel s1;
    Panel_Muestreo panelS1;
    JPanel panelS2;
    JPanel panelS3;
    JLabel nombre;
    JButton exportar;
    JButton iniciar;
    JButton parar;
    JSlider Slider_adquisicion;
    JLabel t_adquisicion;
    
    
    Color Fondo=new Color(164, 213, 237);
    
    public panel_Botones(){
        panelselec= new JPanel();
        panelselec.setLayout(new GridLayout(3,1));
        panelselec.setBorder(BorderFactory.createLineBorder(Color.black));
        panelselec.setBackground(Fondo);//cambia el color del fondo
        
        panelS1=new Panel_Muestreo();
        panelselec.add(panelS1.getPanel());
        panelS1.activar_listener();
        
        panelS2= new JPanel();
        panelS2.setBorder(BorderFactory.createLineBorder(Color.black));
        panelS2.setLayout(new GridLayout(3,1,15,15));
        exportar= new JButton("EXPORTAR");
        exportar.setBounds(3,2,1,3);
        panelS2.add(exportar);
        iniciar= new JButton("INICIAR");
        iniciar.setBounds(3,2,1,3);
        panelS2.add(iniciar);
        parar= new JButton("PARAR");
        parar.setBounds(3,2,1,3);
        panelS2.add(parar);
        panelselec.add(panelS2);  
        
        panelS3= new JPanel();
        panelS3.setBorder(BorderFactory.createLineBorder(Color.black));
        panelS3.setLayout(new GridLayout(2,1));
        t_adquisicion= new JLabel("Tiempo adquisición ");
        Slider_adquisicion = new JSlider(60, 500, 300);
        Slider_adquisicion.setMinorTickSpacing(50);
        Slider_adquisicion.setMajorTickSpacing(100);
        Slider_adquisicion.setPaintLabels(true);
        Slider_adquisicion.setPaintTicks(true);
        t_adquisicion.setText("Tiempo de adquisición: " + Slider_adquisicion.getValue()+"[ms]");
        panelS3.add(t_adquisicion);
        panelS3.add(Slider_adquisicion, BorderLayout.CENTER);
        panelselec.add(panelS3); 
              
    }
      
      public JPanel getPanel(){
       return panelselec;
        }
      
       
    public JButton get_button_set(){
        
        return panelS1.get_button();
    } 
    
     public JButton get_button_exportar(){
        
        return exportar;
    } 
     
     public JButton get_button_iniciar(){
        
        return iniciar;
    } 
     
     public JButton get_button_parar(){
        
        return parar;
    } 
     
     public JSlider get_Slider(){
        
        return Slider_adquisicion;
    } 
     
     public JLabel get_t_adqiosicion(){
        
        return t_adquisicion;
    } 
     
    public int get_configurador(int n){
        switch(n){
            case 1: return panelS1.get_valor_promedio();
            case 2: return panelS1.get_valor_tvoltaje();
            case 3: return panelS1.get_valor_tcorriente();
        }
        return 0;
    } 
   
}