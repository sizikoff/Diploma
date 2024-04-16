package com.example.diploma.Employee;

public class Employee {

    private String fio; // название
    private String dolznost;  // столица
    private String obyazannost;  // столица
    private int foto; // ресурс флага

    public Employee(String fio, String dolznost, String obyazannost, int foto) {
        this.fio = fio;
        this.dolznost = dolznost;
        this.obyazannost = obyazannost;
        this.foto = foto;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDolznost() {
        return dolznost;
    }

    public void setDolznost(String dolznost) {
        this.dolznost = dolznost;
    }

    public String getObyazannost() {
        return obyazannost;
    }

    public void setObyazannost(String obyazannost) {
        this.obyazannost = obyazannost;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
