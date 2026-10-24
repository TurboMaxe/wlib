package xyz.webmc.wlib.api.item;

import com.avaje.ebean.validation.NotNull;
import com.cryptomorin.xseries.XMaterial;
import lombok.Getter;
import org.bukkit.Material;
import org.jspecify.annotations.Nullable;
import xyz.webmc.wlib.api.misc.iface.Serializable;

public class WMaterial implements BukkitMaterial {
    @Getter private final XMaterial material;
    @NotNull private final Key key;

    private WMaterial(Material material) {
        this.material = XMaterial.matchXMaterial(material);
        this.key = Key.key("minecraft", material.name());
    }
    private WMaterial(XMaterial material) {
        new WMaterial(material.get());
    }

    public static BukkitMaterial init(XMaterial material) {
        return new WMaterial(material);
    }


    @Override
    public String serialize() {
        if (this.material != null) {
            return "material:%d".formatted(material.getId());
        }
      return "material:null";
    }

    @Override
    public XMaterial deserialize(String data) {
        StringBuilder string = new StringBuilder(data);

    }
}
