package com.group.libraryapp.ex.cleancode;

import java.util.Scanner;

public class CleanCode {

    private static final int DICE_MAX_NUMBER = 6;

    public static void main(String[] args) throws Exception {
        System.out.println("숫자를 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();

        int[] diceNumbers = new int[DICE_MAX_NUMBER];



        for (int i = 0; i < inputNumber; i++) {
            double pip = Math.random() * DICE_MAX_NUMBER;
            int diceIndex = (int) pip;

            if (diceIndex >= 0 && diceIndex < DICE_MAX_NUMBER) {
                diceNumbers[diceIndex]++;
            }

        }


        for (int i = 0; i < DICE_MAX_NUMBER; i++) {
            System.out.printf((i + 1) + "번은 %d번 나왔습니다.\n", diceNumbers[i]);
        }
    }
}
