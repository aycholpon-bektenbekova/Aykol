package com.example.aykol.ui.home

import java.io.Serializable

data class Model(
    var image: Int? = null,
    var title: String? = null,
    var keyId: Int = 0
): Serializable
