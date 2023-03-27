package org.example;

import org.example.Modelos.Pronostico;
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

        /*
        Lectura de pronosticos. Cada pronostico se carga en un ArrayList Pronostico que contine:
         -Partido (EquipoL, Equipo V, golesL y golesV)
         -Apostador

        Lectura de Resultados. Los resultados se cargan en un ArrayList Ronda. Cada elemento de ronda contiene:
        String N° Ronda
        ArrayList <Partido> (EquiposL/V y golesL/V)

         Proximo paso: Control de errores
         Tomare de referencia el archivo con resultados para comparar con las apuestas. Si no coinciden los equipos en
         los partidos apostados en la tabla de resultados, esa linea se descarta con un mensaje de error.
         Esto va a hacer mas facil la comparacion cuando haya que contar los puntos y aciertos

        Calculo de puntos:
        leer nombre de apostadores y generar categorias. filtrar por cada uno
        para calculo de puntos:


         */
        String archivoResultados=".\\src\\main\\java\\org\\example\\resultados.txt";
        List<Ronda> ronda=new ArrayList<>();

        ronda= leerResultadosFile.leer(archivoResultados);

        System.out.println(ronda);

        String archivoPronostico=".\\src\\main\\java\\org\\example\\pronosticos.txt";
        List<Pronostico> pronostico=new ArrayList<>();

        pronostico= leerPronosticoFile.leer(archivoPronostico);

        System.out.println(pronostico);

        //Configuración de puntos
        final int PUNTOS_ACIERTO_PARTIDO =1; // Acierto de Local empate o Visitante
        final int PUNTOS_ACIERTO_GOLES =1; // Sumar si aciertan los goles del partido - entrega 3
        final int PUNTOS_ACIERTO_RONDA =1; // sumar si acierta la totalidad de ronda - entrega 3



    }
}