package com.brfdev.domain.model

import com.brfdev.domain.R


class NetworkException(
    val message: Int
) {

    companion object {
        fun getNotFoundException(): NetworkException {
            return NetworkException(R.string.erro_network)
        }
    }

}