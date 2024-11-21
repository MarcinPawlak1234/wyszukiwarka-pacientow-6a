import java.util.HashMap;
import java.util.Map;

public class PacjentRepository {
    private Map<String, Pacjent> pacjenci = new HashMap<>();

    public void dodajPacjenta(Pacjent pacjent) {
        if (pacjenci.containsKey(pacjent.getPesel())) {
            System.out.println("Pacjent o podanym numerze PESEL już istnieje w systemie.");
        } else {
            pacjenci.put(pacjent.getPesel(), pacjent);
            System.out.println("Pacjent został dodany pomyślnie.");
        }
    }

    public Map<String, Pacjent> getPacjenci() {
        return pacjenci;
    }
}