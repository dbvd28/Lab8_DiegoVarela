/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab8;

/**
 *
 * @author diego
 */
public interface Polimorfismo {

    public void Eliminar(String nombre);

    public void Modnombre(String nombre, String nuevo);

    public void Modplaneta(String nombre, String nuevo);

    public void Modraza(String nombre, String nuevo);

    public void Modaños(String nombre, int años);

    public void Modpoder(String nombre, int poder);
}
