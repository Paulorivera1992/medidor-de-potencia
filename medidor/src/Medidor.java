

import com.tinkerforge.BrickletVoltageCurrentV2;
import com.tinkerforge.IPConnection;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;
import static javafx.scene.paint.Color.color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import static javax.swing.text.StyleConstants.setBackground;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.general.SeriesException; 
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Second; 
import org.jfree.data.time.TimeSeries; 
import org.jfree.data.time.TimeSeriesCollection; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author paulo
 */
public class Medidor {
    private static final String HOST = "localhost";
    private static final int PORT = 4223; 
    static int num_sensores=5;
    int n_disp=0;
    
   
    
     public static void main(String[] args) throws Exception {
        MedidorFrame frame = new MedidorFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        coneccion con= new coneccion(HOST,PORT,frame);
        con.conectar();
        
        while(frame.get_nsensors()<num_sensores){
            System.out.println("numero sensores: "+frame.get_nsensors());
         }
        
        brick_medidor brick1;
        brick1 = new brick_medidor(frame.get_UID(1),con.get_ipcon(),frame,1);
      //  brick1.conectar();
        frame.get_Manejador().set_brick(brick1);
        
        brick_medidor brick2;
        brick2 = new brick_medidor(frame.get_UID(2),con.get_ipcon(),frame,2);
       // brick2.conectar();
       frame.get_Manejador().set_brick(brick2);
        
        brick_medidor brick3;
        brick3 = new brick_medidor(frame.get_UID(3),con.get_ipcon(),frame,3);
       // brick3.conectar();
       frame.get_Manejador().set_brick(brick3);
        
        brick_medidor brick4;
        brick4 = new brick_medidor(frame.get_UID(4),con.get_ipcon(),frame,4);
       // brick4.conectar();
        frame.get_Manejador().set_brick(brick4);
        
        brick_medidor brick5;
        brick5 = new brick_medidor(frame.get_UID(5),con.get_ipcon(),frame,5);
       // brick5.conectar();
        frame.get_Manejador().set_brick(brick5);
        
        
        
        System.out.println("Press key to exit"); System.in.read();
	con.get_ipcon().disconnect();
        
    }
    
}

class MedidorFrame extends JFrame {
      public int contador=0;
      public int n_sensors=0;
      public String UID[]={"NULL","NULL","NULL","NULL","NULL"};
      panel_UID paneluid;
      panel_datos panelDatos;
      panel_Botones panelbotones;
      tabla_datos tabla_datos_voltaje;
      tabla_datos tabla_datos_corriente;
      tabla_datos tabla_datos_potencia;
      int contadorvoltajes=0;
      double datos_voltaje[]={0.1,0.1,0.1,0.1,0.1};
      int contadorcorriente=0;
      double datos_corriente[]={0.1,0.1,0.1,0.1,0.1};
      int contadorpotencia=0;
      double datos_potencia[]={0.1,0.1,0.1,0.1,0.1};
      
      graficos g_vga1;
      graficos g_vga2;
      graficos g_vga3;
      graficos g_vga4;
      graficos g_vga5;
      LinkedList<String> cola_vgav = new LinkedList();
      LinkedList<String> cola_vgac = new LinkedList();
      LinkedList<String> cola_vgap = new LinkedList();
            
