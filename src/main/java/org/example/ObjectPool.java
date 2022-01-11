package org.example;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ObjectPool {
    private static ConcurrentLinkedDeque<Connection> queue = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) {
        int size = 10;

        for (int i = 0; i < size - 1; i++) {
            queue.offer(new Connection());
        }

        Connection getConnection = getConnection(queue);
        if(getConnection != null){
            getConnection.getMethod();
        }
    }

    public static Connection getConnection(ConcurrentLinkedDeque queue) {
        Connection connection = null;
        if(queue.poll() != null) {
            connection = (Connection) queue.poll();
        }
        return connection;
    }
}

    class Connection {
        Connection() {
        }

        public void getMethod(){
            System.out.println("Connection");
        }
    }

