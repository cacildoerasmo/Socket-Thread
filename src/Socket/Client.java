package Socket;

import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("localhost", 13456);
			
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			String msg = "Eu sou o Primeiro Cliente";
			output.writeUTF(msg);
			output.flush();
			System.out.println("Mensagem <"+msg+"> enviada.");
			
			output.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
