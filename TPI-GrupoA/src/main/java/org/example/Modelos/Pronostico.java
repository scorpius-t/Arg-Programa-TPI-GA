package org.example.Modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pronostico {
    private Partido partido = new Partido();

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

       this.setPartido(partidoIndividual);


    }




    public Partido getPartido() {
        return this.partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public String getApostador() {
        return apostador;
    }

    public void setApostador(String apostador) {
        this.apostador = apostador;

    }
    public boolean isEmpty(){
        return (this.apostador.isEmpty() || this.partido.isEmpty());
    }

    @Override
    public String toString() {
        return "Pronostico{" +
                "partido=" + partido +
                ", apostador='" + apostador + '\'' +
                "}\n";
    }
}
