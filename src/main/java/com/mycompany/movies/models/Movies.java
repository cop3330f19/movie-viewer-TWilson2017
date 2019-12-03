/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movies.models;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.Video;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import java.util.ArrayList;

/**
 *
 * @author Wilso
 */
public class Movies {
    
    // TMDB API Connection
    private static final TmdbApi CONNECTION = new TmdbApi("6d6ad136a480f8734b701dec7efbbccf");
    // Language
    private static final String LANGUAGE = "en-US";
    
    // Return the list of currently playing
    public ArrayList<MovieDb> getMovies(){
        TmdbMovies movies = new TmdbMovies(CONNECTION);
        MovieResultsPage result = movies.getNowPlayingMovies(LANGUAGE, 1, "");
        
        return (ArrayList<MovieDb>) result.getResults();
    }
    
    // Get Trailers
    public ArrayList<Video> getVideos(int movieId){
        TmdbMovies movies = new TmdbMovies(CONNECTION);
        
        return (ArrayList<Video>) movies.getVideos(movieId, LANGUAGE);
    }
}   
