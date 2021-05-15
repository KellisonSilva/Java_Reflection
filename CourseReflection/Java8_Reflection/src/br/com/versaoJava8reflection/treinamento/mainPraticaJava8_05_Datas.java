package br.com.versaoJava8reflection.treinamento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class mainPraticaJava8_05_Datas {

	public static void main(String[] args) {

		LocalDate hoje = LocalDate.now();
		LocalDate yearTheEnd = LocalDate.of(2030, 12, 31);

		/* saber quanto anos faltam pro fim do mundo */
		Period periodo = Period.between(hoje, yearTheEnd);
		System.out.println("Ano = " + periodo.getYears() + " anos " + "\nmes = "
		+ periodo.getMonths() + " meses " + "\nDia = " + periodo.getDays() + " dias");
		
		 LocalDate fim = yearTheEnd.plusYears(5);
		 System.out.println(fim);
		 
		 DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 String valorFormatado = fim.format(formatador);
		 System.out.println(valorFormatado);
		 
		 DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		 LocalDateTime agora = LocalDateTime.now();
		 String novoData = agora.format(formatadorComHoras);
		 System.out.println(novoData);
		 
		 
		 
	}

}
