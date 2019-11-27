package HelloRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class RMIServer {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		if(System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		
		try {
			Hello hello = new HelloImpl();
			Naming.rebind("rmi://localhost:1009/hello", hello);
			System.out.println("Hello is registried");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e);
		}

	}

}
