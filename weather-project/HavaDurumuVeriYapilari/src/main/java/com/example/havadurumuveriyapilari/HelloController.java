package com.example.havadurumuveriyapilari;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class HelloController {
    @FXML
    private ImageView image,image1,image2,image3,image4,image5;
    @FXML
    private TextField textfield;
    @FXML
    private Button button;
    @FXML
    private Label weather0,weather1,weather2,weather3,weather4,weather5, citytext,templabel,windlabel,nemlabel,hissedilenlabel,bulutlabel,datelabel,date1label,date2label,date3label,date4label;


    @FXML
    protected void submit() throws IOException {
        String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q="+textfield.getText()+"&mode=json&lang=tr&units=metric&&appid=d52106c90c1e7537d6d25d91562d330f";

        // URL nesnesi oluştur
        URL url = new URL(apiUrl);

        // HttpURLConnection oluştur
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Yanıt kodunu kontrol et
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Bağlantı başarılı ise, yanıtı oku
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String jsonString = response.toString();

            // Yanıtı JSON formatında konsola yazdır
            System.out.println(response.toString());

            JSONObject ss=new JSONObject(jsonString);
            String ico=ss.getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("icon");
            image.setImage(new Image("https://openweathermap.org/img/wn/"+ico+".png"));
            System.out.println(new Image("https://openweathermap.org/img/wn/"+ico+".png").getHeight()+"   "+new Image("https://openweathermap.org/img/wn/"+ico+".png").getWidth());
            String city=ss.getJSONObject("city").getString("name");
            String country=ss.getJSONObject("city").getString("country");
            citytext.setText(city+","+country);
            float temp=ss.getJSONArray("list").getJSONObject(0).getJSONObject("main").getFloat("temp");
            templabel.setText(Float.toString(temp)+"°C");

            String descrtiption0 = ss.getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("description");
            weather0.setText(descrtiption0);

            float ruzgar=ss.getJSONArray("list").getJSONObject(0).getJSONObject("wind").getFloat("speed");
            DecimalFormat df = new DecimalFormat("#.0");
            String formatliSayi = df.format(ruzgar);
            windlabel.setText(formatliSayi+" m/s");
            int nem=ss.getJSONArray("list").getJSONObject(0).getJSONObject("main").getInt("humidity");
            nemlabel.setText("%"+Integer.toString(nem));
            float H_sicaklik=ss.getJSONArray("list").getJSONObject(0).getJSONObject("main").getFloat("feels_like");
           hissedilenlabel.setText(Float.toString(H_sicaklik)+"°C");
           int cloud=ss.getJSONArray("list").getJSONObject(0).getJSONObject("clouds").getInt("all");
           bulutlabel.setText("%"+Integer.toString(cloud));
           String tarih=ss.getJSONArray("list").getJSONObject(0).getString("dt_txt");

            String son=cc(tarih);
            datelabel.setText(son);

            String tarih1=ss.getJSONArray("list").getJSONObject(15).getString("dt_txt");

            String son1=cc(tarih1);
            date1label.setText(son1);

            String tarih2=ss.getJSONArray("list").getJSONObject(23).getString("dt_txt");

            String son2=cc(tarih2);
            date2label.setText(son2);
            String tarih3=ss.getJSONArray("list").getJSONObject(31).getString("dt_txt");

            String son3=cc(tarih3);
            date3label.setText(son3);
            String tarih4=ss.getJSONArray("list").getJSONObject(39).getString("dt_txt");

            String son4=cc(tarih4);
            date4label.setText(son4);



            String ico1=ss.getJSONArray("list").getJSONObject(7).getJSONArray("weather").getJSONObject(0).getString("icon");
            image1.setImage(new Image("https://openweathermap.org/img/wn/"+ico1+".png"));
            String ico2=ss.getJSONArray("list").getJSONObject(15).getJSONArray("weather").getJSONObject(0).getString("icon");
            image2.setImage(new Image("https://openweathermap.org/img/wn/"+ico2+".png"));
            String ico3=ss.getJSONArray("list").getJSONObject(23).getJSONArray("weather").getJSONObject(0).getString("icon");
            image3.setImage(new Image("https://openweathermap.org/img/wn/"+ico3+".png"));
            String ico4=ss.getJSONArray("list").getJSONObject(31).getJSONArray("weather").getJSONObject(0).getString("icon");
            image4.setImage(new Image("https://openweathermap.org/img/wn/"+ico4+".png"));
            String ico5=ss.getJSONArray("list").getJSONObject(39).getJSONArray("weather").getJSONObject(0).getString("icon");
            image5.setImage(new Image("https://openweathermap.org/img/wn/"+ico5+".png"));

            String description1=ss.getJSONArray("list").getJSONObject(7).getJSONArray("weather").getJSONObject(0).getString("description");
            String description2=ss.getJSONArray("list").getJSONObject(15).getJSONArray("weather").getJSONObject(0).getString("description");
            String description3=ss.getJSONArray("list").getJSONObject(23).getJSONArray("weather").getJSONObject(0).getString("description");
            String description4=ss.getJSONArray("list").getJSONObject(31).getJSONArray("weather").getJSONObject(0).getString("description");
            String description5=ss.getJSONArray("list").getJSONObject(39).getJSONArray("weather").getJSONObject(0).getString("description");

weather1.setText(description1);
            weather2.setText(description2);
            weather3.setText(description3);
            weather4.setText(description4);
            weather5.setText(description5);








        } else {
            // Bağlantı başarısız ise, hata kodunu yazdır
            System.out.println("HTTP request failed with error code: " + responseCode);
        }

        textfield.clear();
    }

    static String cc(String tarih) throws IOException {
        String[] dizi=tarih.split("\\s+");
        String[] dizi2= dizi[0].split("-");
        String[] newDate=new String[3];
        for (int i = 0; i < dizi2.length; i++) {
            newDate[i] = dizi2[dizi2.length - 1 - i];
        }
        String newDate2=String.join("/",newDate);
        return newDate2;

    }



}