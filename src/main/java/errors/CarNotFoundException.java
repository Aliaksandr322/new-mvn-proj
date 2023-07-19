package errors;

public class CarNotFoundException extends Exception{
    public CarNotFoundException(){
        super("Car is not found");
    }
    public CarNotFoundException(Exception e){
        super("Car is not found", e);
    }
    public CarNotFoundException(String msg){
        super(msg);
    }

    public CarNotFoundException(String person_is_null_, Exception e) {
        super(person_is_null_,e);
    }
}
