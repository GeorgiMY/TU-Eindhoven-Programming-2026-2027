/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author georg
 */
public class DataValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year =  scanner.nextInt();
        
        System.out.print(day + " " + month  + " " + year);
    }
}
