package gl

import gl.td3.movie.data.MovieRequest
import gl.td3.movie.data.Movie
import io.micronaut.core.type.Argument
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.reactivex.Flowable
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.lang.Shared
import io.micronaut.http.HttpRequest

import javax.inject.Inject

@MicronautTest
class MovieControllerSpec extends Specification {

    @Shared @Inject
    EmbeddedServer embeddedServer

    @Shared @AutoCleanup @Inject @Client("/")
    RxHttpClient client

    void "test index"() {
        given:
        Flowable flowable = client.retrieve(HttpRequest.GET("/movie"), Argument.listOf(Movie))
        def content = flowable.firstElement()
        expect:
        content.blockingGet() == []
    }
    void "test film creation"() {
        given:
        HttpResponse response = client.toBlocking().exchange(
                HttpRequest.POST("/movie", new MovieRequest(imdbId: "aaaaa"))
        )
        expect:
        response.status == HttpStatus.CREATED
    }
}
