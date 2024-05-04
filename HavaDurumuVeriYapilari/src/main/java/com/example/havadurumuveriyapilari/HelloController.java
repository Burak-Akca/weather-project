package com.example.havadurumuveriyapilari;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class HelloController  {
    @FXML
    private ImageView image0,image1,image2,image3,image4,image5;
    @FXML
    private TextField textfield;
    @FXML
    private Button button;
    @FXML
    private Label weather0,weather1,weather2,weather3,weather4,weather5, citytext,templabel,windlabel,nemlabel,hissedilenlabel,bulutlabel,datelabel,date1label, date2label, date3label, date4label, date5label;



    @FXML

    protected void submit() throws IOException {
        Label[] dateLabels={date1label, date2label, date3label, date4label, date5label};

        ImageView[] imageViews={image1,image2,image3,image4,image5};
        Label[] weatherLabel={weather1,weather2,weather3,weather4,weather5};

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

            JSONObject jsonText=new JSONObject(jsonString);
            String tarih;
            String icon;
            String description;

            LinkedList<String> newLinkedList=new LinkedList<>();

            Queue queue=new Queue();
            for (int i=7;i<40;i+=8){
                tarih=jsonText.getJSONArray("list").getJSONObject(i).getString("dt_txt");
              icon =jsonText.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("icon");
              description=jsonText.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description");
                LinkedList<String> linkedList=new LinkedList<>();
              linkedList.add(tarih);
              linkedList.add(icon);
              linkedList.add(description);
              queue.enqueue(linkedList);
              System.out.println(queue.sayac);


            }
            for (int k=0;k<queue.sayac;k++){
                newLinkedList=queue.dequeue();
                dateLabels[k].setText(editDate(newLinkedList.get(0)));
                imageViews[k].setImage(new Image("https://openweathermap.org/img/wn/"+newLinkedList.get(1)+".png"));
                weatherLabel[k].setText(newLinkedList.get(2));
            }




            String ico=jsonText.getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("icon");
            image0.setImage(new Image("https://openweathermap.org/img/wn/"+ico+".png"));
            System.out.println(new Image("https://openweathermap.org/img/wn/"+ico+".png").getHeight()+"   "+new Image("https://openweathermap.org/img/wn/"+ico+".png").getWidth());
            String city=jsonText.getJSONObject("city").getString("name");
            String country=jsonText.getJSONObject("city").getString("country");
            citytext.setText(city+","+country);
            float temp=jsonText.getJSONArray("list").getJSONObject(0).getJSONObject("main").getFloat("temp");
            templabel.setText(Float.toString(temp)+"°C");

            String descrtiption0 = jsonText.getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("description");
            weather0.setText(descrtiption0);

            float ruzgar=jsonText.getJSONArray("list").getJSONObject(0).getJSONObject("wind").getFloat("speed");
            DecimalFormat df = new DecimalFormat("#.0");
            String formatliSayi = df.format(ruzgar);
            windlabel.setText(formatliSayi+" m/s");
            int nem=jsonText.getJSONArray("list").getJSONObject(0).getJSONObject("main").getInt("humidity");
            nemlabel.setText("%"+Integer.toString(nem));
            float H_sicaklik=jsonText.getJSONArray("list").getJSONObject(0).getJSONObject("main").getFloat("feels_like");
           hissedilenlabel.setText(Float.toString(H_sicaklik)+"°C");
           int cloud=jsonText.getJSONArray("list").getJSONObject(0).getJSONObject("clouds").getInt("all");
           bulutlabel.setText("%"+Integer.toString(cloud));



//
//            tarih=jsonText.getJSONArray("list").getJSONObject(0).getString("dt_txt");
//           String son=cc(tarih);
//           datelabel.setText(son);
//
//
//
//            String ico1=jsonText.getJSONArray("list").getJSONObject(7).getJSONArray("weather").getJSONObject(0).getString("icon");
//            image1.setImage(new Image("https://openweathermap.org/img/wn/"+ico1+".png"));
//            String description1=jsonText.getJSONArray("list").getJSONObject(7).getJSONArray("weather").getJSONObject(0).getString("description");
//
//            weather1.setText(description1);
//
//
//
//
//            String tarih1=jsonText.getJSONArray("list").getJSONObject(15).getString("dt_txt");
//            String son1=cc(tarih1);
//            date2label.setText(son1);
//            String ico2=jsonText.getJSONArray("list").getJSONObject(15).getJSONArray("weather").getJSONObject(0).getString("icon");
//            image2.setImage(new Image("https://openweathermap.org/img/wn/"+ico2+".png"));
//            String description2=jsonText.getJSONArray("list").getJSONObject(15).getJSONArray("weather").getJSONObject(0).getString("description");
//            weather2.setText(description2);
//
//
//
//
//            String tarih2=jsonText.getJSONArray("list").getJSONObject(23).getString("dt_txt");
//            String son2=cc(tarih2);
//            date3label.setText(son2);
//            String ico3=jsonText.getJSONArray("list").getJSONObject(23).getJSONArray("weather").getJSONObject(0).getString("icon");
//            image3.setImage(new Image("https://openweathermap.org/img/wn/"+ico3+".png"));
//            String description3=jsonText.getJSONArray("list").getJSONObject(23).getJSONArray("weather").getJSONObject(0).getString("description");
//            weather3.setText(description3);
//
//
//
//
//            String tarih3=jsonText.getJSONArray("list").getJSONObject(31).getString("dt_txt");
//            String son3=cc(tarih3);
//            date4label.setText(son3);
//            String ico4=jsonText.getJSONArray("list").getJSONObject(31).getJSONArray("weather").getJSONObject(0).getString("icon");
//            image4.setImage(new Image("https://openweathermap.org/img/wn/"+ico4+".png"));
//            String description4=jsonText.getJSONArray("list").getJSONObject(31).getJSONArray("weather").getJSONObject(0).getString("description");
//            weather4.setText(description4);
//
//
//            String tarih4=jsonText.getJSONArray("list").getJSONObject(39).getString("dt_txt");
//            String son4=cc(tarih4);
//            date5label.setText(son4);
//            String ico5=jsonText.getJSONArray("list").getJSONObject(39).getJSONArray("weather").getJSONObject(0).getString("icon");
//            image5.setImage(new Image("https://openweathermap.org/img/wn/"+ico5+".png"));
//            String description5=jsonText.getJSONArray("list").getJSONObject(39).getJSONArray("weather").getJSONObject(0).getString("description");
//            weather5.setText(description5);
//















        } else {
            // Bağlantı başarısız ise, hata kodunu yazdır
            System.out.println("HTTP request failed with error code: " + responseCode);
        }

        textfield.clear();
    }

    static String editDate(String tarih) throws IOException {
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