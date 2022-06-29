package com.freitas.graphqldgspaginationpoc.controller

import graphql.schema.GraphQLSchema
import graphql.schema.GraphqlTypeComparatorRegistry
import graphql.schema.idl.SchemaPrinter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SchemaController(private val graphQLSchema: GraphQLSchema) {

    @GetMapping("/schema")
    fun schemaFile(): String {
        val schemaPrinter = SchemaPrinter.Options
            .defaultOptions()
            .setComparators(GraphqlTypeComparatorRegistry.AS_IS_REGISTRY)
        return SchemaPrinter(schemaPrinter).print(graphQLSchema)
    }

}
