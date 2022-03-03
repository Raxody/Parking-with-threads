/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.*;
import vista.frmParqueadero;
import vista.frmTransacciones;

public class controlador implements ActionListener, Runnable {

    Thread hilo;
    frmParqueadero objfrmParqueadero;
    hora objHora;
    Carro objCarro;
    Parqueadero objParqueadero;
    int hora, minuto, segundo;
    frmTransacciones objfrmTransacciones;

    public controlador() {
        this.hilo = new Thread(this);
        objfrmParqueadero = new frmParqueadero();
        objHora = new hora();
        objCarro = new Carro();
        objParqueadero = new Parqueadero();
        objfrmTransacciones = new frmTransacciones();
    }

    public void iniciar() {
        objfrmParqueadero.setVisible(true);
        objfrmParqueadero.setLocationRelativeTo(null);
        hilo.start();
        objfrmParqueadero.getParqueadero1().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero2().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero3().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero4().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero5().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero6().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero7().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero8().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero9().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero10().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero11().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero12().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero13().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero14().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero15().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero16().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero17().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero18().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero19().setBackground(Color.GREEN);
        objfrmParqueadero.getParqueadero20().setBackground(Color.GREEN);
        objfrmTransacciones.getBtnVolver().addActionListener(this);
        objfrmParqueadero.getBtnIngresar().addActionListener(this);
        objfrmParqueadero.getBtnModificar().addActionListener(this);
        objfrmParqueadero.getBtnMovimientos().addActionListener(this);
        objfrmParqueadero.getBtnSalir().addActionListener(this);
        objfrmParqueadero.getTxtPuestosVacios().setText(String.valueOf(objParqueadero.puestos()));
        objfrmParqueadero.getTxtValorCaja1().setText(String.valueOf(objParqueadero.recaudo()));
        objfrmParqueadero.getLblValor().setText(String.valueOf(objParqueadero.getValorHora()));

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (objfrmParqueadero.getBtnIngresar() == ae.getSource()) {
            if (objParqueadero.puestos() == 0) {
                JOptionPane.showMessageDialog(null, "NO HAY PUESTOS");
            } else {
                int puesto = 0;
                boolean cambiador = false;
                try {
                    puesto = Integer.parseInt(JOptionPane.showInputDialog("Digite el puesto en el cual desee parquear: "));
                    cambiador = objParqueadero.ingresarCarro(puesto, JOptionPane.showInputDialog("Digite la placa: "), hora, minuto, segundo);

                } catch (java.lang.NumberFormatException a) {
                    JOptionPane.showMessageDialog(null, "INGRESE VALORES NUMERICOS");
                }

                if (cambiador == true) {
                    this.tomarPuesto(puesto);
                }
                //     for (int i = 0; i < objParqueadero.getObjArrayCarros().size(); i++) {
                //         System.out.println(objParqueadero.getObjArrayCarros().get(i).toString());
                //     }
                objfrmParqueadero.getTxtPuestosVacios().setText(String.valueOf(objParqueadero.puestos()));

                objfrmParqueadero.getTxtValorCaja1().setText(String.valueOf(objParqueadero.recaudo()));
            }
        }

        if (objfrmParqueadero.getBtnSalir() == ae.getSource()) {
            if (objParqueadero.puestos() == 20) {
                JOptionPane.showMessageDialog(null, "NO HAY NADIE EN EL PARQUEADERO");
            } else {
                int puesto = 0;
                boolean cambiador = false;
                try {
                    puesto = Integer.parseInt(JOptionPane.showInputDialog("Digite el puesto de su carro: "));
                    cambiador = objParqueadero.buscarPagar(puesto, JOptionPane.showInputDialog("Digite la placa: "), Integer.parseInt(JOptionPane.showInputDialog("Digite los minutos que uso el parqueadero: ")), segundo);

                } catch (java.lang.NumberFormatException a) {
                    JOptionPane.showMessageDialog(null, "INGRESE VALORES NUMERICOS");
                }
                if (cambiador == true) {
                    this.dejarPuesto(puesto);
                }
                objfrmParqueadero.getTxtPuestosVacios().setText(String.valueOf(objParqueadero.puestos()));
                objfrmParqueadero.getTxtValorCaja1().setText(String.valueOf(objParqueadero.recaudo()));
            }

        }
        if (objfrmParqueadero.getBtnMovimientos() == ae.getSource()) {
            objfrmTransacciones.setVisible(true);
            objfrmTransacciones.setLocationRelativeTo(null);
            objfrmParqueadero.setVisible(false);
            objfrmTransacciones.getTxtMovimientos().setText(objParqueadero.movimientos());
        }
        if (objfrmTransacciones.getBtnVolver() == ae.getSource()) {
            objfrmTransacciones.setVisible(false);
            objfrmParqueadero.setVisible(true);
            objfrmParqueadero.setLocationRelativeTo(null);
        }
        if (objfrmParqueadero.getBtnModificar() == ae.getSource()) {
            int resp = JOptionPane.showConfirmDialog(null, "¿El gobierno autoriza el cambio de valor en la tarifa de la hora?");
            if (resp == 0) {
                int nuevoValor;
                try {
                    nuevoValor = Integer.parseInt(JOptionPane.showInputDialog("Digita el nuevo valor: "));
                    objParqueadero.setValorHora(nuevoValor);
                } catch (java.lang.NumberFormatException a) {
                    JOptionPane.showMessageDialog(null, "INGRESE VALORES NUMERICOS");
                }
            }
            objfrmParqueadero.getLblValor().setText(String.valueOf(objParqueadero.getValorHora()));
        }

    }

