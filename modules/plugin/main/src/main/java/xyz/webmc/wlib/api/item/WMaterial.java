package xyz.webmc.wlib.api.item;

import com.avaje.ebean.validation.NotNull;
import com.cryptomorin.xseries.XMaterial;
import net.kyori.adventure.key.Key;
import org.bukkit.Material;
import xyz.webmc.wlib.api.misc.iface.SerializerParseException;

import java.util.Objects;

public class WMaterial implements BukkitMaterial {
    private XMaterial material;
    @NotNull private final Key key;

    private WMaterial(Material material) {
        this.material = XMaterial.matchXMaterial(material);
        this.key =  Key.key("minecraft:%s".formatted(material.name()));
    }
    private WMaterial(XMaterial material) {
        this.material = material;
        this.key = Key.key("minecraft:%s".formatted(material.name()));
        new WMaterial(material.get());
    }

    public static BukkitMaterial init(XMaterial material) {
        return new WMaterial(material);
    }

    public static BukkitMaterial init(Material material) {
        return new WMaterial(material);
    }

    @Override
    public String serialize(XMaterial src) {
        if (this.material != null) {
            return "material:%s".formatted(src.name());
        }
      return "material:null";
    }

    @Override
    public XMaterial deserialize(String data) throws SerializerParseException {
        String[] splitName = data.split(":");
        XMaterial mat = null;
        if (Objects.equals(splitName[0], "material")) {
            final String materialName = splitName[1];
            var optionalMaterial =  XMaterial.matchXMaterial(materialName);
            mat = optionalMaterial.orElse(null);
        }
        if (mat == null) {
            throw new SerializerParseException("Null material.");
        }
        return mat;
    }

    public Material getBukkitMaterial() {
        return material.get();
    }
}
