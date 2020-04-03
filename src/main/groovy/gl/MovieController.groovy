package gl

import gl.td3.movie.data.Movie
import gl.td3.movie.data.MovieRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Post


@Controller("/movie")
class MovieController {

    @Get("/")
    List<Movie> index() {
        []
    }
    @Post('/')
    HttpStatus addMovie(MovieRequest movieRequest) {
        HttpStatus.CREATED
    }
}