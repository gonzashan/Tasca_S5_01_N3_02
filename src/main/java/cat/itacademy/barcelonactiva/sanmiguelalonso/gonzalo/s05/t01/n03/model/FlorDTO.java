package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n03.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FlorDTO implements Serializable {

    private Integer pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipusFlor;

    public FlorDTO() {
    }


    /* Getters & Setters */
    public Integer getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNomFlor() {
        return nomFlor;
    }

    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    public String getTipusFlor() {
        return this.tipusFlor;
    }

    public void setTipusFlor(String tipusFlor) {
        this.tipusFlor = tipusFlor;
    }




}
