package com.auxilioservico.backend.exceptions

import kotlin.RuntimeException

class NotFoundException (override val message: String)
    : RuntimeException()