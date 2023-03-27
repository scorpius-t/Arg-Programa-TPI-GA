package org.example.Modelos;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private String numero;
    private List<Partido> partido =new ArrayList<>();

    public void agregar(String numRonda, String local, String golesLocal,String visitante,String golesVisitante){
        Partido partidoIndividual=new Partido();
        Equipo equipoLocal=new Equipo();
        Equipo equipoVisitante=new Equipo();

        equipoLocal.setNombre(local);
        equipoVisitante.setNombre(visitante);

        this.setNumero(numRonda);
        partidoIndividual.setEquipoL(equipoLocal);
        partidoIndividual.setGolesEquipoL(Integer.parseInt(golesLocal));
        partidoIndividual.setEquipoV(equipoVisitante);
        partidoIndividual.setGetGolesEquipoV(Integer.parseInt(golesVisitante));

        this.partido.add(partidoIndividual);


    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Partido> getPartidos() {
        return partido;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partido = partidos;
    }

    @Override
    public String toString() {
        return "Ronda{" +
                "numero='" + numero + '\'' +
                ", partido=" + partido +
                "}\n";
    }
}
