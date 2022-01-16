package com.example.demo.service;

import com.example.demo.domain.KeywordMappingModel;
import com.example.demo.domain.StoreModel;
import com.example.demo.repository.KeywordMappingRepository;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository repository;
    private final KeywordMappingRepository keywordMappingRepository;
    private final MenuRepository menuRepository;


    public List<StoreModel> getStores() {
        return repository.findAll();
    }

    public StoreModel getStore(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public StoreModel getStore(String name) {
        return repository.findByName(name).orElseThrow();
    }

    public StoreModel getStore(Long id, String name) {
        return repository.findByIdAndName(id, name).orElseThrow();
    }

    public List<StoreModel> getStores(Long keywordId) {

        return keywordMappingRepository.findAllByKeywordId(keywordId)
                .stream()
                .sorted(Comparator.comparing(KeywordMappingModel::getKeywordCount).reversed())
                .map(KeywordMappingModel::getStoreId)
                .map(e -> repository.findById(e).orElseThrow())
                .collect(Collectors.toList());

    }

    public StoreModel getStoreInfo(Long storeId) {

        // 매장 정보를 가지고 와서 storeInfos에 넣어둠
        StoreModel storeInfos = repository.findStoreById(storeId);

        /*
         storeInfos이 갖고 있는 List<MenuModel> menus를
         menuRepository.findMenuById(storeId) 초기화
         menus가 메뉴정보를 갖게됨
         */
        storeInfos.setMenus(menuRepository.findMenuByStoreId(storeId));  // 매장의 메뉴 리스트 담음
        return storeInfos;
    }

    public List<StoreModel> getRecommendStores(Long keywordId) {


        // 맵핑테이블에서 키워드아이디 가지고 동일한 애들의 스토어아이디 여러개!@!!! 가져와
        // 스토어 모델 여러개를 뿌려준다
        // 가져와야될것 : 스토어 모델 여러개

        //select * from store where id = ~~~ ;
        //키워드가 15인 매장들을 가져와

        List<KeywordMappingModel> recommendKeyword = keywordMappingRepository.findByKeywordId(keywordId);

        List<Long> storeIds = new ArrayList<>();

        for (int i = 0; i < recommendKeyword.size(); i++) {

            storeIds.add(recommendKeyword.get(i).getStoreId());
        }

        // 키워드별 최소 5개이상인지
        int count = 4; // 난수 생성 갯수
        int a[] = new int[count];  //1,2,3,4,6
        Random r = new Random();
        // storeIds [10,90,43,87,50,104,167]   0~6 의 숫자에서 5개를 뽑는다
        for (int i = 0; i < count; i++) {
            a[i] = r.nextInt(storeIds.size()); // 0~storeIds.size
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    i--;
                }
            }
        }
        // a 배열에는 storeIds 의 인덱스 번호들이 들어있다.storeIds는 스토어아이디들이 들어있다
        List<Long> selectedIds = new ArrayList<>();

        //a 배열 들어있는값을  storeIds의 인덱스와 매칭한거임
        for (int i = 0; i < count; i++) {

            selectedIds.add(storeIds.get(a[i]));
        }

        List<StoreModel> recommendStoreInfos = repository.findAllById(selectedIds); // 선택매장(1441)의 정보 가져옴

        return recommendStoreInfos;  //키워드가 15인 애들을 던져줘야함
    }


}
