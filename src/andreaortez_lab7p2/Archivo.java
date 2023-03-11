
package andreaortez_lab7p2;

import java.io.Serializable;

public class Archivo implements Serializable{
    private String nombre, link, extensión;
    private double tamaño;
    private boolean unidad,favorito, papelera;

    private static final long SerialVersionUID=111L;
    
    public Archivo() {
    }

    public Archivo(String nombre, String link, String extensión, double tamaño) {
        this.nombre = nombre;
        this.link = link;
        this.extensión = extensión;
        this.tamaño = tamaño;
        this.unidad = true;
        this.favorito = false;
        this.papelera = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getExtensión() {
        return extensión;
    }

    public void setExtensión(String extensión) {
        this.extensión = extensión;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public boolean isPapelera() {
        return papelera;
    }

    public void setPapelera(boolean papelera) {
        this.papelera = papelera;
    }

    public boolean isUnidad() {
        return unidad;
    }

    public void setUnidad(boolean unidad) {
        this.unidad = unidad;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
    
}
