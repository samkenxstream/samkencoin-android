/*
 * Copyright (c) 2022 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.matrix.android.sdk.test.fixtures

import org.matrix.android.sdk.internal.auth.db.SessionParamsEntity

internal object SessionParamsEntityFixture {
    fun aSessionParamsEntity(
            sessionId: String = "",
            userId: String = "",
            credentialsJson: String = "",
            homeServerConnectionConfigJson: String = "",
            isTokenValid: Boolean = true,
            loginType: String = "",
    ) = SessionParamsEntity(
            sessionId,
            userId,
            credentialsJson,
            homeServerConnectionConfigJson,
            isTokenValid,
            loginType,
    )
}