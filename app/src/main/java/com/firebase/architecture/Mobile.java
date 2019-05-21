package com.firebase.architecture;

import androidx.annotation.NonNull;

public class Mobile {
    private String name;

    public Mobile() {
    }

    public Mobile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
