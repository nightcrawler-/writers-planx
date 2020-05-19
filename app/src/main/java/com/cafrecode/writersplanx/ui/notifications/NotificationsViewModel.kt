package com.cafrecode.writersplanx.ui.notifications

import androidx.lifecycle.ViewModel
import com.cafrecode.writersplanx.db.Message
import com.cafrecode.writersplanx.repositories.MessagesRepo
import javax.inject.Inject

class NotificationsViewModel @Inject constructor(private val repo: MessagesRepo) : ViewModel() {

    fun insert(message: Message) = repo.insert(message)

    fun list() = repo.list()
}