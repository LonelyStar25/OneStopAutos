package onestopautos;

public class Vehículo {
    int numSerial, precio;
    String modelo, marca, tipo, fechaEntrada, infoAdicional;

    public Vehículo(int numSerial, String modelo, String marca, String tipo, int precio, String fechaEntrada, String infoAdicional) {
        this.numSerial = numSerial;
        this.precio = precio;
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo;
        this.fechaEntrada = fechaEntrada;
        this.infoAdicional = infoAdicional;
    }

    @Override
    public String toString() {
        return "Veh\u00edculo{" + "numSerial=" + numSerial + ", precio=" + precio + ", modelo=" + modelo + ", marca=" + marca + ", tipo=" + tipo + ", fechaEntrada=" + fechaEntrada + ", infoAdicional=" + infoAdicional + '}';
    }
}
