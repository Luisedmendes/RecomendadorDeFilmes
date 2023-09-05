package br.inatel.cdg.classes;

public class Categoria {
    // Atributos
    public int idCategoria;
    private String nome;

    // Construtor
    public Categoria(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
