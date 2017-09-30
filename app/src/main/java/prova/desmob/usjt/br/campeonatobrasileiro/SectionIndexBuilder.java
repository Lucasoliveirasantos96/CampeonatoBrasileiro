package prova.desmob.usjt.br.campeonatobrasileiro;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeSet;

/**
 * Created by arqdsis on 29/09/2017.
 */

public class SectionIndexBuilder {

    public static Object[] buildSectionHeaders(Campeonato[] campeonatos){
        ArrayList<String> resultado = new ArrayList<>();
        TreeSet<String> usados = new TreeSet<>();
        for(Campeonato campeonato:campeonatos){
            String letra = campeonato.getNome().substring(0,1);
            if((!usados.contains(letra))){
                resultado.add(letra);
            }
            usados.add(letra);
        }
        return resultado.toArray(new Object[0]);
    }
    //cria uma mapa para responder: posicao --> secao de dados ordenados pelo nome
    public static Hashtable<Integer, Integer> buildSectionForPositionMap(Campeonato[] campeonatos){
        Hashtable<Integer, Integer> resultados = new Hashtable<>();
        TreeSet<String> usados = new TreeSet<>();

        int secao = -1;

        for(int i = 0; i < campeonatos.length; i++){
            String letra = campeonatos[i].getNome().substring(0,1);

            if(!usados.contains(letra)){
                secao++;
                usados.add(letra);
            }
            resultados.put(i, secao);
        }
        return resultados;
    }

    //cria uma mapa para responder: secao --> posicao de dados ordenados pelo nome
    public static Hashtable<Integer, Integer> buildPositionForSectionMap(Campeonato[] campeonatos){
        Hashtable<Integer, Integer> resultados = new Hashtable<>();
        TreeSet<String> usados = new TreeSet<>();

        int secao = -1;

        for(int i = 0; i < campeonatos.length; i++){
            String letra = campeonatos[i].getNome().substring(0,1);

            if(!usados.contains(letra)){
                secao++;
                usados.add(letra);
                resultados.put(secao, i);
            }
        }
        return resultados;
    }
}
