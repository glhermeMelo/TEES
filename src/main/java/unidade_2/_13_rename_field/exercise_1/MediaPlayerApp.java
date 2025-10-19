package unidade_2._13_rename_field.exercise_1;

public class MediaPlayerApp {
    public static void main(String[] args) {
        System.out.println("--- Media Player Simples ---");

        Song song1 = new Song("Bohemian Rhapsody", "Queen", 354, "A Night at the Opera");
        Song song2 = new Song("Stairway to Heaven", "Led Zeppelin", 482, "Led Zeppelin IV");
        Song song3 = new Song("Hotel California", "Eagles", 390, "Hotel California");

        // Exibe detalhes das músicas
        System.out.println(song1);
        System.out.println("\n" + song2);

        // Cria uma playlist e adiciona músicas
        Playlist classicRock = new Playlist("Clássicos do Rock");
        classicRock.addSong(song1);
        classicRock.addSong(song2);
        classicRock.addSong(song3);

        classicRock.displayPlaylist();

        // Atualiza uma música (exemplo)
        System.out.println("\n--- Atualizando Título da Música 1 ---");
        song1.setTtl("Bohemian Rhapsody (Remastered)");
        classicRock.displayPlaylist();
    }
}
