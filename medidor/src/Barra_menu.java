import javax.swing.*;


public class Barra_menu extends JFrame{
        JMenuBar bmenu;
    public Barra_menu(){
        bmenu= new JMenuBar();
        JMenu inicio= new JMenu("Inicio");
        JMenu Estanques= new JMenu("Estanques");
        JMenu Bombas= new JMenu("Bombas");
        JMenu Valvulas= new JMenu("Valvulas");
        inicio.add(new JMenuItem("Primera Opcion"));
        inicio.add(new JSeparator());
        ButtonGroup Botones= new ButtonGroup();
        JRadioButtonMenuItem b1= new JRadioButtonMenuItem("opcion1");
        Botones.add(b1);
        inicio.add(b1);
        bmenu.add(inicio);
        bmenu.add(Estanques);
        bmenu.add(Bombas);
        bmenu.add(Valvulas);
        //setJMenuBar(bmenu);
        //pack();
       // setVisible(true);
      }
    JMenuBar get_menubar(){
    
        return bmenu;
    }
}
