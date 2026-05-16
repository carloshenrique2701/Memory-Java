package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 Nessa classe veremos alguns conceitos que fazem parte da stream:
 
 -Operação intermediária -> é uma 'lazy evaluation', pois só executa quando uma operação é executada.
 -Operação terminal -> produz umopjeto não-stream e determina o fim doprocessamento da stream.
 
 *Exemplos de Operações Intermediária (tem um pouco mais):
 -filter
 -map
 -peek
 -distinct
 -limit*
 
 *Exemplos de Operações Terminais (tem um pouco mais):
 -forEach
 -toArray
 -reduce
 -collect
 -min
 -max
 -anyMatch*
 -allMatch*
 -noneMatch*
 -findFirst*
 -findAny*
 
 --As operações com * são short-circuit, porquê ela 'corta' a execução quando a condição é satisfeita o processamento para.
 
 */

public class Program {
	public static void main(String[] args) {

		//Converte para uma Stream
		List<Integer> list = Arrays.asList(3, 4, 5, 6, 65, 12, 43);
		Stream<Integer> st1 = list.stream().map(x -> x * 10).filter(x -> x > 50);
		System.out.println(Arrays.toString(st1.toArray()));
		
		//Cria uma lista 
		Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
		System.out.println(Arrays.toString(st2.toArray()));
		
		//Cria uma stream, gera elementos a partir de 0 e depois limita a criação de 10 elementos
		Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
		System.out.println(Arrays.toString(st3.limit(10).toArray()));
		
		//Sequência de fibonacci
		Stream<Long> st4 = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] {p[1], p[0] + p[1]}).map(p -> p[0]);
		System.out.println(Arrays.toString(st4.limit(10).toArray()));
		
	}
}
