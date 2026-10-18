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

package xyz.webmc.wlib.api.structure.block;

import xyz.webmc.wlib.internal.compat.WCompat;

import com.cryptomorin.xseries.XMaterial;

@Deprecated(forRemoval = true)
@WCompat(xyz.webmc.wlib.internal.structure.block.AbstractBlockBase.class)
public abstract class AbstractBlockBase extends xyz.webmc.wlib.internal.structure.block.AbstractBlockBase {
  @Deprecated(forRemoval = true)
  protected AbstractBlockBase(XMaterial mat, String dataModern, byte dataLegacy) {
    super(mat, dataModern, dataLegacy);
  }

  @Deprecated(forRemoval = true)
  protected AbstractBlockBase(XMaterial mat, String data) {
    this(mat, data, (byte) 0);
  }

  @Deprecated(forRemoval = true)
  protected AbstractBlockBase(XMaterial mat, byte data) {
    this(mat, null, data);
  }
}
