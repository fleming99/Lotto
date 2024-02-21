/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.lotto;

import java.util.Comparator;

/**
 * Esta classe é utilizada para fornencer uma forma de compáração para ser passada
 * no método Collections.sort.
 * @author Rafael Fleming
 */
public class NumberComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
    
}
