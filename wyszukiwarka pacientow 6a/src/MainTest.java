import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

/**
 * Klasa testowa, która sprawdza działanie metod w klasie PacjentRepository.
 */
public class MainTest {

    private PacjentRepository pacjentRepository;

    /**
     * Metoda uruchamiana przed każdym testem, przygotowująca repozytorium pacjentów.
     */
    @BeforeEach
    public void setup() {
        pacjentRepository = new PacjentRepository();

        // Dodanie przykładowych pacjentów
        Pacjent pacjent1 = new Pacjent("Jan", "Kowalski", "12345678901",
                LocalDate.of(1990, 5, 15), "123-456-789", "jan.kowalski@example.com");
        Pacjent pacjent2 = new Pacjent("Anna", "Nowak", "09876543210",
                LocalDate.of(1985, 3, 20), "987-654-321", "anna.nowak@example.com");

        pacjentRepository.dodajPacjenta(pacjent1);
        pacjentRepository.dodajPacjenta(pacjent2);
    }

    /**
     * Testuje dodawanie pacjenta do repozytorium.
     */
    @Test
    public void testDodajPacjenta() {
        // Sprawdzenie, czy pacjenci zostali dodani
        assertEquals(2, pacjentRepository.getPacjenci().size());
    }

    /**
     * Testuje wyszukiwanie pacjenta po numerze PESEL.
     */
    @Test
    public void testZnajdzPacjentaPoPesel() {
        // Wyszukiwanie istniejącego pacjenta
        Pacjent pacjent = pacjentRepository.znajdzPacjentaPoPesel("12345678901");
        assertNotNull(pacjent);
        assertEquals("Jan", pacjent.getImie());

        // Wyszukiwanie nieistniejącego pacjenta
        Pacjent nieistniejacyPacjent = pacjentRepository.znajdzPacjentaPoPesel("00000000000");
        assertNull(nieistniejacyPacjent);
    }
}