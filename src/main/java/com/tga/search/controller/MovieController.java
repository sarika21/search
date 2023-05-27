package com.tga.search.controller;

import com.tga.search.model.City;
import com.tga.search.model.Movie;
import com.tga.search.service.MovieService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/movies")
public class MovieController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	MovieService movieService;

	@PostMapping("/save")
	public Movie saveMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}

	@GetMapping("/find/all")
	public List<Movie> allMovies() {
		return movieService.allMovies();
	}

	@GetMapping("/hello")
	public String test() {
		return "Hello";
	}

	@GetMapping("/{search}")
	public Page<Movie> searchMovie(@PathVariable String search) {
		return movieService.searchMovieName(search);
	}

	@GetMapping("/fuzzines/{search}")
	public Page<Movie> searchMovieWithFuzzines(@PathVariable String search) {
		return movieService.searchMovieWithFuzzines(search);
	}

	@GetMapping("/multi/{search}")
	public Page<Movie> searchMovieWithMultiMatch(@PathVariable String search) {
		return movieService.searchMovieWithMultiMatch(search);
	}

	@GetMapping("/phrase_search/{search}")
	public Page<Movie> searchMovieWithPhraseQuery(@PathVariable String search) {
		return movieService.searchMovieWithPhraseQuery(search);
	}

	@GetMapping("/find/{id}")
	public Optional<Movie> findById(@PathVariable String id) {
		LOG.info("Getting find movie By id, ", id);
		return movieService.findById(id);
	}

	@GetMapping("/find_name/{name}")
	public List<Movie> findByName(@PathVariable String name) {
		LOG.info("Getting find movie By name, ", name);
		return movieService.getByName(name);
	}

	
	@GetMapping("/findcity/{name}")
	public Page<Movie> findByCity(@PathVariable String name) {
		LOG.info("findByCity , ", name);
		return movieService.findByCity(name);
	}

	@PutMapping("/update/{id}")
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable String id) {
		LOG.info("Updating Movie with id {}", id);
		movieService.update(id, movie);
		return movie;
	}

	@DeleteMapping("delete/{id}")
	public void deleteMovieByID(@PathVariable String id) {
		LOG.info("Deleting Movie with id {}", id);
		movieService.deleteMovie(id);
	}
}
