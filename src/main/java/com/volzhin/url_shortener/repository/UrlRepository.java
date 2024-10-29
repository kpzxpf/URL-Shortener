package com.volzhin.url_shortener.repository;

import com.volzhin.url_shortener.model.Hash;
import com.volzhin.url_shortener.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UrlRepository extends JpaRepository<Url, String> {

    @Query(value = "DELETE FROM Url WHERE created_at < NOW() - INTERVAL '1 year' RETURNING url.hash;",
            nativeQuery = true)
    List<Hash> deleteOlderOneYearUrls();

    boolean existsByUrl(String url);
}
