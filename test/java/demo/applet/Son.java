package demo.applet;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by simpletour_Jenkin on 2016/6/14.
 */
public class Son extends Father {

    private String name;


    public Son() {
    }

    public Son(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Father father = new Son("dd","ewe");

        Son son = (Son) father;

        Set<String> ss = new HashSet<>();
        ss.add("ww");
        ss.add("qq");

        System.out.println(ss.contains("ww")+"     "+ss.contains("wq"));

        Date startTime = new Date(1466740800000L);

        Date now = new Date();

        Date endTime = new Date(1468166400000L);

        System.out.println(startTime + "---"+now + "---"+endTime);


        Long aa = 45678794561651564L;
        Long bb = 45678794561651564L;

        System.out.println(aa!=bb);
        System.out.println(aa.equals(bb));

    }
}
