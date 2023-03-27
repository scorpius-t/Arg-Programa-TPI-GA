package org.example.Servicios;

import org.example.Modelos.Pronostico;
import org.example.Modelos.Ronda;

import java.util.List;

public interface LeerResultados {
    public List<Ronda> leer(String path);

}
