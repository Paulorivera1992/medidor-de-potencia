import com.tinkerforge.AlreadyConnectedException;
import com.tinkerforge.IPConnection;
import com.tinkerforge.BrickletVoltageCurrentV2;
import com.tinkerforge.BrickletVoltageCurrentV2.CurrentListener;
import com.tinkerforge.BrickletVoltageCurrentV2.PowerListener;
import com.tinkerforge.BrickletVoltageCurrentV2.VoltageListener;
import com.tinkerforge.NetworkException;
import com.tinkerforge.TinkerforgeException;
import javax.xml.bind.Marshaller.Listener;

public class brick_medidor {
	private static String UID;
        private IPConnection ipcon;
        BrickletVoltageCurrentV2 vc;
        MedidorFrame Frame;
        int identificador;
        
        PowerListener Lis_p;
        CurrentListener Lis_c;
        VoltageListener Lis_v;

        
        
        public brick_medidor(String uid,IPConnection conect,MedidorFrame frame, int ident) throws NetworkException, AlreadyConnectedException{
           UID=uid;
           ipcon=conect;
           vc = new BrickletVoltageCurrentV2(UID, ipcon);
           Frame=frame;
           identificador=ident;
           System.out.println("uid: " + UID);
        }
        
	public void listener() throws Exception {
		// Add power listener
                Lis_p=new BrickletVoltageCurrentV2.PowerListener() {
			public void power(int power) {
			//	System.out.println("power: " + power/1000.0 + " W");
                                Frame.setBrickP(power/1000.0, identificador);
                            }
                    };
                Lis_v=new BrickletVoltageCurrentV2.VoltageListener() {
			public void voltage(int voltage) {
			//	System.out.println("voltage: " + voltage/1000.0 + " V");
                                Frame.setBrickV(voltage/1000.0, identificador);
			}
		};
                
                Lis_c=(int current) -> {
                   // System.out.println("Current: " + current/1000.0 + "A"+identificador);
                    Frame.setBrickC(current/1000.0, identificador);
                    };
                
		vc.addPowerListener(Lis_p);
		vc.addVoltageListener(Lis_v);
                vc.addCurrentListener(Lis_c);
	}
        
        public BrickletVoltageCurrentV2 get_brick(){
        
            return vc;
        }
        
        public void iniciar(int tiempo) throws TinkerforgeException, Exception{ 
            this.listener();
            vc.setVoltageCallbackConfiguration(tiempo, false, 'x', 0, 0);
            vc.setCurrentCallbackConfiguration(tiempo, false, 'x', 0, 0);
            vc.setPowerCallbackConfiguration(tiempo, false, 'x', 0, 0);
        }
        
        public void parar() throws TinkerforgeException, Exception{ 
            vc.removePowerListener(Lis_p);
            vc.removeVoltageListener(Lis_v);
            vc.removeCurrentListener(Lis_c);
        }
}