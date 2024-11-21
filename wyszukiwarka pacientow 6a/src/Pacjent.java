import java.time.LocalDate;

public class Pacjent {
    private String imie;
    private String nazwisko;
    private String pesel;
    private LocalDate dataUrodzenia;
    private String telefon;
    private String email;

    // Konstruktor
    public Pacjent(String imie, String nazwisko, String pesel, LocalDate dataUrodzenia, String telefon, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
        this.telefon = telefon;
        this.email = email;
    }

    // Gettery
    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Pacjent{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}