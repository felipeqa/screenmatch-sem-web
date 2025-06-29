package br.com.alura.screenmatch;

import br.com.alura.screenmatch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.exibirMenu();














		/*
		exercicio 1
		Multiplicacao multiplicacao = (a, b) ->  {
            return (a * b);
        };

		System.out.println(multiplicacao.executar(2, 4));
		*/


		/*
		EhPrimo primo = (numero) -> {
			if (numero <= 1) return false;
			if (numero == 2) return true;
			if (numero % 2 == 0) return false;

			long limite = (long) Math.sqrt(numero);
			for (long i = 3; i <= limite; i += 2) {
				if (numero % i == 0) {
					return false;
				}
			}
			return true;
		};

		//maior numero primo long
		long numero = 9223372036854775783L;
		System.out.println(primo.validarNumeroPrimo(numero));
		 */


//		var consumoApi = new ConsumoApi();
//		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=a4fc13c3");
//		ConverteDados conversor = new ConverteDados();
//		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
//		System.out.println(dados);
//
//		json = consumoApi.obterDados(
//				"https://www.omdbapi.com/?t=gilmore+girls&season=2&episode=1&apikey=a4fc13c3");
//		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
//		System.out.println(dadosEpisodio);
//
//		json = consumoApi.obterDados(
//				"https://www.omdbapi.com/?t=gilmore+girls&season=2&apikey=a4fc13c3");
//		DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
//		System.out.println(dadosTemporada);
//
//		//sout direto
//		for (int i = 1; i <= dados.totalTemporadas(); i++){
//			json = consumoApi.obterDados(
//					"https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=a4fc13c3");
//			DadosTemporada dadosTemporada1 = conversor.obterDados(json, DadosTemporada.class);
//			System.out.println(dadosTemporada1);
//		}
//
//		List<DadosTemporada> listaTemporadas = new ArrayList<>();
//
//		for (int i = 1; i <= dados.totalTemporadas(); i++){
//			json = consumoApi.obterDados(
//					"https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=a4fc13c3");
//			DadosTemporada dadosTemporada1 = conversor.obterDados(json, DadosTemporada.class);
//			listaTemporadas.add(dadosTemporada1);
//		}
//
//		listaTemporadas.forEach( temporada -> {
//			System.out.println(temporada);
//		});
	}
}
