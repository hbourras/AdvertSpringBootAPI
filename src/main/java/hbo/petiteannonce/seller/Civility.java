package hbo.petiteannonce.seller;

public enum Civility {
    M("Monsieur"), MME("Madame"), DR("Docteur"), ME("Maître");
    private String title;

    Civility(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
