import java.util.Map;

public class cita {
    private int idCita;
    private String fechaHora;
    private String motivo;

    public cita(int idCita, String fechaHora, String motivo) { // se inicializa constructor cita
        this.idCita = idCita;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }

    // getters para tomar valores de los atributos de cita, y setters para guardar valores de cita
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void guardarCita(Map<Integer, cita> citas) { // guarda en el mapa el registro de citas
        if (citas.containsKey(this.idCita)) {
            System.out.println("Cita ya existe en la base de datos");
        } else {
            citas.put(this.idCita, this);
            System.out.println("Cita guardada exitosamente en la base de datos");
        }
    }

    public void imprimirTicket() {
        System.out.println("Cita registrada: ID " + idCita + ", Fecha y Hora " + fechaHora + ", Motivo " + motivo);
    }
} // clase cita