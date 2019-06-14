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

package im.vector.matrix.android.internal.crypto.tasks

import arrow.core.Try
import im.vector.matrix.android.internal.crypto.api.CryptoApi
import im.vector.matrix.android.internal.crypto.model.rest.DeleteDeviceParams
import im.vector.matrix.android.internal.network.executeRequest
import im.vector.matrix.android.internal.session.SessionScope
import im.vector.matrix.android.internal.task.Task
import javax.inject.Inject

internal interface DeleteDeviceTask : Task<DeleteDeviceTask.Params, Unit> {
    data class Params(
            val deviceId: String,
            val accountPassword: String
    )
}

@SessionScope
internal class DefaultDeleteDeviceTask @Inject constructor(private val cryptoApi: CryptoApi)
    : DeleteDeviceTask {

    override suspend fun execute(params: DeleteDeviceTask.Params): Try<Unit> {
        return executeRequest {
            apiCall = cryptoApi.deleteDevice(params.deviceId,
                    DeleteDeviceParams())
        }

        // TODO Recover error, see legacy code MXSession.deleteDevice()
    }
}
