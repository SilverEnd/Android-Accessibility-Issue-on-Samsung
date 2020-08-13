/*
 * Copyright (c) 2020 Woolworths. All rights reserved.
 */

package com.erikzuo.androidplayground

import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelGroup

class ProductCardGroup(list: List<String>) : EpoxyModelGroup(
    R.layout.group,
    buildModels(list)
) {
    companion object {
        private fun buildModels(list: List<String>): List<EpoxyModel<*>> = listOf(
            CarouselModel_()
                .id("carousel")
                .models(
                    list.mapIndexed { index, item ->
                        MyImageViewBindingModel_()
                            .id(index)
                            .url(item)
                    }
                )
        )
    }
}
