package br.inatel.cdg.classes;

public class Usuario {
    // Atributos
    public int idUsuario;
    private String nome;
    private String email;

    // Construtor
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
