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
import com.bebound.sdk.engine.listener.request.OnSentListener
import com.bebound.sdk.model.request.Request
import com.bebound.template.BeApp
import com.bebound.template.R
import com.bebound.template.toast

/**
 * OnSentListener implementation
 */
class MyOnSentListener: OnSentListener {

    /**
     * @param context
     * @param request   request sent
     * @return by default
     */
    override fun onSent(context: Context?, request: Request?) {
        BeApp.applicationContext().getString(R.string.toast_sent).toast()
    }
}