package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++){
            json = consumoApi.obterDados(url + "&season=" + i);
            dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }

        System.out.println("TEMPORADAS \n" + temporadas);

        temporadas.forEach(temporada -> {
            temporada.dadosEpisodios().forEach(episodio -> {
                System.out.println(episodio.titulo());
            });
        });

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(temporada -> temporada.dadosEpisodios().stream())
                .collect(Collectors.toList()); //permite adicionar na lista
//                .toList(); lista imutavel

        System.out.println("DADOS EPISODIOS" + "\n");
        dadosEpisodios.stream().forEach(System.out::println);

        dadosEpisodios.stream()
                .filter(episodio -> !episodio.avaliacao().equalsIgnoreCase("N/A"))
                .peek(ep -> System.out.println("filtro n/a: " + ep))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);


        List<Episodio> episodios = temporadas.stream()
                .flatMap(temporada -> temporada.dadosEpisodios().stream()
                        .map(episodio -> new Episodio(temporada.numero(), episodio)))
                .collect(Collectors.toList());

        System.out.println(episodios);

        System.out.println("Digite um trecho do episodio:");
        var trechoEpisodio = leitura.nextLine();

        Optional<Episodio> episodioEncontrado = episodios.stream()
                .filter(episodio -> episodio.getTitulo().toUpperCase().contains(trechoEpisodio.toUpperCase()))
                .findFirst();

        if (episodioEncontrado.isPresent()) {
            System.out.println("Episodio encontrado: " + episodioEncontrado.get().getTitulo());
            System.out.println("Temporada: " + episodioEncontrado.get().getTemporada());
        } else {
            System.out.println("Episodio não encontrado!!!");
        }

        System.out.println("A partir de que ano vc deseja ver os episódios?");

        var ano = leitura.nextInt();
        leitura.nextLine();

        LocalDate date = LocalDate.of(ano, 1, 1);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(episodio -> episodio.getDataLancamento() != null && episodio.getDataLancamento().isAfter(date))
                .forEach(episodio -> {
                    System.out.println( "Temporada: " + episodio.getTemporada() +
                            " Episódio: " + episodio.getTitulo() +
                            " Data lançamento: " + episodio.getDataLancamento().format(formatador));
                });

    }
}
