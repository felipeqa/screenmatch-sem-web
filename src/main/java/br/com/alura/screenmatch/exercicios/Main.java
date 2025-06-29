package br.com.alura.screenmatch.exercicios;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //filtrar apenas pares
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream()
                .filter(numero -> numero % 2 == 0)
                .forEach(System.out::println);

        //converter todas palavras em letra maiuscula
        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        palavras.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //filtre os números ímpares, multiplique cada um por 2 e colete os resultados em uma nova lista.
        List<Integer> numeros2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> listaNUmeros = numeros2.stream()
                .filter(num2 -> num2 % 2 != 0)
                .map(num2 -> num2 * 2)
                .toList();
        System.out.println(listaNUmeros);

        //remova as duplicatas (palavras que aparecem mais de uma vez) e imprima o resultado.
        List<String> palavras2 = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        palavras2.stream()
                .distinct()
                .forEach(System.out::println);

        //Dada a lista de sublistas de números inteiros abaixo, extraia todos os números primos em uma única lista e os ordene em ordem crescente.
        List<List<Integer>> listaDeNumeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );

        ///como imprimir a lista achatada
        List<Integer> listaPrimos = listaDeNumeros.stream()
                .flatMap(lista -> lista.stream())
                .toList();
        System.out.println("lista primo " + listaPrimos);
        System.out.println("lista listaDeNumeros " + listaDeNumeros);

        List<Integer> listaNumPrimo = listaDeNumeros.stream()
                .flatMap(Collection::stream)
                .filter(num -> ehPrimo(num) == true)
                .collect(Collectors.toList());
        System.out.println(listaNumPrimo);

        //filtre as pessoas com mais de 18 anos, extraia os nomes e imprima-os em ordem alfabética. A classe Pessoa está definida abaixo.

        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 22),
                new Pessoa("Bob", 17),
                new Pessoa("Charlie", 19)
        );

        pessoas.stream()
                .filter(pessoa -> pessoa.idade > 18)
                .map(Pessoa::getNome)
                .sorted()
                .forEach(System.out::println);

        List<Integer> numeros4 = Arrays.asList(1, 2, 3, 4, 5);

        int soma = numeros4.stream()
                .peek(n -> System.out.println("Elemento: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Conteúdo depois do map: " + n))
                .reduce(0, (total, numero) -> total + numero);

        System.out.println("A soma dos números é: " + soma);

    }

    private static boolean ehPrimo(int numero) {
        if (numero < 2) return false; // Números menores que 2 não são primos
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Divisível por outro número que não 1 e ele mesmo
            }
        }
        return true;
    }
}
