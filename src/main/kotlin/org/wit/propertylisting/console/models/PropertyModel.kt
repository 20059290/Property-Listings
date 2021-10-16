package org.wit.propertylisting.console.models

data class PropertyModel(var id: Long = 0,
                         var propType: String = "",
                         var address: String = "",
                         var bedrooms: Int = 0,
                         var bathrooms: Int =0,
                         var description: String = "",
                         var price: Long = 0)