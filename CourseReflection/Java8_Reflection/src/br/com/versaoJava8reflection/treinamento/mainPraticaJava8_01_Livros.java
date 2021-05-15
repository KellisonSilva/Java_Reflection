package br.com.versaoJava8reflection.treinamento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.versaoJava8reflection.treinamento.modelo.Livro;

public class mainPraticaJava8_01_Livros {
	public static void main(String[] args) {

		List<Livro> livros = new ArrayList<>();
		livros.add(new Livro("A vida intelectual", 86, 69, "Filosofia"));
		livros.add(new Livro("A Primeira chave", 56, 60, "Comportamental"));
		livros.add(new Livro("Introduçao a vida intelectual", 143, 41, "Resenha"));
		livros.add(new Livro("Ensaio a liberdade", 294, 100, "Filosofia"));

		livros.sort(Comparator.comparing(c -> c.getQuantidade()));
		livros.sort(Comparator.comparing(Livro::getNumeropagina));
		System.out.println("-------------------------");
		livros.forEach(livro -> System.out
				.println(livro.getNome() + "= " + livro.getQuantidade() + "/" + livro.getNumeropagina()));

		livros.stream().filter(liv -> liv.getQuantidade() > 100).map(Livro::getQuantidade).forEach(System.out::println);
		;
		System.out.println("------------------------Tipo de cada livro---------------------");
		livros.stream().filter(liv -> liv.getTipo().equalsIgnoreCase("filosofia")).map(Livro::getTipo)
				.forEach(System.out::println);
		;

		/* supplier(fornecedor) = nao recebe nada e retorna um valor */
		Stream.generate(() -> new Random().nextInt()).limit(5).filter(valor -> valor > 0).forEach(System.out::println);
		;
		Stream.generate(() -> new Random().nextInt()).limit(5).filter(c -> c.intValue() > 0)
				.forEach(System.out::println);
		;

		/* forEach = consumidor(Consumer) que so recebe e nao retorna nada */

		/*
		 * Filter = recebe um valor e retorna um valor booleano, comparaçoes, filtragem
		 * Ex: valor -> valor % 2 == 0(booleano)
		 */

		/*
		 * map = recebe um valor real e retorna outro valor Ex: map.(livro ->
		 * livro.DoubleValue())/ essa expressao nao tem relaçao com o tipo (valor real)
		 * que ele retorna toda vez que ver uma function precisara de uma expressao
		 * lambda que vai receber um valor e outro valor
		 */

		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6);
		lista.stream().filter(valor -> valor % 2 == 0).map(valor -> valor.doubleValue()).forEach(System.out::println);
		;

		/*
		 * reduce = recebe 2 valores e retorna outro valor porem tem que ser do mesmo
		 * tipo
		 */
		lista.stream().filter(valor -> valor % 2 == 0).map(valor -> valor.doubleValue()).reduce((v1, v2) -> v1 + v2)
				.ifPresent(System.out::println);
		;

		livros.forEach(c -> System.out.println(c.getNumeropagina()));
//		System.out.println("----------------antes");
		livros.stream().filter(l -> l.getNumeropagina() >= 100).map(Livro::getNumeropagina).findAny()
				.ifPresent(System.out::println);
		;

//		System.out.println("-------finded pages---------");
		livros.stream().filter(l -> l.getNumeropagina() >= 100).map(Livro::getNumeropagina).findAny()
				.ifPresent(System.out::println);
		;

//		System.out.println("---------what's name this book ? book finded-------------");
		livros.stream().filter(livro -> livro.getNome() != "").map(Livro::getNome).findFirst()
				.ifPresent(System.out::println);
		;

//		System.out.println("---------- test --------------");
		livros.sort(Comparator.comparing(liv -> liv.getNome()));
//		System.out.println("----------------- ordem alfabetica----------------");
		livros.forEach(liv -> System.out.println(liv.getNome().length() + " = tamanho do livro e o nome = "
				+ liv.getNome() + " /quantidade " + liv.getQuantidade()));
//		System.out.println("-----------------  ordem alfabetica e com duas logicas-------------");
		livros.stream()
				.filter(livro -> !livro.getNome().toLowerCase().isEmpty() && !livro.getTipo().toLowerCase().isEmpty())
				.forEach(l -> System.out.println(l.getNome() + " /tipo: " + l.getTipo()));
		;
		/*--------------------------------nova ordenacao-------------------------*/
		livros.stream().filter(livro -> !livro.getNome().isEmpty() && livro.getTipo().equalsIgnoreCase(livro.getTipo()))
				.map(Livro::getNome).collect(Collectors.toList()).forEach(l -> System.out.println(l));
		;
		/*----------------------------------------Primeiro orderna logica Ex: alfabeticamente como no exercicio abaixo ----------------------------------*/
		livros.sort(Comparator.comparing(nome -> nome.getNome()));
//		System.out.println("----------------------------------------------");
		livros.stream()
				.filter(livro -> !livro.getNome().toLowerCase().isEmpty() && !livro.getTipo().toLowerCase().isEmpty())
				.forEach(livro -> System.out.println("LIVRO: " + livro.getNome() + "\nTIPO: " + livro.getTipo()
						+ "\nQTDCARACT: " + livro.getNome().length() + "\n----------------------------"));
		;

	}
}
