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

    public int puntos(){
        int puntos=0;
        return puntos;
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
