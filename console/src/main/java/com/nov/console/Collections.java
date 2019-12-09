package com.nov.console;

import com.nov.console.model.UserDTO;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Collections {

    public static void main(String[] args) {
        Lists();
        funTreeMap();
    }

    public static void parseToList() {

        String[] str = new String[]{"aa", "bb"};
        Arrays.asList(str);
    }


    public static void Lists() {


        List<String> strings = new ArrayList<>();
        strings.add("1");

        List<UserDTO> userDTOList = new ArrayList<>();
        for (int index = 1; index < 100; index++) {
            userDTOList.add(new UserDTO("name" + index, index));
        }

        List<UserDTO> subList = userDTOList.subList(1, 10);
        subList.get(0).setName("newName");
        UserDTO userDTO = subList.get(0);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("ll");

        List<String> vector = new Vector();
        vector.add("v");

        java.util.Collections.sort(linkedList);

    }


    public static void funLinkedHashMap() {
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(1, "A");
        linkedHashMap.put(2, "B");
        linkedHashMap.put(3, "C");

        Set<Integer> integerSet = linkedHashMap.keySet();
        for (Integer key : integerSet) {
            String val = linkedHashMap.get(key);
            System.out.println(val);
        }


    }


    public static void funTreeMap() {
        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(20, 20);
        treeMap.put(10, 10);
        treeMap.put(30, 30);


        treeMap.put(22, 22);
    }


}
