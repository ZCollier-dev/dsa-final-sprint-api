package org.example.rest.root;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RootRepo extends MongoRepository<Root,Long> {
}
