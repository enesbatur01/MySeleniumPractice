public class Class {
    public static void main(String[] args) {
        //**** **** **** 4567
        String carNum = "1234 5678 9123 4567";

        String newCardNum = carNum.substring(0,carNum.length()-4)
                .replaceAll("[0-9]","*")
                .concat(carNum.substring(carNum.length()-4));

        System.out.println(newCardNum);



    }
}
