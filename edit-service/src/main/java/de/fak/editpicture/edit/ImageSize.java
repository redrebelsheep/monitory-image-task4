package de.fak.editpicture.edit;


import de.fak.editpicture.image.ImageFile;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class ImageSize {

    @Id
    private long id;

    private List<ImageFile> imageFileList;

}
