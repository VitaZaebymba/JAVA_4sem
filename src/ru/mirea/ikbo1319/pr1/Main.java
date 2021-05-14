package ru.mirea.ikbo1319.pr1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Function<Integer[], String> getMinValue = array ->
                new HashSet<>(Arrays.asList(array))
                        .stream()
                        .filter(item -> item > 0 && item < 10)
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining()); //В метод collect() нужно передать
        // специальный объект — collector. Этот объект вычитывает все данные
        // из потока, преобразует их к определенной коллекции и возвращает ее.
        // А следом за ним эту же коллекцию возвращает и сам метод collect.
        //Collectors.joing()преобразовывает все элементы потока к типу String и склеивает их в одну строку.
        System.out.println(getMinValue.apply(new Integer[]{5, 2, 1, 3, 1}));
    }
}

