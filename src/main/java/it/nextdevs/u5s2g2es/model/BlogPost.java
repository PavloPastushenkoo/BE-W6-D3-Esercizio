package it.nextdevs.u5s2g2es.model;

import lombok.Data;

@Data
public class BlogPost {
    private static int count;
    private Integer id;
    private String categoria;
    private String cover;
    private String contenuto;
    private Integer tempoDiLettura;

    public BlogPost(String categoria, String contenuto, Integer tempoDiLettura) {
        this.categoria = categoria;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        count++;
        this.id = count;
        this.cover = "https://picsum.photos/200/300";
    }
}
