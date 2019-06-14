/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.matrix.android.internal.crypto.keysbackup.tasks

import arrow.core.Try
import im.vector.matrix.android.internal.crypto.keysbackup.api.RoomKeysApi
import im.vector.matrix.android.internal.crypto.keysbackup.model.rest.KeysVersionResult
import im.vector.matrix.android.internal.network.executeRequest
import im.vector.matrix.android.internal.session.SessionScope
import im.vector.matrix.android.internal.task.Task
import javax.inject.Inject

internal interface GetKeysBackupVersionTask : Task<String, KeysVersionResult>

@SessionScope
internal class DefaultGetKeysBackupVersionTask @Inject constructor(private val roomKeysApi: RoomKeysApi)
    : GetKeysBackupVersionTask {


    override suspend fun execute(params: String): Try<KeysVersionResult> {
        return executeRequest {
            apiCall = roomKeysApi.getKeysBackupVersion(params)
        }
    }
}
