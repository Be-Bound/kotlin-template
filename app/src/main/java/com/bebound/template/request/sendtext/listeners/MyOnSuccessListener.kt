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

package com.bebound.template.request.sendtext.listeners

import android.content.Context
import android.util.Log
import com.bebound.sdk.engine.listener.request.OnSuccessListener
import com.bebound.sdk.model.request.Request
import com.bebound.sdk.model.request.Response
import com.bebound.template.BeApp
import com.bebound.template.R
import com.bebound.template.toast

/**
 * OnSuccessListener implementation
 */
class MyOnSuccessListener: OnSuccessListener {

    /**
     * @param context
     * @param request   request sent
     * @param response  response received
     * @return by default
     */
    override fun onSuccess(context: Context?, request: Request?, response: Response?) {
        Log.d(MyOnSuccessListener::class.java.simpleName, "The request was a success")

        /* NOTE: Get the response value by using the type and key associated to the response
        in the Be-App Manifest. */
        val length = response?.parameters?.getInt("length")

        // NOTE: length would be 0 if the response doesn't contains data.
        if (length == 0) {
            Log.d(MyOnSuccessListener::class.java.simpleName, "But the response had some issue. It doesn't contains --length--")
            BeApp.applicationContext().getString(R.string.toast_success, length).toast()
        } else {
            BeApp.applicationContext().getString(R.string.toast_success, length).toast()
        }
    }
}