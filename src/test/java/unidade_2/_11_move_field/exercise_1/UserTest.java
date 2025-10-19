package unidade_2._11_move_field.exercise_1;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void constructor_shouldInitializeUserAndDefaultPostContent() {
        User user = new User("testuser", "test@example.com");
        assertEquals("testuser", user.getUsername());
        assertEquals("test@example.com", user.getEmail());
        assertTrue(user.getFollowers().isEmpty());
        assertTrue(user.getFollowing().isEmpty());
        assertEquals("Nenhuma postagem ainda.", user.getPostContent());
        assertNull(user.getPostDate());
    }

    @Test
    void createPost_shouldUpdatePostContentAndDate() {
        User user = new User("poster", "poster@example.com");
        String content = "Minha postagem de teste.";
        user.createPost(content);
        assertEquals(content, user.getPostContent());
        assertNotNull(user.getPostDate());
        assertTrue(user.getPostDate().isBefore(LocalDateTime.now().plusSeconds(1)));
    }

    @Test
    void follow_shouldAddUserToFollowingAndFollowers() {
        User user1 = new User("u1", "u1@e.com");
        User user2 = new User("u2", "u2@e.com");

        user1.follow(user2);

        assertTrue(user1.getFollowing().contains(user2));
        assertTrue(user2.getFollowers().contains(user1));
        assertEquals(1, user1.getFollowing().size());
        assertEquals(1, user2.getFollowers().size());
    }

    @Test
    void createMultiplePosts_onlyLastPostShouldBeRetained() {
        User user = new User("multi", "multi@e.com");
        String content1 = "Primeira postagem.";
        String content2 = "Segunda postagem.";

        user.createPost(content1);
        user.createPost(content2);
        assertEquals(content2, user.getPostContent());
    }
}