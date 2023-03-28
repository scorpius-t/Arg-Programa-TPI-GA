package org.example.Modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pronostico {
    private List<Partido> partidos = new ArrayList<>();

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

       this.partidos.add(partidoIndividual);


    }


    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partido) {
        this.partidos = partido;
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
                "partido=" + partidos +
                ", apostador='" + apostador + '\'' +
                "}\n";
    }
}
