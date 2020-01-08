
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulo
 */
public class graficos {
    
    DefaultCategoryDataset grafico_voltaje;
    DefaultCategoryDataset grafico_corriente;
    DefaultCategoryDataset grafico_potencia;
    JPanel panel_vga1;
    
    public graficos(){
             // VGA voltaje
        grafico_voltaje = new DefaultCategoryDataset();
        JFreeChart chart_v1=ChartFactory.createLineChart("Voltaje",
                "Tiempo","Volt",grafico_voltaje,PlotOrientation.VERTICAL,
                false,false,false);  
                                
        // VGA corriente
        grafico_corriente = new DefaultCategoryDataset();
        JFreeChart chart_c1=ChartFactory.createLineChart("Corriente",
                "Tiempo","Ampere",grafico_corriente,PlotOrientation.VERTICAL,
                false,true,false); 
        // VGA potencia
        grafico_potencia = new DefaultCategoryDataset();
        JFreeChart chart_p1=ChartFactory.createLineChart("Potencia",
                "Tiempo","Watt",grafico_potencia,PlotOrientation.VERTICAL,
                false,true,false); 
        
        CategoryPlot plotv = chart_v1.getCategoryPlot();
        CategoryPlot plotc = chart_c1.getCategoryPlot();
        CategoryPlot plotp = chart_p1.getCategoryPlot();
        CategoryAxis domainAxisv= plotv.getDomainAxis();
        ValueAxis rangeAxisv= plotv.getRangeAxis();
        domainAxisv.setLowerMargin(0.0);
        domainAxisv.setUpperMargin(0.0);
        domainAxisv.setLabelFont(new Font("SansSerif", Font.PLAIN, 15));
        domainAxisv.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10));
        domainAxisv.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        CategoryAxis domainAxisc= plotc.getDomainAxis();
        domainAxisc.setLowerMargin(0.0);
        domainAxisc.setUpperMargin(0.0);
        domainAxisc.setLabelFont(new Font("SansSerif", Font.PLAIN, 15));
        domainAxisc.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10));
        domainAxisc.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        CategoryAxis domainAxisp= plotp.getDomainAxis();
        domainAxisp.setLowerMargin(0.0);
        domainAxisp.setUpperMargin(0.0);
        domainAxisp.setLabelFont(new Font("SansSerif", Font.PLAIN, 15));
        domainAxisp.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10));
        domainAxisp.setCategoryLabelPositions(CategoryLabelPositions.UP_45);  
    
        
        // Mostrar Grafico
        ChartPanel chartPanelv1 = new ChartPanel(chart_v1);
        ChartPanel chartPanelc1 = new ChartPanel(chart_c1);
        ChartPanel chartPanelp1 = new ChartPanel(chart_p1);
        
        //panel grafico vga1
        panel_vga1=new JPanel();
        GridLayout g5 = new GridLayout(3,1);
        panel_vga1.setLayout(g5);
        panel_vga1.add(chartPanelv1);
        panel_vga1.add(chartPanelc1);
        panel_vga1.add(chartPanelp1);
    
    }
    
    JPanel get_panel(){
        return panel_vga1;
    }
    
    DefaultCategoryDataset datos_potencia(){
        return grafico_potencia;
    }
    
    DefaultCategoryDataset datos_voltaje(){
        return grafico_voltaje;
    }
    
    DefaultCategoryDataset datos_corriente(){
        return grafico_corriente;
    }
    
}
