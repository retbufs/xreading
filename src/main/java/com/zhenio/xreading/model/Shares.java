package com.zhenio.xreading.model;

import java.io.Serializable;

public class Shares  implements Serializable {
    private Integer id;
    private String fdcode;
    private String abbrev;
    private String spell;
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFdcode() {
        return fdcode;
    }

    public void setFdcode(String fdcode) {
        this.fdcode = fdcode;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
