package br.com.mc.elderbr.smarthopperteste;

import java.util.List;

public class Grupo extends Traducao{
    private int cdGrupo;
    private String dsGrupo;
    private List<Item> list;

    public Grupo() {
    }   

    public int getCdGrupo() {
        return cdGrupo;
    }

    public void setCdGrupo(int cdGrupo) {
        this.cdGrupo = cdGrupo;
    }

    public String getDsGrupo() {
        return dsGrupo;
    }

    public void setDsGrupo(String dsGrupo) {
        this.dsGrupo = dsGrupo;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
    
    
}
