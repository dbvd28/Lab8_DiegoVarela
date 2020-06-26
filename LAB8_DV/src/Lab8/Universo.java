/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Universo implements Polimorfismo {

    private ArrayList<Seresv> vivos = new ArrayList();
    private File archivo = null;

    public Universo(String path) {
        archivo = new File(path);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<Seresv> getVivos() {
        return vivos;
    }

    public void setVivos(ArrayList<Seresv> vivos) {
        this.vivos = vivos;
    }

    @Override
    public String toString() {
        return "Universo{" + "vivos=" + vivos + ", archivo=" + archivo + '}';
    }

    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Seresv t : vivos) {
                bw.write(t.getNombre() + ";");
                bw.write(t.getPoder() + ";");
                bw.write(t.getAños() + ";");
                bw.write(t.getPlaneta() + ";");
                bw.write(t.getRaza() + ";");
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        vivos = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    vivos.add(new Seresv(sc.next(),
                            sc.nextInt(),
                            sc.nextInt(), sc.next(), sc.next()
                    )
                    );
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }

    @Override
    public void Eliminar(String nombre) {
        try {
            cargarArchivo();
            int elim = 0;
            for (int i = 0; i < vivos.size(); i++) {
                if (vivos.get(i).getNombre().equals(nombre)) {
                    elim = i;
                }
            }
            vivos.remove(elim);
            escribirArchivo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Modnombre(String nombre, String nuevo) {
        try {
            cargarArchivo();
            for (int i = 0; i < vivos.size(); i++) {
                if (vivos.get(i).getNombre().equals(nombre)) {
                    vivos.get(i).setNombre(nuevo);
                }
            }
            escribirArchivo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Modplaneta(String nombre, String nuevo) {
        try {
            cargarArchivo();
            for (int i = 0; i < vivos.size(); i++) {
                if (vivos.get(i).getNombre().equals(nombre)) {
                    vivos.get(i).setPlaneta(nuevo);
                }
            }
            escribirArchivo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Modraza(String nombre, String nuevo) {
        try {
            cargarArchivo();
            for (int i = 0; i < vivos.size(); i++) {
                if (vivos.get(i).getNombre().equals(nombre)) {
                    vivos.get(i).setRaza(nuevo);
                }
            }
            escribirArchivo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Modaños(String nombre, int años) {
        try {
            cargarArchivo();
            for (int i = 0; i < vivos.size(); i++) {
                if (vivos.get(i).getNombre().equals(nombre)) {
                    vivos.get(i).setAños(años);
                }
            }
            escribirArchivo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Modpoder(String nombre, int poder) {
        try {
            cargarArchivo();
            for (int i = 0; i < vivos.size(); i++) {
                if (vivos.get(i).getNombre().equals(nombre)) {
                    vivos.get(i).setPoder(poder);
                }
            }
            escribirArchivo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
