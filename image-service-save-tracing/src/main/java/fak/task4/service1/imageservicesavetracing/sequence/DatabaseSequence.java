package fak.task4.service1.imageservicesavetracing.sequence;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;

    @Getter
    private long seq;

    public DatabaseSequence() {}

}