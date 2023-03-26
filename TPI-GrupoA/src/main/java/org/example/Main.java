package org.example;

import org.example.Modelos.Pronostico;
import org.example.Servicios.LeerPronostico;
import org.example.Servicios.LeerPronosticoFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static LeerPronosticoFile leerPronosticoFile=new LeerPronosticoFile();
    public static void main(String[] args) {

        /*
        Lectura de pronosticos. Cada pronostico se carga en un ArrayList Pronostico que contine:
         -Partido (EquipoL, Equipo V, golesL golesV y ronda(proximamente)
         -Apostador

         Proximo paso (ademas de control de errores), generare una rutina para lectura de los resultados el cual
         será un ArrayList con Partidos (EquipoL, Equipo V, golesL golesV y ronda(proximamente))

         Una vez que tenga las 2 rutinas de lectura voy a hacer un control de errores:
         Tomo de referencia el archivo con resultados para comparar con las apuestas. Si no coinciden los equipos en
         los partidos apostados en la tabla de resultados, esa linea se descarta con un mensaje de error.
         Esto va a hacer mas facil la comparacion cuando haya que contar los puntos y aciertos



         */

        String archivoPronostico=".\\src\\main\\java\\org\\example\\pronosticos.txt";
        List<Pronostico> pronostico=new ArrayList<>();

        pronostico= leerPronosticoFile.leer(archivoPronostico);

        System.out.println(pronostico);
    }
}