package com.mcsoftware.ticketo.rating.model.dto.response

import com.mcsoftware.ticketo.rating.constant.ECode
import java.util.UUID

data class RatingResponse(
    val id: UUID,
    val code: ECode,
    val description: String
)
