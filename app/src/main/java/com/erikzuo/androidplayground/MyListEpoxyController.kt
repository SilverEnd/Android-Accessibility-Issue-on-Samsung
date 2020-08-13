package com.erikzuo.androidplayground

import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.TypedEpoxyController

class MyListEpoxyController : TypedEpoxyController<List<String>>() {
    override fun buildModels(data: List<String>) {
//        ProductCardGroup(data).addTo(this)

        CarouselModel_()
            .id("carousel")
            .models(
                data.mapIndexed { index, item ->
                    MyImageViewBindingModel_()
                        .id(index)
                        .url(item)
                }
            ).addTo(this)

        data.mapIndexed { index, item ->
            myTextView {
                id(index)
            }
        }
    }
}
