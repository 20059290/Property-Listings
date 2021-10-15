package org.wit.propertylisting.console.main
import PropertyModel
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

var property = PropertyModel()
val properties = ArrayList<PropertyModel>()

fun main(args: Array<String>){
    print("Property Listing Kotlin App Version 1.0")
    logger.info { "Launching Property Listing Console App" }

    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> addProperty()
            2 -> updateProperty()
            3 -> listAllProperties()
            4 -> searchProperty()
            -1 -> println("Exiting app")
            else -> println("Invalid option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Property Listing Console App" }
}

fun menu() : Int{
    var option : Int
    var input: String? = null

    println("Main Menu")
    println(" 1. Add Property")
    println(" 2. Update Property")
    println(" 3. List All Property")
    println(" 4. Search Properties")
    println("-1. Exit")
    println()
    print("Enter an integer: ")
    input = readLine()!!
    option = input.toInt()
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9

    return option
}

fun addProperty(){
    println("Add Property")
    println()
    print("Enter a Address : ")
    property.address = readLine()!!
    print("Enter a Type (Apt,Flat,House etc..): ")
    property.propType = readLine()!!
    print("Enter a Description : ")
    property.description = readLine()!!
    print("Enter a Price : ")
    property.price = readLine()!!.toLong()
    if (property.address.isNotEmpty() && property.description.isNotEmpty() && property.propType.isNotEmpty()) {
        properties.add(property.copy())
        property.id++
        println("Property Type: "+ property.propType + "\n Located at: " + property.address + "\n Description: " + property.description +" \n €" + property.price)
        logger.info("Property Added : [ $property ]")
    }
    else
        logger.info("Property Not Added")
}

fun updateProperty(){
    println("Add Property")
    println()
    print("Enter a new Address for [ " + property.address + " ] : ")
    property.address = readLine()!!
    print("Enter a new Description for [ " + property.description + " ]: ")
    property.description = readLine()!!
    println("You updated \n Property Type: "+ property.propType + "\n Located at: " + property.address + "\n Description: " + property.description +" \n €" + property.price)}

fun listAllProperties(){
    println("List All Properties")
    println()
    properties.forEach { logger.info("${it}") }
}

fun searchProperty() {
    var searchId = getId()

    // create Property object here and assign,
    // based on 'searchId' value passed to 'search()'

    // Then display details to user
}

fun getId() : Long {
    var strId : String? // String to hold user input
    var searchId : Long // Long to hold converted id
    print("Enter id to Search/Update : ")
    strId = readLine()!!
    searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
        strId.toLong()
    else
        -9
    return searchId
}

fun search(id: Long) : PropertyModel? {
    var foundProperty: PropertyModel? = properties.find { p -> p.id == id }
    return foundProperty
}

fun dummyData() {
    properties.add(PropertyModel(1, "Apartment", "Buckingham Palace", 2, 1,"Cosy 2 bed apt located in London", 1_449_000))
    properties.add(PropertyModel(2, "Flat", "White House", 5, 4,"Spacious 1 bed flat located in USA", 750_000))
    properties.add(PropertyModel(3, "House", "Aras an Uachtarain", 15, 10,"Beautiful house located in Phoenix park Dublin", 1_999_999))
}