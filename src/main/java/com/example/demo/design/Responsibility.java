package com.example.demo.design;

/**
 * Responsibility
 *
 * @author zhbin
 * @date 2020-06-03
 */
public class Responsibility {
    class red {
        private void handleRequest(String red){
            if (red.equals("red")) {
                System.out.println(red);
            }
        }
    }
    class blue {
        private void handleRequest(String blue){
            if (blue.equals("blue")) {
                System.out.println(blue);
            }else {
                new red().handleRequest(blue);
            }
        }
    }
    class green {
        private void handleRequest(String green){
            if (green.equals("green")) {
                System.out.println(green);
            }else {
                new blue().handleRequest(green);
            }
        }
    }

    protected Class handler;

    public void handleRequest(String request) throws IllegalAccessException, InstantiationException {
        green green = (green)handler.newInstance();
        green.handleRequest(request);
    }


}
