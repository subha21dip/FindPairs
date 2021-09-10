package com.sinch;

import java.io.IOException;
import java.util.*;

public class FindPairs {

    public static void main(String []args) throws IOException {
        List<Integer> inputArray = new ArrayList<>();
        int value = 0;
        int resultCount = 0;
        String input = null;
        System.out.println("Insert sum and array values by one value each line. Insert exit to return.");
        Scanner sc = new Scanner(System.in);
        try {
            value = sc.nextInt();
            while (true) {
                input = sc.nextLine();
                if(input == null || input.isEmpty())
                    continue;
                else if(input.equalsIgnoreCase("exit"))
                    break;
                else
                    inputArray.add(Integer.parseInt(input));
            }
        }catch (Exception e){
            System.out.println("Error parsing input : " + input);
            System.exit(1);
        }finally{
            sc.close();
        }
        System.out.println(calculatePairs(inputArray, value));
    }

    public static int calculatePairs(List<Integer> inputArray, int value) {
        int resultCount = 0;
        Map<Integer, List<Integer>> inputMap= new HashMap<>();
        // creating a map with each unique value in the input array as key and array indexes as values
        for (int index = 0; index < inputArray.size(); index++) {
            List<Integer> IndexList = inputMap.get(inputArray.get(index));
            if(IndexList == null || IndexList.isEmpty()) {
                IndexList = new ArrayList<>();
            }
            IndexList.add(index);
            inputMap.put(inputArray.get(index), IndexList);
        }
        for (int index = 0; index < inputArray.size(); index++) {
            int requiredVal = value - inputArray.get(index);
            List<Integer> matchedIndexList = inputMap.get(requiredVal);
            if(matchedIndexList == null || matchedIndexList.isEmpty()) {
                continue;
            }
            else {
                int finalI = index;
                if(matchedIndexList.stream().anyMatch(indexValue -> indexValue > finalI)){
                    //System.out.println("(" + inputArray.get(index) + "," + requiredVal + ")");
                    resultCount++;
                }
                inputMap.remove(requiredVal);
            }
        }
        return resultCount;
    }
}
