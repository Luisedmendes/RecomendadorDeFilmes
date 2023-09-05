package br.inatel.cdg.database;

import br.inatel.cdg.classes.Filme;
import br.inatel.cdg.classes.Perfil;
import br.inatel.cdg.classes.Usuario;

import java.util.Random;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDB extends Database{

    public boolean insertFilme(Filme filme){
        connect();
        String sql = "INSERT INTO filme(titulo,ano,duracao) VALUES (?,?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, filme.getTitulo());
            pst.setString(2, filme.getAno());
            pst.setFloat(3, filme.getDuracao());
            pst.execute();
            check = true;
        }
        catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try {
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: "+e.getMessage());
            }
        }
        return check;
    }

    //Pesquisa um filme
    public ArrayList<Filme> researchFilme(){
        connect();
        ArrayList<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * from filme";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Filme filmeTemp = new Filme(result.getString("titulo"), result.getString("ano"), result.getInt("duracao"));
                filmeTemp.idFilme = result.getInt("idFilme");
                System.out.println("ID = " +filmeTemp.idFilme);
                System.out.println("Titulo = " +filmeTemp.getTitulo());
                System.out.println("Ano = " +filmeTemp.getAno());
                System.out.println("Duração = " +filmeTemp.getDuracao());
                System.out.println("-------------------------------");
                filmes.add(filmeTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return filmes;
    }

    // Pega somente um filme
    public ArrayList<Filme> researchAleatorioFilme(){

        Random random = new Random();
        int numeroAleatorio = random.nextInt(10) + 1;

        connect();
        ArrayList<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * from filme WHERE idfilme = "+ numeroAleatorio;

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Filme filmeTemp = new Filme(result.getString("titulo"), result.getString("ano"), result.getInt("duracao"));
                filmeTemp.idFilme = result.getInt("idFilme");
                System.out.println("ID = " +filmeTemp.idFilme);
                System.out.println("Titulo = " +filmeTemp.getTitulo());
                System.out.println("Ano = " +filmeTemp.getAno());
                System.out.println("Duração = " +filmeTemp.getDuracao());
                System.out.println("-------------------------------");
                filmes.add(filmeTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return filmes;
    }

    public ArrayList<Filme> recomendaFilme(String escolha){

        connect();
        ArrayList<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * from filme, categoria WHERE nome = "+"'"+escolha+"'";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Filme filmeTemp = new Filme(result.getString("titulo"), result.getString("ano"), result.getInt("duracao"));
                filmeTemp.idFilme = result.getInt("idFilme");
                System.out.println("ID = " +filmeTemp.idFilme);
                System.out.println("Titulo = " +filmeTemp.getTitulo());
                System.out.println("Ano = " +filmeTemp.getAno());
                System.out.println("Duração = " +filmeTemp.getDuracao());
                System.out.println("-------------------------------");
                filmes.add(filmeTemp);


            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return filmes;
    }




}


