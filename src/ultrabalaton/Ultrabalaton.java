/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultrabalaton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author steyza
 */
public class Ultrabalaton {
    static ArrayList<UbClass> Ublist=new ArrayList<UbClass>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            System.setProperty("file.encoding", "UTF8");
            FileReader fajl=new FileReader("ub2017egyeni.txt");
            BufferedReader br=new BufferedReader(fajl);
            String sor=null;
            br.readLine();
            while ((sor = br.readLine())!=null)
            {
                //példányosítás
                UbClass ubl=new UbClass(sor);
                Ublist.add(ubl);
            }
            br.close();
            fajl.close();
        }
        catch(IOException | NumberFormatException e)
        {
            System.out.println("Hiba: " +e );
        }
        System.out.println("3.feladat: Egyéni indulók: " + Ublist.size());
        int nok=0;
        for (int i=0; i<Ublist.size(); i++)
        {
            if (Ublist.get(i).getKategoria().equals("Noi") && Ublist.get(i).getTavszazalek()==100)
            {
                nok++;
            }
        }
        System.out.println("4.feladat: Célba ért női sportolók: "+nok + " fő");
        System.out.println("5.feldaat: Kérek egy sportoló nevét: ");
        Scanner beolvasas = new Scanner(System.in);
        String nev=beolvasas.nextLine();
        System.out.println(nev);
        int index=0;
        boolean talalt=false;
        while (!talalt && index<Ublist.size())
        {
            //System.out.println(Ublist.get(index).getVersenyzo());
            if (Ublist.get(index).getVersenyzo().equals(nev))
            {
                talalt=true;
            }
            index++;
        }
        System.out.println("\tIndult-e egyéniben a sportoló? ");
        if (talalt)
        {
            System.out.println("Igen");
            System.out.println("Teljesítette-e a távot?");
            if (Ublist.get(index-1).getTavszazalek()==100)
            {
                System.out.println("Teljesítette");
            }
            else
            {
                System.out.println("Nem Teljesítette");
            }
        }
        else
        {
            System.out.println("Nem");
        }
        System.out.println("7.feladat: Átlagos idő:");
        double osszido=0;
        int db=0;
        for(int i=0; i<Ublist.size(); i++)
        {
            if (Ublist.get(i).getKategoria().equals("Ferfi") && Ublist.get(i).getTavszazalek()== 100)
            {
                osszido+=Ublist.get(i).idoOraban();
                db++;
            }
        }
        System.out.println((osszido/db)+ " óra");
        System.out.println("8.feladat: ");
        double min = Ublist.get(0).idoOraban();
        System.out.println(min);
        int db2 = 0;
        int ferfiid = 0;
        int noiid = 0;
        for(int i=1; i<Ublist.size(); i++)
        {
            if (Ublist.get(i).getKategoria().equals("Ferfi") && Ublist.get(i).getTavszazalek()==100)
            {   
                
                if (min > Ublist.get(i).idoOraban())
                {
 
                    min = Ublist.get(i).idoOraban();
                    ferfiid = i;      
                    System.out.println(min);
                    
                }                	
            }
            else if (Ublist.get(i).getKategoria().equals("Nöi") && Ublist.get(i).getTavszazalek()==100)
            {   
                if (min > Ublist.get(i).idoOraban())
                {
 
                    min = Ublist.get(i).idoOraban();
                    noiid = i;      
                    System.out.println(min);
                    
                }                	
            }
        }
        System.out.println("\tFérfiak: "  + Ublist.get(ferfiid).getVersenyzo() + " (" + Ublist.get(ferfiid).getRajtszam()+ ".) " + Ublist.get(ferfiid).getVersenyido());
        System.out.println("\Női : "  + Ublist.get(noiid).getVersenyzo() + " (" + Ublist.get(noiid).getRajtszam()+ ".) " + Ublist.get(noiid).getVersenyido());
    }
}
