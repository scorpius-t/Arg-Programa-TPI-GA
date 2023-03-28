package org.example.Modelos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PuntajeApuestas {
    private Map<String, Integer> apostadorPuntos = new HashMap<>();

    public Map<String, Integer> getApostadorPuntos() {
        return apostadorPuntos;
    }

    public void setApostadorPuntos(Map<String, Integer> apostadorPuntos) {
        this.apostadorPuntos = apostadorPuntos;
    }

    public Map<String, Integer> calculoDePuntos(List<Ronda> rondas, List<Pronostico> pronosticos, int ptoPartido, int ptoGoles, int ptoRonda) {
        Map<String, Integer> puntaje = new HashMap<>();

        for (Pronostico pronostico : pronosticos) {
            if (puntaje.isEmpty())
                puntaje.put(pronostico.getApostador(), 0);


            if (!puntaje.containsKey(pronostico.getApostador()))
                puntaje.put(pronostico.getApostador(), 0);


            Partido partidoPronostico = new Partido();

            if (pronostico.getPartidos().size() == 1) {
                partidoPronostico = pronostico.getPartidos().get(pronostico.getPartidos().size() - 1);
            } else {
                System.out.println("ERROR INDICE LINEA PRONOSTICO");
                puntaje.clear();
                puntaje.put("ERROR CALCULO", 0);
                this.setApostadorPuntos(puntaje);
                return puntaje;
            }

            for (Ronda ronda : rondas) {

                List<Partido> partidoDeRonda = ronda.getPartidos();


                for (Partido partido : partidoDeRonda) {
/*
                        String debug1=partido.getEquipoL().getNombre()+partido.getEquipoV().getNombre();
                        String debug2=partidoPronostico.getEquipoL().getNombre()+partidoPronostico.getEquipoV().getNombre();
                        System.out.println(debug1+"\n"+debug2);
*/
                    if (partido.getEquipoL().getNombre().equalsIgnoreCase(partidoPronostico.getEquipoL().getNombre()) &&
                            partido.getEquipoV().getNombre().equalsIgnoreCase(partidoPronostico.getEquipoV().getNombre())) {
                        boolean isPronosticoLocal = (partido.getGolesEquipoL() > partido.getGetGolesEquipoV() && partidoPronostico.getGolesEquipoL() > partidoPronostico.getGetGolesEquipoV());
                        boolean isPronosticoVisitante = (partido.getGolesEquipoL() < partido.getGetGolesEquipoV() && partidoPronostico.getGolesEquipoL() < partidoPronostico.getGetGolesEquipoV());
                        boolean isPronosticoEmpate = (partido.getGolesEquipoL() == partido.getGetGolesEquipoV() && partidoPronostico.getGolesEquipoL() == partidoPronostico.getGetGolesEquipoV());

                        if (isPronosticoLocal || isPronosticoEmpate || isPronosticoVisitante) {

                            Integer puntos = puntaje.get(pronostico.getApostador()) + ptoPartido;
                            puntaje.put(pronostico.getApostador(), puntos);
                            // System.out.println(pronostico.getApostador() + puntaje.get(pronostico.getApostador())+"\n---------------------------");

                        }


                    }


                }

            }


        }
        this.setApostadorPuntos(puntaje);
        return puntaje;
    }

    public String toString() {
        return apostadorPuntos.toString();
    }
}
