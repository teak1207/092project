package com.example.demo.service;


import com.example.demo.domain.KeywordMappingModel;
import com.example.demo.domain.MenuModel;
import com.example.demo.domain.StoreModel;
import com.example.demo.repository.KeywordMappingRepository;
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
    private final KeywordMappingRepository keywordMappingRepository;

    @Transactional  //  돌다가 문제 생기면 다시 롤백 !!!
    public void saveStores() throws IOException, ParseException {

        // 정해둔 경로에 BufferedReader로 읽어드림.
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\DEV\\workspace_boot\\output.json"), StandardCharsets.UTF_8));

        JSONParser parser = new JSONParser();

        JSONObject jsonObj = (JSONObject) parser.parse(reader);
        //System.out.println(jsonObj);
        JSONArray jsonArr = (JSONArray) jsonObj.get("매장정보");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
       // jsonArr
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

            // menuNames를 배열로 저장.
            JSONArray menuNames = (JSONArray) jsonObj2.get("menu");
            // menuPrices를 배열로 따로 저장.
            JSONArray menuPrices = (JSONArray) jsonObj2.get("price");

            // 메뉴와 가격이 1:1 아님 ==> ?????  ==> 여기는 다시 작성
            int size = Math.min(menuNames.size(), menuPrices.size());

            for (int j = 0; j < size; j++) {
                MenuModel menuModel = new MenuModel(store2.getId(), (String) menuNames.get(j), (String) menuPrices.get(j));
                menuRepository.save(menuModel);
            }

            JSONArray keywords = (JSONArray) jsonObj2.get("kwd");
            JSONArray keywordCounts = (JSONArray) jsonObj2.get("kwd_count");

            for (int j = 0; j < keywords.size(); j++) {

                KeywordMappingModel keywordMappingModel = new KeywordMappingModel(store2.getId(), Long.valueOf((String) keywords.get(j)), (Long) keywordCounts.get(j));
                keywordMappingRepository.save(keywordMappingModel);
            }

            bw.write(store.toString());
            bw.write("\n\n");
        }
        bw.flush();
        bw.close();

    }
}
