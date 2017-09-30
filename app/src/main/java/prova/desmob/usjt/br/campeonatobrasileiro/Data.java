package prova.desmob.usjt.br.campeonatobrasileiro;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by arqdsis on 29/09/2017.
 */

public class Data {
    public static ArrayList<String> listarNomes(Campeonato[] campeonatos) {
        ArrayList<String> nomes = new ArrayList<>();
        for (Campeonato campeonatos1 : campeonatos) {
            nomes.add(campeonatos1.getNome());
        }
        return nomes;
    }

    public static Campeonato[] listarcampeonato(String campeonato) {
        Campeonato[] lista;
        ArrayList<Campeonato> campeonatos = new ArrayList<>();
        //carrega somente os paises da regiao escolhida
        for (Campeonato campeonato1 : todosCampeonatos()) {
            if (campeonato1.getRegiao().equals(campeonato) || campeonato.equals("Todos")) {
                campeonatos.add(campeonato1);
            }
        }
        //converte para vetor para poder ordenar usando o sort da classe Arrays
        lista = campeonatos.toArray(new Campeonato[0]);
        //ordena baseado no compareTo sobrescrito na classe Pais
        //para funcionar, a classe pais precisa implementar a interface Comparable
        Arrays.sort(lista);

        return lista;
    }

    private static ArrayList<Campeonato> todosCampeonatos() {
        ArrayList<Campeonato> campeonato = new ArrayList<>();
        Campeonato campeonato1;
        ArrayList<String> idiomas;
        ArrayList<String> moedas;
        ArrayList<String> dominios;
        ArrayList<String> fronteiras;
        ArrayList<String> fusos;
        campeonato1 = new Campeonato();
        campeonato1.setNome("Afghanistan");
        campeonato1.setCodigo3("AFG");
        campeonato1.setCapital("Kabul");
        campeonato1.setRegiao("Asia");
        campeonato1.setSubRegiao("Southern Asia");
        campeonato1.setDemonimo("Afghan");
        campeonato1.setPopulacao(27657145);
        campeonato1.setArea(652230);
        campeonato1.setBandeira("https://restcountries.eu/data/afg.svg");
        campeonato1.setGini(27.80);
        idiomas = new ArrayList<>();
        idiomas.add("Pashto");
        idiomas.add("Uzbek");
        idiomas.add("Turkmen");
        campeonato1.setIdiomas(idiomas);
        moedas = new ArrayList<>();
        moedas.add("Afghan afghani");
        campeonato1.setMoedas(moedas);
        dominios = new ArrayList<>();
        dominios.add(".af");
        campeonato1.setDominios(dominios);
        fusos = new ArrayList<>();
        fusos.add("UTC+04:30");
        campeonato1.setFusos(fusos);
        fronteiras = new ArrayList<>();
        fronteiras.add("IRN");
        fronteiras.add("PAK");
        fronteiras.add("TKM");
        fronteiras.add("UZB");
        fronteiras.add("TJK");
        fronteiras.add("CHN");
        campeonato1.setFronteiras(fronteiras);
        campeonato1.setLatitude(33.000000);
        campeonato1.setLongitude(65.000000);
        campeonato.add(campeonato1);

        campeonato1 = new Campeonato();
        campeonato1.setNome("Åland Islands");
        campeonato1.setCodigo3("ALA");
        campeonato1.setCapital("Mariehamn");
        campeonato1.setRegiao("Europe");
        campeonato1.setSubRegiao("Northern Europe");
        campeonato1.setDemonimo("Ålandish");
        campeonato1.setPopulacao(28875);
        campeonato1.setArea(1580);
        campeonato1.setBandeira("https://restcountries.eu/data/ala.svg");
        campeonato1.setGini(0.00);
        idiomas = new ArrayList<>();
        idiomas.add("Swedish");
        campeonato1.setIdiomas(idiomas);
        moedas = new ArrayList<>();
        moedas.add("Euro");
        campeonato1.setMoedas(moedas);
        dominios = new ArrayList<>();
        dominios.add(".ax");
        campeonato1.setDominios(dominios);
        fusos = new ArrayList<>();
        fusos.add("UTC+02:00");
        campeonato1.setFusos(fusos);
        fronteiras = new ArrayList<>();
        campeonato1.setFronteiras(fronteiras);
        campeonato1.setLatitude(60.116667);
        campeonato1.setLongitude(19.900000);
        campeonato.add(campeonato1);

    }
}



