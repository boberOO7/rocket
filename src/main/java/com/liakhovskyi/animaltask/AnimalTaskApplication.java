package com.liakhovskyi.animaltask;

import org.reflections.Reflections;

import java.util.Scanner;
import java.util.Set;

public class AnimalTaskApplication {

    public static void main(String[] args) {
        System.out.println("enter animal name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println(getAnimalSound(name));
    }

    public static String getAnimalSound(String name) {
        Class<? extends Animal> animal = getAnimalClass(name);

        try {
            return animal != null ? animal.newInstance().getSound() : "no such animal";
        } catch (InstantiationException | IllegalAccessException e) {
            return "problems during creating new instance";
        }
    }

    private static Class<? extends Animal> getAnimalClass(String name) {
        Reflections reflections = new Reflections(Animal.class.getPackage().getName());
        Set<Class<? extends Animal>> childClasses = reflections.getSubTypesOf(Animal.class);

        return childClasses.stream()
                .filter(x -> x.getSimpleName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
