import com.tinkerforge.IPConnection;

public class coneccion {
	private  String HOST;
	private  int PORT;
        IPConnection ipcon;
        MedidorFrame Frame;
       
        public coneccion(String host, int port,MedidorFrame frame){
            HOST=host;
            PORT=port;
            Frame=frame;
        }
        
        public void conectar()throws Exception{
          ipcon = new IPConnection();
	  ipcon.connect(HOST, PORT);
          this.listener();
          ipcon.enumerate();
                 
        }
        
        public void desconectar()throws Exception{
          ipcon.disconnect();
        }
        
        public IPConnection get_ipcon(){
        
           return ipcon;
        }
      
	public void listener() throws Exception {
		
		ipcon.addEnumerateListener(new IPConnection.EnumerateListener() {
			public void enumerate(String uid, String connectedUid, char position,
			                      short[] hardwareVersion, short[] firmwareVersion,
			                      int deviceIdentifier, short enumerationType) {
				System.out.println("UID:               " + uid);
				System.out.println("Enumeration Type:  " + enumerationType);

				if(enumerationType == IPConnection.ENUMERATION_TYPE_DISCONNECTED) {
					System.out.println("");
					return;
				}

				System.out.println("Connected UID:     " + connectedUid);
				System.out.println("Position:          " + position);
				System.out.println("Hardware Version:  " + hardwareVersion[0] + "." +
				                                           hardwareVersion[1] + "." +
				                                           hardwareVersion[2]);
				System.out.println("Firmware Version:  " + firmwareVersion[0] + "." +
				                                           firmwareVersion[1] + "." +
				                                           firmwareVersion[2]);
				System.out.println("Device Identifier: " + deviceIdentifier);
				System.out.println("");
                                if(connectedUid.equals("6sQDd6")){
                                              Frame.set_valor('e', uid);
                                              }
                                else{
                                               Frame.set_valor(position, uid);
                                                }
                                
			}
		});
	}
}