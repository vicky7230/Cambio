package com.vicky7230.cambio.utils.event

import androidx.lifecycle.Observer

class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event_<T>> {
    override fun onChanged(event: Event_<T>?) {
        event?.getContentIfNotHandled()?.let { value ->
            onEventUnhandledContent(value)
        }
    }
}