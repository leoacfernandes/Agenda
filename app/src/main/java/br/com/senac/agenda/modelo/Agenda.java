package br.com.senac.agenda.modelo;

import java.io.Serializable;

public class Agenda implements Serializable {
    private Long id;
    private String agenda;
    private String data;
    private String hora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String toString() {
        return getAgenda() + " - " + getData()+ " - " + getHora();
    }

}





