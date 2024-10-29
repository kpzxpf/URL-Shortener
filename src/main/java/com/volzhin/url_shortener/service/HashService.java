package com.volzhin.url_shortener.service;

import com.volzhin.url_shortener.model.Hash;
import com.volzhin.url_shortener.repository.BatchHashRepository;
import com.volzhin.url_shortener.repository.HashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HashService {
    private final BatchHashRepository batchHashRepository;
    private final HashRepository hashRepository;

    @Transactional
    public void saveBatch(List<Hash> hashes) {
        batchHashRepository.saveAll(hashes);
    }

    @Transactional
    public List<Long> getUniqueNumbers(int countGenerateNumber) {
        return hashRepository.getUniqueNumbers(countGenerateNumber);
    }
}
