package br.inatel.cdg;

import br.inatel.cdg.classes.Categoria;
import br.inatel.cdg.classes.Filme;
import br.inatel.cdg.classes.Perfil;
import br.inatel.cdg.classes.Usuario;
import br.inatel.cdg.database.CategoriaBD;
import br.inatel.cdg.database.FilmeDB;
import br.inatel.cdg.database.PerfilDB;
import br.inatel.cdg.database.UsuarioDB;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PerfilDB perfilDB = new PerfilDB();
        UsuarioDB usuarioDB = new UsuarioDB();
        FilmeDB filmeDB = new FilmeDB();
        CategoriaBD categoriaBD = new CategoriaBD();
        Scanner sc = new Scanner(System.in);



        System.out.println("CADASTRE SEU USUARIO");
        System.out.println("Nome: ");
        String nome = sc.nextLine();

        System.out.println("Email: ");
        String email = sc.nextLine();
        Usuario usuario = new Usuario(nome, email);

        usuarioDB.insertUsuario(usuario);

        System.out.println("-- USUARIO INSERIDO -- ");
        usuarioDB.researchUsuario();

        System.out.println("Genero preferido: ");
        String genero = sc.nextLine();

        System.out.println("ID de seu usuario: ");
        int idusuario = sc.nextInt();
        sc.nextLine();
        Perfil perfil = new Perfil(genero,idusuario);
        perfilDB.insertPerfil(perfil);



        boolean flag = true;

        while (flag){
            System.out.println("BEM VINDO AO RECOMENDADOR DE FILME 4000");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Mostrar todos filmes");
            System.out.println("3 - Recomendar filme aleatório");
            System.out.println("4 - Recomendar filmes da categoria preferida");
            System.out.println("5 - Deletar Usuario");
            System.out.println("6 - Atualizar os dados de um usuario");
            System.out.println("7 - SAIR");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:

                    System.out.println("ADICIONANDO FILME");
                    System.out.println();

                    System.out.println("Titulo: ");
                    String titulo = sc.nextLine();


                    System.out.println("Ano: ");
                    String ano = sc.nextLine();


                    System.out.println("Duracao: ");
                    Float duracao = sc.nextFloat();
                    sc.nextLine();

                    Filme filme = new Filme(titulo,ano,duracao);

                    System.out.println("Categoria: ");
                    String categ = sc.nextLine();

                    Categoria categoria = new Categoria(categ);

                    filmeDB.insertFilme(filme);
                    categoriaBD.insertCategoria(categoria);
                    break;
                case 2:
                    filmeDB.researchFilme();
                    break;

                case 3:
                    filmeDB.researchAleatorioFilme();
                    break;

                case 4:
                    System.out.println("Entre com qual categoria quer assistir: (suspense,acao,terror,comedia,aventura)");
                    String escolha = sc.nextLine();
                    if(escolha.equalsIgnoreCase("suspense")){
                        filmeDB.recomendaFilme(escolha);
                    } else if(escolha.equalsIgnoreCase("aventura")){
                        filmeDB.recomendaFilme(escolha);
                    } else if (escolha.equalsIgnoreCase("terror")){
                        filmeDB.recomendaFilme(escolha);
                    } else if(escolha.equalsIgnoreCase("acao")){
                        filmeDB.recomendaFilme(escolha);
                    } else {
                        filmeDB.recomendaFilme(escolha);
                    }
                    break;

                case 5:
                    System.out.println("Entre com o id do usuario que quer deletar: ");
                    int idelete = sc.nextInt();
                    sc.nextLine();
                    usuarioDB.deleteUsuario(idelete);
                    break;
                case 6:
                    System.out.println("Entre com o ID do usuario");
                    int iduserupdate = sc.nextInt();
                    sc.nextLine();
                    String nomeNovo = sc.nextLine();
                    System.out.println("Entre com novo nome de usuario");
                    usuarioDB.updateUsuario(iduserupdate, nomeNovo);
                    break;
                case 7:
                    System.out.println("ENCERRADO");
                    flag = false;
                    break;
                default:
                    System.out.println("OPERACAO INVALIDA");
            }
        }

    }
}
