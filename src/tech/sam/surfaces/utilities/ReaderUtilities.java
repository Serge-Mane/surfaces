package tech.sam.surfaces.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderUtilities {

    public int readChoice() throws IOException {
        this.displayInstructions();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }

    private void displayInstructions(){
        System.out.println("Bienvenue dans ce programme pour calculer les surfaces");
        System.out.println("Pour calculer la surface du Cercle taper 1");
        System.out.println("Pour calculer la surface du Rectangle/carre taper 2");
        System.out.println("Pour calculer la surface du Triangle taper 3");
    }
}
