package com.example.tcpdemo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
class tcpServer {
public static void main(String[] args) {
try {
System.out.println("Server is Running!");
ServerSocket s1 = new ServerSocket(8081);
Socket s = s1.accept();
System.out.println("Client connected!");
BufferedReader br = new BufferedReader(new
InputStreamReader(s.getInputStream()));
PrintWriter out = new PrintWriter(s.getOutputStream(), true);

String msg = "";
while (true) {
msg = br.readLine();
if (msg == null) break; // Handle client disconnect
System.out.println("From client: " + msg);
out.println("Message received: " + msg); // Responding to the client
if (msg.equals("quit")) break;
}
br.close();
out.close();
s.close();
s1.close();
System.out.println("TERMINATED!");
} catch (Exception e) {
System.out.println(e);
}
}
}