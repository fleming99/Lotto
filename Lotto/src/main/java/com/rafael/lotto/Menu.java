/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Está é a classe Menu, que dispõe de todas as funções de menu para o usuário,
 * incluindo a entrada do usuário e o tratamento desses dados.
 * @author Rafael Fleming
 */
public final class Menu {
    
    /**
     * Disponibiliza o menu para o usuário, recebe a entrada de 6 (seis) números,
     * armazena-o em uma lista, e trata esses dados no método generator.
     */
    public static void menu(){
        
        Scanner input = new Scanner(System.in);
        List<Integer> userNumbers = new ArrayList<>();
        
        // Contador de números para entrada do usuário (primeiro numero, segundo número, etc...).
        int numberCounter = 1;
        
        System.out.println("""
                           | ======================================== |
                           
                                        WELCOME TO LOTTO!
                           
                            RULES: 
                            PICK 6 NUMBERS FROM 1 TO 100, ONE AT A TIME 
                            (IT CAN'T BE DUPLICATED). HIT 6 NUMBERS TO
                            WIN THE PRIZE.
                           
                           PRIZE: R$%.2f
                           
                           | ======================================== |
                           """.formatted(LottoGenerator.getPRIZE()));
        
        // Realiza um loop infinito até que os 6 valores sejam digitados corretamente.
        while(true){
            
            System.out.print(" ".repeat(13) + numberCounter + " number: ");
            
            
            try{
                Integer temp = Integer.valueOf(input.nextLine());
                
                if(userNumbers.contains(temp)){
                    System.out.println("You have already chosen this number. Try again.");
                }else if(temp < 1 || temp > 100){
                    System.out.println("Only numbers from 1 to 100.");
                }else{
                    numberCounter++;
                    userNumbers.add(temp);
                }
            }catch(NumberFormatException e){
                System.out.println(" ".repeat(8) + "Only numbers are valid.");
            }
            
            if(userNumbers.size() >= 6){
                System.out.println(LottoGenerator.generator(userNumbers));
                break;
            }
        }
    }
}
