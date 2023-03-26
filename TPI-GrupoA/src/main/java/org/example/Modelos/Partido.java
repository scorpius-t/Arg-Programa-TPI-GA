package org.example.Modelos;

import java.nio.file.Files;
import java.nio.file.Path;

public class Partido {
    private Integer ronda;
    private Equipo equipoL;
    private Equipo equipoV;
    private int golesEquipoL;
    private int getGolesEquipoV;

    public ResultadoEnum resultado(Equipo equipoAux){

        ResultadoEnum resultado = new ResultadoEnum();
        return resultado;
    }

    public Equipo getEquipoL() {
        return equipoL;
    }

    public void setEquipoL(Equipo equipoL) {
        this.equipoL = equipoL;
    }

    public Equipo getEquipoV() {
        return equipoV;
    }

    public void setEquipoV(Equipo equipoV) {
        this.equipoV = equipoV;
    }

    public int getGolesEquipoL() {
        return golesEquipoL;
    }

    public void setGolesEquipoL(int golesEquipoL) {
        this.golesEquipoL = golesEquipoL;
    }

    public int getGetGolesEquipoV() {
        return getGolesEquipoV;
    }

    public void setGetGolesEquipoV(int getGolesEquipoV) {
        this.getGolesEquipoV = getGolesEquipoV;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "ronda=" + ronda +
                ", equipoL=" + equipoL +
                ", equipoV=" + equipoV +
                ", golesEquipoL=" + golesEquipoL +
                ", getGolesEquipoV=" + getGolesEquipoV +
                '}';
    }
}
