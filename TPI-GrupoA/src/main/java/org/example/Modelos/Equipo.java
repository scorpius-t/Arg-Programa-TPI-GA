package org.example.Modelos;

import java.util.Objects;

public class Equipo {
    private String nombre;
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo equipo)) return false;
        return getNombre().equalsIgnoreCase(equipo.getNombre());// && Objects.equals(getDescripcion(), equipo.getDescripcion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getDescripcion());
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
