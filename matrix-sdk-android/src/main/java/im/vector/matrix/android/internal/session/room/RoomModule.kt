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

package im.vector.matrix.android.internal.session.room

import dagger.Module
import dagger.Provides
import im.vector.matrix.android.internal.session.SessionScope
import im.vector.matrix.android.internal.session.room.create.CreateRoomTask
import im.vector.matrix.android.internal.session.room.create.DefaultCreateRoomTask
import im.vector.matrix.android.internal.session.room.membership.DefaultLoadRoomMembersTask
import im.vector.matrix.android.internal.session.room.membership.LoadRoomMembersTask
import im.vector.matrix.android.internal.session.room.membership.joining.DefaultInviteTask
import im.vector.matrix.android.internal.session.room.membership.joining.DefaultJoinRoomTask
import im.vector.matrix.android.internal.session.room.membership.joining.InviteTask
import im.vector.matrix.android.internal.session.room.membership.joining.JoinRoomTask
import im.vector.matrix.android.internal.session.room.membership.leaving.DefaultLeaveRoomTask
import im.vector.matrix.android.internal.session.room.membership.leaving.LeaveRoomTask
import im.vector.matrix.android.internal.session.room.prune.DefaultPruneEventTask
import im.vector.matrix.android.internal.session.room.prune.PruneEventTask
import im.vector.matrix.android.internal.session.room.read.DefaultSetReadMarkersTask
import im.vector.matrix.android.internal.session.room.read.SetReadMarkersTask
import im.vector.matrix.android.internal.session.room.relation.DefaultFindReactionEventForUndoTask
import im.vector.matrix.android.internal.session.room.relation.DefaultUpdateQuickReactionTask
import im.vector.matrix.android.internal.session.room.relation.FindReactionEventForUndoTask
import im.vector.matrix.android.internal.session.room.relation.UpdateQuickReactionTask
import im.vector.matrix.android.internal.session.room.send.LocalEchoEventFactory
import im.vector.matrix.android.internal.session.room.send.LocalEchoUpdater
import im.vector.matrix.android.internal.session.room.state.DefaultSendStateTask
import im.vector.matrix.android.internal.session.room.state.SendStateTask
import im.vector.matrix.android.internal.session.room.timeline.DefaultGetContextOfEventTask
import im.vector.matrix.android.internal.session.room.timeline.DefaultPaginationTask
import im.vector.matrix.android.internal.session.room.timeline.GetContextOfEventTask
import im.vector.matrix.android.internal.session.room.timeline.PaginationTask
import im.vector.matrix.android.internal.session.room.timeline.TokenChunkEventPersistor
import retrofit2.Retrofit

@Module
internal class RoomModule {

    @SessionScope
    @Provides
    fun providesRoomAPI(retrofit: Retrofit): RoomAPI {
        return retrofit.create(RoomAPI::class.java)
    }

}
