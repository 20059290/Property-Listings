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

fun addProperty(){
    var property = PropertyModel()
    if (propertyView.addPropertyData(property)){
    properties.create(property)
    }
    else
        logger.info("Property Not Added")
}

fun updateProperty() {
    println("Update a Property")
    println()
    propertyView.listProperties(properties)
    var searchId = propertyView.getId()
    val aProperty = search(searchId)
    if (aProperty != null) {
        if (propertyView.updatePropertyData(aProperty)){
            properties.update(aProperty)
            propertyView.showProperty(aProperty)
            logger.info("Placemark Updated : [ $aProperty ]")
        }
        else
            logger.info("Placemark Updated : [ $aProperty ]")
    } else
        logger.info("Not a valid index")
}


fun searchProperty() {
    val aProperty = search(propertyView.getId())!!
    propertyView.showProperty(aProperty)
}

fun search(id: Long) : PropertyModel? {
    var foundProperty: PropertyModel? = properties.findOne(id)
    return foundProperty
}

fun dummyData() {
    properties.create(PropertyModel(propType = "Apartment", address ="Buckingham Palace", bedrooms = 2, bathrooms = 1, description = "Cosy 2 bed apt located in London", price = 1_449_000))
    properties.create(PropertyModel(propType = "Flat", address ="White House", bedrooms = 5, bathrooms = 4, description = "Spacious 1 bed flat located in USA", price = 750_000))
    properties.create(PropertyModel(propType = "House", address ="Aras an Uachtarain", bedrooms = 15, bathrooms = 10, description = "Beautiful house located in Phoenix park Dublin", price = 1_999_999))
}