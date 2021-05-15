package br.com.versaoJava8reflection.treinamento;

public class mainPraticaJava8_06_StringBuilder {

	public static void main(String[] args) {

		StringBuilder builder = new StringBuilder("Socorram");
		builder.append("-");
		builder.append("me");
		builder.append(", ");
		builder.append("subi ");
		builder.append("no ");
		builder.append("ônibus ");
		builder.append("em ");
		builder.append("Marrocos");
		String texto = builder.toString();
		System.out.println(texto);
		
		CharSequence cs = new StringBuilder("também é uma sequencia de caracteres");
		System.out.println(cs);
		System.out.println(builder.length());
		System.out.println(builder.substring(0, 10));
		System.out.println(builder.charAt(0));
		
	
	}

}
