/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Carro {

    private String placa;
    private int horaEntrada;
    private int minutoEntrada;
    private int segundoEntrada;
    private int horaSalida;
    private int minutoSalida;
    private int segundoSalida;
    private boolean Estado;

    public Carro(String placa, int horaEntrada, int minutoEntrada, int segundoEntrada, int horaSalida, int minutoSalida, int segundoSalida, boolean Estado) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.minutoEntrada = minutoEntrada;
        this.segundoEntrada = segundoEntrada;
        this.horaSalida = horaSalida;
        this.minutoSalida = minutoSalida;
        this.segundoSalida = segundoSalida;
        this.Estado = Estado;
    }

    public Carro() {
    }
    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getMinutoEntrada() {
        return minutoEntrada;
    }

    public void setMinutoEntrada(int minutoEntrada) {
        this.minutoEntrada = minutoEntrada;
    }

    public int getSegundoEntrada() {
        return segundoEntrada;
    }

    public void setSegundoEntrada(int segundoEntrada) {
        this.segundoEntrada = segundoEntrada;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getMinutoSalida() {
        return minutoSalida;
    }

    public void setMinutoSalida(int minutoSalida) {
        this.minutoSalida = minutoSalida;
    }

    public int getSegundoSalida() {
        return segundoSalida;
    }

    public void setSegundoSalida(int segundoSalida) {
        this.segundoSalida = segundoSalida;
    }

   
    
    

}
