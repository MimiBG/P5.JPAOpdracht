package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    //  private static SessionFactory factory;
    public static void main(String[] args) throws SQLException, ParseException {

        ArrayList<OvChipkaart> kaartsFormReizigerOne = new ArrayList<OvChipkaart>();

        Reiziger reiziger1 = new Reiziger(1, "Michele", "de", "onbekend", java.sql.Date.valueOf("1994-02-06"), null);
        OvChipkaart kaart1 = new OvChipkaart(1234, java.sql.Date.valueOf("2020-01-01"), 1, 20, reiziger1);
        kaartsFormReizigerOne.add(kaart1);
        reiziger1.setKaarts(kaartsFormReizigerOne);

        ReizigerDAO reizigerdao = new ReizigerDAO();
        reizigerdao.createReiziger(reiziger1);

        OvChipkaartDAO kaartdao = new OvChipkaartDAO();
        kaartdao.createKaart(kaart1);

        System.out.println("De nieuwe reiziger:");
        reizigerdao.findAll();

        System.out.println("\n de nieuwe kaart:");
        kaartdao.findAll();

        System.out.println("\n Geen kaarten meer:");
        kaartdao.deleteKaart(kaart1);
        kaartdao.findAll();

    }
}