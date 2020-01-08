
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulo
 */
public class ClockLabel extends JLabel implements ActionListener {
 
  String type;
  SimpleDateFormat sdf;
  SimpleDateFormat sdp;
  Date d;
 
  public ClockLabel(String type) {
    this.type = type;
    setForeground(Color.black);
    sdf = new SimpleDateFormat("hh:mm:ss");
    sdp = new SimpleDateFormat("hh:mm:ss:S");
    setFont(new Font("sans-serif", Font.PLAIN, 20));
    setBorder(BorderFactory.createLineBorder(Color.black));
    setHorizontalAlignment(SwingConstants.CENTER);
    Timer t = new Timer(1, this);
    t.start();
  }
 
  @Override
  public void actionPerformed(ActionEvent ae) {
    d = new Date();
    setText(sdf.format(d));
  //  System.out.println("time: " + sdf.format(d) );
  //  System.out.println("time: " + d.getSeconds() );
  }
  
  public Date time(){
      return d;
  }
}