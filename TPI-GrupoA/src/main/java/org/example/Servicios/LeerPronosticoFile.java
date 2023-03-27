package org.example.Servicios;

import org.example.Modelos.Partido;
import org.example.Modelos.Pronostico;
import org.example.Modelos.Ronda;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeerPronosticoFile implements LeerPronostico {
    public List<Pronostico> leer(String ruta,List<Ronda> rondas){
        Path inputFile= Paths.get( ruta);

        List<Pronostico> pronostico=new ArrayList<>();

        try {
            for(String linea: Files.readAllLines(inputFile.toAbsolutePath())){

                String strPronostico[]=linea.split(";");
                boolean existePartido=false;

                //Control de errores:
                if (strPronostico.length != 5){
                    System.out.println("Error en la lectura del pronostico: '"+linea+"'");
                    continue;
                }
                //Busqueda de apuesta de equipos dentro de las rondas

                for(Ronda ronda:rondas) {

                    List<Partido> partidoDeRonda=ronda.getPartidos();
                    for(Partido partido:partidoDeRonda){
                        if(partido.getEquipoL().getNombre().equalsIgnoreCase(strPronostico[1]) && partido.getEquipoV().getNombre().equalsIgnoreCase(strPronostico[3]) ){
                            existePartido=true;
                            Pronostico pronosticoLectura=new Pronostico();
                            pronosticoLectura.agregar(strPronostico[0],strPronostico[1],strPronostico[2],strPronostico[3],strPronostico[4] );

                            pronostico.add(pronosticoLectura);
                        }
                    }
                }


                if (!existePartido)
                    System.out.println("No existe el partido: '"+strPronostico[1]+"' vs '"+strPronostico[3]+"'");


            }
        } catch (Exception e){
            System.out.println("Error :"+e.getMessage()+"\n"+e.getLocalizedMessage());
        }
        return pronostico;


    }

}
