
import com.tinkerforge.BrickletVoltageCurrentV2;
import com.tinkerforge.TinkerforgeException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulo
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Manejador_eventos {
    panel_Botones botones;
    Boolean inicio=false;
    brick_medidor bri1;
    List<brick_medidor> bri = new ArrayList<brick_medidor>();
    JTable jTablev;
    JTable jTablec;
    JTable jTablep;
    
    public Manejador_eventos(panel_Botones b1,JTable jTable1 ,JTable jTable2,JTable jTable3)
    {   
        botones=b1;
        jTablev=jTable1;
        jTablec=jTable2;
        jTablep=jTable3;
    }
    
     public void activar_listener() {
    
    botones.get_button_set().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e){
                    if (e.getSource()==botones.get_button_set()){
                        int Vpromedio=botones.get_configurador(1);
                        int Vtvoltaje=botones.get_configurador(2);
                        int Vtcorriente=botones.get_configurador(3);
                        for (int index = 0; index < bri.size(); index++) {
                            bri1=bri.get(index);
                        try {
                            bri1.get_brick().setConfiguration(botones.get_configurador(1),botones.get_configurador(2),botones.get_configurador(3));
                        } catch (TinkerforgeException ex) {
                            Logger.getLogger(Manejador_eventos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                    } 
                }           
            });
    
    botones.get_button_iniciar().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e){
                    inicio=true;
                    if (e.getSource()==botones.get_button_iniciar()){
                        for (int index = 0; index < bri.size(); index++) {
                            bri1=bri.get(index);
                            try {
                                bri1.iniciar(botones.get_Slider().getValue());
                            } catch (Exception ex) {
                                Logger.getLogger(Manejador_eventos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } 
                }           
            });
    
    botones.get_button_parar().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e){
                    inicio=false;
                    if (e.getSource()==botones.get_button_parar()){
                        for (int index = 0; index < bri.size(); index++) {
                            bri1=bri.get(index);
                            try {
                                bri1.parar();
                            } catch (Exception ex) {
                                Logger.getLogger(Manejador_eventos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } 
                }           
            });
    
    botones.get_button_exportar().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e){
                    if (jTablev.getRowCount() > 0) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                List<JTable> tb = new ArrayList<JTable>();
                List<String> nom = new ArrayList<String>();
                tb.add(jTablep);
                tb.add(jTablec);
                tb.add(jTablev);
                nom.add("Potencia");
                nom.add("Corriente");
                nom.add("Voltaje");
                String file = chooser.getSelectedFile().toString().concat(".xls");
              try {
                    Exporter exp = new Exporter(new File(file), tb, nom);
                    if (exp.export()) {
                        JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel en el directorio seleccionado", "Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, "Hubo un error " + exp.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
                }  
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay datos para exportar","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        } 
                }           
            });
    
    botones.get_Slider().addChangeListener(new ChangeListener() {@Override public void stateChanged(ChangeEvent e){
                   
                   botones.get_t_adqiosicion().setText("Tiempo de adquisición: " + botones.get_Slider().getValue()+"[ms]");
                   if(inicio){
                    for (int index = 0; index < bri.size(); index++) {
                            bri1=bri.get(index);
                            try {
                                bri1.parar();
                                bri1.iniciar(botones.get_Slider().getValue());
                            } catch (Exception ex) {
                                Logger.getLogger(Manejador_eventos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }           
            });
  
    }
    
    
     
     
     public void set_brick(brick_medidor br){
        bri.add(br);
     }
    
}
            


