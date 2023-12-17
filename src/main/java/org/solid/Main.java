package org.solid;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n***************************************************");
            System.out.println("Welcome to S.O.L.I.D. Manager:");
            System.out.println("***************************************************");
            System.out.println("Please choose a principle you want to execute:");
            System.out.println("[1] Solid Responsibility principle.");
            System.out.println("[2] Open / Close principle.");
            System.out.println("[3] Liskov Substitution principle.");
            System.out.println("[4] Interface Segregation principle.");
            System.out.println("[5] Dependency Inversion principle.");
            System.out.println("CHOICE : ");
            String input = getInput.nextLine();
            if (input.equals("1") ||input.equals("2") ||input.equals("3") ||input.equals("4") ||input.equals("5")) {
                String inputCat;
                while (true) {
                    System.out.println("Do you wish to execute the:\n[1] Bad example.\n[2] Good example.\nChoice:");
                    inputCat = getInput.nextLine();
                    inputCat = inputCat.strip();
                    if (inputCat.equals("1") || inputCat.equals("2")) {
                        break;
                    }
                    else {
                        System.out.println(inputCat);
                        System.out.println("[**ERROR**] Invalid input entered. Please enter a value from this [1/2]. Please try again!\n");
                    }
                }
                switch (input+"-"+inputCat) {
                    case "1-1":
                        System.out.println("\n...Starting BAD SRP...\n");
                        org.solid.Bad.SRP.Main badSRP = null;
                        badSRP.main(null);
                        break;

                    case "1-2":
                        System.out.println("\n...Starting GOOD SRP...\n");
                        org.solid.Good.SRP.Main goodSRP = null;
                        goodSRP.main(null);
                        break;

                    case "2-1":
                        System.out.println("\n...Starting BAD OCP...\n");
                        org.solid.Bad.OCP.Main badOCP = null;
                        badOCP.main(null);
                        break;

                    case "2-2":
                        System.out.println("\n...Starting GOOD OCP...\n");
                        org.solid.Good.OCP.Main goodOCP = null;
                        goodOCP.main(null);
                        break;

                    case "3-1":
                        System.out.println("\n...Starting BAD LSP...\n");
                        org.solid.Bad.LSP.Main badLSP = null;
                        badLSP.main(null);
                        break;

                    case "3-2":
                        System.out.println("\n...Starting GOOD LSP Partially satisfying LSP...\n");
                        org.solid.Good.LSP.Main goodLSP1 = null;
                        goodLSP1.main(null);

                        System.out.println("...Please Enter to continue...");
                        getInput.nextLine();

                        System.out.println("\n...Starting GOOD LSP Completely satisfying LSP...\n");
                        org.solid.Good.LSP_v2.Main goodLSP2 = null;
                        goodLSP2.main(null);
                        break;

                    case "4-1":
                        System.out.println("\n...Starting BAD ISP...\n");
                        org.solid.Bad.ISP.Main badISP = null;
                        badISP.main(null);
                        break;

                    case "4-2":
                        System.out.println("\n...Starting GOOD ISP...\n");
                        org.solid.Good.ISP.Main goodISP = null;
                        goodISP.main(null);
                        break;

                    case "5-1":
                        System.out.println("\n...Starting BAD DIP...\n");
                        org.solid.Bad.DIP.Main badDIP = null;
                        badDIP.main(null);
                        break;

                    case "5-2":
                        System.out.println("\n...Starting GOOD DIP...\n");
                        org.solid.Good.DIP.Main goodDIP = null;
                        goodDIP.main(null);
                        break;
                }
            }
            else {
                System.out.println("[**ERROR**] Invalid input entered. Please enter a value from this [1/2/3/4/5]. Please try again!\n");
            }
        }
    }
}