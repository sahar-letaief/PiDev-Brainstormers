package com.mycompany.entities;

public class Order {
    private int id;
    private int code_postal,tel;
    private String ref_cmde,Pays,Region;
    private String etat_cmde;



    public Order(int id, int code_postal, int tel, String ref_cmde, String pays, String region, String etat_cmde) {
        this.id = id;
        this.code_postal = code_postal;
        this.tel = tel;
        this.ref_cmde = ref_cmde;
        this.Pays = pays;
        this.Region = region;
        this.etat_cmde = etat_cmde;
    }
    public Order() {
    }




    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code_postal=" + code_postal +
                ", tel=" + tel +
                ", ref_cmde='" + ref_cmde + '\'' +
                ", Pays='" + Pays + '\'' +
                ", Region='" + Region + '\'' +
                ", etat_cmde=" + etat_cmde +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getRef_cmde() {
        return ref_cmde;
    }

    public void setRef_cmde(String ref_cmde) {
        this.ref_cmde = ref_cmde;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String pays) {
        Pays = pays;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getEtat_cmde() {
        return etat_cmde;
    }

    public void setEtat_cmde(String etat_cmde) {
        this.etat_cmde = etat_cmde;
    }
}
