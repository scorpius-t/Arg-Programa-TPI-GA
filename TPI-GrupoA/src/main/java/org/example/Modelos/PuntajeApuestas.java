package org.example.Modelos;

public class PuntajeApuestas {
    private String apostador;
    private Integer puntos;

    public String getApostador() {
        return apostador;
    }

    public void setApostador(String apostador) {
        this.apostador = apostador;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "PuntajeApuestas{" +
                "apostador='" + apostador + '\'' +
                ", puntos=" + puntos +
                '}';
    }
}
