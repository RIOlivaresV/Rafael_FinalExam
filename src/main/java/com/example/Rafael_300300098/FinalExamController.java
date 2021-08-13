package com.example.Rafael_300300098;

import com.example.Rafael_300300098.Connection.Connection;
import com.example.Rafael_300300098.Connection.DaoSavingTable;
import com.example.Rafael_300300098.Entities.SavingTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping
@Controller
public class FinalExamController {

    DaoSavingTable  dao;
    @Autowired
    Connection con;

    String[] savingType = new String[]{ "Savings-Delux", "Savings-Regular"};

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showPage(ModelMap model, @RequestParam(defaultValue = "") String id) throws ClassNotFoundException, SQLException {
        dao = new DaoSavingTable(con.connection());
        List<SavingTable> list = dao.display();
        model.addAttribute("savings", list);
        model.addAttribute("edit", false);
        model.addAttribute("types", savingType);
        return "FinalExamView";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(ModelMap model, @RequestParam(defaultValue = "") String id) throws ClassNotFoundException, SQLException {
        dao = new DaoSavingTable(con.connection());
        List<SavingTable> list = dao.display();
        model.addAttribute("savings", list);
        model.addAttribute("types", savingType);
        model.addAttribute("customer", new SavingTable());
        return "FinalExamView";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addUser(ModelMap model, @RequestParam String custno, @RequestParam String custname, @RequestParam String cdep, @RequestParam String nyears, @RequestParam String savingType) throws ClassNotFoundException, SQLException {
        dao = new DaoSavingTable(con.connection());
        if (!((dao.search(custno)) == null)) {
            model.put("errorMessage", "Record Existing");
            return "redirect:/";
        }
        SavingTable savingTable= new SavingTable(custno, custname, Double.parseDouble(cdep), Integer.parseInt(nyears), savingType);
        dao.add(savingTable);
        model.clear();
        model.put("messages", "User "+savingTable.getCustname()+" was added");
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUserGet(ModelMap model, @RequestParam String custno) throws ClassNotFoundException, SQLException {
        dao = new DaoSavingTable(con.connection());
        SavingTable savingTable= dao.search(custno);
        List<SavingTable> list = dao.display();
        model.addAttribute("edit", false);
        model.addAttribute("savings", list);
        model.addAttribute("types", savingType);
        model.addAttribute("customer", savingTable);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(ModelMap model, @RequestParam String custno, @RequestParam String custname, @RequestParam String cdep, @RequestParam String nyears, @RequestParam String savingType) throws ClassNotFoundException, SQLException {
        dao = new DaoSavingTable(con.connection());
        SavingTable savingTable= new SavingTable(custno, custname, Double.parseDouble(cdep), Integer.parseInt(nyears), savingType);
        dao.edit(savingTable);
        model.clear();
        model.put("messages", "User "+savingTable.getCustname()+" was edited");
        return "redirect:/";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(ModelMap model, @RequestParam String id) throws ClassNotFoundException, SQLException {
        dao = new DaoSavingTable(con.connection());
        dao.delete(id);
        model.clear();
        model.put("messages", "User was deleted");
        return "redirect:/";
    }
}
