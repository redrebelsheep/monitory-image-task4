package fak.task4.service1.imageservicesavetracing.image;

import fak.task4.service1.imageservicesavetracing.sequence.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ImageFileService {

  private ImageFileRepository imageRepository;
  private SequenceGeneratorService sequenceGeneratorService;

  public void saveImage(MultipartFile file) {
    try {
      ImageFile imageFile =
          ImageFile.builder()
              .name(file.getName())
              .createdTime(LocalDate.now())
              .contentType(file.getContentType())
              .content(new Binary(file.getBytes()))
              .size(file.getSize())
              .build();
        imageFile.setId(sequenceGeneratorService.generateSequence(ImageFile.SEQUENCE_NAME));
        imageRepository.save(imageFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Resource getImageById(long id) {
    Optional<ImageFile> optionalImageFile = imageRepository.findById(id);
    Resource image = null;
    if(optionalImageFile.isPresent()){
      //      image = (Resource) optionalImageFile.get();
      String name = optionalImageFile.get().getName();
      String originalFileName = optionalImageFile.get().getName();
      String contentType = optionalImageFile.get().getContentType();
      Binary content =  optionalImageFile.get().getContent();
      InputStream is = new ByteArrayInputStream(content.getData());

      try {
        BufferedImage newBufferdImage = ImageIO.read(is);
        newBufferdImage.get
      } catch (IOException e) {
        e.printStackTrace();
      }
//      MultipartFile result = new MockMultipartFile(name,
//                                                   originalFileName, contentType, content);

    }
    return image;
  }
}