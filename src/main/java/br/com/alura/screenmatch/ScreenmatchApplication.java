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
