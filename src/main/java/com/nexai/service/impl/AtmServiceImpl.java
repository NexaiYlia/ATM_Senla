package com.nexai.service.impl;

import com.nexai.service.AtmService;

import java.util.Scanner;

public class AtmServiceImpl implements AtmService {

    Scanner input = new Scanner(System.in);

    public void run() throws InterruptedException {
        for (int i = 0; i < 2; i++) {

            System.out.println("Hello! Please insert your bank card");
            String inputCard = input.nextLine();
            System.out.println("Enter password:");
            int inputPwd = input.nextInt();

            Boolean result = false;
            if (result) {
                result = true;
            }

            if (result == false) {
                System.out.println("Wrong card number or pincode entered! Try again!");
                continue;
            } else if (i == 2) {
                System.out.println("Data entered incorrectly! The card is blocked!");
                return;
            }

        }
        menu();
    }

    public void menu() throws InterruptedException {
        System.out.println("Авторизация прошла успешно. Выберите операцию:\n1.Проверить баланс;\n2.Пополнить баланс.\n3.Снять наличные");
        int userChoice = input.nextInt();
        switch (userChoice) {
            case 1:
                System.out.println("Баланс лицевого счета составляет:");
                break;
            case 2:
                System.out.println("Введите сумму для пополнения счета:");
                int money1 = input.nextInt();
                break;
            case 3:
                System.out.println("Введите сумму для выдачи наличными:");
                int money2 = input.nextInt();
                break;
            default:
                wait(10000);
                System.out.println("The session has ended. Take the card!");
        }
    }
}
