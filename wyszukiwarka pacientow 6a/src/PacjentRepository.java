import java.util.HashMap;
import java.util.Map;

/**
 * Klasa przechowująca pacjentów w systemie.
 * Umożliwia dodawanie pacjentów i wyszukiwanie ich po numerze PESEL.
 */
public class PacjentRepository {

    private Map<String, Pacjent> pacjenci = new HashMap<>();

    /**
     * Dodaje pacjenta do repozytorium.
     *
     * @param pacjent Pacjent, który ma zostać dodany.
     */
    public void dodajPacjenta(Pacjent pacjent) {
        pacjenci.put(pacjent.getPesel(), pacjent);
    }

    /**
     * Wyszukuje pacjenta po numerze PESEL.
     *
     * @param pesel Numer PESEL pacjenta.
     * @return Obiekt Pacjent, jeśli znaleziono; null w przeciwnym razie.
     */
    public Pacjent znajdzPacjentaPoPesel(String pesel) {
        return pacjenci.get(pesel);
    }

    /**
     * Zwraca wszystkich pacjentów przechowywanych w repozytorium.
     *
     * @return Mapę pacjentów, gdzie kluczem jest numer PESEL, a wartością obiekt Pacjent.
     */
    public Map<String, Pacjent> getPacjenci() {
        return pacjenci;
    }
}
