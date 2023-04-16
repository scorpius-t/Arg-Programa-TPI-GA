package org.example;

import org.example.Modelos.Pronostico;
import org.example.Modelos.PuntajeApuestas;
import org.example.Modelos.Ronda;
import org.example.Modelos.Configura;

import org.example.Servicios.LeerPronosticoFile;
import org.example.Servicios.LeerPronosticosDB;
import org.example.Servicios.LeerResultadosFile;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static LeerPronosticoFile leerPronosticoFile=new LeerPronosticoFile();
    public static LeerResultadosFile leerResultadosFile=new LeerResultadosFile();
    public static LeerPronosticosDB leerPronosticosDB=new LeerPronosticosDB();
    public static void main(String[] args) {

       Configura conf= new Configura();
       try {
           conf.instanciarConfig();
       } catch (Exception e){
           e.printStackTrace();
           System.out.println("Finalizando ejecucion por error de lectura de config.properties");
           return; // finaliza el programa por error de lectura de configuracion
       }
        final String FUENTE_DB="DB";
        final String FUENTE_FILE="File";

        String archivoResultados=".\\src\\main\\java\\org\\example\\resultados.txt";
        List<Ronda> ronda=new ArrayList<>();

        ronda= leerResultadosFile.leer(archivoResultados);

        String archivoPronostico=".\\src\\main\\java\\org\\example\\pronosticos.txt";
        List<Pronostico> pronostico=new ArrayList<>();


        switch (conf.getFuentePronostico()){
            case FUENTE_FILE:
                pronostico= leerPronosticoFile.leer(archivoPronostico,ronda);
                break;
            case FUENTE_DB:
                pronostico=leerPronosticosDB.leer(archivoPronostico, ronda);
                break;
            default:
                System.out.printf("Error en la definicion de origen de pronostico");
                return; // finaliza la ejecucion del programa
        }


        PuntajeApuestas puntajeApuestas=new PuntajeApuestas();

        puntajeApuestas.calculoDePuntos(ronda,pronostico, conf.getPtosPartido(),
                conf.getPtosGoles(), conf.getPtosRonda(), conf.getPtosFase());

        //Salida en consola

        System.out.printf("%15s %15s %15s %15s %15s \n","Ronda","Local","Goles Local","Visitante","Goles Visitante");
        System.out.println("-------------------------------------------------------------------------------------");
        ronda.forEach((r)->System.out.printf("%15s %15s %15s %15s %15s \n",r.getNumero(),r.getPartido().getEquipoL().getNombre(),
                r.getPartido().getGolesEquipoL(),r.getPartido().getEquipoV().getNombre(),r.getPartido().getGetGolesEquipoV()));
        System.out.println("\n");

        System.out.printf("%15s %15s %15s %15s %15s \n","Apostador","Local","Goles Local","Visitante","Goles Visitante");
        System.out.println("-------------------------------------------------------------------------------------");
        pronostico.forEach((r)->System.out.printf("%15s %15s %15s %15s %15s \n",r.getApostador(),r.getPartido().getEquipoL().getNombre(),
                r.getPartido().getGolesEquipoL(),r.getPartido().getEquipoV().getNombre(),r.getPartido().getGetGolesEquipoV()));
        System.out.println("\n");

        System.out.println("Puntos: "+ puntajeApuestas.getApostadorPuntos());
        System.out.println("Cantidad de aciertos: "+puntajeApuestas.getApostadorAciertos());

    }


}