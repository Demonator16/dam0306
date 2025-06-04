package servicios;

/**
 * Clase que gestiona la iluminación de las pistas deportivas.
 */
public class GestorIluminacion {
    private boolean[] iluminacion; // Estado de iluminación de cada pista

    /**
     * Constructor que inicializa las luces apagadas.
     * @param maxPistas Número total de pistas.
     */
    public GestorIluminacion(int maxPistas) {
        iluminacion = new boolean[maxPistas];
    }

    /**
     * Enciende la iluminación de una pista.
     * @param idPista ID de la pista.
     * @return true si se enciende correctamente, false si el ID es inválido.
     */
    public boolean encenderLuces(int idPista) {
        if (!esIdValido(idPista)) {
            return false;
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * Apaga la iluminación de una pista.
     * @param idPista ID de la pista.
     * @return true si se apaga correctamente, false si el ID es inválido.
     */
    public boolean apagarLuces(int idPista) {
        if (!esIdValido(idPista)) {
            return false;
        }
        iluminacion[idPista] = false;
        return true;
    }

    /**
     * Verifica si el ID de la pista es válido.
     * @param idPista ID de la pista.
     * @return true si es válido, false si no lo es.
     */
    private boolean esIdValido(int idPista) {
        return idPista >= 0 && idPista < iluminacion.length;
    }

    /**
     * Obtiene el estado de la iluminación de una pista.
     * @param idPista ID de la pista.
     * @return true si las luces están encendidas, false si están apagadas o el ID es inválido.
     */
    public boolean estadoLuces(int idPista) {
        if (!esIdValido(idPista)) {
            return false;
        }
        return iluminacion[idPista];
    }

    /**
     * Enciende todas las luces de las pistas.
     */
    public void encenderTodas() {
        for (int i = 0; i < iluminacion.length; i++) {
            iluminacion[i] = true;
        }
    }

    /**
     * Apaga todas las luces de las pistas.
     */
    public void apagarTodas() {
        for (int i = 0; i < iluminacion.length; i++) {
            iluminacion[i] = false;
        }
    }
}