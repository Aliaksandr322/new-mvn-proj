package errors;

import model.Person;

public class ExceptionsTester {
    public static void main(String[] args) {
        System.out.println("Begin.");
        Person p1 = new Person();
        Throwable throwable;
        Error error;
        Exception exception;

        try {
            //Потенциально не безопасный код. Пытаемся словить Exception ,который ожидает нас в блоке catch
            p1.clone(); // will throw new NullPointerException object!
        }
        catch (NullPointerException e){//в блоке catch ожидается объект конкретного типа
            // обработка в случае наступления данной ошибки
            System.out.println("Ooops! It's NullPointerException ( : " + e.getMessage());
            e.printStackTrace();

        }finally {
            //Блок выполнится в любом случае, в случае ошибки и без ошибки
            System.out.println("final job");
        }


        int[] array = {2,12,33};
        int x = 2;
        try {
            int val = array[x];
            System.out.println(val);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Wrong index " + x );
            e.printStackTrace();
            System.out.println("Please use next indexes bound -> from 0 to " + (array.length-1) );
        }finally {
            //default implementation -> print first element
            System.out.println(array[0]);
        }

        String str = "Hello Java World!";
        String[] words = str.split(" ");
        for (String word : words){
            try {
                System.out.println(word.charAt(word.indexOf('o')));

            }catch (StringIndexOutOfBoundsException e){
                System.out.println(word + " не содержит символ о " + e.getMessage());
                e.printStackTrace();
            }

        }




        System.out.println("End.");
    }
}
