package Socket;

import java.io.*;



import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiplosClientes extends Thread {

	private Socket s = null;
	
	ObjectInputStream input;
	MultiplosClientes() throws IOException{
		
	}
	MultiplosClientes(Socket s)throws IOException{
		this.s=s;
		    input = new ObjectInputStream(s.getInputStream());

	}
	public void run() {
		String msg = new String();
		try {
			msg = input.readUTF();
		}catch(IOException ex) {
			Logger.getLogger(MultiplosClientes.class.getName()).log(Level.SEVERE, null, ex);
			
		}
		System.out.println("Mensagem Recebida: "+msg);
		try {
			System.out.println("Cliente finalizado.");
			s.close();
		}catch(IOException ex) {
			Logger.getLogger(MultiplosClientes.class.getName()).log(Level.SEVERE, null, ex);
			
		}
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{

		while(true) {
			ServerSocket ss = new ServerSocket(13456);
			System.out.println("Aguardando a conexao...");
			Socket s = ss.accept();
			MultiplosClientes t = new MultiplosClientes(s);
			t.start();
			Thread.sleep(2000);
			ss.close();
		}
	}

}
