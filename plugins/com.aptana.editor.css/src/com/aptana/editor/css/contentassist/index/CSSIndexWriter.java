/**
 * This file Copyright (c) 2005-2010 Aptana, Inc. This program is
 * dual-licensed under both the Aptana Public License and the GNU General
 * Public license. You may elect to use one or the other of these licenses.
 * 
 * This program is distributed in the hope that it will be useful, but
 * AS-IS and WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, TITLE, or
 * NONINFRINGEMENT. Redistribution, except as permitted by whichever of
 * the GPL or APL you select, is prohibited.
 *
 * 1. For the GPL license (GPL), you can redistribute and/or modify this
 * program under the terms of the GNU General Public License,
 * Version 3, as published by the Free Software Foundation.  You should
 * have received a copy of the GNU General Public License, Version 3 along
 * with this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Aptana provides a special exception to allow redistribution of this file
 * with certain other free and open source software ("FOSS") code and certain additional terms
 * pursuant to Section 7 of the GPL. You may view the exception and these
 * terms on the web at http://www.aptana.com/legal/gpl/.
 * 
 * 2. For the Aptana Public License (APL), this program and the
 * accompanying materials are made available under the terms of the APL
 * v1.0 which accompanies this distribution, and is available at
 * http://www.aptana.com/legal/apl/.
 * 
 * You may view the GPL, Aptana's exception and additional terms, and the
 * APL in the file titled license.html at the root of the corresponding
 * plugin containing this source file.
 * 
 * Any modifications to this file must keep this entire header intact.
 */
package com.aptana.editor.css.contentassist.index;

import java.io.InputStream;
import java.net.URI;

import org.mortbay.util.ajax.JSON;

import com.aptana.core.util.StringUtil;
import com.aptana.editor.css.contentassist.model.ElementElement;
import com.aptana.editor.css.contentassist.model.PropertyElement;
import com.aptana.index.core.Index;

public class CSSIndexWriter
{
	private CSSMetadataReader _reader;
	
	/**
	 * CSSIndexWriter
	 */
	public CSSIndexWriter()
	{
		this._reader = new CSSMetadataReader();
	}
	
	/**
	 * getDocumentPath
	 * 
	 * @return
	 */
	protected URI getDocumentPath()
	{
		return URI.create(CSSIndexConstants.METADATA);
	}
	
	/**
	 * loadXML
	 * 
	 * @param stream
	 * @throws Exception 
	 * @throws ScriptDocException
	 */
	public void loadXML(InputStream stream) throws Exception
	{
		this._reader.loadXML(stream);
	}

	/**
	 * writeElement
	 * 
	 * @param index
	 * @param element
	 */
	protected void writeElement(Index index, ElementElement element)
	{
		String key = StringUtil.join( //
			CSSIndexConstants.DELIMITER, //
			element.getName(), //
			JSON.toString(element) //
		);
		
		index.addEntry(CSSIndexConstants.ELEMENT, key, this.getDocumentPath());
	}
	
	/**
	 * writeProperty
	 * 
	 * @param index
	 * @param property
	 */
	protected void writeProperty(Index index, PropertyElement property)
	{
		String key = StringUtil.join( //
			CSSIndexConstants.DELIMITER, //
			JSON.toString(property) //
		);
		
		index.addEntry(CSSIndexConstants.PROPERTY, key, this.getDocumentPath());
	}

	/**
	 * writeToIndex
	 * 
	 * @param index
	 */
	public void writeToIndex(Index index)
	{
		for (ElementElement element : this._reader.getElements())
		{
			this.writeElement(index, element);
		}
		
		for (PropertyElement property : this._reader.getProperties())
		{
			this.writeProperty(index, property);
		}
	}
}
