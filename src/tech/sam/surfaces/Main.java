package tech.sam.surfaces;

import tech.sam.surfaces.utilities.ReaderUtilities;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ReaderUtilities readerUtilities=new ReaderUtilities();
        List<Integer> coordinates=readerUtilities.readData();
        /*
        for (int i=0;i<coordinates.size();i++){
            System.out.println(String.format("coordonees %s vaut %s",i,coordinates.get(i)));
        }*/

        coordinates.forEach(item-> System.out.println(String.format("coordonees %s",item)));
    }
}