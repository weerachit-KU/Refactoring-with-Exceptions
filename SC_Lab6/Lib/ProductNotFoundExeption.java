package Lib;
// Checked Exeption when product not found.
public class ProductNotFoundExeption extends Exception{
    public ProductNotFoundExeption(String message){
        super(message);
    }
}
