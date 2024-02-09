package an.opensauce.armourweight.client.graphics;

import an.opensauce.armourweight.Armourweight;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;

/**
 *  a single-pixel (at least, for now) texture, that can be set to a custom colour.
 */
public class DynamicColourTexture {

    public DynamicColourTexture(Identifier id){
        ImageID = id;
    }

    public Identifier ImageID;

    public NativeImage image = new NativeImage(1,1,false); // RGBA
    NativeImageBackedTexture texture = new NativeImageBackedTexture(image);

    /**
     * @param colour The colour to change the image to, is RGB(A), and is in hex (i.e. White RGBA = 0xFFFFFFFF)
     */
    public Identifier setImageColour(int colour, MinecraftClient client){
        image = new NativeImage(1,1,true);
        image.setColor(0, 0, colour); // set the pixel


        texture.setImage(image);
        client.getTextureManager().registerTexture(ImageID,texture);
        return ImageID;
    }

}
