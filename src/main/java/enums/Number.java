package enums;

public enum Number {

    //пречисляем название объектов.Все эти объекты они же экземпляры. Публичны статичны и финальны. Каждый экземпляр public static final.Каждый экземпляр есть Number.
    ONE, TWO, THREE

}

class EnumsTester{
    public static void main(String[] args) {
        Number num = Number.ONE;
        if(num instanceof Enum){
            System.out.println("this is enum");
        }
        System.out.println(Number.values().length);
        for (Number n : Number.values()){
            System.out.println("Enum value : " + n.name() + " | position " + n.ordinal());
        }





    }
}



class Constants{
    public static final double PI = 3.14;
}