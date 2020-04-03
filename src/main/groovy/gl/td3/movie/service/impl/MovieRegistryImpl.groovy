package gl.td3.movie.service.impl

import gl.td3.movie.data.Movie
import gl.td3.movie.service.MovieClient

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRegistryImpl implements gl.td3.movie.service.MovieRegistry {
    private List<Movie> internalRegistry = [];
    @Inject
    private MovieClient movieClient
    @Override
    void addMovieToFavorites(String imdbID) {
        internalRegistry << movieClient.getMovieDetail(imdbID)
    }

    @Override
    List<Movie> listFavorites() {
         internalRegistry
    }
}
