package de.fak.editpicture.edit;

import de.fak.editpicture.image.ImageFile;
import de.fak.editpicture.image.ImageFileRepository;
import lombok.AllArgsConstructor;
import org.bson.types.Binary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EditService {

    private ImageFileRepository imageFileRepository;
    private ImageSizeRepository imageSizeRepository;

    private int width = 1024;
    private int height = 600;




    public void resizeImage(Long id) {
        Optional<ImageFile> optionalImageFile = getImageById(id);
        Binary content = null;
        ImageFile imageFile = null;
        if(optionalImageFile.isPresent()){
            imageFile = optionalImageFile.get();
            content =  optionalImageFile.get().getContent();
        }
        InputStream is = new ByteArrayInputStream(content.getData());
        try {
            BufferedImage bufferedImage = ImageIO.read((is));
            BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = resizedImage.createGraphics();
            graphics2D.drawImage(bufferedImage, 0, 0, width, height, null);
            graphics2D.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); ImageIO.write(resizedImage, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            assert imageFile != null;
            imageFile.setContent(new Binary(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<ImageFile> getImageById(long id) {
        Optional<ImageFile> optionalImageFile = imageFileRepository.findById(id);
        return optionalImageFile;
    }



}
