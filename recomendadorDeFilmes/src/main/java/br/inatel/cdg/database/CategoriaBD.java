package br.inatel.cdg.database;

import br.inatel.cdg.classes.Categoria;
import br.inatel.cdg.classes.Perfil;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaBD extends Database{
    //Criando uma nova categoria
    public boolean insertCategoria(Categoria categoria){
        connect();
        String sql = "INSERT INTO Categoria(nome) VALUES (?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, categoria.getNome());
            pst.execute();
            check = true;
        }
        catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
    // Pesquisa uma categoria
    public ArrayList<Categoria> researchCategoria(){
        connect();
        ArrayList<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * from categoria";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Categoria categoriaTemp = new Categoria(result.getString("nome"));
                categoriaTemp.idCategoria = result.getInt("idCategoria");
                System.out.println("ID = " + categoriaTemp.idCategoria);
                System.out.println("Nome categoria = " + categoriaTemp.getNome());
                System.out.println("-------------------------------");
                categorias.add(categoriaTemp);
            }
        }catch(SQLException e){
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
        return categorias;
    }
}
