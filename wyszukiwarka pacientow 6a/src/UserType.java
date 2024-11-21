public enum UserType {
    HR("Pracownik działu HR"),
    RECEPCJONISTA("Recepcjonista");

    private final String displayName;

    UserType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}