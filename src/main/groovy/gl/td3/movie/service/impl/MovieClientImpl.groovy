package gl.td3.movie.service.impl

import gl.td3.movie.data.Movie
import gl.td3.movie.service.MovieClient
import javax.inject.Singleton

@Singleton
class MovieClientImpl implements MovieClient {
    @Override
    Movie getMovieDetail(String imdbID) {
        return null
    }
}
