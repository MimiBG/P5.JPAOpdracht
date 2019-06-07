package hu.nl.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="REIZIGER")
public class Reiziger {
    @Id
    @Column(name = "REIZIGERID", unique = true, nullable = false)
    private int id;

    @Column(name ="VOORLETTERS", length = 10)
    private String voorLetters;

    @Column(name = "TUSSENVOEGSEL", length = 10)
    private String tussenvoegsel;

    @Column(name = "ACHTERNAAM")
    private String achterNaam;

    @Column(name = "GEBOORTEDATUM")
    private Date gbdatum;

    @OneToMany(targetEntity = OvChipkaart.class, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "reiziger")
    private List<OvChipkaart> kaarts;

    public Reiziger(int id, String vl, String tv, String an, Date gbDate, ArrayList<OvChipkaart> kaarts) {
        this.id = id;
        this.voorLetters = vl;
        this.tussenvoegsel = tv;
        this.achterNaam = an;
        this.gbdatum = gbDate;
        this.kaarts = kaarts;
    }

    public Reiziger() {}

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id;}


    public String getVoorletters() {
        return this.voorLetters;
    }

    public String getMiddleName() {
        return this.tussenvoegsel;
    }

    public String getLastName() {
        return this.achterNaam;
    }

    public void setVoorLetters(String voorLetters) {
        this.voorLetters = voorLetters;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    public Date getGBdatum() {
        return this.gbdatum;
    }

    public void setGBdatum(Date datum) {
        this.gbdatum = datum;
    }

    public List<OvChipkaart> getKaarts() {
        return kaarts;
    }

    public void setkaarts(ArrayList<OvChipkaart> kaarts) {
        this.kaarts = kaarts;
    }
}