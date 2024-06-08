import java.util.Map;

public class paciente {
    private int idPaciente;
    private String nombrePaciente;

    public paciente(int idPaciente, String nombrePaciente) { // se inicializa constructor paciente
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
    }

    // getters para tomar valores de los atributos de paciente, y setters para guardar valores de paciente
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int id) {
        this.idPaciente = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void guardaRegistroPaciente(Map<Integer, paciente> pacientes) { // guarda en el mapa el registro de pacientes
        if (pacientes.containsKey(this.idPaciente)) {
            System.out.println("Paciente ya existe en la base de datos");
        } else {
            pacientes.put(this.idPaciente, this);
            System.out.println("Paciente guardado exitosamente en la base de datos");
        }
    }
} // clase paciente