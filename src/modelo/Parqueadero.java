/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Parqueadero {

    private double valorHora;
    private ArrayList<Carro> objArrayCarros;
    Carro objCarro;
    private ArrayList<String> informacion;
    private ArrayList<Double> dinero;
    private int numeroFactura;

    public Parqueadero(double valorHora, int numeroFactura) {
        this.valorHora = valorHora;

        this.objArrayCarros = new ArrayList<>();
        informacion = new ArrayList<>();
        dinero = new ArrayList<>();
    }

    public Parqueadero() {
        this.valorHora = 3200;
        this.objArrayCarros = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            objArrayCarros.add(new Carro("", 0, 0, 0, 0, 0, 0, false));
            //    System.out.println("creado" + i);
        }
        informacion = new ArrayList<>();
        dinero = new ArrayList<>();
        numeroFactura = 100000;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public ArrayList<Carro> getObjArrayCarros() {
        return objArrayCarros;
    }

    public void setObjArrayCarros(ArrayList<Carro> objArrayCarros) {
        this.objArrayCarros = objArrayCarros;
    }

    public boolean verificarPuesto(int Puesto) {

        if (objArrayCarros.get(Puesto).isEstado() == false) {
            return true;
        }

        return false;
    }

    private double fraccionHora() {
        return this.valorHora / 60;
    }

    public boolean ingresarCarro(int puesto, String placa, int hora, int minuto, int segundo) {
        if (puesto <= 0 || puesto > 20 || placa.equals("")) {
            JOptionPane.showMessageDialog(null, "Datos erroneos");
        } else {
            if (this.verificarPuesto(puesto) == true) {
                objArrayCarros.get(puesto).setEstado(true);
                objArrayCarros.get(puesto).setHoraEntrada(hora);
                objArrayCarros.get(puesto).setMinutoEntrada(minuto);
                objArrayCarros.get(puesto).setSegundoEntrada(segundo);
                objArrayCarros.get(puesto).setPlaca(placa);
                JOptionPane.showMessageDialog(null, "Bienvenido, siga a parquear");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El puesto esta ocupado");
                return false;
            }
        }
        return false;

    }

    public boolean buscarPagar(int puesto, String placa, int minuto, int segundo) {
        if (puesto <= 0 || puesto > 20 || placa.equals("")) {
            JOptionPane.showMessageDialog(null, "Datos erroneos");
        } else {
            int cantHoras = (minuto + objArrayCarros.get(puesto).getMinutoEntrada()) / 60;
            int cantMinutos = 0;
            if (minuto % 60 == 0) {
                cantMinutos = objArrayCarros.get(puesto).getMinutoEntrada();
            } else {
                cantMinutos = (minuto + objArrayCarros.get(puesto).getMinutoEntrada()) % 60;
            }
            if (this.verificarPuesto(puesto) == false && placa.equals(objArrayCarros.get(puesto).getPlaca())) {
                objArrayCarros.get(puesto).setHoraSalida((objArrayCarros.get(puesto).getHoraEntrada() + cantHoras));
                objArrayCarros.get(puesto).setMinutoSalida(cantMinutos);
                objArrayCarros.get(puesto).setSegundoSalida(segundo);
                double pagar = this.pagar(minuto);
                JOptionPane.showMessageDialog(null, "Numero de factura: " + (++this.numeroFactura) + "\nSabiendo que el auto con placa: " + objArrayCarros.get(puesto).getPlaca()
                        + "\nubicado en el puesto: " + puesto + "\nHora entrada: " + objArrayCarros.get(puesto).getHoraEntrada() + ":"
                        + objArrayCarros.get(puesto).getMinutoEntrada() + ":" + objArrayCarros.get(puesto).getSegundoEntrada()
                        + "\nHora salida: " + objArrayCarros.get(puesto).getHoraSalida() + ":" + objArrayCarros.get(puesto).getMinutoSalida() + ":"
                        + +objArrayCarros.get(puesto).getSegundoSalida() + "\nDebe pagar: " + pagar);
                this.dinero.add(pagar);
                this.informacion.add("Numero de factura: " + this.numeroFactura + "\nSabiendo que el auto con placa: " + objArrayCarros.get(puesto).getPlaca()
                        + "\nubicado en el puesto: " + puesto + "\nHora entrada: " + objArrayCarros.get(puesto).getHoraEntrada() + ":"
                        + objArrayCarros.get(puesto).getMinutoEntrada() + ":" + objArrayCarros.get(puesto).getSegundoEntrada()
                        + "\nHora salida: " + objArrayCarros.get(puesto).getHoraSalida() + ":" + objArrayCarros.get(puesto).getMinutoSalida() + ":"
                        + +objArrayCarros.get(puesto).getSegundoSalida() + "\nDebe pagar: " + pagar + "\n\n\n");
                objArrayCarros.get(puesto).setEstado(false);
                objArrayCarros.get(puesto).setHoraEntrada(0);
                objArrayCarros.get(puesto).setHoraSalida(0);
                objArrayCarros.get(puesto).setMinutoEntrada(0);
                objArrayCarros.get(puesto).setMinutoSalida(0);
                objArrayCarros.get(puesto).setPlaca("");
                objArrayCarros.get(puesto).setSegundoEntrada(0);
                objArrayCarros.get(puesto).setSegundoSalida(0);

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Rectifique el puesto o la placa");
                return false;
            }
        }
        return false;

    }

    public double pagar(int cantMinutos) {
        double valoMinutos = cantMinutos * this.fraccionHora();

        return valoMinutos;

    }

    public int puestos() {
        int cantidad = -1;
        for (int i = 0; i < this.objArrayCarros.size(); i++) {
            if (this.objArrayCarros.get(i).isEstado() == false) {
                cantidad++;
            }
        }
        if(cantidad == -1){
            return 0;
        }
        return cantidad;
    }

    public double recaudo() {
        double recaudo = 0;
        for (int i = 0; i < this.dinero.size(); i++) {
            recaudo += this.dinero.get(i);
        }
        return recaudo;
    }

    public String movimientos() {
        String acom = "";
        for(String dato: this.informacion){
            acom += dato;
        }
        return acom;
    }

}
