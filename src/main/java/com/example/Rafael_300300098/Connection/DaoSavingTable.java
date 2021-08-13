package com.example.Rafael_300300098.Connection;

import com.example.Rafael_300300098.Entities.SavingTable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoSavingTable implements IDatabase<SavingTable>{
    java.sql.Connection con;

    public DaoSavingTable(java.sql.Connection con) {
        this.con = con;
    }

    @Override
    public void add(SavingTable entity) throws ClassNotFoundException, SQLException {
        String quer1 = "INSERT INTO savingstable VALUES ( ?, ?, ?, ?, ? )";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, entity.getCustno());
        query.setString(2, entity.getCustname());
        query.setDouble(3, entity.getCdep());
        query.setInt(4, entity.getNyears());
        query.setString(5, entity.getSavtype());
        query.executeUpdate();
    }

    @Override
    public SavingTable edit(SavingTable entity) throws SQLException, ClassNotFoundException {
        String quer1 = "UPDATE savingstable SET custname = ?, cdep = ?, nyears = ?, savtype = ? WHERE custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, entity.getCustname());
        query.setDouble(2, entity.getCdep());
        query.setInt(3, entity.getNyears());
        query.setString(4, entity.getSavtype());
        query.setString(5, entity.getCustno());
        ResultSet rs = query.executeQuery();
        SavingTable obj1=null;
        obj1 = new SavingTable(rs.getString("custno"),rs.getString("custname"), rs.getDouble("cdep"), rs.getInt("nyears"), rs.getString("savtype"));
        return obj1;
    }

    @Override
    public void delete(String id) throws SQLException {
        String quer1 = "DELETE FROM savingstable WHERE custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, id);
        query.executeQuery();
    }

    @Override
    public List<SavingTable> display() throws ClassNotFoundException, SQLException {
        List<SavingTable> savingTablesList = new ArrayList<SavingTable>();
        String quer1 = "Select * from savingstable";
        PreparedStatement query = con.prepareStatement(quer1, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = query.executeQuery();
        SavingTable obj1;
        //display records if there is data;
        while (rs.next()) {
            obj1 = new SavingTable(rs.getString("custno"),rs.getString("custname"), rs.getDouble("cdep"), rs.getInt("nyears"), rs.getString("savtype"));
            savingTablesList.add(obj1);
        }
        return savingTablesList;
    }


    public SavingTable search(String custno) throws SQLException,ClassNotFoundException {
        String quer1 = "Select * from savingstable where custno = ?";
        PreparedStatement query = con.prepareStatement(quer1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        query.setString(1, custno);
        ResultSet rs = query.executeQuery();
        if(!rs.first()){
            System.out.print("Record not existing");
            return null;
        }
        SavingTable obj1=null;
        obj1 = new SavingTable(rs.getString("custno"),rs.getString("custname"), rs.getDouble("cdep"), rs.getInt("nyears"), rs.getString("savtype"));
        return obj1;
    }
}
