package br.inatel.cdg.database;

import java.sql.*;

public abstract class Database {
    Connection connection;
    Statement statement;
    ResultSet result;
    PreparedStatement pst;

    static final String user = "root";
    static final String password = "Batata16082012#";
    static final String database = "bancopoo";

    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public boolean check = false;

    public void connect(){
        try{
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Conexão feita com sucesso: " + connection);
        }
        catch (SQLException e){
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
}