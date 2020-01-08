import javax.swing.*;
import java.awt.*;

public class panel_UID {//creacion del panel de datos
    JPanel panelDatos;//panel principal
    JPanel panelNombres;//panel de valores y nombres
    JPanel panelUID;//panel sensor 1
    JLabel j11;
    JLabel j12;
    JLabel j13;
    JLabel j14;
    JLabel j15;
    JLabel j16;
    JLabel j17;
    
    Color Fondo=new Color(164, 213, 237);
    
    public panel_UID(){
        
        //panel principal
        panelDatos= new JPanel();
        panelDatos.setLayout(new GridLayout(1,2,0,0));
        panelDatos.setBorder(BorderFactory.createLineBorder(Color.black));//cambia el color de la linea
        panelDatos.setBackground(Fondo);//cambia el color del fondo
        
           //panel nombres
        panelNombres= new JPanel();
        panelNombres.setLayout(new GridLayout(7,1));
        panelNombres.setBackground(Fondo);//cambia el color del fondo
        panelNombres.add(new JLabel("M BRICK #1"));
        panelNombres.add(new JLabel("M BRICK #2"));
        panelNombres.add(new JLabel("VGA1"));
        panelNombres.add(new JLabel("VGA2"));
        panelNombres.add(new JLabel("VGA3"));
        panelNombres.add(new JLabel("VGA4"));
        panelNombres.add(new JLabel("VGA5"));
        panelDatos.add(panelNombres);//agregamos los nombres al panel
        
        //panel uid
        panelUID= new JPanel();
        panelUID.setLayout(new GridLayout(7,1));
        panelUID.setBackground(Fondo);//cambia el color del fondo
        j11=new JLabel("");
        panelUID.add(j11);
        j11.setBorder(BorderFactory.createLineBorder(Color.black));
        j11.setOpaque(true);
        j11.setBackground(Color.white);
        j12=new JLabel("");
        panelUID.add(j12);
        j12.setBorder(BorderFactory.createLineBorder(Color.black));
        j12.setOpaque(true);
        j12.setBackground(Color.white);
        j13=new JLabel("");
        panelUID.add(j13);
        j13.setBorder(BorderFactory.createLineBorder(Color.black));
        j13.setOpaque(true);
        j13.setBackground(Color.white);
        j14=new JLabel("");
        panelUID.add(j14);
        j14.setBorder(BorderFactory.createLineBorder(Color.black));
        j14.setOpaque(true);
        j14.setBackground(Color.white);
        j15=new JLabel("");
        panelUID.add(j15);
        j15.setBorder(BorderFactory.createLineBorder(Color.black));
        j15.setOpaque(true);
        j15.setBackground(Color.white);
        j16=new JLabel("");
        panelUID.add(j16);
        j16.setBorder(BorderFactory.createLineBorder(Color.black));
        j16.setOpaque(true);
        j16.setBackground(Color.white);
        j17=new JLabel("");
        panelUID.add(j17);
        j17.setBorder(BorderFactory.createLineBorder(Color.black));
        j17.setOpaque(true);
        j17.setBackground(Color.white);
        
        
        panelDatos.add(panelUID);//agregamos los nombres al panel
    }
    
    public JPanel getPanel(){

    return panelDatos;
}
    
    JLabel get_uid_panel(int n){
        
        switch(n){
            case 1: return j11;
            case 2: return j12;
            case 3: return j13;
            case 4: return j14;
            case 5: return j15;
            case 6: return j16;
            case 7: return j17;
                   
        }
        return null;
    }
    
}
