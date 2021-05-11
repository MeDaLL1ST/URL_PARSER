package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String uri=in.nextLine();
        String num_reg="^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$"; //регулярка для мобилок
        String ip_reg="(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";//регулярка для ip адресов
        String email_reg="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";//регулярка для почты
        String soc_reg="/^(https:\\/\\/)?(vk.com|ok.ru|facebook.com)/";//регулярка для некоторых соц сетей
        Pattern pattern = Pattern.compile(num_reg);
        Pattern pattern1=Pattern.compile(ip_reg);
        Pattern pattern2=Pattern.compile(email_reg);
        Pattern pattern3=Pattern.compile(soc_reg);
        if (uri.contains("https://")||uri.contains("http://")||uri.contains("Http://")||uri.contains("Https://")) {
            BufferedReader reader = null;
            try {
                URL site = new URL(uri);
                reader = new BufferedReader(new InputStreamReader(site.openStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    Matcher matcher1 = pattern1.matcher(line);
                    Matcher matcher2 = pattern2.matcher(line);
                    Matcher matcher3 = pattern3.matcher(line);
                    while (matcher.find()){
                        System.out.println(line.substring(matcher.start(),matcher.end()));
                    }
                    while (matcher1.find()){
                        System.out.println(line.substring(matcher1.start(),matcher1.end()));
                    }
                    while (matcher2.find()){
                        System.out.println(line.substring(matcher2.start(),matcher2.end()));
                    }
                    while (matcher3.find()){
                        System.out.println(line.substring(matcher3.start(),matcher3.end()));
                    }
                }
                reader.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            Matcher matcher = pattern.matcher(uri);
            Matcher matcher1 = pattern1.matcher(uri);
            Matcher matcher2 = pattern2.matcher(uri);
            Matcher matcher3 = pattern3.matcher(uri);
            while (matcher.find()){
                System.out.println(uri.substring(matcher.start(),matcher.end()));
            }
            while (matcher1.find()){
                System.out.println(uri.substring(matcher1.start(),matcher1.end()));
            }
            while (matcher2.find()){
                System.out.println(uri.substring(matcher2.start(),matcher2.end()));
            }
            while (matcher3.find()){
                System.out.println(uri.substring(matcher3.start(),matcher3.end()));
            }
        }

    }
}
