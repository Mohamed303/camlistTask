package com.example.camlist.Enums;

public enum ErrorMessages {
    TAG_NOT_FOUND("Tag not found"),
    CATEGORY_NOT_FOUND("Category not found"),PET_ID_NOT_EXIST("Pet id Not exist"),
   USER_NOT_FOUND( "user not found"),CATEGORY_IS_EXIST("Category is already exist"),
    TAG_IS_EXIST("tag is already exist"),USER_HAVE_NO_PET_WITH_THIS_ID("you have no pet with this id"),

    ORDER_IS_EXIST("this order has already as done before");
    private String value;

    ErrorMessages (String value){ this.value =value;}

    public String getValue() {
        return value;
    }
}
