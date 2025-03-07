package tech.sam.surfaces.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReaderUtilities {
/*
* lire les donnees
* retourner les coordonnees
* @throw IOException
 * */
    public List<Integer> readData(int choice) throws IOException {

        List<Integer> coordinates=new ArrayList<>();
        if (choice==1){
            System.out.println("Pour le cercle saisi 4 coordonnes");
            coordinates=readCoordinates(4);
        } else if (choice==2) {
            System.out.println("Pour Rectangle/carre saisi 6 coordonnes");
            coordinates=readCoordinates(6);
            }
        else if (choice==3) {
            System.out.println("Pour Triangle 6 coordonnes");
            coordinates=readCoordinates(6);
            }
        else {
            System.out.println("Votre choix est inconnu");
        }
        return coordinates;
    }

    private List<Integer> readCoordinates(int size) throws IOException {
        List<Integer> coordinates=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int index=0;
        while (index < size){
            System.out.println("coordonnees"+(index +1));
            String valueAsString= reader.readLine();
            if (!valueAsString.isEmpty()){
                int value=Integer.parseInt(valueAsString);
                coordinates.add(value);
                index++;
            }
        }
        return coordinates;
    }
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
