package gl.td3.movie.service.Impl

import gl.td3.movie.data.Movie

import javax.inject.Singleton

@Singleton
class MovieRegistryImpl implements gl.td3.movie.service.MovieRegistry {
    private List<Movie> internalRegistry = [];
    @Override
    void addMovieToFavorites(String imdbID) {
        internalRegistry<<new Movie(imdbID:imdbID)
    }

    @Override
    List<Movie> listFavorites() {
         internalRegistry
    }
}
