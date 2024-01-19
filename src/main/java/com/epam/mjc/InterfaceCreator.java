package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> {
            for (String string : strings) {
                if(!Character.isUpperCase(string.charAt(0)) || !Character.isLetter(string.charAt(0))){
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            int length=integers.size();
            for (int i = 0; i < length; i++) {
                if (integers.get(i)%2==0){
                    integers.add(integers.get(i));
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        List<String>strings=new ArrayList<>();
        Supplier<List<String>>supplier = () -> {
            return strings;
        };
        for (String value : values) {
            if (Character.isUpperCase(value.charAt(0))  && value.charAt(value.length()-1)=='.'){
                String str=value;
                int count=0;
                while (true){
                    int index=str.indexOf(" ");
                    if(index!=-1){
                        count++;
                    }else {
                        break;
                    }
                    str=str.substring(index+1);
                }
                if (count>3){
                    supplier.get().add(value);
                }
            }
        }
        return supplier;
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Map<String,Integer> map=new HashMap<>();
        return strings -> {
            for (String string : strings) {
                map.put(string,string.length());
            }
            return  map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        List<Integer> list=new ArrayList<>();
        return (integers, integers2) -> {
            for (Integer integer : integers) {
                list.add(integer);
            }
            for (Integer i : integers2) {
                list.add(i);
            }
            return list;
        };
    }
}
