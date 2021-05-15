package br.com.versaoJava8reflection.treinamento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class mainPraticaJava8_03_funcoes {
	public static void main(String[] args) {

		List<String> mapped = Stream.of("hello", "world").map(word -> word + "!").collect(Collectors.toList());
		Map<String, String> mapa = mapped.stream().collect(Collectors.toMap(c -> c, c -> c));
		mapa.keySet().forEach(System.out::println);

		/*
		 * os dois valores, a e b, são Strings . Escrevemos um lambda que os combina
		 * para produzir a saída desejada, com o segundo primeiro e um travessão entre
		 * eles.
		 */

		String result = Stream.of("hello", "world").reduce("", (a, b) -> a + "-" + b);
		System.out.println(result);

		List<String> chars = Arrays.asList("A, B, C");
		List<String> numbers = Arrays.asList("1, 2, 3");
		List<String> together = new ArrayList<>();

		for (int i = 0; i < chars.size(); i++) {
			together.add(chars.get(i) + ", " + numbers.get(i));
			System.out.println(together.get(i).replace(", ", "\n"));
		}

		/*
		 * Function<Integer,Integer> printNumber = a-> a*10;
		 * System.out.println("The number is: " + printNumber.apply(10));
		 * 
		 * BiFunction<Integer,Integer,Integer> add= (a,b) -> a+b;
		 * System.out.println("The addition of two numbers are: "+ add.apply(3,2));
		 */

		/*
		 * BiFunction<Integer,Integer,Integer> calcul = (a,b) -> a/b)); (a+b ou a*b ou
		 * a-b) Integer resultado= calcul.apply(10,2); System.out.println(resultado);
		 */

		BiFunction<Integer, Integer, Integer> composicao = (a, b) -> a + b;
		composicao = composicao.andThen(a -> a / (a - 5));
		try {
			/*
			 * A expressão Lambda está sendo usada para inicializar o método apply() na
			 * interface BiFunction.
			 */
			System.out.println(composicao.apply(2, 3));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
