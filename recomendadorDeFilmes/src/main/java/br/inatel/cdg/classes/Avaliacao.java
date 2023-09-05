package br.inatel.cdg.classes;

public class Avaliacao {
    // Atributos
    public int idAvaliacao;
    private String pontuacao;
    private String comentario;

    // Construtor
    public Avaliacao(String pontuacao, String comentario) {
        this.pontuacao = pontuacao;
        this.comentario = comentario;
    }

    // Getters e Setters
    public String getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
