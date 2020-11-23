package onestopautos;

public class Venta {
    int numSerial, beneficios;
    String DNICliente, DNIUsuario, plazo;

    public Venta(int numSerial, String DNICliente, String DNIUsuario, int beneficios, String plazo) {
        this.numSerial = numSerial;
        this.beneficios = beneficios;
        this.DNICliente = DNICliente;
        this.DNIUsuario = DNIUsuario;
        this.plazo = plazo;
    }

    @Override
    public String toString() {
        return numSerial + " " + beneficios + " " + DNICliente + " " + DNIUsuario + " " + plazo;
    }
}
