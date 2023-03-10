
package andreaortez_lab7p2;

import java.util.ArrayList;

public class Carpeta {
    private String nombre;
    private ArrayList <Archivo> archivos = new ArrayList();
    private ArrayList <Carpeta> carpetas = new ArrayList();

    public Carpeta() {
    }

    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(ArrayList<Archivo> archivos) {
        this.archivos = archivos;
    }

    public ArrayList<Carpeta> getCarpetas() {
        return carpetas;
    }

    public void setCarpetas(ArrayList<Carpeta> carpetas) {
        this.carpetas = carpetas;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
