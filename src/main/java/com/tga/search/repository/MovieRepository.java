package com.tga.search.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.tga.search.model.City;
import com.tga.search.model.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, String> {

    List<Movie> findByName(String name);
    List<Movie> findByRatingBetween(Double start, Double end);
}
