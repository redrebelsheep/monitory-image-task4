package de.fak.editpicture.edit;


import de.fak.editpicture.image.ImageFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageSizeRepository extends MongoRepository<ImageSize, Long> {
}
