package com.tga.search.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class City implements Serializable {

    @NonNull
    private String name;

    private List<Movie> movies;
}
