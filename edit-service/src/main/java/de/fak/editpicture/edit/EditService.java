package de.fak.editpicture.edit;

import de.fak.editpicture.image.ImageFile;
import de.fak.editpicture.image.ImageFileRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.bson.types.Binary;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EditService {

    private ImageFileRepository imageFileRepository;

    private int width = 1024;
    private int height = 600;




    public MultipartFile resizeImage(Long id) {
        Optional<ImageFile> optionalImageFile = getImageById(id);
        Binary content =  optionalImageFile.get().getContent();
        InputStream is = new ByteArrayInputStream(content.getData());
        try {
            BufferedImage bufferedImage = ImageIO.read((is));
            BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = resizedImage.createGraphics();
            graphics2D.drawImage(bufferedImage, 0, 0, width, height, null);
            graphics2D.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); ImageIO.write(resizedImage, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            optionalImageFile.get().setContent(new Binary(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Optional<ImageFile> getImageById(long id) {
        Optional<ImageFile> optionalImageFile = imageFileRepository.findById(id);

        return optionalImageFile;
    }


}
