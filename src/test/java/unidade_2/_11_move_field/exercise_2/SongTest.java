package unidade_2._11_move_field.exercise_2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @Test
    void constructor_shouldSetTitleAndArtist() {
        Song song = new Song("Test Title", "Test Artist");
        assertEquals("Test Title", song.getTitle());
        assertEquals("Test Artist", song.getArtist());
    }

    @Test
    void toString_shouldReturnFormattedTitleAndArtist() {
        Song song = new Song("My Awesome Song", "The Band");
        assertEquals("'My Awesome Song' por The Band", song.toString());
    }
}