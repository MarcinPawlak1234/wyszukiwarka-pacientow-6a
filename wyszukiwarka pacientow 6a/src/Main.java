import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final PacjentRepository pacjentRepository = new PacjentRepository();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Wybór konta użytkownika
        UserType userType = wybierzTypUzytkownika(scanner);
        System.out.println("Zalogowano jako: " + userType);

        boolean running = true;

        // Główna pętla aplikacji
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Dodaj nowego pacjenta");
            System.out.println("2. Wyświetl wszystkich pacjentów (DEBUG)");
            System.out.println("3. Wyjdź");

            System.out.print("Wybierz opcję: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> dodajPacjenta(scanner);
                case 2 -> wyswietlPacjentow();
                case 3 -> {
                    running = false;
                    System.out.println("Zamykanie systemu...");
                }
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }

        scanner.close();
    }

    private static UserType wybierzTypUzytkownika(Scanner scanner) {
        System.out.println("Witaj w systemie zarządzania przychodnią lekarską!");
        System.out.println("Wybierz swoje konto:");
        System.out.println("1. Pracownik działu HR");
        System.out.println("2. Recepcjonista");

        int choice = -1;

        // Obsługa błędnych wejść
        while (choice < 1 || choice > 2) {
            System.out.print("Wpisz numer (1 lub 2): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }

        return (choice == 1) ? UserType.HR : UserType.RECEPCJONISTA;
    }

    private static void dodajPacjenta(Scanner scanner) {
        System.out.print("Podaj imię: ");
        String imie = scanner.nextLine();

        System.out.print("Podaj nazwisko: ");
        String nazwisko = scanner.nextLine();

        System.out.print("Podaj PESEL: ");
        String pesel = scanner.nextLine();

        System.out.print("Podaj datę urodzenia (YYYY-MM-DD): ");
        LocalDate dataUrodzenia = LocalDate.parse(scanner.nextLine());

        System.out.print("Podaj numer telefonu: ");
        String telefon = scanner.nextLine();

        System.out.print("Podaj adres e-mail: ");
        String email = scanner.nextLine();

        Pacjent pacjent = new Pacjent(imie, nazwisko, pesel, dataUrodzenia, telefon, email);
        pacjentRepository.dodajPacjenta(pacjent);
    }

    private static void wyswietlPacjentow() {
        if (pacjentRepository.getPacjenci().isEmpty()) {
            System.out.println("Brak pacjentów w systemie.");
        } else {
            pacjentRepository.getPacjenci().values().forEach(System.out::println);
        }
    }
}
