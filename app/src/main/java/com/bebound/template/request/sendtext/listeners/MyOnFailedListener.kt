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
import com.bebound.sdk.engine.listener.request.OnFailedListener
import com.bebound.sdk.model.request.Request
import com.bebound.sdk.model.request.Response
import com.bebound.template.BeApp
import com.bebound.template.R
import com.bebound.template.toast

/**
 * OnFailedListener implementation
 */
class MyOnFailedListener: OnFailedListener {

    /**
     * @param context
     * @param request   request sent
     * @param requestStatusCode     see more about requestStatusCode at https://doc.be-bound.com/docs/list-of-errors
     * @param requestStatusMessage  see more about requestStatusMessage at https://doc.be-bound.com/docs/list-of-errors
     * @return by default
     */
    override fun onRequestFailed(context: Context?, request: Request?, requestStatusCode: Int, requestStatusMessage: String?) {
        Log.e(MyOnFailedListener::class.java.simpleName, "onRequestFailed")
        BeApp.applicationContext().getString(R.string.toast_fail).toast()
    }

    /**
     * @param context
     * @param request   request sent
     * @return by default
     */
    override fun onTimeout(context: Context?, request: Request?) {
        Log.e(MyOnFailedListener::class.java.simpleName, "onTimeout")
        BeApp.applicationContext().getString(R.string.toast_fail).toast()
    }

    /**
     * @param context
     * @param request   request sent
     * @param response  response received
     * @param responseStatusCode    see more about requestStatusCode at https://doc.be-bound.com/docs/list-of-errors
     * @param responseStatusMessage     see more about requestStatusMessage at https://doc.be-bound.com/docs/list-of-errors
     * @return by default
     */
    override fun onResponseError(context: Context?, request: Request?, response: Response?, responseStatusCode: Int, responseStatusMessage: String?) {
        Log.e(MyOnFailedListener::class.java.simpleName, "onResponseError")
        BeApp.applicationContext().getString(R.string.toast_fail).toast()
    }
}