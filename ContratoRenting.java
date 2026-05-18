

public class ContratoRenting {

    private String idContrato;
    private String cedulaCliente;
    private String placaVehiculo;
    private String fechaInicio;
    private String fechaFin;
    private int totalDias;
    private float valorTotal;
    private boolean activo;

    public ContratoRenting() {

    }

    public ContratoRenting(String idContrato, String cedulaCliente,
            String placaVehiculo, String fechaInicio,
            String fechaFin, int totalDias,
            float valorTotal, boolean activo) {

        this.idContrato = idContrato;
        this.cedulaCliente = cedulaCliente;
        this.placaVehiculo = placaVehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalDias = totalDias;
        this.valorTotal = valorTotal;
        this.activo = activo;
    }

    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getTotalDias() {
        return totalDias;
    }

    public void setTotalDias(int totalDias) {
        this.totalDias = totalDias;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {

        return "\nID Contrato: " + idContrato
                + "\nCedula Cliente: " + cedulaCliente
                + "\nPlaca Vehiculo: " + placaVehiculo
                + "\nFecha Inicio: " + fechaInicio
                + "\nFecha Fin: " + fechaFin
                + "\nTotal Dias: " + totalDias
                + "\nValor Total: " + valorTotal
                + "\nEstado: "
                + (activo ? "Activo" : "Finalizado");
    }
}