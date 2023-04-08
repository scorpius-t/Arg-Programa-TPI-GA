package org.example.Modelos;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.leerPronosticoFile;
import static org.example.Main.leerResultadosFile;
import static org.junit.jupiter.api.Assertions.*;

public class PuntajeApuestasTest {
    final int PUNTOS_ACIERTO_PARTIDO =1; // Acierto de Local empate o Visitante
    final int PUNTOS_ACIERTO_GOLES =1; // Sumar si aciertan los goles del partido - entrega 3
    final int PUNTOS_ACIERTO_RONDA =2; // sumar si acierta la totalidad de ronda - entrega 3
    final String archivoResultados=".\\src\\test\\java\\org\\example\\Modelos\\testResultados.txt";

    final String  archivoPronostico=".\\src\\test\\java\\org\\example\\Modelos\\testPronosticos.txt";

    @Test
    public void aciertoGanadorEmpate_ok() {

       List<Ronda> ronda=new ArrayList<>();
       ronda= leerResultadosFile.leer(archivoResultados);

       List<Pronostico> pronostico=new ArrayList<>();

       pronostico= leerPronosticoFile.leer(archivoPronostico,ronda);

       PuntajeApuestas puntajeApuestas=new PuntajeApuestas();

       puntajeApuestas.calculoDePuntos(ronda,pronostico,PUNTOS_ACIERTO_PARTIDO,PUNTOS_ACIERTO_GOLES,PUNTOS_ACIERTO_RONDA);

       int calculoEsperado=(PUNTOS_ACIERTO_PARTIDO*4);

       assertEquals(calculoEsperado,puntajeApuestas.getApostadorPuntos().get("aciertoGanadorEmpate"));

    }
@Test
    public void aciertoUnPartido_ok() {

        List<Ronda> ronda=new ArrayList<>();
        ronda= leerResultadosFile.leer(archivoResultados);

        List<Pronostico> pronostico=new ArrayList<>();

        pronostico= leerPronosticoFile.leer(archivoPronostico,ronda);

        PuntajeApuestas puntajeApuestas=new PuntajeApuestas();

        puntajeApuestas.calculoDePuntos(ronda,pronostico,PUNTOS_ACIERTO_PARTIDO,PUNTOS_ACIERTO_GOLES,PUNTOS_ACIERTO_RONDA);

        int calculoEsperado=PUNTOS_ACIERTO_PARTIDO+PUNTOS_ACIERTO_GOLES;

        assertEquals(calculoEsperado,puntajeApuestas.getApostadorPuntos().get("aciertoUnPartido"));

    }
    @Test
    public void aciertoRonda_ok() {

        List<Ronda> ronda=new ArrayList<>();
        ronda= leerResultadosFile.leer(archivoResultados);

        List<Pronostico> pronostico=new ArrayList<>();

        pronostico= leerPronosticoFile.leer(archivoPronostico,ronda);

        PuntajeApuestas puntajeApuestas=new PuntajeApuestas();

        puntajeApuestas.calculoDePuntos(ronda,pronostico,PUNTOS_ACIERTO_PARTIDO,PUNTOS_ACIERTO_GOLES,PUNTOS_ACIERTO_RONDA);

        int calculoEsperado=(PUNTOS_ACIERTO_PARTIDO+PUNTOS_ACIERTO_GOLES)*4+PUNTOS_ACIERTO_RONDA;

        assertEquals(calculoEsperado,puntajeApuestas.getApostadorPuntos().get("aciertoRonda"));

    }
@Test
    // Se ingresan 3 de 4 partidos
    public void aciertoRondaMenosUno_ok() {

        List<Ronda> ronda=new ArrayList<>();
        ronda= leerResultadosFile.leer(archivoResultados);

        List<Pronostico> pronostico=new ArrayList<>();

        pronostico= leerPronosticoFile.leer(archivoPronostico,ronda);

        PuntajeApuestas puntajeApuestas=new PuntajeApuestas();

        puntajeApuestas.calculoDePuntos(ronda,pronostico,PUNTOS_ACIERTO_PARTIDO,PUNTOS_ACIERTO_GOLES,PUNTOS_ACIERTO_RONDA);

        int calculoEsperado=(PUNTOS_ACIERTO_PARTIDO+PUNTOS_ACIERTO_GOLES)*3;

        assertEquals(calculoEsperado,puntajeApuestas.getApostadorPuntos().get("aciertoRondaMenosUno"));

    }
}