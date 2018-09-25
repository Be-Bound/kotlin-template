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

import android.app.Application
import android.content.Context
import com.bebound.sdk.BeBound
import com.bebound.sdk.config.BeAppConfig

/**
 * Instance of Application() in order to create a BeAppConfig.
 * The name of this class has no importance.
 * Update of the Android Manifest is necessary:
 *      <application
 *          android:name=".BeApp"
 *          (...)
 *      </application>
 */
class BeApp: Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: BeApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        /*
         * Initiate the SDK.
         * @param context       application context.
         * @param BeAppConfig   implementation.
         */
        BeBound.init(this, object: BeAppConfig {
            // NOTE: Add your APP_ID generated in the console.
            override fun getBeAppId(): Long {
                return 113
            }

            // NOTE: Add the reference of your Be-App manifest from res/xml.
            override fun getBeAppManifestResId(): Int {
                return R.xml.beappmanifest
            }
        })
    }
}