package com.company;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final  String path1 = "src/com/company/tomsawyer.txt";
        HashMap<String, Integer> hashMap = new HashMap<>();
        FileIO.readFile(path1,hashMap);


    }

}


class FileIO{

    public static String compound(String[] arr){
        if(arr.length == 0)
            return null;
        else{
            String word="";
            for(String s : arr)
                word+=s;
            return word;
        }


    }

    public static void readFile(String path, HashMap<String,Integer > hashMap){
        File f= new File(path);
        try{
            if(!f.exists())
                f.createNewFile();

            Scanner scanner = new Scanner(f);
            String[] words;
            while(scanner.hasNext()){
                words = scanner.next().toLowerCase().split("[^a-zA-Z’]");
                String word= compound(words);
                if(word != null){

                   if(hashMap.containsKey(word))
                       hashMap.put(word,hashMap.get(word)+1);

                   else
                       hashMap.put(word,1);

               }

            }



        }catch(IOException exception){
            exception.printStackTrace();
        }catch (IndexOutOfBoundsException exceptione){
            exceptione.printStackTrace();
        }catch (NullPointerException exception){
            exception.printStackTrace();
        }



    }
}