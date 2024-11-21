import java.time.LocalDate;
import java.time.Period;

public class Pacjent {
    private String imie;
    private String nazwisko;
    private String pesel;
    private LocalDate dataUrodzenia;
    private int wiek;
    private String telefon;
    private String email;

    public Pacjent(String imie, String nazwisko, String pesel, LocalDate dataUrodzenia, String telefon, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
        this.wiek = obliczWiek(dataUrodzenia);
        this.telefon = telefon;
        this.email = email;
    }

    private int obliczWiek(LocalDate dataUrodzenia) {
        return Period.between(dataUrodzenia, LocalDate.now()).getYears();
    }

    // Getter dla PESEL
    public String getPesel() {
        return pesel;
    }

    @Override
    public String toString() {
        return "Pacjent{" +
                "Imię='" + imie + '\'' +
                ", Nazwisko='" + nazwisko + '\'' +
                ", PESEL='" + pesel + '\'' +
                ", Data urodzenia=" + dataUrodzenia +
                ", Wiek=" + wiek +
                ", Telefon='" + telefon + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}