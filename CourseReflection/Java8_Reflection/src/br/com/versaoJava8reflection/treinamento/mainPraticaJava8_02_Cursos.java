package br.com.versaoJava8reflection.treinamento;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.versaoJava8reflection.treinamento.modelo.Curso;

public class mainPraticaJava8_02_Cursos {
	public static void main(String[] args) {

		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		
		cursos.forEach(curso -> {System.out.println(curso.getAlunos());});
//		System.out.println("---------------------Ordenando o curso com a menor carga horaria-----------------------");
		cursos.sort(Comparator.comparing(c -> c.getAlunos()));
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		/*----------------------------------------------------------------------------------------------------------*/
		/* Infelizmente o metodo reference nao se aplica ao toString */
		cursos.forEach(System.out::println);
		cursos.forEach(c -> System.out.println(c.getNome() + " = " + c.getAlunos()));
		cursos.forEach(c -> System.out.println(c.getAlunos()));
        /*-----------------------------------------------------------------------------------------------------------*/
		
//		System.out.println("-----------------------------fluxo--------------------------");
		/*nova forma com versao java 8 / stream(fluxo de objetos) de cursos/ Interface fluente/ metodos encadeados*/
		cursos.stream().filter(c -> c.getAlunos() >= 100).forEach(c -> System.out.println(c.getNome()));;
		/*buscando a quantidade de alunos em cada curso usando map/ poderia usar um
		 sysout para alunos contudo se fizesse esse tipo de comportamento nao poderia mais trabalhar com esse numeros*/
		/*Dado um numero de cursos eu quero a quantidade de alunos que fazem esse curso*/
		
//		System.out.println("----------------------Usando o map de stream para criterios----------------------");
		cursos.stream().filter(c -> c.getAlunos() >= 100).map(c -> c.getAlunos()).forEach(total -> System.out.println(total));;
		/*------------------------------------------------------------------------------------------------------------*/
		/*Nesse caso eu posso usar o metodo reference pra pegar a quantidade de alunos e imprimir*/
		cursos.stream().filter(c -> c.getAlunos() >= 100).map(Curso::getAlunos).forEach(System.out::println);;
		/*-------------------------------------------------------------------------------------------------------------*/
		/*stream tem varios metodos especificos pra trabalhar com integer inves do Integer com varios metodos genericos*/
		/*Ele usa um designer patterns invocando varios metodos do mesmo tipo chamado interface fluente */
		/*-------------------------------------------------------------------------------------------------------------*/
		/*em uma linha so, filtramos os alunos os cursos, filtramos tambem os que tem
		 *mais de 100 pegamos uma quantidade de alunos e somamos*/
		cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).sum();
		/*--------------------------------------------------------------------------------------------------------------*/
		/*internamente ele faz boxing e autoboxing a vantagem eh essa alem de trabalhar com um tipo determinado*/
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		/*-------------------------------------------------------------------------------------------------------------*/
		/*Exercicios*/
		cursos.stream().filter(c -> c.getAlunos() > 50).forEach(cn -> System.out.println(cn.getNome()));
		/*-------------------------------------------------------------------------------------------------------------*/
		/*Exercicio transformar Stream<Curso> em Stream<String>*/
		cursos.stream().filter(c -> c.getNome().length() > 5).forEach(curs ->System.out.println(curs.getNome()));
		/*------------------------------------------------------------------------------------------------------------*/
		/*forma certa*/
//		Stream<String> nomes = cursos.stream().map(Curso::getNome);
		/*--------------------------------------------------------------------------------------------------------------*/
		/*Em que parte desse código podemos tirar proveito da sintaxe de method reference?*/
		cursos.stream().filter(c -> c.getAlunos() > 50).map(Curso::getAlunos).forEach(System.out::println);
		/*--------------------------------------------------------------------------------------------------------------*/
		/*Filtra o object alunos e aplica uma logica e quantidade maior ou igual a 100 e seleciona qualquer um object(Aluno)*/
		cursos.stream().filter(c -> c.getAlunos() >= 100).findAny();
		/*---------------------------------------------------------------------------------------------------------------*/
		/*Optional eh uma classe nova, incluida no java 8. na verdade ele é uma classe que retorna o curso se caso existir*/
		Optional<Curso> opcurso = cursos.stream().filter(c -> c.getAlunos() >= 100).findAny();
		/*----------------------------------------------------------------------------------------------------------------*/
		/*vai retornar o cuso caso existir se nao uma exception*/
		opcurso.get();
		/*-------------------------------------------------------------------------------------------------------------------*/
		/*a melhor forma*/
//		Curso curso = opcurso.orElse(null);
		/*-------------------------------------------------------------------------------------------------------------------*/
		/*classe Option existem varios metodos interessantes que usam na melhorar do codigo*/
		opcurso.stream().filter(c -> c.getAlunos() >= 100).findAny();
		/*--------------------------------------------------------------------------------------------------------------------*/
		/*se caso existir esse curso ifPresent() imprimi os nome desse curso*/
		opcurso.ifPresent(c -> System.out.println(c.getNome()));
		/*-------------------------------------------------------------------------------------------------------------------*/
		/*normalmente usado*/
		opcurso.stream().filter(c -> c.getAlunos() > 100).findAny().ifPresent(Curso::getNome);
		/*-------------------------------------------------------------------------------------------------------------------*/
		/*A option esta atrelada ao java 8, stream, collection*/
//		OptionalDouble media = opcurso.stream().filter(c -> c.getAlunos() > 1000).mapToInt(Curso::getAlunos).average();
		/*------------------------------------------------------------------------------------------------------------------*/
	    /* se caso eu quiser guardar os objetos ou o conteudo fazendo os mesmo procedimentos acima ele sempre vai retornar
	     * a ordem orginal dessa lista ou stream, a forma certa se fazer caso eu queira guardar essa nova lista ordenada pelo stream
	     * terei que usar collect para transformar em um list, map, set etc..*/
		/*----------------------------------------------------------------------------------------------------------------------*/
		/*bem frequente usar esse tipo de forma*/
//		List<Curso> resultado = opcurso.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toList());
		/*------------------------------------------------------------------------------------------------------------------------*/
		/*mudando a collection antiga sem precisar de list*/
		 cursos =  opcurso.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toList());
		/*----------------------------------------------------------------------------------------------------------------------*/
		 /*pode ser feito pra map( map recebe duas functions) chave , valor*/
		 Map<String, Integer> map = opcurso.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		 System.out.println(map);
		 /*-------------------------------------------------------------------------------------------------------------------------*/
		 /*usando uma function pelo map*/
		 		  opcurso.stream()
				 .filter(c -> c.getAlunos() >= 100)
				 .collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
				 .forEach((nome, alunos) -> System.out.println(nome  + " tem " +alunos + " alunos"));
		 /*-----------------------------------------------------------------------------------------------------------------------*/
		/*Exercicios Stream pegar o primeiro*/
		 		 cursos.stream()
		 		   .filter(c -> c.getAlunos() > 50).findFirst();
		 /*---------------------------------------------------------------------------------------------------------------*/
		/*Calcule a quantidade média de alunos de todos os seus cursos utilizando a API de Stream.*/
//		 		OptionalDouble med = cursos.stream().mapToInt(c -> c.getAlunos()).average();
		 /*--------------------------------------------------------------------------------*/
		 /*Como podemos transformar esse Stream<Curso> filtrado em uma List<Curso>?*/
		 		List<Curso> collect = cursos.stream().filter(c -> c.getAlunos() > 50).collect(Collectors.toList());;
		 		collect.forEach(c -> System.out.println(c.getAlunos()));
		/*------------------------------------------------------------------------------------------------------------------*/
		
	}
}
