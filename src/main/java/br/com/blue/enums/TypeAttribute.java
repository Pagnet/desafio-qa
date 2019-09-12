package br.com.blue.enums;

public enum TypeAttribute {

    INNERTEXT("innerText");


    private String selector;

    TypeAttribute(String value){

        this.selector = value;
    }

    public String getTypeAttribute(){
        return this.selector;
    }
}
