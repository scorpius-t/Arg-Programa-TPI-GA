package org.example.Modelos;

import java.util.*;
import java.util.stream.Collectors;

public class PuntajeApuestas {
    private Map<String, Integer> apostadorPuntos = new HashMap<>();
    private Map<String, Integer> apostadorAciertos = new HashMap<>();

    public Map<String, Integer> getApostadorPuntos() {
        return this.apostadorPuntos;
    }

    public void setApostadorPuntos(Map<String, Integer> apostadorPuntos) {
        this.apostadorPuntos = apostadorPuntos;
    }

    public void calculoDePuntos(List<Ronda> rondas, List<Pronostico> pronosticos, int ptoPartido, int ptoGoles, int ptoRonda) {
        Map<String, Integer> puntaje = new HashMap<>();
        Map<String, Integer> aciertos = new HashMap<>();
        for (Pronostico pronostico : pronosticos) {
            if (puntaje.isEmpty()) {
                puntaje.put(pronostico.getApostador(), 0);
                aciertos.put(pronostico.getApostador(), 0);
            }

            if (!puntaje.containsKey(pronostico.getApostador())) {
                puntaje.put(pronostico.getApostador(), 0);
                aciertos.put(pronostico.getApostador(), 0);
            }
            Partido partidoPronostico = new Partido();

            if (!pronostico.isEmpty()) {
                partidoPronostico = pronostico.getPartido();
            } else {
                System.out.println("ERROR INDICE LINEA PRONOSTICO");
                puntaje.clear();
                puntaje.put("ERROR DE CALCULO", 0);
                this.setApostadorPuntos(puntaje);

                aciertos.put("ERROR DE CALCULO", 0);
                this.setApostadorAciertos(aciertos);
                return;
            }

            for (Ronda ronda : rondas) {

                Partido partidoDeRonda = ronda.getPartido();

/*
                        String debug1=partido.getEquipoL().getNombre()+partido.getEquipoV().getNombre();
                        String debug2=partidoPronostico.getEquipoL().getNombre()+partidoPronostico.getEquipoV().getNombre();
                        System.out.println(debug1+"\n"+debug2);
*/

                    boolean coincidenEquipoL=partidoDeRonda.getEquipoL().getNombre().equalsIgnoreCase(partidoPronostico.getEquipoL().getNombre());
                    boolean coincidenEquipoV=partidoDeRonda.getEquipoV().getNombre().equalsIgnoreCase(partidoPronostico.getEquipoV().getNombre());

                    if ( coincidenEquipoL && coincidenEquipoV) {

                        boolean isPronosticoLocal = (partidoDeRonda.getGolesEquipoL() > partidoDeRonda.getGetGolesEquipoV() && partidoPronostico.getGolesEquipoL() > partidoPronostico.getGetGolesEquipoV());
                        boolean isPronosticoVisitante = (partidoDeRonda.getGolesEquipoL() < partidoDeRonda.getGetGolesEquipoV() && partidoPronostico.getGolesEquipoL() < partidoPronostico.getGetGolesEquipoV());
                        boolean isPronosticoEmpate = (partidoDeRonda.getGolesEquipoL() == partidoDeRonda.getGetGolesEquipoV() && partidoPronostico.getGolesEquipoL() == partidoPronostico.getGetGolesEquipoV());

                        if (isPronosticoLocal || isPronosticoEmpate || isPronosticoVisitante) {

                            Integer puntos = puntaje.get(pronostico.getApostador()) + ptoPartido;

                            boolean aciertoDeGoles=(partidoDeRonda.getGolesEquipoL()==partidoPronostico.getGolesEquipoL())&&
                                    partidoDeRonda.getGetGolesEquipoV()==partidoPronostico.getGetGolesEquipoV();
                            if (aciertoDeGoles)
                                puntos+=ptoGoles;

                            puntaje.put(pronostico.getApostador(), puntos);

                            aciertos.put(pronostico.getApostador(),aciertos.get(pronostico.getApostador())+1);

                            // System.out.println(pronostico.getApostador() + puntaje.get(pronostico.getApostador())+"\n---------------------------");

                        }
                    }
                }
            }

        /*
        Calculo de puntos extra por acierto total de partidos - Practica de expresiones lambda
          El cualculo de puntos también se podría reescribir para simplificarlo, pero como la consigna
          permite el menor impacto respecto a entregas anteriores, lo dejo como está.
        */
        Set<String> apostadores=puntaje.keySet();
        for(String apostador:apostadores) {
            if (puntajePerfecto(apostador,pronosticos,rondas)) {
                puntaje.put(apostador, (puntaje.get(apostador) + ptoRonda));
                System.out.println(apostador+" tuvo puntaje perfecto");
            }
        }

        this.setApostadorPuntos(puntaje);
        this.setApostadorAciertos(aciertos);

        return;
    }

    private boolean puntajePerfecto(String apostador,List<Pronostico> pronosticos, List<Ronda> rondas){
            List<Pronostico> pronosticoDeApostador=pronosticos.stream()
                    .filter(x -> x.getApostador().equalsIgnoreCase(apostador))
                    .collect(Collectors.toList()); // genero lista de pronosticos de 1 apostador

            List<Partido> partidosDeApostador=new ArrayList<>();
            pronosticoDeApostador.forEach((p)->partidosDeApostador.add(p.getPartido())); // genero lista de partidos de 1 apostador

            List<Partido> partidosDeRonda=new ArrayList<>();
            rondas.forEach(ronda ->partidosDeRonda.add(ronda.getPartido()) ); // genero lista de partidos de ronda (para comparar)

            return (partidosDeRonda.equals(partidosDeApostador)); //comparo partidos -
            // tuve que hacer override de equals y hashmap de clases Partido y Equipo para que funcione la funcion equals
    }

    public Map<String, Integer> getApostadorAciertos() {
        return apostadorAciertos;
    }

    public void setApostadorAciertos(Map<String, Integer> apostadorAciertos) {
        this.apostadorAciertos = apostadorAciertos;
    }

    public String toString() {
        return apostadorPuntos.toString();
    }
}
/*       Set<String> apostadores=puntaje.keySet();
        for(String apostador:apostadores) {
            List<Pronostico> pronosticoDeApostador=pronosticos.stream()
                    .filter(x -> x.getApostador().equalsIgnoreCase(apostador))
                    .collect(Collectors.toList()); // genero lista de pronosticos de 1 apostador

            List<Partido> partidosDeApostador=new ArrayList<>();
            pronosticoDeApostador.forEach((p)->partidosDeApostador.add(p.getPartido())); // genero lista de partidos de 1 apostador

            List<Partido> partidosDeRonda=new ArrayList<>();
            rondas.forEach(ronda ->partidosDeRonda.add(ronda.getPartido()) ); // genero lista de partidos de ronda (para comparar)

            if (partidosDeRonda.equals(partidosDeApostador)) { //comparo partidos - tuve que hacer override de equals y hashmap de clases Partido y Equipo
                puntaje.put(apostador, (puntaje.get(apostador) + ptoRonda));
                System.out.println(apostador+" tuvo puntaje perfecto");
            }
        }
*/