package com.example.Rafael_300300098.Entities;

public class SavingTable {
    private String custno;
    private String custname;
    private double cdep;
    private int nyears;
    private String savtype;

    public SavingTable(String custno, String custname, double cdep, int nyears, String savtype) {
        this.custno = custno;
        this.custname = custname;
        this.cdep = cdep;
        this.nyears = nyears;
        this.savtype = savtype;
    }

    public SavingTable() {
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public double getCdep() {
        return cdep;
    }

    public void setCdep(double cdep) {
        this.cdep = cdep;
    }

    public int getNyears() {
        return nyears;
    }

    public void setNyears(int nyears) {
        this.nyears = nyears;
    }

    public String getSavtype() {
        return savtype;
    }

    public void setSavtype(String savtype) {
        this.savtype = savtype;
    }
}
