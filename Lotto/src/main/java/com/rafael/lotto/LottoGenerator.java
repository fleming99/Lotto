/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Esta clsse recebe os 6(seis) números digitados pelo usuário em forma de lista,
 * gera uma outra lista de 6(seis) números (que seriam os números sorteados), 
 * realiza a ordenação e a comparação entre elas, e caso o usuário acerte todos
 * os números, ele recebe o prêmio, caso contrário o premio acumula (dobra);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
 * @author Rafael Fleming
 */
public class LottoGenerator {
    
    private static double PRIZE = 1000.00;

    public static double getPRIZE() {
        return PRIZE;
    }
    
    /**
     * Este método é responsável por receber uma lista com os 6 (seis) números do 
     * usuário, gerar uma outra lista com 6 (seis) números aleatórios, realizar a 
     * ordenação das listas e compara-las para ver quantos números digitados pelo
     * usuário são iguais aos números gerados.
     * 
     * @param numbers recebe a lista de 6 (seis) números digitados pelo usuário.
     * @return retorna o número de acertos para o usuário.
     */
    public static String generator(List<Integer> numbers){
        
        Random random = new Random();
        List<Integer> prizeNumbers = new ArrayList<>();
        
        // Contador de acertos (números digitados pelo usuário que são iguais aos números gerados).
        int counter = 0;
        
        System.out.println("\n| ======================================== |\n");
        System.out.println("Drawn numbers:");
        
        for(int i = 0; i < 6; i++){
            int temp = random.nextInt(100) + 1;
            System.out.print(temp + " ");
            prizeNumbers.add(temp);
        }
        
        System.out.println("\n\n| ======================================== |\n");
        
        Collections.sort(prizeNumbers, new NumberComparator());
        Collections.sort(numbers, new NumberComparator());
        
        for(int i = 0; i < prizeNumbers.size(); i++){
            if(prizeNumbers.contains(numbers.get(i))){
                counter++;
                System.out.println("You hit the number: " + numbers.get(i));
            }
        }
        
        if(counter == 6){
            System.out.println("You win the prize! R$" + PRIZE);
            PRIZE = 1000.00;
        }else{
            System.out.println("There were no winners! The prize has rolled to the next draw.");
            PRIZE += PRIZE;
        }
        
        return "You hit: " + counter + "\n";
    }   
}