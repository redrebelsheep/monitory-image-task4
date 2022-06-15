package de.fak.editpicture.edit;

import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class EditService {


    public MultipartFile resizeImage(MultipartFile multipartFile,int width,int height) {
        try {
            BufferedImage bufferedImage = ImageIO.read((multipartFile.getInputStream()));
            BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = resizedImage.createGraphics();
            graphics2D.drawImage(bufferedImage, 0, 0, width, height, null);
            graphics2D.dispose();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
