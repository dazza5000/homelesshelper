/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.whereisdarran.homelesshelper.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.whereisdarran.homelesshelper.databinding.ListItemResourceBinding
import com.whereisdarran.homelesshelper.model.Resource

class ResourceAdapter : ListAdapter<Resource, RecyclerView.ViewHolder>(ResourceDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ResourceViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val plant = getItem(position)
        (holder as ResourceViewHolder).bind(plant)
    }

    class ResourceViewHolder(
        private val binding: ListItemResourceBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
//            binding.setClickListener {
//                binding.plant?.let { plant ->
//                    navigateToResource(plant, it)
//                }
//            }
        }

        private fun navigateToResource(
            plant: Resource,
            view: View
        ) {
//            val direction =
//                HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(
//                    plant.plantId
//                )
//            view.findNavController().navigate(direction)
        }

        fun bind(item: Resource) {
            binding.resourceId.text = item.objectId
            binding.resourceName.text = item.name
        }

        companion object {
            fun from(parent: ViewGroup): RecyclerView.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemResourceBinding.inflate(layoutInflater, parent, false)

                return ResourceViewHolder(binding)
            }
        }
    }
}

private class ResourceDiffCallback : DiffUtil.ItemCallback<Resource>() {

    override fun areItemsTheSame(oldItem: Resource, newItem: Resource): Boolean {
        return oldItem.objectId == newItem.objectId
    }

    override fun areContentsTheSame(oldItem: Resource, newItem: Resource): Boolean {
        return oldItem == newItem
    }
}
