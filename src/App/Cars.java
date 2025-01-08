package App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
	public static List<String> Empresa;
	public static List<String> Toyota;
	public static List<String> Ford;
	public static List<String> Mazda;
	public static Map<String, List<String>> Empresario;
	
	static {
		Empresa = new ArrayList<>();
		Toyota = new ArrayList<>();
		Ford = new ArrayList<>();
		Mazda = new ArrayList<>();
		Empresario = new HashMap<>();
		
		Empresa.add("Toyota");
		Empresa.add("Ford");
		Empresa.add("Mazda");
		
		Toyota.add("Corolla");
		Toyota.add("Celica");
		
		Ford.add("Focus");
		
		Mazda.add("RX-7 2005");
		Mazda.add("RX-7 1998");
		
		Empresario.put("Toyota", Toyota);
		Empresario.put("Mazda", Mazda);
		Empresario.put("Ford", Ford);
	}
}
