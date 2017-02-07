/**
 * Copyright 2010-present Mobily.ws.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mobily.api.sms;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.mobily.api.sms.entity.BalanceResponse;
import com.mobily.api.sms.entity.BalanceResponseData;
import com.mobily.api.sms.utility.MobilyAPI;
import com.mobily.api.sms.utility.OnDataReceiveListner;

import junit.framework.TestResult;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);




    }
}