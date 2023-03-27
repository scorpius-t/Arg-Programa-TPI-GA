package org.example.Servicios;

import org.example.Modelos.Pronostico;
import org.example.Modelos.Ronda;

import java.util.List;

public interface LeerPronostico {
    public List<Pronostico> leer(String path,List<Ronda> ronda);


}
