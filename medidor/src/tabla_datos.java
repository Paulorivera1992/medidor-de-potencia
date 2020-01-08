
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulo
 */
public class tabla_datos {
    JPanel panelTablas;//panel principal
    JScrollPane scrollPane;
    DefaultTableModel dtm;
    final JTable table;
    Object datos[][] = { };
    String[] columnNames = {"Tiempo","VGA1","VGA2","VGA3","VGA4","VGA5"};

    public tabla_datos(){
        dtm= new DefaultTableModel(datos,columnNames);
        table = new JTable(dtm);
        scrollPane=new JScrollPane(table);
        System.out.println(table.getColumnName(0));
    }
    
    
    
    public JScrollPane getScroll(){
        return scrollPane;
        }
    
    public JTable getTable(){
        return table;
        }
    
    void new_valor(Object[] dato){
        dtm.addRow(dato);
    }
    
    public void eliminar(){
        DefaultTableModel tb = (DefaultTableModel) table.getModel();
        int a = table.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
        tb.removeRow(tb.getRowCount()-1);
        }
        //cargaTicket();
    }
    
}
