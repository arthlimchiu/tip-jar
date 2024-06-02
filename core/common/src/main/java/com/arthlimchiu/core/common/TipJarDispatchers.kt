package com.arthlimchiu.core.common

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcher: TipJarDispatchers)

enum class TipJarDispatchers {
    Default,
    IO
}