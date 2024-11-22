import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Główna klasa aplikacji, która umożliwia użytkownikowi wybór typu konta (HR lub recepcjonista)
 * i wykonywanie podstawowych operacji związanych z pacjentami.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Wybór typu użytkownika
        System.out.println("Wybierz typ użytkownika:");
        System.out.println("1. Pracownik działu HR");
        System.out.println("2. Recepcjonista");
        int wybor = scanner.nextInt();
        scanner.nextLine(); // konsumowanie znaku nowej linii po nextInt()

        UserType userType = (wybor == 1) ? UserType.HR : UserType.RECEPCJONISTA;

        // Wyświetlenie wybranego typu użytkownika
        System.out.println("Wybrano: " + userType);

        // Inicjalizacja repozytorium pacjentów
        PacjentRepository pacjentRepository = new PacjentRepository();

        // Dodanie przykładowych pacjentów (opcjonalnie)
        Pacjent pacjent1 = new Pacjent("Jan", "Kowalski", "12345678901",
                LocalDate.of(1990, 5, 15), "123-456-789", "jan.kowalski@example.com");
        Pacjent pacjent2 = new Pacjent("Anna", "Nowak", "09876543210",
                LocalDate.of(1985, 3, 20), "987-654-321", "anna.nowak@example.com");
        Pacjent pacjent3 = new Pacjent("Piotr", "Nowak", "11223344556",
                LocalDate.of(1988, 7, 10), "555-666-777", "piotr.nowak@example.com");

        pacjentRepository.dodajPacjenta(pacjent1);
        pacjentRepository.dodajPacjenta(pacjent2);
        pacjentRepository.dodajPacjenta(pacjent3);

        // Menu dla recepcjonisty
        if (userType == UserType.RECEPCJONISTA) {
            boolean exit = false;
            while (!exit) {
                System.out.println("\nWybierz opcję:");
                System.out.println("1. Dodaj nowego pacjenta");
                System.out.println("2. Wyszukaj pacjenta po numerze PESEL");
                System.out.println("3. Wyszukaj pacjentów po nazwisku");
                System.out.println("4. Wyjście");
                int opcja = scanner.nextInt();
                scanner.nextLine(); // konsumowanie znaku nowej linii

                switch (opcja) {
                    case 1:
                        // Dodawanie nowego pacjenta
                        System.out.println("Podaj imię:");
                        String imie = scanner.nextLine();
                        System.out.println("Podaj nazwisko:");
                        String nazwisko = scanner.nextLine();
                        System.out.println("Podaj numer PESEL:");
                        String pesel = scanner.nextLine();
                        System.out.println("Podaj datę urodzenia (RRRR-MM-DD):");
                        String data = scanner.nextLine();
                        LocalDate dataUrodzenia = LocalDate.parse(data);
                        System.out.println("Podaj numer telefonu:");
                        String telefon = scanner.nextLine();
                        System.out.println("Podaj adres email:");
                        String email = scanner.nextLine();

                        Pacjent nowyPacjent = new Pacjent(imie, nazwisko, pesel, dataUrodzenia, telefon, email);
                        pacjentRepository.dodajPacjenta(nowyPacjent);
                        System.out.println("Dodano nowego pacjenta.");
                        break;
                    case 2:
                        // Wyszukiwanie pacjenta po PESEL
                        System.out.println("Podaj numer PESEL pacjenta do wyszukania:");
                        String szukanyPesel = scanner.nextLine();

                        Pacjent znalezionyPacjent = pacjentRepository.znajdzPacjentaPoPesel(szukanyPesel);
                        if (znalezionyPacjent != null) {
                            System.out.println("Znaleziono pacjenta:");
                            System.out.println(znalezionyPacjent);
                        } else {
                            System.out.println("Nie znaleziono pacjenta o podanym numerze PESEL.");
                        }
                        break;
                    case 3:
                        // Wyszukiwanie pacjentów po nazwisku
                        System.out.println("Podaj nazwisko pacjentów do wyszukania:");
                        String szukaneNazwisko = scanner.nextLine();

                        List<Pacjent> znalezieniPacjenci = pacjentRepository.znajdzPacjentowPoNazwisku(szukaneNazwisko);
                        if (!znalezieniPacjenci.isEmpty()) {
                            System.out.println("Znaleziono pacjentów:");
                            for (Pacjent pacjent : znalezieniPacjenci) {
                                System.out.println(pacjent);
                            }
                        } else {
                            System.out.println("Nie znaleziono pacjentów o podanym nazwisku.");
                        }
                        break;
                    case 4:
                        // Wyjście z programu
                        exit = true;
                        break;
                    default:
                        System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                }
            }
        } else {
            System.out.println("Brak dostępnych opcji dla wybranego typu użytkownika.");
        }
    }
}