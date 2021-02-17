package DAO;

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
        return numSerial + " " + precio + " " + modelo + " " + marca + " " + tipo
                + " " + fechaEntrada + " " + infoAdicional;
    }

    public int getNumSerial() {
        return numSerial;
    }

    public int getPrecio() {
        return precio;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }
}
