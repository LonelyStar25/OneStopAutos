package DAO;

public class Propuesta {
    String DNICliente;
    int numSerial;

    public Propuesta(String DNICliente, int numSerial) {
        this.DNICliente = DNICliente;
        this.numSerial = numSerial;
    }

    @Override
    public String toString() {
        return DNICliente + " " + numSerial;
    }

    public String getDNICliente() {
        return DNICliente;
    }

    public int getNumSerial() {
        return numSerial;
    }
}
