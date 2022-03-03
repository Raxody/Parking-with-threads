package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class hora {

    private int hh, mm, ss;

    /**
     * Constructor paramètrico que genera una instancia a partir de los datos
     * recibidos correspondientes a los siguientes parametros.
     *
     * @param hh hora del dia en formato texto.
     * @param mm mes del dia en formato texto.
     * @param ss año del dia en formato texto.
     */
    public hora(int hh, int mm, int ss) {
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }

    /**
     * Constructor básico que genera una instancia que inicializa los parametros
     * horas, minutos y segundos gracias a la clase calendar la cual los
     * inicializa con la hora del dia actual.
     */
    public hora() {
        Calendar objF = new GregorianCalendar();
        this.hh = objF.get(Calendar.HOUR_OF_DAY);
        this.mm = objF.get(Calendar.MINUTE);
        this.ss = objF.get(Calendar.SECOND);
        //QUITAR ESTO PARA LA PRUEBA 
        //this.hh = 20;
        //this.mm = 31;
        //this.ss = 00;
    }

    /**
     * Permite obtener el valor del atributo hora(hh) de la clase en formato de
     * texto (int)
     *
     * @return int
     */
    public int getHh() {
        return hh;
    }

    /**
     * Actualiza o modifica el valor del atributo hh(hora) a partir del valor
     * que recibe en formato texto
     *
     * @param hh
     */
    public void setHh(int hh) {
        this.hh = hh;
    }

    /**
     * Permite obtener el valor del atributo minuto(mm) de la clase en formato
     * de texto (int)
     *
     * @return int
     */
    public int getMm() {
        return mm;
    }

    /**
     * Actualiza o modifica el valor del atributo minuto(mm) a partir del valor
     * que recibe en formato texto
     *
     * @param mm
     */
    public void setMm(int mm) {
        this.mm = mm;
    }

    /**
     * Permite obtener el valor del atributo segundo(ss) de la clase en formato
     * de texto (int)
     *
     * @return int
     */
    public int getSs() {
        return ss;
    }

    /**
     * Actualiza o modifica el valor del atributo segundo(ss) a partir del valor
     * que recibe en formato texto
     *
     * @param ss
     */
    public void setSs(int ss) {
        this.ss = ss;
    }

    /**
     * Este método Actualiza o modifica el valor de los atributos
     * mm(minutos),ss(segungos) y hh(horas) según el tiempo transcurrido en a
     * actualidad.
     *
     */
    public void Hora() {
        if (ss < 59) {
            ss++;
        } else {
            ss = 0;
            mm++;
            if (mm >= 60) {
                hh++;
                mm = 0;
            }
            if (hh > 23) {
                hh = 0;
            }
        }
    }

    /**
     * Retorna la información con la clase concatenando los atributos horas,
     * minutos y segundos en forma de texto (string)
     *
     * @return string
     */
    @Override
    public String toString() {
        return hh + ":" + mm + ": " + ss;
    }

}
