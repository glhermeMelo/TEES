package unidade_2._11_move_field.exercise_1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String email;
    private List<User> followers;
    private List<User> following;

    // Estes campos representam detalhes de uma postagem
    private String postContent;
    private LocalDateTime postDate;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.postContent = "Nenhuma postagem ainda.";
        this.postDate = null;
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public List<User> getFollowing() { return following; }

    public List<User> getFollowers() {
        return followers;
    }

    public String getPostContent() { return postContent; }
    public LocalDateTime getPostDate() { return postDate; }

    /**
     * Simula a criação de uma postagem por este usuário.
     *
     * @param content O conteúdo da postagem.
     */
    public void createPost(String content) {
        this.postContent = content;
        this.postDate = LocalDateTime.now();
        System.out.println(username + " postou: '" + content + "' em " + postDate);
    }

    /**
     * Segue outro usuário.
     *
     * @param userToFollow O usuário a ser seguido.
     */
    public void follow(User userToFollow) {
        if (!this.following.contains(userToFollow) && !this.equals(userToFollow)) {
            this.following.add(userToFollow);
            userToFollow.addFollower(this);
            System.out.println(this.username + " agora segue " + userToFollow.getUsername());
        }
    }

    /**
     * Adiciona um seguidor a este usuário.
     *
     * @param follower O usuário que está seguindo.
     */
    private void addFollower(User follower) {
        if (!this.followers.contains(follower)) {
            this.followers.add(follower);
        }
    }

    /**
     * Exibe o perfil do usuário, incluindo a postagem mais recente.
     */
    public void displayProfile() {
        System.out.println("\n--- Perfil de " + username + " ---");
        System.out.println("Email: " + email);
        System.out.println("Seguidores: " + followers.size());
        System.out.println("Seguindo: " + following.size());
        System.out.println("Última Postagem: " + (postContent.equals("Nenhuma postagem ainda.") ? postContent : "'" + postContent + "' em " + postDate));
    }
}