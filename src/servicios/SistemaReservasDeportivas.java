package servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase que gestiona el sistema de reservas deportivas.
 * Permite reservar pistas, cancelar reservas y verificar disponibilidad.
 */
public class SistemaReservasDeportivas {
    private List<Reserva> reservas; // Lista de reservas
    private static final int MAX_PISTAS = 10; // Máximo de pistas
    private GestorIluminacion gestorIluminacion; // Nueva clase para iluminación

    /**
     * Constructor de la clase SistemaReservasDeportivas.
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        gestorIluminacion = new GestorIluminacion(MAX_PISTAS);
    }

    /**
     * Reserva una pista con un objeto Reserva en lugar de parámetros individuales.
     * @param reserva Objeto Reserva con detalles.
     * @return true si la reserva se realiza correctamente, false si la pista está ocupada.
     */
    public boolean reservarPista(Reserva reserva) {
        if (reserva.getIdPista() < 0 || reserva.getIdPista() >= MAX_PISTAS) {
            System.out.println("Error: ID de pista inválido.");
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
        if (!esFechaDisponible(reserva.getIdPista(), reserva.getFecha())) {
            System.out.println("Error: Fecha no disponible.");
            return false; // Fecha no disponible
        }
        reservas.add(reserva);
        return true;
    }
		return false;
    }

    private boolean esFechaDisponible(int idPista, String fecha) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
     * Cancela una reserva.
     * @param idReserva ID de la reserva a cancelar.
     * @return true si se cancela correctamente, false si no se encuentra.
     */
    public boolean cancelarReserva(int idReserva) {
        boolean eliminada = reservas.removeIf(r -> r.getIdPista() == idReserva); // Cambiado de idPista a idReserva
        if (!eliminada) {
            System.out.println("Error: Reserva no encontrada.");
        }
        return eliminada;
    }

    /**
     * Verifica si una pista está disponible en una fecha específica.
     * @param idPista ID de la pista.
     * @param fecha Fecha en formato LocalDate.
     * @return true si la pista está disponible, false si ya está reservada.
     */
    public boolean verificarDisponibilidad(int idPista, LocalDate fecha) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            System.out.println("Error: ID de pista inválido.");
            return false;
        }
        return esFechaDisponible(idPista, fecha);
    }

    private boolean esFechaDisponible(int idPista, LocalDate fecha) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
     * Método privado que verifica si una fecha está disponible para reservar.
     * @param idPista ID de la pista.
     * @param string Fecha en LocalDate.
     * @return true si la pista está libre en esa fecha.
     */
    private boolean esFechaDisponible1(int idPista, LocalDate fecha) {
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && extracted(fecha, r)) {
                return false;
            }
        }
        return true;
    }

	private boolean extracted(LocalDate fecha, Reserva r) {
		return r.getFecha().equals(fecha);
	}

    // Métodos delegados a la nueva clase GestorIluminacion
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            System.out.println("Error: ID de pista inválido.");
            return false;
        }
        return gestorIluminacion.encenderLuces(idPista);
    }

    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            System.out.println("Error: ID de pista inválido.");
            return false;
        }
        return gestorIluminacion.apagarLuces(idPista);
    }
    
    
    
    
    
    
}