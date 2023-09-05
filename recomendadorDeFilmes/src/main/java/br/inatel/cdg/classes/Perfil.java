package br.inatel.cdg.classes;

public class Perfil {
    // Atributos
    public int idPerfil;
    public int usario_idusuario;
    private String generoFavorito;

    // Construtor
    public Perfil(String generoFavorito, int usario_idusuario) {
        this.generoFavorito = generoFavorito;
        this.usario_idusuario = usario_idusuario;
    }

    // Getters e Setters
    public String getGeneroFavorito() {
        return generoFavorito;
    }

    public void setGeneroFavorito(String generoFavorito) {
        this.generoFavorito = generoFavorito;
    }
}
