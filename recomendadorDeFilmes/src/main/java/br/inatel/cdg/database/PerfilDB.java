package br.inatel.cdg.database;
import br.inatel.cdg.classes.Perfil;
import br.inatel.cdg.classes.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class PerfilDB extends Database{
    //Criando um novo perfil
    public boolean insertPerfil(Perfil perfil){
        connect();
        String sql = "INSERT INTO perfil(generofavorito,usuario_idusuario) VALUES (?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, perfil.getGeneroFavorito());
            pst.setInt(2, perfil.usario_idusuario);
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


}
