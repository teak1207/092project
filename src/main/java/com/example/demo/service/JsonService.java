package com.example.demo.service;


import com.example.demo.domain.MenuModel;
import com.example.demo.domain.StoreModel;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class JsonService {

    private final StoreRepository storeRepository;
    private final MenuRepository menuRepository;

    @Transactional  //  돌다가 문제 생기면 다시 롤백 !!!
    public void saveStores() throws IOException, ParseException {
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
                    (String) jsonObj2.get("thumb"),
                    (String) jsonObj2.get("tel"),
                    (String) jsonObj2.get("addr"),
                    (String) jsonObj2.get("star"),
                    (String) jsonObj2.get("time")
            );

            StoreModel store2 = storeRepository.save(store);
            // 메뉴를 뽑아온다
            //store2.getId();
            JSONArray menuNames = (JSONArray) jsonObj2.get("menu");
            JSONArray menuPrices = (JSONArray) jsonObj2.get("price");
            int size = Math.min(menuNames.size(), menuPrices.size());

            for (int j = 0; j < size; j++) {
                MenuModel menuModel = new MenuModel(store2.getId(), (String) menuNames.get(j), (String) menuPrices.get(j));
                menuRepository.save(menuModel);
            }


            bw.write(store.toString());
            bw.write("\n\n");
        }
        bw.flush();
        bw.close();

    }
}
