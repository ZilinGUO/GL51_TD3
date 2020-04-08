package gl

import gl.td3.movie.data.Movie
import gl.td3.movie.data.MovieRequest
import gl.td3.movie.service.MovieRegistry
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Post

import javax.inject.Inject


@Controller("/movie")
class MovieController {

    @Inject
    MovieRegistry registry
    @Get("/")
    List<Movie> index() {
        []
    }
    @Post('/')
    HttpStatus addMovie(MovieRequest movieRequest) {
        registry.addMovieToFavorites(movieRequest.getImdbId())
        HttpStatus.CREATED
    }
}