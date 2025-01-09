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
	public static List<String> Dodge;
	public static Map<String, List<String>> Empresario;
	
	static {
		Empresa = new ArrayList<>();
		Toyota = new ArrayList<>();
		Ford = new ArrayList<>();
		Mazda = new ArrayList<>();
		Dodge = new ArrayList<>();
		Empresario = new HashMap<>();
		
		Empresa.add("Toyota");
		Empresa.add("Ford");
		Empresa.add("Mazda");
		Empresa.add("Dodge");
		
		Toyota.add("Corolla");
		Toyota.add("Celica");
		Toyota.add("Supra");
		
		Ford.add("Focus");
		Ford.add("Fiesta");
		
		Mazda.add("RX-7 2005");
		Mazda.add("RX-7 1998");
		
		Dodge.add("Challenger");
		Dodge.add("Viper");
		
		Empresario.put("Toyota", Toyota);
		Empresario.put("Mazda", Mazda);
		Empresario.put("Ford", Ford);
		Empresario.put("Dodge", Dodge);
	}
}
