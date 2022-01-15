package com.example.demo.service;


import java.io.*;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ReadJsonFile {
    public static void main(String[] args) throws IOException, ParseException {


        Reader reader = new FileReader("D:\\DEV\\workspace_boot\\store_data_final.json");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\DEV\\workspace_boot\\store_data_final.json"), "UTF8"));

        JSONParser parser = new JSONParser();

        JSONObject jsonObj = (JSONObject) parser.parse(reader);

        JSONArray jsonArr = (JSONArray) jsonObj.get("매장정보");


        for (int i = 0; i < jsonArr.size(); i++) {

            JSONObject jsonObj2 = (JSONObject) jsonArr.get(i);

            System.out.println(jsonObj2);
        }
    }
}
