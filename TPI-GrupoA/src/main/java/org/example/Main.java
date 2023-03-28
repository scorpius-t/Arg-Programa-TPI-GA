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
    //Configuración de puntos - entregas futuras
    public static void main(String[] args) {

        final int PUNTOS_ACIERTO_PARTIDO =1; // Acierto de Local empate o Visitante
        final int PUNTOS_ACIERTO_GOLES =1; // Sumar si aciertan los goles del partido - entrega 3
        final int PUNTOS_ACIERTO_RONDA =1; // sumar si acierta la totalidad de ronda - entrega 3

        /*

         */
        String archivoResultados=".\\src\\main\\java\\org\\example\\resultados.txt";
        List<Ronda> ronda=new ArrayList<>();

        ronda= leerResultadosFile.leer(archivoResultados);

        System.out.println(ronda);

        String archivoPronostico=".\\src\\main\\java\\org\\example\\pronosticos.txt";
        List<Pronostico> pronostico=new ArrayList<>();

        pronostico= leerPronosticoFile.leer(archivoPronostico,ronda);

        System.out.println(pronostico);

        PuntajeApuestas puntajeApuestas=new PuntajeApuestas();

        System.out.println(puntajeApuestas.calculoDePuntos(ronda,pronostico,PUNTOS_ACIERTO_PARTIDO,PUNTOS_ACIERTO_GOLES,PUNTOS_ACIERTO_RONDA));





    }
}