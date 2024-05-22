package it.nextdevs.u5s2g2es.model;

import lombok.Data;

@Data
public class BlogAuthor {
    private static int count;
    private Integer id;
    private String nome;
    private String cognome;
    private String email;
    private String dataDiNascita;
    private String avatar;

    public BlogAuthor(String nome, String cognome, String email, String dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.avatar = "https://ui-avatars.com/api/?name="+this.nome+"+"+this.cognome;
        count++;
        this.id = count;
    }
}
