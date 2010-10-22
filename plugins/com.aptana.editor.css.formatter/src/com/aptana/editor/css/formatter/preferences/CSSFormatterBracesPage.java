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
package com.aptana.editor.css.formatter.preferences;

import java.net.URL;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import com.aptana.editor.css.formatter.CSSFormatterConstants;
import com.aptana.formatter.ui.CodeFormatterConstants;
import com.aptana.formatter.ui.FormatterMessages;
import com.aptana.formatter.ui.IFormatterControlManager;
import com.aptana.formatter.ui.IFormatterModifyDialog;
import com.aptana.formatter.ui.preferences.FormatterModifyTabPage;
import com.aptana.formatter.ui.util.SWTFactory;

public class CSSFormatterBracesPage extends FormatterModifyTabPage
{
	private static final String BRACES_PREVIEW_NAME = "braces-preview.css"; //$NON-NLS-1$
	private static final String[] TAB_OPTION_ITEMS = new String[] { CodeFormatterConstants.SAME_LINE,
			CodeFormatterConstants.NEW_LINE };
	private static final String[] TAB_OPTION_NAMES = new String[] {
			FormatterMessages.BracesTabPage_position_option_SAME_LINE,
			FormatterMessages.BracesTabPage_position_option_NEW_LINE };

	public CSSFormatterBracesPage(IFormatterModifyDialog dialog)
	{
		super(dialog);
	}

	protected void createOptions(IFormatterControlManager manager, Composite parent)
	{
		Group bracesGroup = SWTFactory.createGroup(parent, Messages.CSSFormatterBracesPage_braces_group_label, 1, 2,
				GridData.FILL_HORIZONTAL);
		manager.createCombo(bracesGroup, CSSFormatterConstants.NEW_LINES_BEFORE_BLOCKS,
				Messages.CSSFormatterBracesPage_blocks, TAB_OPTION_ITEMS, TAB_OPTION_NAMES);
	}

	protected URL getPreviewContent()
	{
		return getClass().getResource(BRACES_PREVIEW_NAME);
	}

}
