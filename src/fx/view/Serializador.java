package fx.view;

import g4.Universidad;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializador {
	
	
	
	public static void serializar(Universidad universidad){
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream("universidad.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(universidad);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in universidad.ser");
	      }
		catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	public static Universidad Deserializar()
	   {
	      Universidad u = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("universidad.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         u = (Universidad) in.readObject();
	         in.close();
	         fileIn.close();
	         
	         return u;
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return null;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("universidad class not found");
	         c.printStackTrace();
	         return null;
	      }
	      
	    }

}
