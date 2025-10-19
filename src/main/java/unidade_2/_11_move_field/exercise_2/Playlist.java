package unidade_2._11_move_field.exercise_2;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Song> songs;
    private int currentSongDurationSeconds;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
        this.currentSongDurationSeconds = 0;
    }

    public String getName() { return name; }

    public List<Song> getSongs() { return songs; }

    /**
     * Adiciona uma música à playlist e, como efeito colateral,
     * define a duração da playlist como a duração da música adicionada.
     *
     * @param song A música a ser adicionada.
     * @param durationSeconds A duração da música em segundos.
     */
    public void addSong(Song song, int durationSeconds) {
        this.songs.add(song);
        this.currentSongDurationSeconds = durationSeconds;
        System.out.println("Adicionada à playlist '" + name + "': " + song.getTitle() +
                " (" + formatDuration(durationSeconds) + ")");
    }

    /**
     * Retorna a duração da "música atual" ou "última música adicionada"
     * armazenada na playlist.
     *
     * @return A duração da música em segundos.
     */
    public int getCurrentSongDurationSeconds() {
        return currentSongDurationSeconds;
    }

    /**
     * Formata uma duração de segundos para o formato MM:SS.
     *
     * @param totalSeconds O total de segundos a ser formatado.
     *
     * @return A duração formatada como String (MM:SS).
     */
    public String formatDuration(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    /**
     * Exibe o conteúdo da playlist.
     */
    public void displayPlaylist() {
        System.out.println("\n--- Playlist: " + name + " ---");
        if (songs.isEmpty()) {
            System.out.println("Nenhuma música nesta playlist.");
        } else {
            for (int i = 0; i < songs.size(); i++) {
                System.out.println((i + 1) + ". " + songs.get(i).getTitle() + " - " + songs.get(i).getArtist() +
                        " (" + formatDuration(currentSongDurationSeconds) + ")");
            }
        }
    }
}