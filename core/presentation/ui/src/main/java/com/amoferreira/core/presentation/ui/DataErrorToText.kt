package com.amoferreira.core.presentation.ui

import com.amoferreira.core.domain.util.DataError

fun DataError.asUiText(): UiText {
    return when(this) {
        DataError.Local.DISK_FULL -> {
            UiText.StringResource(R.string.error_message_disk_full)
        }
        DataError.Network.REQUEST_TIMEOUT -> {
            UiText.StringResource(R.string.error_message_request_timeout)
        }
        DataError.Network.TOO_MANY_REQUESTS -> {
            UiText.StringResource(R.string.error_message_too_many_request)
        }
        DataError.Network.NO_INTERNET -> {
            UiText.StringResource(R.string.error_message_no_internet)
        }
        DataError.Network.PAYLOAD_TOO_LARGE -> {
            UiText.StringResource(R.string.error_message_payload_too_large)
        }
        DataError.Network.SERVER_ERROR -> {
            UiText.StringResource(R.string.error_message_server_error)
        }
        DataError.Network.SERIALIZATION -> {
            UiText.StringResource(R.string.error_message_serialization)
        }
        DataError.Network.UNKNOWN -> {
            UiText.StringResource(R.string.error_message_unknwon_error)
        }
        else -> UiText.StringResource(R.string.error_message_unknwon_error)
    }
}