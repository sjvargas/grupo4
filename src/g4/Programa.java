package g4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Programa {
	public List<List<String>> lista_programas = new ArrayList<List<String>>();


	public Programa() throws IOException{
		lista_programas.add(new ArrayList<String>());
		File file = new File("calculo1.txt");
		if (file != null) {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lista_programas.get(0).add(line);
			}
			fileReader.close();
		}		
		lista_programas.add(new ArrayList<String>());
		File file2 = new File("calculo2.txt");
		if (file != null) {
			FileReader fileReader = new FileReader(file2);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lista_programas.get(0).add(line);
			}
			fileReader.close();
		}		
		lista_programas.add(new ArrayList<String>());
		File file3 = new File("calculo3.txt");
		if (file != null) {
			FileReader fileReader = new FileReader(file3);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lista_programas.get(0).add(line);
			}
			fileReader.close();
		}		
		lista_programas.add(new ArrayList<String>());
		File file4 = new File("algebralineal.txt");
		if (file != null) {
			FileReader fileReader = new FileReader(file4);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lista_programas.get(0).add(line);
			}
			fileReader.close();
		}		
		lista_programas.add(new ArrayList<String>());
		File file5 = new File("programacionavanzada.txt");
		if (file != null) {
			FileReader fileReader = new FileReader(file5);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lista_programas.get(0).add(line);
			}
			fileReader.close();
		}
	}
}
