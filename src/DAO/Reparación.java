package DAO;

public class Reparación {

    int numIncidencia, coste;
    String DNICliente, DNIUsuario, problema, tiempoEstimado, piezas;

    public Reparación(int numIncidencia, String DNICliente, String DNIUsuario, String problema, int coste, String tiempoEstimado, String piezas) {
        this.numIncidencia = numIncidencia;
        this.coste = coste;
        this.DNICliente = DNICliente;
        this.DNIUsuario = DNIUsuario;
        this.problema = problema;
        this.tiempoEstimado = tiempoEstimado;
        this.piezas = piezas;
    }
    
    public Reparación(int numIncidencia) {
        this.numIncidencia = numIncidencia;
    }


    @Override
    public String toString() {
        return numIncidencia + " " + coste + " " + DNICliente + " " + DNIUsuario
                + " " + problema + " " + tiempoEstimado + " " + piezas;
    }

    public int getNumIncidencia() {
        return numIncidencia;
    }

    public int getCoste() {
        return coste;
    }

    public String getDNICliente() {
        return DNICliente;
    }

    public String getDNIUsuario() {
        return DNIUsuario;
    }

    public String getProblema() {
        return problema;
    }

    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public String getPiezas() {
        return piezas;
    }
}
