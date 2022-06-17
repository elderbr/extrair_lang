/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.sqlite.SQLiteConfig;
import utils.Msg;

/**
 *
 * @author User
 */
public class Conexao {
    
    public static Connection conexao;
    
    public static Connection connected() {

        String url = "jdbc:sqlite:smarthopper.db";
        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.setEncoding(SQLiteConfig.Encoding.UTF8);
            conexao = DriverManager.getConnection(url, config.toProperties());
            return conexao;
        } catch (SQLException ex) {
            ex.printStackTrace();
            Msg.ServidorErro(ex, "connected", Conexao.class);
        } catch (ClassNotFoundException e) {
            Msg.ServidorErro("Erro ao criar banco", "connected", Conexao.class, e);

        }
        return null;
    }

    public static PreparedStatement prepared(String sql) throws SQLException {
        connected();
        return conexao.prepareStatement(sql);
    }

    public static boolean desconect() {
        try {
            if (conexao.isClosed() == false) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean create(String sql) throws SQLException {
        connected();
        PreparedStatement smt = conexao.prepareStatement(sql);
        return smt.execute();
    }
}
