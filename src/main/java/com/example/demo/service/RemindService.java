package com.example.demo.service;

import com.example.demo.domain.RemindModel;
import com.example.demo.repository.RemindRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RemindService {

    private final RemindRepository repository;

    public List<RemindModel> getInfomations() {
        return repository.findAll();
    }


}
