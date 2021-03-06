import java.util.*;
import java.lang.*;

/*
扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A、2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）：
3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如：4 4 4 4-joker JOKER。
请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR。
基本规则：
（1）输入每手牌可能是个子、对子、顺子（连续5张）、三个、炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
（2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）；
（3）大小规则跟大家平时了解的常见规则相同，个子、对子、三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；

（4）输入的两手牌不会出现相等的情况。 
*/

class Poker {
    public static void main(String[] args)
    {
        String input = new String();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            input = sc.nextLine();
            compare(input);
        }
        sc.close();
    }

    public static void compare(String input){
        String[] pokers = input.split("-");
        String first = pokers[0];
        String second = pokers[1];

        if(first.toLowerCase().equals("joker joker") || second.toLowerCase().equals("joker joker")){
            System.out.println("joker JOKER");
            return;
        }

        List<String> l1 = Arrays.asList(first.split(" "));
        List<String> l2 = Arrays.asList(second.split(" "));
        ArrayList<Integer> li1 = new ArrayList<Integer>();
        ArrayList<Integer> li2 = new ArrayList<Integer>();


        for(String s : l1){
            if(s.equals("J")){
                li1.add(11);
            }else if(s.equals("Q")){
                li1.add(13);
            }else if(s.equals("K")){
                li1.add(13);
            }else if(s.equals("A")){
                li1.add(14);
            }else if(s.equals("2")){
                li1.add(15);
            }else if(s.equals("joker")){
                li1.add(20);
            }else if(s.equals("JOKER")){
                li1.add(21);
            }else{
                li1.add(Integer.parseInt(s));
            }
        }
        for(String s : l2){
            if(s.equals("J")){
                li2.add(11);
            }else if(s.equals("Q")){
                li2.add(13);
            }else if(s.equals("K")){
                li2.add(13);
            }else if(s.equals("A")){
                li2.add(14);
            }else if(s.equals("2")){
                li2.add(15);
            }else if(s.equals("joker")){
                li2.add(20);
            }else if(s.equals("JOKER")){
                li2.add(21);
            }else{
                li2.add(Integer.parseInt(s));
            }
        }


        //check boom
        if(l1.size()==4 || l2.size()==4){
            //if l2 is boom
            if(l1.size()!=4){
                System.out.println(second);
                return;
            }

            //if l1 is boom
            if(l2.size()!=4){
                System.out.println(first);
                return;
            }

            //if both is boom
            if(li2.get(0)>li1.get(0)){
                System.out.println(second);
            }else if(li2.get(0)<li1.get(0)){
                System.out.println(first);
            }else{
                System.out.println("ERROR");
            }
            return;
        }

        //check sequence
        if(li2.size() == 5 && li1.size() == 5){
            if(li1.get(0)>li2.get(0)){
                System.out.println(first);
            }else if(li1.get(0)<li2.get(0)){
                System.out.println(second);
            }else{
                System.out.println("ERROR");
            }
            return;
        }


        //check signle, double, triple
        if((li2.size() == 1 && li1.size() == 1) || (li2.size() == 2 && li1.size() == 2) || (li2.size() == 3 && li1.size() == 3)){
            if(li1.get(0)>li2.get(0)){
                System.out.println(first);
            }else if(li1.get(0)<li2.get(0)){
                System.out.println(second);
            }else{
                System.out.println("ERROR");
            }
            return;
        }

        System.out.println("ERROR");
    }
}