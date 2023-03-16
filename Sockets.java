import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sockets {

    public Sockets() {
    }
    
    public static void socketReceiver() throws UnknownHostException, IOException{
        ServerSocket serverSocket = new ServerSocket(8080);

        while(true){
            Socket socket = serverSocket.accept();
            System.out.println("New conecction received: " + socket);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            FileWriter writer = new FileWriter("Data.csv");
            String line;

            while((line = reader.readLine()) != null){
                writer.write(line + "\n");
            }
            writer.close();
        }
    }
}
