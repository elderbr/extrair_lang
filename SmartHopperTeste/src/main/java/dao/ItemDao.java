/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import br.com.mc.elderbr.smarthopperteste.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Msg;

/**
 *
 * @author User
 */
public class ItemDao {

    private Item item = new Item();
    private PreparedStatement stm;
    private ResultSet rs;

    public ItemDao() {
        try {
            stm = Conexao.prepared("CREATE TABLE IF NOT EXISTS item ("
                    + "cdItem INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "dsItem TEXT NOT NULL UNIQUE"
                    + ");");
            stm.execute();
        } catch (SQLException ex) {
            
                Msg.ServidorErro("Erro ao criar a tabela item!!", ItemDao.class, ex);
        }finally{
            Conexao.desconect();
        }
        INSERT_DEFAULT();
    }
    
    
    
    public int insert(Item item){
        try {
            stm = Conexao.prepared("INSERT INTO item (dsItem) VALUES (?);");
            stm.setString(1, item.getDsItem());
            stm.execute();
            rs = stm.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            if(ex.getErrorCode()!=19)
                Msg.ServidorErro("Erro ao adicionar item!!", "insert(Item item)", getClass(), ex);
        }finally{
            Conexao.desconect();
            close();
        }
        return 0;
    }
    
    public int select(Item item){
        try {
            
            if(item.getCdItem()>0){
                stm = Conexao.prepared( String.format("SELECT * FROM item WHERE cdItem = %d;", item.getCdItem()));
            }else{
                stm = Conexao.prepared( String.format("SELECT * FROM item WHERE dsItem = %s;", item.getDsItem()));
            }
            
            stm.execute();
            rs = stm.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Msg.ServidorErro("Erro ao adicionar item!!", "insert(Item item)", getClass(), ex);
        }finally{
            Conexao.desconect();
            close();
        }
        return 0;
    }
    
    public int update(Item item){
        try {
            stm = Conexao.prepared("UPDATE item SET dsItem = ? WHERE cdItem = ?;");
            stm.setString(1, item.getDsItem());
            stm.setInt(2, item.getCdItem());
            return stm.executeUpdate();
        } catch (SQLException ex) {
            Msg.ServidorErro("Erro ao atualizar o item!!", "update(Item item)", getClass(), ex);
        }finally{
            Conexao.desconect();
            close();
        }
        return 0;
    }
    
    private void INSERT_DEFAULT(){
        this.item.getListItemStack().forEach(item -> {
            insert(item);
        });
    }
    
    private void close(){
        try{
            if(stm!=null){
                stm.close();
            }
            if(rs!=null){
                rs.close();
            }
        }catch(SQLException e){
            
        }
    }

}
