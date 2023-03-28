package org.example.Modelos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PuntajeApuestas {
    private Map<String,Integer> apostadorPuntos=new HashMap<>();
    private String apostador2;
    private Integer puntos2;

    public String getApostador2() {
        return apostador2;
    }

    public void setApostador2(String apostador2) {
        this.apostador2 = apostador2;
    }

    public Integer getPuntos2() {
        return puntos2;
    }

    public void setPuntos2(Integer puntos2) {
        this.puntos2 = puntos2;
    }
/*
    public PuntajeApuestas(String apostador, Integer puntos) {
        this.setApostador2(apostador);
        this.setPuntos2(puntos);
    }
*/
    public Map<String,Integer> calculoDePuntos(List<Ronda> rondas, List<Pronostico> pronosticos , int ptoPartido, int ptoGoles, int ptoRonda){
        Map<String,Integer> puntaje=new HashMap<>();


        /*
        Calcular puntaje


        recorrer partidos de todas las rondas comparando equiposL y equivosV de esta clase. Si hay coincidencia,
        comparar goles de pronostico con ronda (si V>L V=L V<L). Si hay acierto, ver en puntaje (lista de apostadores y puntaje)
        si existe apostador (si no existe crearlo), sumar ptoPartido a puntaje.puntaje (usando getter y setter)

        devolver puntaje

         */

        for(Pronostico pronostico:pronosticos) {
            if (puntaje.isEmpty())
                puntaje.put(pronostico.getApostador(), 0);


            if (!puntaje.containsKey(pronostico.getApostador()))
                puntaje.put(pronostico.getApostador(), 0);

            for(Partido partidoPronostico:pronostico.getPartidos()){


                for (Ronda ronda : rondas) {

                    List<Partido> partidoDeRonda = ronda.getPartidos();
                    for (Partido partido : partidoDeRonda) {
                        boolean isPronosticoLocal= (partido.getGolesEquipoL()>partido.getGetGolesEquipoV() && partidoPronostico.getGolesEquipoL()>partidoPronostico.getGetGolesEquipoV());
                        boolean isPronosticoVisitante= (partido.getGolesEquipoL()<partido.getGetGolesEquipoV() && partidoPronostico.getGolesEquipoL()<partidoPronostico.getGetGolesEquipoV());
                        boolean isPronosticoEmpate= (partido.getGolesEquipoL()<partido.getGetGolesEquipoV() && partidoPronostico.getGolesEquipoL()<partidoPronostico.getGetGolesEquipoV());

                        if(isPronosticoLocal||isPronosticoEmpate||isPronosticoVisitante){

                            Integer puntos= puntaje.get(pronostico.getApostador())+ptoPartido;
                            puntaje.put(pronostico.getApostador(),puntos);
                            System.out.println(pronostico.getApostador()+puntaje.get(pronostico.getApostador()));


                        }

                    }
                }
            }

        }

        return puntaje;
    }
    @Override
    public String toString() {
        return "PuntajeApuestas{" +
                "apostador='" + apostador2 + '\'' +
                ", puntos=" + puntos2 +
                '}';
    }
}
