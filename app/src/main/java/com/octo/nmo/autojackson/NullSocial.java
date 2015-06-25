package com.octo.nmo.autojackson;

public class NullSocial implements Social{
    @Override
    public String toString() {
        return "NullSocial";
    }

    @Override
    public String type() {
        return null;
    }
}
