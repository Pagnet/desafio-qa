package br.com.blue.enums;

public enum TypeSelector {

    ID("id"),
    CSSSELECTOR("cssSelector"),
    XPATH("xpath"),
    NAME("name"),
    CLASSNAME("className"),
    LINKTEXT("linkText"),
    PARTIALLINKTEXT("partialLinkText");

    private String selector;

    TypeSelector(String value){

        this.selector = value;
    }

    public String getTypeSelector(){
        return this.selector;
    }
}
