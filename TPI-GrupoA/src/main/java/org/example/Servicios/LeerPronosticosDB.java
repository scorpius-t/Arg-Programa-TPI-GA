package org.example.Servicios;

import org.example.Modelos.Pronostico;
import org.example.Modelos.Ronda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LeerPronosticosDB extends ConexionDB implements LeerPronostico {
    @Override
    public List<Pronostico> leer(String path, List<Ronda> ronda) {
        List<Pronostico> listaPronostico= new ArrayList<>();
        ResultSet reader;


        try {
            this.conectar();
            PreparedStatement st= this.getConnection().prepareStatement(
                    "SELECT apostador, equipoL, golesL, equipoV, golesV FROM " +
                            "pronosticos"
            );
            reader=st.executeQuery();
            while(reader.next()){
                Pronostico objPronostico=new Pronostico();
                objPronostico.agregar(
                        reader.getString("apostador"),
                        reader.getString("equipoL"),
                        reader.getString("golesL"),
                        reader.getString("equipoV"),
                        reader.getString("golesV")
                );

//                agrego pronostico si existe partido
                ronda.forEach((r)-> {
                    if (r.contienePartido(objPronostico.getPartido().getEquipoL(), objPronostico.getPartido().getEquipoV()))
                            listaPronostico.add(objPronostico);
                    }
                );

            }

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                this.cerrar();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return listaPronostico;
    }
}
