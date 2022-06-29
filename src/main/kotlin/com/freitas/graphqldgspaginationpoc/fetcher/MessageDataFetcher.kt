package com.freitas.graphqldgspaginationpoc.fetcher

import com.netflix.dgs.codegen.generated.types.Message
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import graphql.relay.Connection
import graphql.relay.SimpleListConnection
import graphql.schema.DataFetchingEnvironment


@DgsComponent
class MessageDataFetcher {

    private val messages = listOf(
        Message("This is a generated connection 1"),
        Message("This is a generated connection 2"),
        Message("This is a generated connection 3"),
        Message("This is a generated connection 4"),
        Message("This is a generated connection 5")
    )

    @DgsQuery
    fun hello(env: DataFetchingEnvironment?): Connection<Message?>? {
        return SimpleListConnection(messages).get(env)
    }

}
