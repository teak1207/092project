package com.example.demo.service;

import com.example.demo.domain.StoreModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadJsonFile {
    public static void main(String[] args) throws IOException, ParseException {

//        Reader reader = new FileReader("D:\\DEV\\workspace_boot\\output.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\DEV\\workspace_boot\\output.json"), StandardCharsets.UTF_8));

        JSONParser parser = new JSONParser();

        JSONObject jsonObj = (JSONObject) parser.parse(reader);
//        System.out.println(jsonObj);
        JSONArray jsonArr = (JSONArray) jsonObj.get("매장정보");


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        for (int i = 0; i < jsonArr.size(); i++) {
            JSONObject jsonObj2 = (JSONObject) jsonArr.get(i);
//            bw.write((String) jsonObj2.get("name"));
//            bw.write(jsonObj2.toJSONString());

            //storeModel 저장
            StoreModel store = new StoreModel(
                    (String) jsonObj2.get("name"),
                    (String)jsonObj2.get("thumb"),
                    (String)jsonObj2.get("tel"),
                    (String) jsonObj2.get("addr"),
                    (String)jsonObj2.get("star"),
                    (String)jsonObj2.get("time")

            );
            bw.write(store.toString());

            bw.write("\n\n");
        }
        bw.flush();
        bw.close();
    }
}
/*

'name': store_name,
        'tel': store_tel,
        'star': store_rating,
        'addr': store_addr,
        'time': store_time,
        'thumb': store_thumb
        'kwd': kwd_title,

        'menu': menus,      -->menumodel
        'price': prices,    -->menumodel


        'kwd_count': kwd_count,    --> 존재 X


*/
