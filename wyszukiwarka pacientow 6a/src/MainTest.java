import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class MainTest {

    private PacjentRepository pacjentRepository;

    @BeforeEach
    public void setup() {
        pacjentRepository = new PacjentRepository(); // Przygotowanie repozytorium przed każdym testem
    }

    @Test
    public void testDodajPacjenta() {
        // Ustawienie danych pacjenta
        String imie = "Jan";
        String nazwisko = "Kowalski";
        String pesel = "12345678901";
        LocalDate dataUrodzenia = LocalDate.of(1990, 5, 15);
        String telefon = "123-456-789";
        String email = "jan.kowalski@example.com";

        Pacjent pacjent = new Pacjent(imie, nazwisko, pesel, dataUrodzenia, telefon, email);
        pacjentRepository.dodajPacjenta(pacjent);

        // Sprawdzenie, czy pacjent został dodany
        Pacjent pacjentZRepo = pacjentRepository.getPacjenci().get(pesel);
        assertNotNull(pacjentZRepo);
        assertEquals(pacjent.getImie(), pacjentZRepo.getImie());
        assertEquals(pacjent.getNazwisko(), pacjentZRepo.getNazwisko());
    }

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
