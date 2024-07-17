package com.mcsoftware.ticketo.rating.model.dto.response

import com.mcsoftware.ticketo.rating.constant.ECode
import lombok.Data
import java.util.UUID

@Data
data class RatingResponse(
    val id: UUID,
    val code: ECode,
    val description: String
)
