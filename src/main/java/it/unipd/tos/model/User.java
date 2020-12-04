////////////////////////////////////////////////////////////////////
// [VALTON] [TAHIRAJ] [1193389]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import java.time.LocalDate;
import java.time.Period;

public class User {
    private String id;
    private String nome;
    private String cognome;
    private LocalDate nascita;
    public User(String id, String nome, String cognome, LocalDate nascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.nascita = nascita;
    }
    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public LocalDate getNascita() {
        return nascita;
    }
    
    public boolean isUnderAge() {
        Period period = Period.between(nascita,LocalDate.now());
        return period.getYears()<18;
    }
}
