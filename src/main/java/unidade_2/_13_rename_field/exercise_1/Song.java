package unidade_2._13_rename_field.exercise_1;

public class Song {
    private String ttl;        // Título da música
    private String art;        // Nome do artista
    private int durSecs;       // Duração em segundos
    private String alb;        // Nome do álbum

    public Song(String ttl, String art, int durSecs, String alb) {
        this.ttl = ttl;
        this.art = art;
        this.durSecs = durSecs;
        this.alb = alb;
    }

    // Getters
    public String getTtl() { return ttl; }
    public String getArt() { return art; }
    public int getDurSecs() { return durSecs; }
    public String getAlb() { return alb; }

    // Setters
    public void setTtl(String ttl) { this.ttl = ttl; }
    public void setArt(String art) { this.art = art; }
    public void setDurSecs(int durSecs) { this.durSecs = durSecs; }
    public void setAlb(String alb) { this.alb = alb; }

    @Override
    public String toString() {
        // Formata a duração para minutos e segundos para exibição
        int minutes = durSecs / 60;
        int seconds = durSecs % 60;
        String formattedDuration = String.format("%d:%02d", minutes, seconds);

        return "Título: '" + ttl + "'" +
                "\n  Artista: " + art +
                "\n  Álbum: " + alb +
                "\n  Duração: " + formattedDuration;
    }
}
