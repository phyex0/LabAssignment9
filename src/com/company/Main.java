package com.company;


import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HashMap<String, Integer> hashMap = new HashMap<>();

        final String path1 = "src/com/company/dyssy10.txt";
        final String path2 = "src/com/company/tomsawyer.txt";
        final String path3 = "src/com/company/totc.txt";
        FileIO.wordCounter(path1,hashMap);
        FileIO.wordCounter(path2,hashMap);
        FileIO.wordCounter(path3,hashMap);

        //System.out.println(hashMap.toString());

        System.out.println("The size of the hashMap is :"+hashMap.size());
        System.out.println("Common words:\n------------------------------------");
        FileIO.printCommons(hashMap);

        //System.out.println(mapToString(hashMap));

    }

    public static <K, V> String mapToString(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining("\n"));
    }

}


class FileIO{

    public static String compound(String[] arr){
        if(arr.length==0)
            return null;
        else if(arr.length==1)
            return arr[0];
        else if(arr.length ==2)
            return arr[0]+arr[1];
        else if(arr.length==3)
            return arr[1]+arr[2];
        else
            return null;
    }


    public static void wordCounter(String path, HashMap<String,Integer>hashMap){
        List<String> list = readFile(path);
        if(list != null)
            for(String word:list){
                if(word != null){
                    if(hashMap.containsKey(word))
                        hashMap.put(word,hashMap.get(word)+1);
                    else
                        hashMap.put(word,1);

                }
            }
    }


    public static List<String> readFile(String path){
        List<String> list = new ArrayList<>();
        try{

            File f= new File(path);
            if(!f.exists())
                f.createNewFile();

           Scanner scanner = new Scanner(f);
            String[] words;
            while(scanner.hasNext()){
                words = scanner.next().toLowerCase().split("[^a-zA-Z’]");
                String word= compound(words);
                if(word != null)
                    list.add(word);
            }

            return list;

        }catch(IOException exception){
            exception.printStackTrace();
        }catch (IndexOutOfBoundsException exception){
            exception.printStackTrace();
        }catch (NullPointerException exception){
            exception.printStackTrace();
        }


        return null;
    }


    public static void printCommons(HashMap<String,Integer> hashMap){
        final String path = "src/com/company/commonwords.txt";
        List<String> list = readFile(path);

        for(String word:list)
            if(hashMap.containsKey(word))
                System.out.println(word+" : "+hashMap.get(word));


    }


}
