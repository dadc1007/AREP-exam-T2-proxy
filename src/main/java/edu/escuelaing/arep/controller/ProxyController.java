package edu.escuelaing.arep.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {
    String service1 = "http://ec2-107-21-11-229.compute-1.amazonaws.com:8080";
    String service2 = "http://ec2-54-161-217-1.compute-1.amazonaws.com:8080";

    @GetMapping("/factors")
    public String factors(@RequestParam int n) {
        String url1 = service1 + "/factors?n=" + n;
        String url2 = service2 + "/factors?n=" + n;

        try {
            System.out.println("LLamado desde server 1");
            return call(url1);
        } catch (Exception e) {
            try {
                System.out.println("LLamado desde server 2");
                return call(url2);
            } catch (Exception ex) {
                return "Error: ambos servicios caidos";
            }
        }
    }

    @GetMapping("/primes")
    public String primes(@RequestParam int n) {
        String url1 = service1 + "/primes?n=" + n;
        String url2 = service2 + "/primes?n=" + n;

        try {
            System.out.println("LLamado desde server 1");
            return call(url1);
        } catch (Exception e) {
            try {
                System.out.println("LLamado desde server 2");
                return call(url2);
            } catch (Exception ex) {
                return "Error: ambos servicios caidos";
            }
        }
    }

    private String call(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        return content.toString();
    }
}