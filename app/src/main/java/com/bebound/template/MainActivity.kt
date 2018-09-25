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

package com.bebound.template

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bebound.template.request.sendtext.RequestSendText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // NOTE: Delegate the permission handling
    private val permissionsDelegate: PermissionsDelegate by lazy { PermissionsDelegate(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt.setOnClickListener {
            // NOTE: When button is clicked and EditText is not empty, a request is sent.
            when (et.text.isEmpty()) {
                true -> getString(R.string.toast_et_empty).toast()
                false -> RequestSendText().sendRequest(et.text.toString())
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (permissionsDelegate.hasPermissions()) {
            bt.isClickable = true
        } else {
            permissionsDelegate.requestPermissions()
        }
    }

    /**
     * Callback for the result from requesting permissions. This method is invoked for every call.
     * Having the permissions is mandatory for Be-Bound.
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // NOTE: Delegate the permission handling to generated method.
        if (permissionsDelegate.resultGranted(requestCode, grantResults)) {
            bt.isClickable = true
        }
    }
}
