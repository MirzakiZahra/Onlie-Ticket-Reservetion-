package main.java;

import main.java.dto.Manegement;
import main.java.entity.Manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manegement manegement = new Manegement();
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.managar\n2.user\n3.exit");
        int input = scanner.nextInt();
        do {


            switch (input) {
                case 1:
                    System.out.println("please enter userName & password");
                    int username = scanner.nextInt();
                    int password = scanner.nextInt();
                    if (username == manager.getUsername() && password == manager.getPassWord()) {
                        System.out.println("1.add city\n2.add ticket\n3.add vehicle\n" +
                                "4.soldTicket\n5.freeCapacityOfVehicle\n6.exit");
                        int managerInput = scanner.nextInt();
                        do {

                            switch (managerInput) {
                                case 1:
                                    System.out.println("please enter name, length,width");
                                    manegement.createCity(scanner.next(),scanner.nextInt()
                                    ,scanner.nextInt());
                                    break;
                                case 2:
                                    System.out.println("please enter date");
                                    String date= scanner.next();
                                    Date date2=new Date();
                                    SimpleDateFormat formatter=
                                            new SimpleDateFormat("dd/MMM/yyyy HH:mm");
                                    try {
                                        date2=formatter.parse(date);
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println("please enter count,barcode" +
                                            ",originCity,destinationCity,plaque");
                                    manegement.createTicket(scanner.nextInt(),scanner.nextInt(),date2
                                    ,scanner.next(),scanner.next(),scanner.nextInt());
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    break;
                            }

                        } while (managerInput != 6);
                    }
                    break;
                case 2:

                    break;
                case 3:
                    break;

            }
        } while (input != 3);
    }
}
