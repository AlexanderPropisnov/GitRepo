package budget;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        List<purchOne> food = new ArrayList<>();
        List<purchOne> clothes = new ArrayList<>();
        List<purchOne> entert = new ArrayList<>();
        List<purchOne> other = new ArrayList<>();
        List<purchOne> allFoo = new ArrayList<>();
        List<purch2> allTwo = new ArrayList<>();

        String f1 = "";
        double valu = 0.0;
        int stopSign = 5;
        int stopSign2,stopSign3 = 0;
        double balcanc = 0.0;

        String CurLine = "";
        double totalS,totalsTwo;

        String TempS = "";

//C:\JavaFiles\
//C:\JavaFiles\
        File fileOnWin2 = new File("purchases.txt");
        Scanner scanner2 = null;

        while (stopSign != 0) {
            System.out.println("Choose your action:");
            System.out.println("1) Add income");
            System.out.println("2) Add purchase");
            System.out.println("3) Show list of purchases");
            System.out.println("4) Balance");
            System.out.println("5) Save");
            System.out.println("6) Load");
            System.out.println("7) Analyze (Sort)");
            System.out.println("0) Exit");

            stopSign = scanner.nextInt();

            if (stopSign == 1) {
                System.out.println();
                System.out.println("Enter income:");
                balcanc = balcanc + scanner.nextInt();
                System.out.println("Income was added!");
                System.out.println();

            } else if (stopSign == 2) {
                System.out.println();

                stopSign2 = 0;
                while (stopSign2 != 5) {
                    System.out.println("Choose the type of purchase");
                    System.out.println("1) Food");
                    System.out.println("2) Clothes");
                    System.out.println("3) Entertainment");
                    System.out.println("4) Other");
                    System.out.println("5) Back");

                    stopSign2 = scanner.nextInt();

                    if (stopSign2 != 5) {
                        System.out.println();

                        System.out.println("Enter purchase name:");
                        scanner.nextLine();
                        f1 = scanner.nextLine();
                        System.out.println("Enter its price:");
                        valu = Double.parseDouble(scanner.nextLine());
                        balcanc = balcanc - valu;

                        if (stopSign2 == 1) {
                            food.add(new purchOne(f1 + " $", valu));
                        } else if (stopSign2 == 2) {
                            clothes.add(new purchOne(f1 + " $", valu));
                        } else if (stopSign2 == 3) {
                            entert.add(new purchOne(f1 + " $", valu));
                        } else if (stopSign2 == 4) {
                            other.add(new purchOne(f1 + " $", valu));
                        }
                        System.out.println("Purchase was added!");
                        System.out.println();
                    }

                }
                allFoo.clear();
                allFoo.addAll(food);
                allFoo.addAll(clothes);
                allFoo.addAll(entert);
                allFoo.addAll(other);
            } else if (stopSign == 3) {


                System.out.println();

                if (!food.isEmpty() || !clothes.isEmpty() || !other.isEmpty() || !entert.isEmpty()) {
                    stopSign2 = 0;
                    while (stopSign2 != 6) {
                        System.out.println("Choose the type of purchases");
                        System.out.println("1) Food");
                        System.out.println("2) Clothes");
                        System.out.println("3) Entertainment");
                        System.out.println("4) Other");
                        System.out.println("5) All");
                        System.out.println("6) Back");

                        stopSign2 = scanner.nextInt();
                        System.out.println();

                        totalS = 0.0;

                        if (stopSign2 == 1) {
                            System.out.println("Food:");
                            if (food.isEmpty()) {
                                System.out.println("The purchase list is empty!");
                            } else {
                                for (purchOne item : food) {
                                    System.out.println(item.getMyString() + String.format("%.2f", item.getMyDouble()));
                                    totalS = totalS + item.getMyDouble();
                                }
                                System.out.println("Total sum: $" + String.format("%.2f", totalS ));
                            }
                            System.out.println();
                        } else if (stopSign2 == 2) {
                            System.out.println("Clothes:");
                            if (clothes.isEmpty()) {
                                System.out.println("The purchase list is empty!");
                            } else {
                                for (purchOne item : clothes) {
                                    System.out.println(item.getMyString() + String.format("%.2f", item.getMyDouble()));
                                    totalS = totalS + item.getMyDouble();
                                }
                                System.out.println("Total sum: $" + String.format("%.2f", totalS ));
                            }
                            System.out.println();
                        } else if (stopSign2 == 3) {
                            System.out.println("Entertainment:");
                            if (entert.isEmpty()) {
                                System.out.println("The purchase list is empty!");
                            } else {
                                for (purchOne item : entert) {
                                    System.out.println(item.getMyString() + String.format("%.2f", item.getMyDouble()));
                                    totalS = totalS + item.getMyDouble();
                                }
                                System.out.println("Total sum: $" + String.format("%.2f", totalS ));
                            }
                            System.out.println();
                        } else if (stopSign2 == 4) {
                            System.out.println("Other:");
                            if (other.isEmpty()) {
                                System.out.println("The purchase list is empty!");
                            } else {
                                for (purchOne item : other) {
                                    System.out.println(item.getMyString() + String.format("%.2f", item.getMyDouble()));
                                    totalS = totalS + item.getMyDouble();
                                }
                                System.out.println("Total sum: $" + String.format("%.2f", totalS ));
                            }
                            System.out.println();
                        } else if (stopSign2 == 5) {
                            System.out.println("All:");



                            for (purchOne item : allFoo) {
                                System.out.println(item.getMyString() + String.format("%.2f", item.getMyDouble()));
                                totalS = totalS + item.getMyDouble();
                            }


                            System.out.println("Total sum: $" + String.format("%.2f", totalS ));
                            System.out.println();
                        }
                    }
                    System.out.println();
                } else{
                    System.out.println("The purchase list is empty!!");
                    System.out.println();
                }
            } else if (stopSign == 4) {
                System.out.println();
                System.out.println("Balance: $" + String.format( "%.2f", balcanc));
                System.out.println();
            } else if (stopSign == 5) {
//C:\JavaFiles\
                File fileOnWin = new File("purchases.txt");
                totalS = 0.0;
                //File fileOnWin = new File("purchases.txt");
                FileWriter writer = new FileWriter(fileOnWin);

                System.out.println();
                System.out.println("Purchases were saved!");


                for (purchOne item : food) {
                    writer.write(item.getMyString() +"\r\n");
                    writer.write(item.getMyDouble() +"\r\n");
                }
                writer.write("Cat_1" +"\r\n");



                for (purchOne item : clothes) {
                    writer.write(item.getMyString() +"\r\n");
                    writer.write(item.getMyDouble() +"\r\n");
                }

                writer.write("Cat_2" +"\r\n");

                for (purchOne item : entert) {
                    writer.write(item.getMyString() +"\r\n");
                    writer.write(item.getMyDouble() +"\r\n");
                }
                writer.write("Cat_3" +"\r\n");


                for (purchOne item : other) {
                    writer.write(item.getMyString() +"\r\n");
                    writer.write(item.getMyDouble() +"\r\n");
                }
                writer.write("Cat_4" +"\r\n");

                writer.write(Double.toString(balcanc));

                writer.close();
                System.out.println();

            } else if (stopSign == 6) {
                try {
                    scanner2 = new Scanner(fileOnWin2);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

                System.out.println();
                System.out.println("Purchases were loaded!");
                CurLine = scanner2.nextLine();
                for(int i =1; i<5; i++){
                    while (!CurLine.equals("Cat_"+(i))){

                        if (i==1){
                            food.add(new purchOne(CurLine, Double.parseDouble(scanner2.nextLine())));
                        } else if (i==2) {
                            clothes.add(new purchOne(CurLine, Double.parseDouble(scanner2.nextLine())));
                        } else if (i==3) {
                            entert.add(new purchOne(CurLine, Double.parseDouble(scanner2.nextLine())));
                        } else if (i==4) {
                            other.add(new purchOne(CurLine, Double.parseDouble(scanner2.nextLine())));
                        }
                        CurLine = scanner2.nextLine();
                    }
                    CurLine = scanner2.nextLine();
                }

                balcanc = Double.parseDouble(CurLine);

                System.out.println();
                allFoo.clear();
                allFoo.addAll(food);
                allFoo.addAll(clothes);
                allFoo.addAll(entert);
                allFoo.addAll(other);
            } else if (stopSign == 7) {
                stopSign2 = 0;
                while (stopSign2 != 4) {
                    System.out.println();
                    System.out.println("How do you want to sort?");
                    System.out.println("1) Sort all purchases");
                    System.out.println("2) Sort by type");
                    System.out.println("3) Sort certain type");
                    System.out.println("4) Back");
                    //       food.sort((purchOne o1, purchOne o2) -> o2.getMyDouble().compareTo(o1.getMyDouble()));

                    stopSign2 = scanner.nextInt();
                    System.out.println();
                    if (stopSign2 == 1) {
                        if (allFoo.isEmpty()){
                            System.out.println("The purchase list is empty!");
                        } else{
                            totalS = 0.00;
                            allFoo.sort((purchOne o1, purchOne o2) -> o2.getMyDouble().compareTo(o1.getMyDouble()));
                            System.out.println("All:");

                            for (purchOne item : allFoo) {
                                System.out.println(item.getMyString() + String.format("%.2f", item.getMyDouble()));
                                totalS = totalS + item.getMyDouble();
                            }

                            System.out.println("Total sum: $" + String.format("%.2f", totalS));
                        }
                    } else if (stopSign2 == 2) {

                        totalS = 0.00;
                        for (purchOne item : food) {
                            totalS = totalS + item.getMyDouble();
                        }
                        allTwo.add(new purch2("Food - $", totalS));

                        totalS = 0.00;
                        for (purchOne item : clothes) {
                            totalS = totalS + item.getMyDouble();
                        }
                        allTwo.add(new purch2("Clothes - $", totalS));

                        totalS = 0.00;
                        for (purchOne item : entert) {
                            totalS = totalS + item.getMyDouble();
                        }
                        allTwo.add(new purch2("Entertainment - $", totalS));

                        totalS = 0.00;
                        for (purchOne item : other) {
                            totalS = totalS + item.getMyDouble();
                        }
                        allTwo.add(new purch2("Other - $", totalS));


                        allTwo.sort((purch2 o1, purch2 o2) -> o2.getMyDouble().compareTo(o1.getMyDouble()));

                        System.out.println("Types:");
                        totalS = 0.00;
                        for (purch2 item : allTwo) {
                            System.out.println(item.getMyString() + String.format("%.2f", item.getMyDouble()));
                            totalS = totalS + item.getMyDouble();
                        }

                        System.out.println("Total sum: $" + String.format("%.2f", totalS));
                    } else if (stopSign2 == 3) {

                        System.out.println("Choose the type of purchases");
                        System.out.println("1) Food");
                        System.out.println("2) Clothes");
                        System.out.println("3) Entertainment");
                        System.out.println("4) Other");
                        stopSign3 = scanner.nextInt();

                        System.out.println();

                        if (stopSign3 == 1) {
                            if (food.isEmpty()) {
                                System.out.println("The purchase list is empty!");
                            } else {
                                totalS = 0.00;

                                food.sort((purchOne o1, purchOne o2) -> o2.getMyDouble().compareTo(o1.getMyDouble()));
                                System.out.println("Food:");

                                for (purchOne item : food) {
                                    System.out.println(item.getMyString() + String.format("%.2f", item.getMyDouble()));
                                    totalS = totalS + item.getMyDouble();
                                }
                                System.out.println("Total sum: $" + String.format("%.2f", totalS));
                            }
                        }
                        if (stopSign3 == 3){
                            if (entert.isEmpty()) {
                                System.out.println("The purchase list is empty!");
                            } else {
                                totalS = 0.00;
                                entert.sort((purchOne o1, purchOne o2) -> o2.getMyDouble().compareTo(o1.getMyDouble()));
                                System.out.println("Entertainment:");

                                for (purchOne item : entert) {
                                    System.out.println(item.getMyString() + String.format("%.2f", item.getMyDouble()));
                                    totalS = totalS + item.getMyDouble();
                                }
                                System.out.println("Total sum: $" + String.format("%.2f", totalS));

                            }
                        }
                        if (stopSign3 == 2) {
                            if (clothes.isEmpty()) {
                                System.out.println("The purchase list is empty!");
                            } else {

                                totalS = 0.00;
                                clothes.sort((purchOne o1, purchOne o2) -> o2.getMyDouble().compareTo(o1.getMyDouble()));
                                System.out.println("Clothes:");

                                for (purchOne item : clothes) {
                                    System.out.println(item.getMyString() + String.format("%.2f", item.getMyDouble()));
                                    totalS = totalS + item.getMyDouble();
                                }
                                System.out.println("Total sum: $" + String.format("%.2f", totalS));

                            }
                        }
                        if (stopSign3 == 4) {
                            if (other.isEmpty()) {
                                System.out.println("The purchase list is empty!");
                            } else {
                                totalS = 0.00;

                                other.sort((purchOne o1, purchOne o2) -> o2.getMyDouble().compareTo(o1.getMyDouble()));
                                System.out.println("Other:");

                                for (purchOne item : other) {
                                    System.out.println(item.getMyString() + String.format("%.2f", item.getMyDouble()));
                                    totalS = totalS + item.getMyDouble();
                                }
                                System.out.println("Total sum: $" + String.format("%.2f", totalS));

                            }
                        }
                    }
                }
            }
            else if (stopSign == 0) {
                System.out.println();
                System.out.println("Bye!");
            } else{
                System.out.println();
           }
       }
    }
}

