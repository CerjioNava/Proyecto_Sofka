package EPA.Cuenta_Bancaria_Web.Repositorio.Mongo;

import EPA.Cuenta_Bancaria_Web.Modelo.Mongo.M_CuentaMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface I_RepositorioCuentaMongo extends ReactiveMongoRepository<M_CuentaMongo, String>
{
    public Mono<M_CuentaMongo> findByid(String id);
}
