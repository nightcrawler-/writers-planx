/*
 * MIT License
 *
 * Copyright (c) 2020 Frederick Nyawaya.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.cafrecode.writersplanx.services

import android.util.Log
import com.cafrecode.writersplanx.db.Message
import com.cafrecode.writersplanx.repositories.MessagesRepo
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.android.AndroidInjection
import javax.inject.Inject

const val TAG = "PlanxIntentService"

class PlanxIntentService : FirebaseMessagingService() {

    @Inject
    lateinit var repo: MessagesRepo

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.i(TAG, "Message: " + remoteMessage.data)

        val notification = remoteMessage.notification

        if (notification != null) {
            persistMessage(notification)
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification()!!.getBody());
        }
    }

    private fun persistMessage(data: RemoteMessage.Notification) {
        val msg = Message(
            title = data.title!!,
            text = data.body!!,
            imageUrl = data.imageUrl.toString()
        )
        repo.insert(msg)
    }
}