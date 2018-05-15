//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
//        int a=10;
//        boolean b=false;
//        char c='a';
//        long d=20;
//        long e=(long)a+d;
//        System.out.println(e);
//        String s1="Tran Ngoc ";
//        String s2="Bao Chung ";
//        System.out.println(s1==s2);
//
//        System.out.println(s1+s2+d);
//        int a=4;
//        if (!(a==3) && a==5)
//        {
//            System.out.println("haha");
//        }
//        else if(!b || a==4)
//        {
//            System.out.println("kaka");
//        }
//        else
//            {
//            System.out.println("hihi");
//        }

//        System.out.println(String.format("%.4f",0.1));
//        System.out.println(0.1+0.1+0.1);
//        System.out.println(0.3);

//        int a=2;
//        switch (a){
//            case 1:
//                System.out.println("1");
//                break;
//            case 2:
//                System.out.println("2");
//                break;
//            default:
//                System.out.println("error");
//                break;
//        }
//        for (int i = 10;i>=0;i--){
//            System.out.println(i);
//            }
//        int i=10;
//        while (i>5){
//            System.out.println(i);
//            i--;
//        }
//        int i=0;
//        do{
//            System.out.println(i);
//            i++;
//        }while(i<10);

//        khai báo mảng tĩnh
//        int[] array = new int[10];
//        int[] list = {0,2,4,6,8,10};

//        for (int i=0;i< array.length ;i++){
//            array[i]=i;
//            int a=array[i];
////            System.out.println(a);
//        }
//        for (int element : list) {
//            System.out.println(element);
//        }

//        khai báo mảng động
//        List<String> list1 = new ArrayList<>();
//        list1.add("a");
//        list1.add("b");
//        list1.add("a");
//        list1.add(2,"b");
//        String string = list1.get(0);
//        System.out.println(string);
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1.get(i));
//        }
//        for (String string : list1) {
//            System.out.println(string);
//        }
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        double b = scanner.nextDouble();
//        String s = scanner.next();
        // gặp space thì k nhận nữa
//        System.out.println(s);
        String[][] list = new String[4][4];
//        String [][] list = {
//                {'*','*'},
//                {'*','*'}
//        };
        int i,j;
        int x = 2;
        int y = 2;
        int x1,y1,x2,y2;
        int xg,yg;
        while (true){
            Random rand = new Random();
            x1 = rand.nextInt(4);
            y1 = rand.nextInt(4);
            x2 = rand.nextInt(4);
            y2 = rand.nextInt(4);
            xg = rand.nextInt(4);
            yg = rand.nextInt(4);
            if (x1==x2 && y1==y2)
                continue;
            else if (x1==2 && y1==2)
                continue;
            else if (x2==2 && y2==2)
                continue;
            else if (xg==2 && yg==2)
                continue;
            else if (x2==xg && y2==yg)
                continue;
            else if (x1==xg && y1==yg)
                continue;
            else
                break;
        }
//        boolean loop=true;
        while (true) {
            for (i = 0; i < 4; i++) {
                for (j = 0; j < 4; j++) {
                    if (i == x && j == y)
                        System.out.print("p ");
                    else if (i == x1 && j == y1)
                        System.out.print("x ");
                    else if (i == x2 && j == y2)
                        System.out.print("x ");
                    else if (i == xg && j == yg)
                        System.out.print("g ");
                    else {
                        list[i][j] = "* ";
                        System.out.print(list[i][j]);
                    }
                }
                System.out.println();
            }

            if (x==x1 && y==y1)
            {
                System.out.println("lose");
                break;
            }
            if (x==x2 && y==y2)
            {
                System.out.println("lose");
                break;
            }
            if (x==xg && y==yg)
            {
                System.out.println("Win");
                break;
            }
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            switch (input) {
                case "s":
                    if(x+1>3) {
                        x=0;
//                        System.out.println("error");
                        break;
                    }
                    else{
                        x = x + 1;

                        break;
                    }
                case "w":
                    if(x-1<0) {
                        x=3;
//                        System.out.println("error");

                        break;
                    }
                    else{
                        x = x - 1;

                        break;
                    }
                case "a":
                    if(y-1<0){
                        y=3;
//                        System.out.println("error");

                        break;
                    }
                    else{
                        y = y - 1;

                        break;
                    }

                case "d":
                    if(y+1>3){
                        y=0;
//                        System.out.println("error");

                        break;
                    }
                    else{
                        y = y + 1;

                        break;
                    }
                default:
                    System.out.println("error");
                    break;
            }
            if (y1+1<4)
                y1=y1+1;
            else
                y1=0;
            if (x2+1<4)
                x2=x2+1;
            else
                x2=0;
            int xc=x;
            int yc=y;
            int x1c=x1;
            int y1c=y1;
            int x2c=x2;
            int y2c=y2;
            if ((x==x1c && y==y1c) && (xc==x1 && yc==y1))
            {
                System.out.println("lose");
                break;
            }
            if ((x==x2c && y==y2c) && (xc==x2 && yc==y2))
            {
                System.out.println("lose");
                break;
            }
        }
    }
}
