package com.thread.并发_栈封闭;

import java.util.Collection;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class Animal {
    private int a=0;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Animal animal = (Animal)o;
        return a == animal.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}
class main{

    /**
     * public class Snippet {
     *     public int loadTheArk(Collection<Animal> candidates) {
     *         SortedSet<Animal> animals;
     *         int numPairs = 0;
     *         Animal candidate = null;
     *
     *         // animals被封闭在方法中，不要使它们逸出！
     *         animals = new TreeSet<Animal>(new SpeciesGenderComparator());
     *         animals.addAll(candidates);
     *         for (Animal a : animals) {
     *             if (candidate == null || !candidate.isPotentialMate(a))
     *                 candidate = a;
     *             else {
     *                 ark.load(new AnimalPair(candidate, a));
     *                 ++numPairs;
     *                 candidate = null;
     *             }
     *         }
     *         return numPairs;
     *     }
     * }
     * @param cas
     * @return
     */
    // 栈封闭
    public int loadTheArk(Collection<Animal> cas){
        SortedSet<Animal> animalSortedSet;
        int num=0;
        Animal ca =null;

        animalSortedSet = new TreeSet<>();
        animalSortedSet.addAll(cas);

        for (Animal animal : animalSortedSet) {
            if (ca == null ){
                ca = animal;
            } else{
                ca.setA(2);
                ++ num;
                ca = null;
            }
        }

        return num;

    }
}
