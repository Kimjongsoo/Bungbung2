package com.example.soo.bungbung2;

public class Contents {
    String id;
    String x;
    String y;
//데이터 베이스에 들어갈 형식을 입력한다.




    public Contents(String id, String x, String y) {
        this.id = id;
        this.x = x;
        this.y = y;
//        this.number = number;
//        this.boolen = boolen;

    }

    public String toString() {
        return String.format(" x : %s \n y : %s", x, y);
    }


}