      Manejador_eventos manejador;
      SimpleDateFormat sdp = new SimpleDateFormat("hh:mm:ss:S");
      SimpleDateFormat sdd = new SimpleDateFormat("dd/MM hh:mm:ss:S");
      
      
public MedidorFrame() throws ParseException {
      setTitle("Medidor de consumo 1");
      setSize(1200,500);//tamaño ventana
      Container cp = getContentPane();
      
     // Barra_menu menu1= new Barra_menu();
     // setJMenuBar(menu1.get_menubar());
        // Creando el Grafico de voltajes
        //Creamos el conjunto de pestañas
        JTabbedPane pestañas=new JTabbedPane();
 
       //panel principal
        JPanel panel_pincipal=new JPanel();
        GridLayout g4 = new GridLayout(1,3,0,5);
        panel_pincipal.setLayout(g4);        
               
        // Panel de uid
        paneluid=new panel_UID();

        // Panel de Datos
        panelDatos= new panel_datos();

        //panel de muestreo
        panelbotones= new panel_Botones(); 

        //creacion tabla de datos

        tabla_datos_voltaje= new tabla_datos();
        tabla_datos_corriente= new tabla_datos();
        tabla_datos_potencia= new tabla_datos();

        panel_pincipal.add(panelDatos.getPanel(), BorderLayout.WEST);
        panel_pincipal.add(panelbotones.getPanel(), BorderLayout.CENTER);
        panel_pincipal.add(paneluid.getPanel(), BorderLayout.SOUTH);  
        
        g_vga1=new graficos();
        g_vga2=new graficos();
        g_vga3=new graficos();
        g_vga4=new graficos();
        g_vga5=new graficos();
 
        //Añadimos un nombre de la pestaña y el panel
        pestañas.addTab("Datos",panel_pincipal);
        pestañas.addTab("Grafico VGA1",g_vga1.get_panel());
        pestañas.addTab("Grafico VGA2",g_vga2.get_panel());
        pestañas.addTab("Grafico VGA3",g_vga3.get_panel());
        pestañas.addTab("Grafico VGA4",g_vga4.get_panel());
        pestañas.addTab("Grafico VGA5",g_vga5.get_panel());
        pestañas.addTab("Tabla voltajes",tabla_datos_voltaje.getScroll());
        pestañas.addTab("Tabla corrientes",tabla_datos_corriente.getScroll());
        pestañas.addTab("Tabla potencias",tabla_datos_potencia.getScroll());
        cp.add(pestañas);
 
        //manejador de eventos
        manejador= new Manejador_eventos(panelbotones,tabla_datos_voltaje.getTable(),tabla_datos_corriente.getTable(),tabla_datos_potencia.getTable());
        manejador.activar_listener();
        System.out.println("todo creado");
 
}

void set_valor(char brick,String as){
    int N=Character.getNumericValue(brick);   
 switch(N){
     case 0:
            paneluid.get_uid_panel(1).setText(as);
            break;
     case 1:
            paneluid.get_uid_panel(2).setText(as);
            break;
     case 10:
            paneluid.get_uid_panel(3).setText(as);
            UID[0]=as;
            n_sensors=n_sensors+1;
            break;
     case 11:
            paneluid.get_uid_panel(4).setText(as);
            UID[1]=as;
            n_sensors=n_sensors+1;
            break;
     case 12:
            paneluid.get_uid_panel(5).setText(as);
            UID[2]=as;
            n_sensors=n_sensors+1;
            break;
     case 13:
            paneluid.get_uid_panel(6).setText(as);
            UID[3]=as;
            n_sensors=n_sensors+1;
            break;
     case 14:
            paneluid.get_uid_panel(7).setText(as);
            UID[4]=as;
            n_sensors=n_sensors+1;
            break;
     case 15:
            paneluid.get_uid_panel(8).setText(as);
            UID[5]=as;
            n_sensors=n_sensors+1;
            break;
     default:
            break;      
 }
}


void setBrickP(double power,int id){
    panelDatos.get_label_p(id).setText(Double.toString(power));
    switch(id){
        case 1:datos_potencia[0]=power;
               contadorpotencia=contadorpotencia+1;
                break;
        case 2:datos_potencia[1]=power;
               contadorpotencia=contadorpotencia+1;
               break;
        case 3:datos_potencia[2]=power;
               contadorpotencia=contadorpotencia+1;
               break;
        case 4:datos_potencia[3]=power;
               contadorpotencia=contadorpotencia+1;
               break;
        case 5:datos_potencia[4]=power;
               contadorpotencia=contadorpotencia+1;
               break;
    }

 if(contadorpotencia==5){
     String fecha=sdp.format(new Date());
     String fecha1=sdd.format(new Date());
     cola_vgap.addFirst(fecha);
     Object[] ans = {fecha1,(double) datos_potencia[0],(double) datos_potencia[1],(double) datos_potencia[2],(double) datos_potencia[3],(double) datos_potencia[4]};
     tabla_datos_potencia.new_valor(ans);
     contadorpotencia=0;
     g_vga1.datos_potencia().addValue(datos_potencia[0], "VGA1", fecha);
     g_vga2.datos_potencia().addValue(datos_potencia[1], "VGA1", fecha);
     g_vga3.datos_potencia().addValue(datos_potencia[2], "VGA1", fecha);
     g_vga4.datos_potencia().addValue(datos_potencia[3], "VGA1", fecha);
     g_vga5.datos_potencia().addValue(datos_potencia[4], "VGA1", fecha);
     if(cola_vgap.size()==40){
         String fecha_eliminar= cola_vgap.removeLast();
         g_vga1.datos_potencia().removeValue("VGA1",fecha_eliminar);
         g_vga2.datos_potencia().removeValue("VGA1",fecha_eliminar);
         g_vga3.datos_potencia().removeValue("VGA1",fecha_eliminar);
         g_vga4.datos_potencia().removeValue("VGA1",fecha_eliminar);
         g_vga5.datos_potencia().removeValue("VGA1",fecha_eliminar);
     }
    }
}

void setBrickV(double power,int id){
panelDatos.get_label_v(id).setText(Double.toString(power));
switch(id){
        case 1:datos_voltaje[0]=power;
               contadorvoltajes=contadorvoltajes+1;
                break;
        case 2:datos_voltaje[1]=power;
               contadorvoltajes=contadorvoltajes+1;
               break;
        case 3:datos_voltaje[2]=power;
               contadorvoltajes=contadorvoltajes+1;
               break;
        case 4:datos_voltaje[3]=power;
               contadorvoltajes=contadorvoltajes+1;
               break;
        case 5:datos_voltaje[4]=power;
               contadorvoltajes=contadorvoltajes+1;
               break;
    }

 if(contadorvoltajes==5){
     String fecha=sdp.format(new Date());
     cola_vgav.addFirst(fecha);
     String fecha1=sdd.format(new Date());
     Object[] ans = {fecha1,(double) datos_voltaje[0],(double) datos_voltaje[1],(double) datos_voltaje[2],(double) datos_voltaje[3],(double) datos_voltaje[4]};
     tabla_datos_voltaje.new_valor(ans);
     contadorvoltajes=0;
     g_vga1.datos_voltaje().addValue(datos_voltaje[0], "VGA1", fecha);
     g_vga2.datos_voltaje().addValue(datos_voltaje[1], "VGA1", fecha);
     g_vga3.datos_voltaje().addValue(datos_voltaje[2], "VGA1", fecha);
     g_vga4.datos_voltaje().addValue(datos_voltaje[3], "VGA1", fecha);
     g_vga5.datos_voltaje().addValue(datos_voltaje[4], "VGA1", fecha);
     if(cola_vgav.size()==40){
         String fecha_eliminar=cola_vgav.removeLast();
         g_vga1.datos_voltaje().removeValue("VGA1", fecha_eliminar);
         g_vga2.datos_voltaje().removeValue("VGA1", fecha_eliminar);
         g_vga3.datos_voltaje().removeValue("VGA1", fecha_eliminar);
         g_vga4.datos_voltaje().removeValue("VGA1", fecha_eliminar);
         g_vga5.datos_voltaje().removeValue("VGA1", fecha_eliminar);
       }
    }
}

void setBrickC(double power,int id){
panelDatos.get_label_c(id).setText(Double.toString(power));
switch(id){
        case 1:datos_corriente[0]=power;
               contadorcorriente=contadorcorriente+1;
                break;
        case 2:datos_corriente[1]=power;
               contadorcorriente=contadorcorriente+1;
               break;
        case 3:datos_corriente[2]=power;
               contadorcorriente=contadorcorriente+1;
               break;
        case 4:datos_corriente[3]=power;
               contadorcorriente=contadorcorriente+1;
               break;
        case 5:datos_corriente[4]=power;
               contadorcorriente=contadorcorriente+1;
               break;
    }

 if(contadorcorriente==5){
     String fecha=sdp.format(new Date());
     String fecha1=sdd.format(new Date());
     cola_vgac.addFirst(fecha);
     Object[] ans = {fecha1,(double) datos_corriente[0],(double) datos_corriente[1],(double) datos_corriente[2],(double) datos_corriente[3],(double) datos_corriente[4]};
     tabla_datos_corriente.new_valor(ans);
     contadorcorriente=0;
     g_vga1.datos_corriente().addValue(datos_corriente[0], "VGA1", fecha);
     g_vga2.datos_corriente().addValue(datos_corriente[1], "VGA1", fecha);
     g_vga3.datos_corriente().addValue(datos_corriente[2], "VGA1", fecha);
     g_vga4.datos_corriente().addValue(datos_corriente[3], "VGA1", fecha);
     g_vga5.datos_corriente().addValue(datos_corriente[4], "VGA1", fecha);
     if(cola_vgac.size()==40){
         String fecha_eliminar=cola_vgac.removeLast();
         g_vga1.datos_corriente().removeValue("VGA1", fecha_eliminar);
         g_vga2.datos_corriente().removeValue("VGA1", fecha_eliminar);
         g_vga3.datos_corriente().removeValue("VGA1", fecha_eliminar);
         g_vga4.datos_corriente().removeValue("VGA1", fecha_eliminar);
         g_vga5.datos_corriente().removeValue("VGA1", fecha_eliminar);
     }
    }
}


String get_UID(int n){
switch(n){
     case 1:
            return UID[0];
     case 2:
            return UID[1];
     case 3:
            return UID[2];
     case 4:
            return UID[3];
     case 5:
            return UID[4];
     default:
             return null;      
 }
}

int get_nsensors(){
  return n_sensors;
}   

void add_brick(brick_medidor b1){
    
     manejador.set_brick(b1);
 }

Manejador_eventos get_Manejador(){
    return manejador;

}

}

