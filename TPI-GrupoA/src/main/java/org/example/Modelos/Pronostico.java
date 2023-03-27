package org.example.Modelos;

import java.util.ArrayList;
import java.util.List;

public class Pronostico {
    private List<Partido> partido = new ArrayList<>();

    private String apostador;

    public void agregar(String apostador, String local, String golesLocal,String visitante,String golesVisitante){
       Partido partidoIndividual=new Partido();
       Equipo equipoLocal=new Equipo();
       Equipo equipoVisitante=new Equipo();

       equipoLocal.setNombre(local);
       equipoVisitante.setNombre(visitante);

       this.setApostador(apostador);
        partidoIndividual.setEquipoL(equipoLocal);
        partidoIndividual.setGolesEquipoL(Integer.parseInt(golesLocal));
        partidoIndividual.setEquipoV(equipoVisitante);
        partidoIndividual.setGetGolesEquipoV(Integer.parseInt(golesVisitante));

       this.partido.add(partidoIndividual);


    }

    public List<PuntajeApuestas> calculoDePuntos(List<Ronda> ronda,int ptoPartido,int ptoGoles, int ptoRonda){
        List<PuntajeApuestas> puntaje= (List<PuntajeApuestas>) new PuntajeApuestas();
        /*
        Calcular puntaje


        recorrer partidos de todas las rondas comparando equiposL y equivosV de esta clase. Si hay coincidencia,
        comparar goles de pronostico con ronda (si V>L V=L V<L). Si hay acierto, ver en puntaje (lista de apostadores y puntaje)
        si existe apostador (si no existe crearlo), sumar ptoPartido a puntaje.puntaje (usando getter y setter)

        devolver puntaje

         */

        return puntaje;
    }

    public String getApostador() {
        return apostador;
    }

    public void setApostador(String apostador) {
        this.apostador = apostador;

    }

    @Override
    public String toString() {
        return "Pronostico{" +
                "partido=" + partido +
                ", apostador='" + apostador + '\'' +
                "}\n";
    }
}
