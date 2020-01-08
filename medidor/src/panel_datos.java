import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class panel_datos {//creacion del panel de datos
    JPanel panelDatos;//panel principal
    JPanel panelNombreGeneral;//panel de nombres
    JPanel panelNombreTitulo;//panel para poner titulo
    JPanel panelNombresVariables;//panel de valores y nombres
    Panel_sensores panelVGA1;//panel sensor 1
    Panel_sensores panelVGA2;//panel sensor 1
    Panel_sensores panelVGA3;//panel sensor 1
    Panel_sensores panelVGA4;//panel sensor 1
    Panel_sensores panelVGA5;//panel sensor 1
    ClockLabel timeLable;
    
    Color Fondo=new Color(164, 213, 237);
    
    public panel_datos(){
        
        //panel principal
        panelDatos= new JPanel();
        panelDatos.setLayout(new GridLayout(7,1,15,15));
        panelDatos.setBorder(BorderFactory.createLineBorder(Color.black));//cambia el color de la linea
        panelDatos.setBackground(Fondo);//cambia el color del fondo
        
        //panelNombreGeneral
         panelNombreGeneral= new JPanel();
         panelNombreGeneral.setLayout(new GridLayout(2,1));
         panelNombreGeneral.setBackground(Fondo);//cambia el color del fondo
        //panel nombres titulo
        panelNombreTitulo= new JPanel();
        panelNombreTitulo.setBackground(Fondo);//cambia el color del fondo
        panelNombreTitulo.add(new JLabel("VALORES INSTANTANEOS",JLabel.CENTER));
       // panelNombreTitulo.setBorder(BorderFactory.createLineBorder(Color.black));//cambia el color de la linea
        panelNombreGeneral.add(panelNombreTitulo);//agregamos los nombres al panel
           //panel nombres variables
        panelNombresVariables= new JPanel();
        panelNombresVariables.setLayout(new GridLayout(1,4));
        panelNombresVariables.setBackground(Fondo);//cambia el color del fondo
        panelNombresVariables.add(new JLabel("",JLabel.CENTER));
        panelNombresVariables.add(new JLabel("Amps[A]",JLabel.CENTER));
        panelNombresVariables.add(new JLabel("Volts[V]",JLabel.CENTER));
        panelNombresVariables.add(new JLabel("Watts[W]",JLabel.CENTER));
        panelNombreGeneral.add(panelNombresVariables);//agregamos los nombres al panel
        panelDatos.add(panelNombreGeneral);//agregamos los nombres al panel
        
        //panel sensores
        panelVGA1=new Panel_sensores("vga1");
        panelDatos.add(panelVGA1.get_panel());//agregamos los nombres al panel
        panelVGA2=new Panel_sensores("vga2");
        panelDatos.add(panelVGA2.get_panel());//agregamos los nombres al panel
        panelVGA3=new Panel_sensores("vga3");
        panelDatos.add(panelVGA3.get_panel());//agregamos los nombres al panel
        panelVGA4=new Panel_sensores("vga4");
        panelDatos.add(panelVGA4.get_panel());//agregamos los nombres al panel
        panelVGA5=new Panel_sensores("vga5");
        panelDatos.add(panelVGA5.get_panel());//agregamos los nombres al panel
        
        timeLable = new ClockLabel("time");
        panelDatos.add(timeLable);
    }
    
    public JPanel getPanel(){

    return panelDatos;
}
    
    public JLabel get_label_p(int n){
        
        switch(n){
            case 1: return panelVGA1.set_lanel_P();
            case 2: return panelVGA2.set_lanel_P();
            case 3: return panelVGA3.set_lanel_P();
            case 4: return panelVGA4.set_lanel_P();
            case 5: return panelVGA5.set_lanel_P();
        }
        return null;
    }
    public JLabel get_label_v(int n){
        
        switch(n){
            case 1: return panelVGA1.set_lanel_V();
            case 2: return panelVGA2.set_lanel_V();
            case 3: return panelVGA3.set_lanel_V();
            case 4: return panelVGA4.set_lanel_V();
            case 5: return panelVGA5.set_lanel_V();
        }
        return null;
    }
    public JLabel get_label_c(int n){
        
        switch(n){
            case 1: return panelVGA1.set_lanel_C();
            case 2: return panelVGA2.set_lanel_C();
            case 3: return panelVGA3.set_lanel_C();
            case 4: return panelVGA4.set_lanel_C();
            case 5: return panelVGA5.set_lanel_C();
        }
        return null;
    }
    public Date get_tiempo() {
        return timeLable.time();
   }
    
}
