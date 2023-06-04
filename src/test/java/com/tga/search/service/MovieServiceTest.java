package com.tga.search.service;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tga.search.model.City;
import com.tga.search.model.Genre;
import com.tga.search.model.Movie;
import com.tga.search.repository.MovieRepository;

import junit.framework.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest {
	
	@MockBean 
	private MovieRepository movieRepository;
	 
    @Autowired
	private MovieService movieService;
 
   
 
    @SuppressWarnings("deprecation")
	@Test
	public void test_save_movie() {
		Movie movie = generateMovieDummyObj();
		when(movieRepository.save(movie)).thenReturn(movie);

		Movie testMovie = movieService.saveMovie(movie); // then
		Assert.assertEquals(movie.getId(),testMovie.getId());
		Assert.assertEquals(movie.getCity(),movie.getCity());
		Assert.assertEquals(movie.getName(),movie.getName());
		Assert.assertEquals(movie.getRating(),movie.getRating());
	}
    
    
    @SuppressWarnings("deprecation")
	@Test
	public void test_movie_find_all() {
		Movie movie = generateMovieDummyObj();
		List<Movie> movies = new ArrayList<>();
		movies.add(movie);
		when(movieRepository.findAll()).thenReturn(movies);

		movies = movieService.allMovies(); // then
		Assert.assertEquals(1,movies.size());
		
	}
    
  
    
    @SuppressWarnings("deprecation")
	@Test
	public void test_movie_find_by_name() {
		Movie movie = generateMovieDummyObj();
		List<Movie> movies = new ArrayList<>();
		movies.add(movie);
		when(movieRepository.findByName(movie.getName())).thenReturn(movies);

		movies = movieService.getByName(movie.getName()); // then
		Assert.assertEquals(1,movies.size());
		
	}
    
    private Movie generateMovieDummyObj() {
		List genreList = new ArrayList<Genre>();
		Genre genre = new Genre();
		genre.setName("hindi");
		genreList.add(genre);
		City city = new City();
		city.setName("City1");		
		Movie movie = new Movie("1001", "Movie1", genreList, 1.5D, city);
		return movie;
	}
    
    
    private Movie generateMovieDummyObj1() {
		List genreList = new ArrayList<Genre>();
		Genre genre = new Genre();
		genre.setName("hindi");
		genreList.add(genre);
		City city = new City();
		city.setName("City1");
		city.setMovies(null);
		Movie movie = new Movie("1001", "Movie1", genreList, 1.5D, city);
		return movie;
	}
    
    

}
