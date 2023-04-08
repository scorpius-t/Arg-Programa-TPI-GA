package org.example;

import org.example.Modelos.Pronostico;
import org.example.Modelos.PuntajeApuestas;
import org.example.Modelos.Ronda;
import org.example.Servicios.LeerPronostico;
import org.example.Servicios.LeerPronosticoFile;
import org.example.Servicios.LeerResultadosFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static LeerPronosticoFile leerPronosticoFile=new LeerPronosticoFile();
    public static LeerResultadosFile leerResultadosFile=new LeerResultadosFile();
    public static void main(String[] args) {

        final int PUNTOS_ACIERTO_PARTIDO =1; // Acierto de Local empate o Visitante
        final int PUNTOS_ACIERTO_GOLES =1; // Acierto por goles de un parido (no suma puntos si se acierta de un solo equipo)
        final int PUNTOS_ACIERTO_RONDA =2; // sumar si acierta la totalidad de los partidos pronosticados

        /*

         */
        String archivoResultados=".\\src\\main\\java\\org\\example\\resultados.txt";
        List<Ronda> ronda=new ArrayList<>();

        ronda= leerResultadosFile.leer(archivoResultados);

        String archivoPronostico=".\\src\\main\\java\\org\\example\\pronosticos.txt";
        List<Pronostico> pronostico=new ArrayList<>();

        pronostico= leerPronosticoFile.leer(archivoPronostico,ronda);

        PuntajeApuestas puntajeApuestas=new PuntajeApuestas();

        puntajeApuestas.calculoDePuntos(ronda,pronostico,PUNTOS_ACIERTO_PARTIDO,PUNTOS_ACIERTO_GOLES,PUNTOS_ACIERTO_RONDA);

        System.out.println("Puntos: "+ puntajeApuestas.getApostadorPuntos());
        System.out.println("Cantidad de aciertos: "+puntajeApuestas.getApostadorAciertos());




    }
}