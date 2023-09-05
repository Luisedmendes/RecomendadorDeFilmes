package br.inatel.cdg.database;
import br.inatel.cdg.classes.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDB extends Database{
    // Inserir um novo registro de usuario
    public boolean insertUsuario(Usuario usuario){
        connect();
        String sql = "INSERT INTO Usuario(Nome,Email) VALUES (?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
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

    // Pesquisa um usuario
    public ArrayList<Usuario> researchUsuario(){
        connect();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * from usuario";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Usuario usuarioTemp = new Usuario(result.getString("nome"),result.getString("email"));
                usuarioTemp.idUsuario = result.getInt("idUsuario");
                System.out.println("ID = " + usuarioTemp.idUsuario);
                System.out.println("Nome = " + usuarioTemp.getNome());
                System.out.println("Email = " + usuarioTemp.getEmail());
                System.out.println("-------------------------------");
                usuarios.add(usuarioTemp);
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
        return usuarios;
    }

    // Dar update em um usario
    public boolean updateUsuario(int idUsuario, String nome){
        connect();
        String sql = "UPDATE usuario SET nome = ? WHERE idusuario=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, idUsuario);
            pst.execute();
            check = true;
        }catch (SQLException e){
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

    // Dar um delete em um usuario
    public boolean deleteUsuario(int idUsuario){
        connect();
        String sql = "DELETE FROM usuario WHERE idusuario=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idUsuario);
            pst.execute();
            check = true;
        }catch (SQLException e){
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
}
