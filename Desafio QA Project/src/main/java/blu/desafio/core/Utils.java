package blu.desafio.core;

public class Utils {
	
	public static String removerFormatacao(String valor) {
		return valor.replaceAll("\\D+","");
	}
}
