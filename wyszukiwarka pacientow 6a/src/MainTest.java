import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

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
        Pacjent pacjent3 = new Pacjent("Piotr", "Nowak", "11223344556",
                LocalDate.of(1988, 7, 10), "555-666-777", "piotr.nowak@example.com");

        pacjentRepository.dodajPacjenta(pacjent1);
        pacjentRepository.dodajPacjenta(pacjent2);
        pacjentRepository.dodajPacjenta(pacjent3);
    }

    /**
     * Testuje dodawanie pacjenta do repozytorium.
     */
    @Test
    public void testDodajPacjenta() {
        // Sprawdzenie, czy pacjenci zostali dodani
        assertEquals(3, pacjentRepository.getPacjenci().size());
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

    /**
     * Testuje wyszukiwanie pacjentów po nazwisku.
     */
    @Test
    public void testZnajdzPacjentowPoNazwisku() {
        // Wyszukiwanie pacjentów o nazwisku "Nowak"
        List<Pacjent> pacjenciNowak = pacjentRepository.znajdzPacjentowPoNazwisku("Nowak");
        assertEquals(2, pacjenciNowak.size());

        // Wyszukiwanie pacjentów o nazwisku, którego nie ma w bazie
        List<Pacjent> pacjenciNieznani = pacjentRepository.znajdzPacjentowPoNazwisku("Nieznane");
        assertTrue(pacjenciNieznani.isEmpty());
    }

    /**
     * Testuje wybór typu użytkownika.
     */
    @Test
    public void testWybierzTypUzytkownika() {
        // Test wyboru typu użytkownika
        UserType userTypeHR = UserType.HR;
        UserType userTypeRecepcjonista = UserType.RECEPCJONISTA;

        // Sprawdzanie, czy wybór zwraca odpowiednie wartości
        assertEquals("Pracownik działu HR", userTypeHR.toString());
        assertEquals("Recepcjonista", userTypeRecepcjonista.toString());
    }
}