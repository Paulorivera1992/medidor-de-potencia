import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panel_sensores {
      JPanel panelVGA;
      JLabel j12;
      JLabel j13;
      JLabel j14;
      Color Fondo=new Color(164, 213, 237);
    public Panel_sensores(String nom){
           //panel VGA1
        panelVGA= new JPanel();
        panelVGA.setLayout(new GridLayout(1,4,15,0));
        panelVGA.setBackground(Fondo);//cambia el color del fondo
        JLabel j11=new JLabel(nom,JLabel.CENTER);
        panelVGA.add(j11);
        j12=new JLabel("0.1",JLabel.CENTER);
        j12.setOpaque(true);
        j12.setBackground(Color.red);
        j12.setBorder(BorderFactory.createLineBorder(Color.white));
        panelVGA.add(j12);
        j13=new JLabel("0.1",JLabel.CENTER);
        j13.setOpaque(true);
        j13.setBackground(Color.green);
        j13.setBorder(BorderFactory.createLineBorder(Color.white));
        panelVGA.add(j13);
        j14=new JLabel("0.1",JLabel.CENTER);
        j14.setOpaque(true);
        j14.setBackground(Color.blue);
        j14.setBorder(BorderFactory.createLineBorder(Color.white));
        panelVGA.add(j14);
    }
    
    JPanel get_panel(){
      return panelVGA;
    }
    
    public JLabel set_lanel_P(){
        return j14;
    }
    
    public JLabel set_lanel_V(){
        return j13;
    }
    
    public JLabel set_lanel_C(){
        return j12;
    }
    
}
