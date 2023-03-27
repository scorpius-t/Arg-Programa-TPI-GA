package org.example.Servicios;

import org.example.Modelos.Pronostico;
import org.example.Modelos.Ronda;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeerResultadosFile implements LeerResultados {
    public List<Ronda> leer(String ruta){
        Path inputFile= Paths.get( ruta);

        List<Ronda> ronda=new ArrayList<>();

        try {
            for(String linea: Files.readAllLines(inputFile.toAbsolutePath())){

                String strResultados[]=linea.split(";");

                if (strResultados.length != 5){
                    System.out.println("Error en la lectura del Resultado: '"+linea+"'");
                    continue;
                }
                Ronda resultadoLectura=new Ronda();
                resultadoLectura.agregar(strResultados[0],strResultados[1],strResultados[2],strResultados[3],strResultados[4] );

                ronda.add(resultadoLectura);


            }
        } catch (Exception e){
            System.out.println("Error :"+e.getMessage()+"\n"+e.getLocalizedMessage());
        }
        return ronda;


    }

}
