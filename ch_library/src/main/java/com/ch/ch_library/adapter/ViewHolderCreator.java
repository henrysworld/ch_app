/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ch.ch_library.adapter;

/**
 * A interface that defines what a View Holder Creator should do.
 *
 * @param <ItemDataType> the generic type of the data in each item of a list.
 * @author http://www.liaohuqiu.net
 */
public interface ViewHolderCreator<ItemDataType> {
    public ViewHolderBase<ItemDataType> createViewHolder(int position);
}