package de.fak.editpicture.edit;

public enum ImageProperties {



    SMALL(1024,768),NORMAL(2048,1080),BIG(4096,2160);

    private int width, height;

    ImageProperties(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
