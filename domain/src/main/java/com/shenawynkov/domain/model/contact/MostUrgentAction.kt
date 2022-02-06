package com.shenawynkov.domain.model.contact

data class MostUrgentAction(
    val assignee_id: String,
    val contact_id: String,
    val created_at: String,
    val date: String,
    val done: Boolean,
    val id: String,
    val modified_at: String,
    val status: String,
    val text: String
)