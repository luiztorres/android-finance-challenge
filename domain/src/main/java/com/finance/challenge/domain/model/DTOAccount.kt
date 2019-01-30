package com.finance.challenge.domain.model

import com.google.gson.annotations.SerializedName

data class DTOAccount(
	val amount: Float? = null,
	val name: String? = null,
	val id: Int? = null,
    @SerializedName("ROI")
	val roi: Float? = null
)
