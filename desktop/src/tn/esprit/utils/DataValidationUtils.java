package tn.esprit.utils;

import java.util.regex.Pattern;

abstract public class DataValidationUtils {

    public static boolean isReferenceValid(String reference) {return Pattern.matches("^[a-zA-Z]{3,}$", reference);}

    public static boolean isProductNameValid(String ProductName) {return Pattern.matches("^[a-zA-Z]{3,}$", ProductName);}

   
    public static boolean isDescriptionValid(String description) {return Pattern.matches("^[a-zA-Z]{3,}$", description);}


    public static boolean price(String price) {
        return Pattern.matches("^[0-9]{1,}$", price);
    }

    public static boolean isStockValid(String stock) {return Pattern.matches("^[0-9]{1,}$", stock);}
    
     public static boolean ValidCodePostal(String code_postal) {return Pattern.matches("[0-9]{4}", code_postal);}

    public static boolean ValidTel(String tel) {return Pattern.matches("[0-9]{8}", tel);}

    public static boolean ValidPays(String Pays) {
        return Pattern.matches("^[a-z]$", Pays);
    }

     public static boolean ValidRegion(String Region) {
        return Pattern.matches("^[a-zA-Z]$", Region);
    }

    
    public static boolean RefValid(String ref_cmde) {return Pattern.matches("^[A-Za-z0-9_-]*$", ref_cmde);}

    public static boolean ValidEtat(String etat_cmde) {
        return Pattern.matches("^[a-zA-Z]$", etat_cmde);
    }

}
