package org.example.Modelos;

public class Ronda {
    private String numero;
    private Partido partido =new Partido();

    public void agregar(String numRonda, String local, String golesLocal,String visitante,String golesVisitante){
        Partido partidoIndividual=new Partido();
        Equipo equipoLocal=new Equipo();
        Equipo equipoVisitante=new Equipo();

        equipoLocal.setNombre(local);
        equipoVisitante.setNombre(visitante);

        this.setNumero(numRonda);
        partidoIndividual.setEquipoL(equipoLocal);
        partidoIndividual.setGolesEquipoL(Integer.parseInt(golesLocal));
        partidoIndividual.setEquipoV(equipoVisitante);
        partidoIndividual.setGetGolesEquipoV(Integer.parseInt(golesVisitante));

        this.setPartido(partidoIndividual);


    }

    public boolean contienePartido(Equipo local, Equipo visitante){
        return  (this.getPartido().getEquipoL().getNombre().equalsIgnoreCase(local.getNombre()) &&
                this.getPartido().getEquipoV().getNombre().equalsIgnoreCase(visitante.getNombre()));

    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partidos) {
        this.partido = partidos;
    }

    @Override
    public String toString() {
        return "Ronda{" +
                "numero='" + numero + '\'' +
                ", partido=" + partido +
                "}\n";
    }
}
