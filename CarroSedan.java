public class CarroSedan extends Vehiculo {

    private String tipoCombustible;
    private String transmision;

    public CarroSedan() {
    }

    public CarroSedan(String placa, String marca, int modelo,
            float precioDiario, String estado,
            String tipoCombustible, String transmision) {

        super(placa, marca, modelo, precioDiario, estado);

        this.tipoCombustible = tipoCombustible;
        this.transmision = transmision;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    @Override
    public String mostrarInformacion() {

        return "\nTipo: Carro Sedan"
                + "\nPlaca: " + getPlaca()
                + "\nMarca: " + getMarca()
                + "\nModelo: " + getModelo()
                + "\nPrecio Diario: " + getPrecioDiario()
                + "\nEstado: " + getEstado()
                + "\nTipo Combustible: " + tipoCombustible
                + "\nTransmision: " + transmision;
    }
}