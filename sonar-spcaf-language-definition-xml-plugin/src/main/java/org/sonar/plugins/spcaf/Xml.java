/*
 * SonarQube PowerShell Plugin
 * Copyright (C) 2014 Rencore
 * sonarqube@googlegroups.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.spcaf;

import org.apache.commons.lang.StringUtils;
import org.sonar.api.config.Settings;
import org.sonar.api.resources.AbstractLanguage;

public class Xml extends AbstractLanguage {

    /** The language key. */
    public static final String KEY = "xml";

    private Settings settings;

    /**
     * Default constructor.
     */
    public Xml(Settings settings) {
        super(KEY, "SPCAF-XML");
        this.settings = settings;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getFileSuffixes() {
        String[] suffixes = settings.getStringArray(spcafPluginXml.XML_SUFFIXES_KEY);
        if (suffixes == null || suffixes.length == 0) {
            suffixes = StringUtils.split(spcafPluginXml.XML_SUFFIXES_DEFAULT_VALUE, ",");
        }
        return suffixes;
    }
}

