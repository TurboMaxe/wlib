/*
 * Copyright (C) 2026 Colbster937
 *
 * SPDX-License-Identifier: AGPL-3.0-or-later
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * See the LICENSE file for details.
 */

package xyz.webmc.wlib.internal.misc;

import com.avaje.ebean.validation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
public final class WPlayer {
    private final @NotNull UUID uuid;
    private final @NotNull String name;
    private final @NotNull String host;

    private WPlayer(UUID uuid, String name, String host) {
        this.uuid = uuid;
        this.name = name;
        this.host = host;
    }

    public static WPlayer createPlayer(UUID uuid, String name, String host) {
         return new WPlayer(uuid, name, host);
    }

    public static WPlayer createPlayer(Player player) {
        return new WPlayer(
                player.getUniqueId(),
                player.getName(),
                player.getAddress().getHostName()
        );
    }
}
