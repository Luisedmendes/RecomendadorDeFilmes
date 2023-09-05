package br.inatel.cdg.classes;

public class Filme {
    // Atributos
    public int idFilme;
    private String titulo;
    private String ano;
    private float duracao;

    public Filme(String titulo, String ano, float duracao) {
        this.titulo = titulo;
        this.ano = ano;
        this.duracao = duracao;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }
}
