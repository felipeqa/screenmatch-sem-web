package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private DadosTemporada dadosTemporada;

    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=a4fc13c3";

    public void exibirMenu() {
        System.out.println("Digite nome serie para busca");
        var nomeSerie = leitura.nextLine();
        var url = URL_BASE + nomeSerie.replace(" ", "+") + API_KEY;
        var json = consumoApi.obterDados(url);
        DadosSerie dadosSerie = converteDados.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

        List<DadosTemporada> dadosTemporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++){
            json = consumoApi.obterDados(url + "&season=" + i);
            dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
            dadosTemporadas.add(dadosTemporada);
        }

        dadosTemporadas.forEach( temporada -> {
            temporada.dadosEpisodios().forEach(episodio -> {
                System.out.println(episodio.titulo());
            });
        });

    }
}
