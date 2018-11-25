/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.dao;

import br.ufpr.tads.bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ArtVin
 */
public class UserDAO {
    private Connection con;
    private ResultSet rs;
    
    public UserDAO(){
        con = ConnectionFactory.getConnection();
    }
    
    public User getUser(String username){
        
        User u = null;
        PreparedStatement st;
        try {
            st = con.prepareStatement(
                    "SELECT IDUSER,PASSWORD FROM USER WHERE USERNAME = ?"
            );
            if(username != null && !username.isEmpty()){
                st.setString(1, username);
                
                rs = st.executeQuery();
                
                while(rs.next()){
                    u = new User();
                    u.setId(rs.getInt("IDUSER"));
                    u.setUsername(rs.getString("USERNAME"));
                    u.setPassword(rs.getString("PASSWORD"));
                }
            }            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
}