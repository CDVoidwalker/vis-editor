/*
 * Copyright 2014-2016 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kotcrab.vis.ui.util.adapter;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kotcrab.vis.ui.widget.ListView;
import com.kotcrab.vis.ui.widget.VisTable;

/**
 * @author Kotcrab
 * @since 1.0.0
 */
public abstract class AbstractListAdapter<ItemT, ViewT extends Actor> extends CachedItemAdapter<ItemT, ViewT>
		implements ListAdapter<ItemT> {
	protected ListView view;

	@Override
	public void fillTable (VisTable itemsTable) {
		for (ItemT item : iterable()) {
			itemsTable.add(getView(item)).growX();
			itemsTable.row();
		}
	}

	@Override
	public void setListView (ListView view) {
		this.view = view;
	}

	@Override
	public void invalidateDataSet () {
		view.invalidateDataSet();
	}
}