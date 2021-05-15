package br.com.versaoJava8reflection.treinamento;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class mainPraticaJava8_04_Ordena_String {

	public static void main(String[] args) {

		List<String> words = new ArrayList<String>();
		words.add("alura online");
		words.add("editora casa do codigo");
		words.add("Caelum");
		
		/*no lugar das classes anonimas surge os lambdas,
		*comparator, consumer(interfaces funcionais) pra
		*facilitar na hora do desenvolvimento*/
		
		/*Quantos métodos uma interface funcional pode ter?
         1 único método abstrato. Além desse método ela pode 
         ter outros métodos, contanto que sejam default ou 'static'.*/
		
		/*lambda funciona sempre que tem uma interface que so
		 * um metodo abstrato(nome da interface = {Interface funcional}*/
		words.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {

				if (s1.length() < s2.length()) {
					return -1;
				}
				if (s1.length() > s2.length()) {
					return 1;
				}
				return 0;
			}
		});
		
		/*Nao precisa do new nem da assinatura*/
		words.sort((String s1, String s2) ->{
			if (s1.length() < s2.length()) {
				return -1;
			}
			if (s1.length() > s2.length()) {
				return 1;
			}
			return 0;
		});

		
		/*Existe uma classe que tem um metodo estatico que faz comparacoes entre 2 numeros e retorna na forma definida*/
		words.sort((String s1, String s2) ->{return Integer.compare(s1.length(), s2.length());});
		/*retorna -1 se o primeiro for maior que o segundo, 2 se segundo for maior ou 0 se forem iguais*/
		words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		/* Novo criterio de comparação */
//		Comparator<String> comparador = new ComparadorPorTamanho();

		/*
		 * Usando classe anonima normalmente implementado(Comum) quando queremos usar
		 * interfaces muito curtas que nao vai ser reaproveitadas futuramente
		 */
//		Consumer<String> consumidor= new Consumer<String>() {
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//			}
//		};

		/*
		 * Nova versao do java 8 lambda metodo consumer recebe apenas um argumento e nao
		 * eh preciso falar o tipo
		 */
		words.forEach((String s) -> {System.out.println(s);});
		/* sem passar o tipo por paramentro */
		words.forEach(s ->{System.out.println(s);});
		/* versao mais compacta */
		words.forEach(s -> System.out.println(s));

		/* versao anterior */
		words.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});

		/* Ordenada de forma alfabetica */
//		Collections.sort(words, comparador);
		System.out.println(words);

		/* Nova versao do java 8 */
//		words.sort(comparador);
		System.out.println(words);

		/* Nova forma de iterar com for */
		/* Usando o consumer para strings */
//		Consumer<String> consumidor1 = new ImprimeNaLinha();
//		words.forEach(consumidor1);
		/*
		 * Todas as collections sao iterable(interface) que contem o metodo iterator que
		 * garante que toda Colecão eh iteravel A interface é a Consumer, que possui um
		 * único método abstrato chamado accept.
		 */
		
		/*Exercicio*/
		words.forEach(palavra  -> System.out.println(palavra));
		/*versao mais compacta*/
		words.sort((s1, s2) -> s1.length() - s2.length());
		
		
		/*O código não funciona porque Object não é uma interface funcional.
        para trabalhar com lambda, uma interface funcional precisa estar envolvida.*/
//		Object o = s -> System.out.println(s);
		

		/*Exercicico*/
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		        System.out.println("Executando um Runnable");
		    }
		}).start();
		/*versao lambda(Nunca tinha visto dessa forma)*/
		new Thread(() ->System.out.println()).start();
		
		/*Usando um factory dentro da propria interface comparator recebe uma function*/
		words.sort(Comparator.comparing(s -> s.length()));
		/*ordenagem de  comparators*/
		Comparator<String> comparador1 = Comparator.comparing(s -> s.length());
		words.sort(comparador1);
		
		/*Dado uma string retorna um inteiro*/
		Function<String, Integer> funcao = s -> s.length();
		words.sort(Comparator.comparing(funcao));

		/*por baixo dos panos*/
//		Function<String, Integer> funcaoR = new Function<String, Integer>() {
//			@Override
//			public Integer apply(String s) {
//				return s.length();
//			}
//		};
//		words.sort(comparador);
		
		/*forma mais comum - comparing recebe um lambda que na verdade eh
		 * uma instancia de uma interface funcional(Function) que tem apenas um metdo default(apply)*/
		/*method reference*/
		words.sort(Comparator.comparing(String::length));
		
		/*ele pode ficar mais curto com import java.util.Comparator*/
//		import static java.util.Comparator.*;
		words.sort(comparing(String::length));
		
		/*Exercicio*/
		words.sort(Comparator.comparing(String::length));
	}
	
}

//class ComparadorPorTamanho implements Comparator<String> {
//
//	@Override
//	public int compare(String s1, String s2) {
//
//		if (s1.length() < s2.length()) {
//			return -1;
//		}
//		if (s1.length() > s2.length()) {
//			return 1;
//		}
//		return 0;
//	}
//
//}
