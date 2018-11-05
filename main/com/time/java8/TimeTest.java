package com.time.java8;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by simpletour_Jenkin on 2016/11/2.
 */
public class TimeTest {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
//        localDateTime.minusDays(1);

        System.out.println(Date.from(localDateTime.toInstant(ZoneOffset.of("+08:00"))).getTime());

        System.out.println(System.currentTimeMillis());

        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }


    }

    private String getSSS() throws NumberFormatException{

        throw new NumberFormatException();

//        return null;
    }
}

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
