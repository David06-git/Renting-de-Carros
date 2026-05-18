public class CamionetaSUV extends Vehiculo {

    private String traccion;
    private float capacidadMaletero;

    public CamionetaSUV() {
    }

    public CamionetaSUV(String placa, String marca, int modelo,
            float precioDiario, String estado,
            String traccion, float capacidadMaletero) {

        super(placa, marca, modelo, precioDiario, estado);

        this.traccion = traccion;
        this.capacidadMaletero = capacidadMaletero;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public float getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public void setCapacidadMaletero(float capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }

    @Override
    public String mostrarInformacion() {

        return "\nTipo: Camioneta SUV"
                + "\nPlaca: " + getPlaca()
                + "\nMarca: " + getMarca()
                + "\nModelo: " + getModelo()
                + "\nPrecio Diario: " + getPrecioDiario()
                + "\nEstado: " + getEstado()
                + "\nTraccion: " + traccion
                + "\nCapacidad Maletero: " + capacidadMaletero;
    }
}