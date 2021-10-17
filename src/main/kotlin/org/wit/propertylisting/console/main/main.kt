package org.wit.propertylisting.console.main

import mu.KotlinLogging
import org.wit.propertylisting.console.controllers.PropertyController
import org.wit.propertylisting.console.models.PropertyMemStore
import org.wit.propertylisting.console.views.PropertyView
import org.wit.propertylisting.console.models.PropertyModel


private val logger = KotlinLogging.logger {}

val properties = PropertyMemStore()
val propertyView = PropertyView()


fun main(args: Array<String>) {
    PropertyController().start()
}