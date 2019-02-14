package com.redi;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Map<String,String> dictionary = new HashMap<>();
    static Map<String,ArrayList<Integer>> pizzas = new HashMap<>();
    static ArrayList<Integer> toyota = new ArrayList<>(Arrays.asList(10000,15000,18000));
    static ArrayList<Integer> bmw = new ArrayList<>(Arrays.asList(20000,23000,50000));
    static ArrayList<Integer> audi = new ArrayList<>(Arrays.asList(35000,43000,18000,50000));
    static Map<String,HashSet<String>> peppa = new HashMap<>();

    public static void main(String[] args) {

        // Exercises 1+2
        Map<String,String> id = new HashMap<>();
        id.put("a1234","Tonino");
        id.put("a5431","Giuseppe");
        id.put("a1662","Sergio");
        System.out.println("EXERCISES 1+2");
        getByKey(id,"a1234");
        getByKey(id,"A1234");

        // Map for exercise 3
        Map<String,String> students = new HashMap<>();
        students.put("Ahmad","Syria");
        students.put("Marwan","Syria");
        students.put("Murat","Syria");
        students.put("Elena","Russia");
        students.put("Mohammed","Egypt");
        students.put("Alessio","Italy");
        students.put("Genoveffo","Italy");
        students.put("John","China");
        students.put("Samira","India");
        students.put("Sundeep","India");

        // Exercise 4
        dictionary.put("bottle","Flasche");
        dictionary.put("glass","Glas");
        dictionary.put("pillow","Kissen");
        dictionary.put("hand","Hand");
        dictionary.put("key","Schlüssel");
        dictionary.put("light","Licht");
        dictionary.put("bed","Bett");
        dictionary.put("picture","Bild");
        dictionary.put("table","Tisch");
        dictionary.put("apartment","Wohnung");
        dictionary.put("door","Tür");
        System.out.println("EXERCISE 3");
        translate();

        //Esercise 4
        pizzas.put("Margherita",new ArrayList<>(Arrays.asList(4,5,6)));
        pizzas.put("Diavola",new ArrayList<>(Arrays.asList(7,9,11)));
        pizzas.put("Quattro Formaggi",new ArrayList<>(Arrays.asList(6,8,10)));
        pizzas.put("Capricciosa",new ArrayList<>(Arrays.asList(8,10,12)));
        pizzas.put("Ortolana",new ArrayList<>(Arrays.asList(6,7,8)));
        System.out.println("EXERCISE 4");
        pizzaWallet();

        //Exercise 5
        System.out.println("EXERCISE 5");
        System.out.println(average());

        //Exercise 6
        System.out.println("EXERCISE 6");
        System.out.println("Elena is from " + students.get("Elena") + ".");
        for (Map.Entry<String, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        Collection<String> values = students.values();
        TreeSet<String> uniqueCountries = new TreeSet<>();
        for(String i : values){
            uniqueCountries.add(i);
        }
        for(String k : uniqueCountries){
            System.out.print(k + " ");
        }
        System.out.println();

        //Map for exercise 7
        //Added a third element in order to test flexibility
        peppa.put("Peppa Pig",new HashSet(Arrays.asList("Suzy Sheep","Emily Elephant","Rebecca Rabbit","Danny Dog","Pedro Pony")));
        peppa.put("Zoe Zebra",new HashSet(Arrays.asList("Freddy Fox","Rebecca Rabbit","Gabriella Goat","Kylie Kangaroo","Danny Dog")));
        peppa.put("Test Character",new HashSet(Arrays.asList("Freddy Fox","Rebecca Rabbit")));
        System.out.println("EXERCISE 7");
        HashSet<String> common = commonFriends(peppa);
        for(String i : common){
            System.out.print(i + " ");
        }

    }

    //Method for exercise 2
    public static void getByKey(Map<String,String> map, String key){
        System.out.println("The key " + key + " is assigned to " + map.get(key.toLowerCase()) + ".");
    }

    public static void printIndexes() {
        Set<String> keys = dictionary.keySet();
        for (String key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();
    }

    //Method for exercise 4
    public static void translate(){
        System.out.println("Which word would you like to translate?");
        String english = scanner.next().toLowerCase();
        while(!dictionary.containsKey(english)){
            System.out.println("Word not found! Here is the list of available words: ");
            printIndexes();
            english = scanner.next().toLowerCase();
        }
        System.out.println("The German word for " + english + " is " + dictionary.get(english) + ".");
    }

    //Method for exercise 5
    // I modified the exercise by setting three different prices for each pizza,
    // depending on the size, then added the affordable pizzas to an ArrayList
    // called withinBudget and printed them from here with a series of conditions
    // to fix syntax/grammar (I'm a bit obsessed with these things, sorry :P).
    public static void pizzaWallet(){
        System.out.println("How much money do you have in your wallet?");
        int money = scanner.nextInt();
        ArrayList<String> withinBudget = new ArrayList<>();
        String size;
        for (Map.Entry<String,ArrayList<Integer>> entry : pizzas.entrySet()) {
            for(int i=0; i<3; i++){
                if(i==0){
                    size="small";
                }else if(i==1){
                    size="medium";
                }else{
                    size="large";
                }
                if(money>=entry.getValue().get(i)){
                    withinBudget.add("a " + size + " " + entry.getKey());
                }
            }
        }
        if(withinBudget.size()==0) {
            System.out.println("You can't afford any of the pizzas in the menu!");
        }else if(withinBudget.size()==15){
            System.out.println("You can afford to buy any of the pizzas in the menu!");
        }else if(withinBudget.size()==1){
            System.out.println("You can only afford to buy " + withinBudget.get(0) + ".");
        }else if(withinBudget.size()==2){
            System.out.println("You can afford to buy " + withinBudget.get(0) + " or " + withinBudget.get(1) + ".");
        }else {
            System.out.print("You can afford to buy ");
            for (int j = 0; j < withinBudget.size(); j++) {
                if (j== withinBudget.size() - 2) {
                    System.out.print(withinBudget.get(j) + " or ");
                }else if (j== withinBudget.size() - 1){
                    System.out.println(withinBudget.get(j) + ".");
                }else{
                    System.out.print(withinBudget.get(j) + ", ");
                }
            }
        }
    }

    //Method for exercise 6, but to be honest I didn't quite understand what was asked for,
    // so I'm not sure I did the right thing.
    public static Map<String,Integer> average(){
        Map<String,Integer> averagePrices = new HashMap<>();
        int average = 0;
        for(int i : toyota){
            average+=i;
        }
        averagePrices.put("Toyota",average/toyota.size());
        average=0;
        for(int i : bmw){
            average+=i;
        }
        averagePrices.put("BMW",average/bmw.size());
        average=0;
        for(int i : audi){
            average+=i;
        }
        averagePrices.put("Audi",average/audi.size());
        return averagePrices;
    }

    //Method for exercise 7
    public static HashSet<String> commonFriends(Map<String,HashSet<String>> map){
        HashSet<String> common = new HashSet<>(peppa.get("Peppa Pig"));
        Collection<HashSet<String>> values = map.values();
        for(HashSet<String> friends : values){
            common.retainAll(friends);
        }
        return common;
    }

}