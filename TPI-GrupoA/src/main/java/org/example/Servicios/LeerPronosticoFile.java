package org.example.Servicios;

import org.example.Modelos.Pronostico;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeerPronosticoFile implements LeerPronostico {
    public List<Pronostico> leer(String ruta){
        Path inputFile= Paths.get( ruta);

        List<Pronostico> pronostico=new ArrayList<>();

        try {
            for(String linea: Files.readAllLines(inputFile.toAbsolutePath())){

                String strPronostico[]=linea.split(";");

                if (strPronostico.length != 5){
                    System.out.println("Error en la lectura del pronostico: '"+linea+"'");
                    continue;
                }
                Pronostico pronosticoLectura=new Pronostico();
                pronosticoLectura.agregar(strPronostico[0],strPronostico[1],strPronostico[2],strPronostico[3],strPronostico[4] );

                pronostico.add(pronosticoLectura);


            }
        } catch (Exception e){
            System.out.println("Error :"+e.getMessage()+"\n"+e.getLocalizedMessage());
        }
        return pronostico;


    }

}
