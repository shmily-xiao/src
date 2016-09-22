package tempDemo;

/**
 * Created by simpletour_Jenkin on 2016/9/21.
 */
public class test {
    public static void main(String[] args){
//        Throwable ex = new Throwable();

        Handsome handsome = new Handsome();

        Man man = handsome.getMan();

        StackTraceElement[] stackElements = man.getStackTrace();

//        StackTraceElement[] stackElements = ex.getStackTrace();
        System.out.println("-----------------------------------");
        if(stackElements != null)
        {
            for(int i = 0; i < stackElements.length; i++)
            {
                System.out.println(stackElements[i].getClassName());
                System.out.println(stackElements[i].getFileName());
                System.out.println(stackElements[i].getLineNumber());
                System.out.println(stackElements[i].getMethodName());
                System.out.println("-----------------------------------");
            }
        }
    }
}
