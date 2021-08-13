package com.example.Rafael_300300098.Connection;

import com.example.Rafael_300300098.Entities.SavingTable;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DaoSavingTableTest {
    DaoSavingTable dao;

    @Test
    void add() throws SQLException, ClassNotFoundException {
        dao =mock(DaoSavingTable.class);
        SavingTable saving = new SavingTable("101", "Rafael", 1000, 10, "Saving-Delux");
//        when(dao.add(saving)).then(true);
    }

    @Test
    void edit() {
    }

    @Test
    void delete() throws SQLException {
//        dao =mock(DaoSavingTable.class);
//        when(dao.delete("101")).thenReturn();
    }

    @Test
    void display() throws SQLException, ClassNotFoundException {
        dao =mock(DaoSavingTable.class);
        when(dao.display()).thenReturn(new ArrayList<>());
        assertEquals(new ArrayList<>(), dao.display());
    }

    @Test
    void search() throws SQLException, ClassNotFoundException {
        dao =mock(DaoSavingTable.class);
        when(dao.search("101")).thenReturn(new SavingTable());
        assertEquals(new SavingTable(), dao.search("101"));
    }
}