    public void tomarPuesto(int puesto) {
        switch (puesto) {
            case 1:
                objfrmParqueadero.getParqueadero1().setBackground(Color.RED);
                break;
            case 2:
                objfrmParqueadero.getParqueadero2().setBackground(Color.RED);
                break;
            case 3:
                objfrmParqueadero.getParqueadero3().setBackground(Color.RED);
                break;
            case 4:
                objfrmParqueadero.getParqueadero4().setBackground(Color.RED);
                break;
            case 5:
                objfrmParqueadero.getParqueadero5().setBackground(Color.RED);
                break;
            case 6:
                objfrmParqueadero.getParqueadero6().setBackground(Color.RED);
                break;
            case 7:
                objfrmParqueadero.getParqueadero7().setBackground(Color.RED);
                break;
            case 8:
                objfrmParqueadero.getParqueadero8().setBackground(Color.RED);
                break;
            case 9:
                objfrmParqueadero.getParqueadero9().setBackground(Color.RED);
                break;
            case 10:
                objfrmParqueadero.getParqueadero10().setBackground(Color.RED);
                break;
            case 11:
                objfrmParqueadero.getParqueadero11().setBackground(Color.RED);
                break;
            case 12:
                objfrmParqueadero.getParqueadero12().setBackground(Color.RED);
                break;
            case 13:
                objfrmParqueadero.getParqueadero13().setBackground(Color.RED);
                break;
            case 14:
                objfrmParqueadero.getParqueadero14().setBackground(Color.RED);
                break;
            case 15:
                objfrmParqueadero.getParqueadero15().setBackground(Color.RED);
                break;
            case 16:
                objfrmParqueadero.getParqueadero16().setBackground(Color.RED);
                break;
            case 17:
                objfrmParqueadero.getParqueadero17().setBackground(Color.RED);
                break;
            case 18:
                objfrmParqueadero.getParqueadero18().setBackground(Color.RED);
                break;
            case 19:
                objfrmParqueadero.getParqueadero19().setBackground(Color.RED);
                break;
            case 20:
                objfrmParqueadero.getParqueadero20().setBackground(Color.RED);
                break;
            default:
                break;
        }
    }

    public void dejarPuesto(int puesto) {
        switch (puesto) {
            case 1:
                objfrmParqueadero.getParqueadero1().setBackground(Color.GREEN);
                break;
            case 2:
                objfrmParqueadero.getParqueadero2().setBackground(Color.GREEN);
                break;
            case 3:
                objfrmParqueadero.getParqueadero3().setBackground(Color.GREEN);
                break;
            case 4:
                objfrmParqueadero.getParqueadero4().setBackground(Color.GREEN);
                break;
            case 5:
                objfrmParqueadero.getParqueadero5().setBackground(Color.GREEN);
                break;
            case 6:
                objfrmParqueadero.getParqueadero6().setBackground(Color.GREEN);
                break;
            case 7:
                objfrmParqueadero.getParqueadero7().setBackground(Color.GREEN);
                break;
            case 8:
                objfrmParqueadero.getParqueadero8().setBackground(Color.GREEN);
                break;
            case 9:
                objfrmParqueadero.getParqueadero9().setBackground(Color.GREEN);
                break;
            case 10:
                objfrmParqueadero.getParqueadero10().setBackground(Color.GREEN);
                break;
            case 11:
                objfrmParqueadero.getParqueadero11().setBackground(Color.GREEN);
                break;
            case 12:
                objfrmParqueadero.getParqueadero12().setBackground(Color.GREEN);
                break;
            case 13:
                objfrmParqueadero.getParqueadero13().setBackground(Color.GREEN);
                break;
            case 14:
                objfrmParqueadero.getParqueadero14().setBackground(Color.GREEN);
                break;
            case 15:
                objfrmParqueadero.getParqueadero15().setBackground(Color.GREEN);
                break;
            case 16:
                objfrmParqueadero.getParqueadero16().setBackground(Color.GREEN);
                break;
            case 17:
                objfrmParqueadero.getParqueadero17().setBackground(Color.GREEN);
                break;
            case 18:
                objfrmParqueadero.getParqueadero18().setBackground(Color.GREEN);
                break;
            case 19:
                objfrmParqueadero.getParqueadero19().setBackground(Color.GREEN);
                break;
            case 20:
                objfrmParqueadero.getParqueadero20().setBackground(Color.GREEN);
                break;
            default:
                break;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                objfrmParqueadero.getLblHora().setText("Hora  " + objHora.toString());
                objHora.Hora();
                sleep(1000);

                if (objHora.getHh() < 20 && objHora.getHh() >= 6) {

                    objfrmParqueadero.getBtnIngresar().setEnabled(true);
                    objfrmParqueadero.getBtnModificar().setEnabled(true);
                    objfrmParqueadero.getBtnMovimientos().setEnabled(true);
                    objfrmParqueadero.getBtnSalir().setEnabled(true);
                    objfrmParqueadero.getTxtPuestosVacios().setEnabled(true);
                    objfrmParqueadero.getTxtValorCaja1().setEnabled(true);
                    objfrmParqueadero.getLblEstado().setText("ABIERTO");
                    hora = objHora.getHh();
                    minuto = objHora.getMm();
                    segundo = objHora.getSs();

                } else {

                    objfrmParqueadero.getBtnIngresar().setEnabled(false);
                    objfrmParqueadero.getBtnModificar().setEnabled(false);
                    objfrmParqueadero.getBtnMovimientos().setEnabled(false);
                    objfrmParqueadero.getBtnSalir().setEnabled(false);
                    objfrmParqueadero.getTxtPuestosVacios().setEnabled(false);
                    objfrmParqueadero.getTxtValorCaja1().setEnabled(false);
                    objfrmParqueadero.getLblEstado().setText("CERRADO");
                }
            } catch (InterruptedException ex) {
                System.out.println("Error:" + ex.toString());
            }
        }
    }

}
