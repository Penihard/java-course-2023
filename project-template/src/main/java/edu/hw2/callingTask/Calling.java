package edu.hw2.callingTask;

import java.util.LinkedList;
import java.util.List;

public class Calling {
    public record CallingInfo(String className, String methodName) {}

    public static void main(String[] s){
        List<CallingInfo> listCalls = call();
        for(var call: listCalls){
            System.out.println(call);
        }
    }
    public static List<CallingInfo> call(){

        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        List<CallingInfo> list = new LinkedList<>();
        for(var el: trace){
            list.add(new CallingInfo(el.getClassName(), el.getMethodName()));
        }

        return list;
    }
}
