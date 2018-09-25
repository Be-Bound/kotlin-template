/*
 * Copyright 2018, Be-Bound
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bebound.template.request.sendtext

import com.bebound.sdk.BeBound
import com.bebound.sdk.engine.request.builder.RequestBuilder
import com.bebound.template.request.sendtext.listeners.MyOnFailedListener
import com.bebound.template.request.sendtext.listeners.MyOnSentListener
import com.bebound.template.request.sendtext.listeners.MyOnSuccessListener

class RequestSendText {

    /**
     * Build and send a Be-Bound request with a RequestBuilder.
     * @param content   text from the EditText to send.
     */
    fun sendRequest(content: String) {
        val request: RequestBuilder = BeBound.newRequest()
                // NOTE: Add the 'operationName' from the Be-App Manifest.
                .withOperationName("send_text")
                // NOTE: Add the request 'name' from the Be-App Manifest.
                .put("content", content)
                // NOTE: Set listeners to handle the response.
                .onSent(MyOnSentListener())
                .onFailed(MyOnFailedListener())
                .onSuccess(MyOnSuccessListener())
        // NOTE: Send the request.
        request.send()
    }
}